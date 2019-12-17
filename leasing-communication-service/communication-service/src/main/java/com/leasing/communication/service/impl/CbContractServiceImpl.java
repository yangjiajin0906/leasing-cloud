package com.leasing.communication.service.impl;

import com.aliyun.oss.model.OSSObject;
import com.leasing.common.entity.calculate.vo.base.InoutPlanVO;
import com.leasing.common.entity.calculate.vo.base.LeasePlanVO;
import com.leasing.common.enums.base.Billstatus;
import com.leasing.common.enums.constant.TradeType;
import com.leasing.common.utils.sys.EventTypeUtil;
import com.leasing.common.utils.tools.DozerUtils;
import com.leasing.common.utils.tools.ExcelUtils;
import com.leasing.communication.entity.dos.AccrualDO;
import com.leasing.communication.entity.dos.CbContractDO;
import com.leasing.communication.entity.dos.CbInoutPlanDO;
import com.leasing.communication.entity.dto.CbContractImpDTO;
import com.leasing.communication.entity.dto.FileOssLogDTO;
import com.leasing.communication.entity.vo.AccrualVO;
import com.leasing.communication.entity.vo.CbContractVO;
import com.leasing.communication.repository.AccrualRepo;
import com.leasing.communication.repository.CbContractRepo;
import com.leasing.communication.repository.InoutPlanRepo;
import com.leasing.communication.service.CbContractService;
import com.leasing.communication.service.arithmetic.ApportionService;
import com.leasing.communication.utils.EntityCacheUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @project:leasing-cloud
 * @date:2019-12-3
 * @author:lvcna@yonyou.com
 * @description: 2C合同接口实现类
 **/
@Transactional
@Service("communication.CbContractServiceImpl")
public class CbContractServiceImpl implements CbContractService {

    @Resource
    CbContractRepo cbContractRepo;

    //计提
    @Resource
    AccrualRepo accrualRepo;

    //租金计划
    @Resource
    InoutPlanRepo inoutPlanRepo;

    //算法Service
    @Resource
    ApportionService apportionService;

    @Override
    public List<CbContractImpDTO> dataImp(MultipartFile file) {
        List<CbContractImpDTO> contList = ExcelUtils.convertExcel(file, CbContractImpDTO.class);
        return contList;
    }

    @Override
    public List<CbContractDO> dataConvert(List<CbContractImpDTO> list) {
        Map<String, String> areaclMap = EntityCacheUtils.cacheEntityField("AreaclVO", "areaclname",
                "pkAreacl", CbContractDO.class);
        Map<String, String> soruceSystemMap = EntityCacheUtils.cacheEntityField("SourceSystemDTO", "systemCode",
                "pkSourceSystem", CbContractDO.class);
        List<CbContractDO> contractDOS = new ArrayList<>();
        for(CbContractImpDTO dto : list){
            CbContractDO contractDO = DozerUtils.convert(dto, CbContractDO.class);
            contractDO.setCustomerProvince(areaclMap.get(dto.getCustomerProvince()));
            contractDO.setCustomerCity(areaclMap.get(dto.getCustomerCity()));
            contractDO.setCustomerRegion(areaclMap.get(dto.getCustomerRegion()));
            contractDO.setPkSystem(soruceSystemMap.get(dto.getSourceSystem()));
            contractDOS.add(contractDO);
        }
        return contractDOS;
    }

    @Override
    public void save(List<CbContractDO> list) {
        cbContractRepo.saveAll(list);
    }

    @Override
    public List<CbContractVO> testQuery() {

        return cbContractRepo.queryForPage();
    }

    @Override
    public FileOssLogDTO dataImp(OSSObject param) {
        FileOssLogDTO logDTO = new FileOssLogDTO(param.getKey());
        try {
            List<CbContractImpDTO> contList = ExcelUtils.convertExcel(param.getObjectContent(), param.getKey(), CbContractImpDTO.class);
            save(dataConvert(contList));
            logDTO.setDataNum(Long.valueOf(contList.size()));
        } catch (IOException e) {
            e.printStackTrace();
            logDTO.setLogMsg(e.getMessage());
            logDTO.setFlag(false);
        } finally {
            try {
                param.close();
            } catch (IOException e) {
                e.printStackTrace();
                logDTO.setLogMsg(e.getMessage());
                logDTO.setFlag(false);
            }
        }
        return logDTO;

    }

    @Override
    public CbContractDO findOne(String pk) {
        return cbContractRepo.findOne(pk);
    }

