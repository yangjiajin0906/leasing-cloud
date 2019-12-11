package com.leasing.communication.service.impl;

import com.aliyun.oss.model.OSSObject;
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.enums.base.Billstatus;
import com.leasing.common.enums.base.Yes_Or_No;
import com.leasing.common.utils.base.BaseBusinessUtils;
import com.leasing.common.utils.base.DateUtils;
import com.leasing.common.utils.tools.DozerUtils;
import com.leasing.common.utils.tools.ExcelUtils;
import com.leasing.communication.entity.dos.CbInvoiceApplyDO;
import com.leasing.communication.entity.dos.CbInvoiceApplyDetailDO;
import com.leasing.communication.entity.dto.CbInvoiceApplyDetailImpDTO;
import com.leasing.communication.entity.dto.FileOssLogDTO;
import com.leasing.communication.entity.dto.SourceSystemDTO;
import com.leasing.communication.entity.query.CbInvoiceApplyDetailQuery;
import com.leasing.communication.entity.vo.CbInvoiceApplyDetailVO;
import com.leasing.communication.repository.CbInvoiceApplyDetailRepo;
import com.leasing.communication.repository.CbInvoiceApplyRepo;
import com.leasing.communication.service.CbInvoiceApplyService;
import com.leasing.communication.utils.EntityCacheUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @project:leasing-cloud
 * @date:2019/11/18
 * @author:jiaoshy@yonyou.com
 * @description:
 **/
@Transactional
@Service("communication.InvoiceApplyServiceImpl")
public class CbInvoiceApplyServiceImpl implements CbInvoiceApplyService {

    @Resource
    CbInvoiceApplyRepo invoiceApplyRepo;
    @Resource
    private CbInvoiceApplyDetailRepo detailRepo;


    @Override
    public CbInvoiceApplyDetailDO save(CbInvoiceApplyDetailDO vo) {

        return null;
    }

    @Override
    public void save(List<CbInvoiceApplyDetailVO> list) {
//
        if (list != null && list.size() > 0){
            String pkApply = BaseBusinessUtils.getOID();
            CbInvoiceApplyDO applyDO = new CbInvoiceApplyDO();
            applyDO.setPkInvoiceApply(pkApply);
            //todo 批次号生成规则待确认
            applyDO.setInvoiceBatchNo(BaseBusinessUtils.getOID());
            applyDO.setBillingStatus(Yes_Or_No.YES.getShort());
            //开票日期
            applyDO.setBillingData(DateUtils.getCurDate());
            applyDO.setBillstatus(Billstatus.APPROVE.getShort());

            List<CbInvoiceApplyDetailDO> forSave = new ArrayList<>();

            BigDecimal totalInvoiceAmount = BigDecimal.ZERO;
            BigDecimal totalLeaseCashTax = BigDecimal.ZERO;
            BigDecimal totalExcludingTax = BigDecimal.ZERO;
            for (CbInvoiceApplyDetailVO detailVO : list) {
                CbInvoiceApplyDetailDO detailDO = DozerUtils.convert(detailVO, CbInvoiceApplyDetailDO.class);
                detailDO.setPkInvoiceApply(pkApply);
                detailDO.setBillingStatus(Yes_Or_No.YES.getShort());
                //开票日期
                detailDO.setBillingData(DateUtils.getCurDate());
                //发票税额
                totalInvoiceAmount = totalInvoiceAmount.add(detailDO.getInvoiceAmount());

                totalLeaseCashTax = totalLeaseCashTax.add(detailDO.getLeaseCashTax());

                totalExcludingTax = totalExcludingTax.add(detailDO.getExcludingTax());
                forSave.add(detailDO);
            }
            applyDO.setInvoiceAmount(totalInvoiceAmount);// 发票总额
            applyDO.setLeaseCashTax(totalLeaseCashTax);//发票税额
            applyDO.setExcludingTax(totalExcludingTax);// 不含税金额
            invoiceApplyRepo.save(applyDO);
            detailRepo.saveAll(forSave);

        }



    }

    @Override
    public void delete(CbInvoiceApplyDetailDO vo) {

    }

    @Override
    public CbInvoiceApplyDetailDO update(CbInvoiceApplyDetailDO vo) {
        return null;
    }

    @Override
    public CbInvoiceApplyDetailDO findOne(String pk) {
        return null;
    }

    @Override
    public PageQueryData pageQuery(Pagination pagination, BaseQuery baseQuery, String queryName) {
        return invoiceApplyRepo.pageQuery(pagination, baseQuery, queryName);
    }

    @Override
    public List<CbInvoiceApplyDetailImpDTO> dataImp(File file) {
        List<CbInvoiceApplyDetailImpDTO> contList = ExcelUtils.convertExcel(file, CbInvoiceApplyDetailImpDTO.class);
        return contList;
    }

    @Override
    public List<CbInvoiceApplyDetailDO> dataConvert(List<CbInvoiceApplyDetailImpDTO> list) {
        Map<String, String> soruceSystemMap = EntityCacheUtils.cacheEntityField("SourceSystemDTO", "systemCode",
                "pkSourceSystem", SourceSystemDTO.class);
        List<CbInvoiceApplyDetailDO> cList = new ArrayList<>();
        for(CbInvoiceApplyDetailImpDTO dto : list){
            CbInvoiceApplyDetailDO cbEarlySettlementDO = DozerUtils.convert(dto, CbInvoiceApplyDetailDO.class);
            cbEarlySettlementDO.setPkInvoiceApplyDetail(UUID.randomUUID().toString().replace("-","").substring(0,20));
            cbEarlySettlementDO.setPkSys(soruceSystemMap.get(dto.getPkSys()));
            cList.add(cbEarlySettlementDO);
        }
        return cList;
    }

    @Override
    public List<CbInvoiceApplyDetailVO> querySub(CbInvoiceApplyDetailQuery query) {
        return detailRepo.pageQuery(query, "invoiceApplyDetail.pageQuery");
    }

    @Override
    public List<CbInvoiceApplyDetailVO> queryNotInvoiceSubList() {
        return detailRepo.queryAllByPkInvoiceApplyIsNull();
    }

    @Override
    public FileOssLogDTO dataImp(OSSObject param) {
        FileOssLogDTO logDTO = new FileOssLogDTO(param.getKey());
        try {
            List<CbInvoiceApplyDetailImpDTO> contList = ExcelUtils.convertExcel(param.getObjectContent(), param.getKey(),
                    CbInvoiceApplyDetailImpDTO.class);
            detailRepo.saveAll(dataConvert(contList));
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
}
