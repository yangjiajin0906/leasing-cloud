package com.leasing.communication.service.impl;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.enums.base.Billstatus;
import com.leasing.common.exception.BaseException;
import com.leasing.common.utils.base.ObjectUtil;
import com.leasing.common.utils.base.UFDate;
import com.leasing.communication.entity.dos.AccruedDO;
import com.leasing.communication.entity.query.AccruedQuery;
import com.leasing.communication.entity.vo.AccrualForAccruedPageRefVO;
import com.leasing.communication.entity.vo.AccruedBVO;
import com.leasing.communication.entity.vo.AccruedVO;
import com.leasing.communication.repository.AccruedRepo;
import com.leasing.communication.service.AccruedService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @project:leasing-cloud
 * @date:2019/11/21
 * @author:Yjj@yonyou.com
 * @description:
 **/
@Transactional
@Service("communication.AccruedServiceImpl")
public class AccruedServiceImpl implements AccruedService {

    @Resource
    AccruedRepo leaseAccruedRepo;

    @Override
    public PageQueryData<AccruedDO> pageQuery(Pagination pagination, AccruedQuery leaseAccruedQuery, String queryName) {
        return leaseAccruedRepo.pageQuery(pagination, leaseAccruedQuery, queryName);
    }

    @Override
    public AccruedVO onAdd(String pkOrg, String currentData, List<AccruedVO> list) {
        //校验
        this.checkData(pkOrg, currentData, list);
        String currentMonth = currentData.substring(0, 7);
        List<AccrualForAccruedPageRefVO> listRef = leaseAccruedRepo.findAccrualForAccrued(currentMonth);
        //构造计提vo
        AccruedVO vo = new AccruedVO();
        vo.setBillstatus(Short.valueOf("20"));//暂存
        vo.setPkOrg(null);
        vo.setPkOperator(null);
        vo.setOperateDate(null);
        vo.setOperateTime(null);
        vo.setContractType(Short.valueOf("1"));//非电信
        vo.setAccrualMonth(currentMonth);//计提月份
        vo = convertVO(vo,listRef);
        return vo;
    }

    /**
     * @description 校验数据
     * @author Yangjiajin
     * @date 2019/11/29 11:39
     * @param
     * @return
     */
    private void checkData(String pkOrg, String currentData, List<AccruedVO> list){
//        for (AccruedVO accruedVO : list) {
//            if (pkOrg.equals(accruedVO.getPkCorp().getPkOrg())) {
//                //暂存或审核中 不可以计提
//                if (Billstatus.INITALIZE.getShort().equals(accruedVO.getBillstatus()) || Billstatus.APPROVING.getShort().equals(accruedVO.getBillstatus()))
//                    throw new BaseException("存在未处理数据，请处理完毕再次计提");
//            }
//        }
        //最后计提月份
        String lastAccrued = leaseAccruedRepo.getLastAccruedMonth(pkOrg, Short.valueOf("9"), Short.valueOf("1"));
        if (StringUtils.isNotBlank(lastAccrued)) {
            UFDate lastAccruedDate = this.convertToUFDate(lastAccrued);
            UFDate accrualUFMonth = this.convertToUFDate(currentData.substring(0, 7));
            /* update by jiaoshy 多次计提 */
            if (lastAccruedDate.compareTo(accrualUFMonth) >= 0) {
                // 现在是多次计提 校验所选月是否已经结账 如果没有结账 则可以多次计提
                boolean flag = checkEnd(pkOrg, currentData);
                if (flag) {
                    StringBuffer buffer = new StringBuffer();
                    buffer.append(accrualUFMonth.getYear()).append("年").append(accrualUFMonth.getMonth()).append("月");
                    buffer.append("当前计提月已经结账，不能重复计提。");
                    throw new BaseException(buffer.toString());
                }
                /* update end */
            } else {
                UFDate needAccruedDate = lastAccruedDate.getMonthAfter(1);// 待计提月份，最大计提月份的下一月
                if (needAccruedDate.compareTo(accrualUFMonth) < 0) {
                    // 最大计提月份加1后还比当前计提月份小，说明夸月计提了
                    accrualUFMonth = accrualUFMonth.getMonthAfter(-1);
                    StringBuffer buffer = new StringBuffer();
                    buffer.append(lastAccruedDate.getYear()).append("年").append(lastAccruedDate.getMonth()).append("月");
                    buffer.append(" 至 ");
                    buffer.append(accrualUFMonth.getYear()).append("年").append(accrualUFMonth.getMonth()).append("月");
                    buffer.append("未计提，请顺序计提。");
                    throw new BaseException(buffer.toString());
                }
            }
        }
    }