    @Override
    public void updateInoutPlan(List<CbContractDO> list) {

        //循环合同
        for (CbContractDO cbContractDO: list){
            List<LeasePlanVO> leasePlanVOList = new ArrayList<LeasePlanVO>();
            //查出每一个合同的收支计划
            List<CbInoutPlanDO> inoutPlanDOList = inoutPlanRepo.findByContCode(cbContractDO.getContCode());
            //将 CbInoutPlanDO列表 转成 LeasePlanVO列表
            leasePlanVOList = conversionVO(inoutPlanDOList, leasePlanVOList);
            List<InoutPlanVO> inoutPlanVOList = apportionService.createAccount(leasePlanVOList);

            List<CbInoutPlanDO> list1 = new ArrayList(); //收支计划list
            for(InoutPlanVO inoutPlanVO: inoutPlanVOList){
                //会计分摊计算结果 没有主键 根据计算日期给主键赋值
                for(CbInoutPlanDO cbInoutPlanDO: inoutPlanDOList){
                    //期次相同 且 日期相同
                    if(inoutPlanVO.getCalDate().equals(cbInoutPlanDO.getDatePaidin())
                            &&inoutPlanVO.getLeaseTime().equals(cbInoutPlanDO.getPlanLeaseTime())){
                        //优先更新 事件类别为 收租和投放的数据  同一个日期执行更新一条数据即可
                        if(inoutPlanVO.getTransType().getEventCode().equals(TradeType.TRADETYPE_RENT)
                                || inoutPlanVO.getTransType().getEventCode().equals(TradeType.TRADETYPE_PUTTING)){
                            inoutPlanVO.setPkInoutPlan(cbInoutPlanDO.getPkInoutPlan());
                        }else{
                            inoutPlanVO.setPkInoutPlan(cbInoutPlanDO.getPkInoutPlan());
                        }
                        break;
                    }
                }
                CbInoutPlanDO inoutPlanDO = inoutPlanRepo.findOne(inoutPlanVO.getPkInoutPlan());
                inoutPlanDO.setDivideCash(inoutPlanVO.getDivideCash());//分拆租金
                inoutPlanDO.setDivideInterest(inoutPlanVO.getDivideInterest());//分拆利息
                inoutPlanDO.setDivideCorpus(inoutPlanVO.getDivideCorpus());//分拆本金

                inoutPlanDO.setLeaseCashIn(inoutPlanVO.getLeaseCashIn());//租赁收入
                inoutPlanDO.setNoTaxInterest(inoutPlanVO.getNoTaxInterest());//去税租息
                inoutPlanDO.setNoTaxOtherin(inoutPlanVO.getNoTaxOtherin());//去税其它收入
                inoutPlanDO.setNoTaxOtherout(inoutPlanVO.getNoTaxOtherout());//去税其它支出
                inoutPlanDO.setNoTaxSrvfee(inoutPlanVO.getNoTaxSrvfee());//去税手续费收入
                inoutPlanDO.setInputTaxDiff(inoutPlanVO.getInputTaxDiff());//进项税差额
                inoutPlanDO.setInputTax(inoutPlanVO.getInputTax());//进项税
                inoutPlanDO.setSumTax(inoutPlanVO.getSumTax());//税金
                list1.add(inoutPlanDO);
            }
            //更新收支计划表
            inoutPlanRepo.saveAll(list1);

            //生成计提表数据
            List<AccrualVO> accrualVOList = apportionService.createAccrual(inoutPlanVOList);
            List<AccrualDO> accrualDOList = new ArrayList();
            for(AccrualVO accrualVO: accrualVOList){
                AccrualDO accrualDO = DozerUtils.convert(accrualVO, AccrualDO.class);
                if(accrualDO.getBillstatus() == null){
                    //暂存
                    accrualDO.setBillstatus(Billstatus.INITALIZE.getShort());
                }
                accrualDO.setPkOrg("1003");//当前登录人的机构
                accrualDO.setSourceBill(cbContractDO.getPkContract());//来源单据
                accrualDO.setPkContract(cbContractDO.getPkContract());//合同主键
                accrualDO.setPkCurrency("00010000000000000001");//人民币
                accrualDOList.add(accrualDO);
            }
            //插入计提数据
            accrualRepo.saveAll(accrualDOList);
        }
    }

    /**
     * @description 把CbInoutPlanDO列表 转换成 LeasePlanVO列表 用于计算会计分摊表
     * @author Yangjiajin
     * @date 2019/12/16 14:49
     * @param list 租金计划表List, leasePlanVOList 用于计算会计分摊表
     * @return com.leasing.common.entity.calculate.vo.base.LeasePlanVO
     */
    private List<LeasePlanVO> conversionVO(List<CbInoutPlanDO> list, List<LeasePlanVO> leasePlanVOList){
          for(CbInoutPlanDO inoutPlanDO: list){
              LeasePlanVO vo = new LeasePlanVO();
              vo.setCal_date(inoutPlanDO.getPlanDate());//计划日期 -> 计算日期
              vo.setPlan_date(inoutPlanDO.getPlanDate());//计划日期
              vo.setLease_time(inoutPlanDO.getPlanLeaseTime());//计划期次 -> 收取期次
              vo.setTrans_type(EventTypeUtil.eventTypeDTOByPk(inoutPlanDO.getPkEventType()).getEventCode());//事件类别 -> 交易类别
              vo.setLease_cash(inoutPlanDO.getAmountPaidin());//实收金额 -> 租金/发生额
              vo.setLease_cash_fin(inoutPlanDO.getAmountPaidin());//实收金额 -> 租金重算
              vo.setLease_corpus(inoutPlanDO.getCorpusPaidin());//实收本金 -> 其中：本金
              vo.setLease_corpus_fin(inoutPlanDO.getCorpusPaidin());//实收本金 -> 本金重算
              vo.setLease_interest(inoutPlanDO.getInterestPaidin());//实收利息 -> 其中：利息
              vo.setLease_interest_fin(inoutPlanDO.getInterestPaidin());//实收利息 -> 其中重算
              vo.setTax_rate(Short.parseShort("1"));//利率
              leasePlanVOList.add(vo);
          }
        return  leasePlanVOList;
    }

}