    private boolean checkEnd(String pkOrg, String currentData) {
        Map<String, String> map = leaseAccruedRepo.getGlSyssettledYearMonth(pkOrg);
        if(map == null){
            throw new BaseException("查询当前计提月结账信息错误,请联系管理员!");
        }
        if(ObjectUtil.isEmpty(map.get("settledperiod")))  return false;     //证明该机构尚未建立账户
        String month = ObjectUtil.toString(map.get("settledperiod"));
        String year = ObjectUtil.toString(map.get("settledyear"));
        String accMonth = currentData.substring(5,7);
        String accYear = currentData.substring(0,4);

        /**Add mengxy **/
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
        String tt = year+"-"+month;
        String acctt = accYear+"-"+accMonth;
        Date time = null;
        Date acctime = null;
        try {
            time = sdf.parse(tt);
            acctime = sdf.parse(acctt);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            throw new BaseException("日期转换异常!");
        }

        if(acctime.after(time) || acctime.equals(time)){
            return false;
        }else{
            return true;
        }
    }

    /**
     * 将AccrualForAccruedPageRefVO转换成AccruedVO
     * @param vo
     * @param list
     * @return
     */
    private AccruedVO convertVO(AccruedVO vo, List<AccrualForAccruedPageRefVO> list){
        List<AccruedBVO> resultList = new ArrayList<AccruedBVO>();//子表数据
        BigDecimal interest_amount = BigDecimal.ZERO;// 利息
        BigDecimal fee_amount = BigDecimal.ZERO;// 手续费
        BigDecimal other_income_amount = BigDecimal.ZERO;// 其他收入
        BigDecimal other_expenses_amount = BigDecimal.ZERO;// 其他支出
        for (AccrualForAccruedPageRefVO pageRefVO : list) {
            if (vo.getAccrualMonth().equals(pageRefVO.getMonth())) {
                AccruedBVO bvo = new AccruedBVO();
                bvo.setPkAccrualC(pageRefVO.getPkAccrual());
                bvo.setPkLeaseAccrued(vo);
                bvo.setPkContract(pageRefVO.getPkContract());// 合同
                bvo.setPkCustomer(pageRefVO.getPkCustomer());// 客户
                bvo.setAssetsClassify(pageRefVO.getAssetsClassify());// 资产五级分类
                bvo.setAccruedMonth(pageRefVO.getMonth());// 计提月份
                bvo.setPkCurrtype(pageRefVO.getPkCurrtype());// 币种
                bvo.setExchgRate(pageRefVO.getExchgRate());// 汇率
                bvo.setPkGlorgbook(pageRefVO.getPkGlorgbook());// 核算主体
                bvo.setInterestAmount(pageRefVO.getInter());// 利息计提
                bvo.setFeeAmount(pageRefVO.getSrv());// 手续费计提
                bvo.setOtherIncomeAmount(pageRefVO.getPri());// 其他收入
                bvo.setOtherExpensesAmount(pageRefVO.getBus());// 其他支出
                resultList.add(bvo);
                //把字表数据相加
                if (bvo.getInterestAmount() != null) {
                    interest_amount = interest_amount.add(bvo.getInterestAmount());
                }
                if (bvo.getFeeAmount() != null) {
                    fee_amount = fee_amount.add(bvo.getFeeAmount());
                }
                if (bvo.getOtherIncomeAmount() != null) {
                    other_income_amount = other_income_amount.add(bvo.getOtherIncomeAmount());
                }
                if (bvo.getOtherExpensesAmount() != null) {
                    other_expenses_amount = other_expenses_amount.add(bvo.getOtherExpensesAmount());
                }
            }
        }
        vo.setLeaseAccruedB(resultList);
        vo.setInterestAmount(interest_amount);
        vo.setFeeAmount(fee_amount);
        vo.setOtherIncomeAmount(other_income_amount);
        vo.setOtherExpensesAmount(other_expenses_amount);
        return vo;
    }
    /**
     * @description 获取本月完整日期  xxxx-xx-01
     * @author Yangjiajin
     * @date 2019/11/29 14:11
     * @param date
     * @return com.leasing.common.utils.base.UFDate
     */
    private UFDate convertToUFDate(String date) {
        String yearAndMonth = date.substring(0, 7);
        date = yearAndMonth + "-01";
        return UFDate.getDate(date);
    }
}