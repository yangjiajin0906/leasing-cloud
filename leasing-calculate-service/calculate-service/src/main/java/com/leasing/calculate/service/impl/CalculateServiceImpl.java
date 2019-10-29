package com.leasing.calculate.service.impl;

import com.alibaba.fastjson.JSON;
import com.leasing.calculate.dos.CalculatorDO;
import com.leasing.calculate.dos.InoutPlanPDO;
import com.leasing.calculate.dos.LeaseLoanPlanDO;
import com.leasing.calculate.repository.LeaseLoanPlanRepo;
import com.leasing.calculate.utils.BaseAppUtils;
import com.leasing.calculate.utils.CalCommonArithmeticUtils;
import com.leasing.calculate.vo.ArithmeticCoreParam;
import com.leasing.calculate.vo.CalArithmeticVO;
import com.leasing.calculate.vo.CalculatorVO;
import com.leasing.calculate.repository.CalculatorRepo;
import com.leasing.calculate.service.CalculateService;
import com.leasing.calculate.dto.CalculatorDTO;

import com.leasing.calculate.vo.LeasePlanVO;
import com.leasing.calculate.vo.queryVO.CalculatorQueryVO;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.utils.base.DozerUtils;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @project:leasing-cloud
 * @date:2019/9/23
 * @author:Yjj@yonyou.comlist
 * @description:
 **/
@Transactional
@Service("calculate.CalculateServiceImpl")
public class CalculateServiceImpl implements CalculateService {

    @Resource
    CalculatorRepo calculatorRepo;

//    @Resource
//    LeaseLoanPlanRepo leaseLoanPlanRepo;

    @Override
    public List<CalculatorVO> pageQuery(Pagination pagination, CalculatorQueryVO vo) {
        StringBuffer sql = new StringBuffer();
        sql.append(
                "select c from CalculatorVO c " +
                        " left join fetch c.pkLimitPlan l" +
                        " left join fetch c.pkDept d" +
                        " left join fetch c.pkChecker u" +
                        " left join fetch c.pkGrantor pg" +
                        " left join fetch c.pkOrg o" +
                        " left join fetch c.pkInterrate i" +
                        " left join fetch c.pkInterrateDepos pid" +
                        " left join fetch c.pkSpecialInterrate psi" +
                        " left join fetch c.pkCurrtype pc"
        );
        return calculatorRepo.pageQuery(pagination, vo, sql.toString());
    }

    @Override
    public CalculatorDO save(CalculatorDO vo) {
        vo = calculatorRepo.findOne("0001MG00000000036711");
        String json = JSON.toJSONString(vo);
        CalculatorDO dos = JSON.parseObject(json, CalculatorDO.class);
        dos.setPkLeaseCalculator("1231MG00000000036YJJ");
        dos.setQuotName("杨佳进测试报价方案名称save");

        //字表1
        List<InoutPlanPDO> list = new ArrayList<>();
        InoutPlanPDO inoutPlanPDO = new InoutPlanPDO();
        inoutPlanPDO.setPkInoutPlan("1231MG00000000036HH1");
        InoutPlanPDO inoutPlanPDO2 = new InoutPlanPDO();
        inoutPlanPDO2.setPkInoutPlan("1231MG00000000036HH2");
        list.add(inoutPlanPDO);
        list.add(inoutPlanPDO2);
        dos.setInoutPlanMarket(list);

        //字表2
//        List<LeaseLoanPlanDO> list2 = new ArrayList<>();
//        LeaseLoanPlanDO pdo = new LeaseLoanPlanDO();
//        pdo.setPkLeaseLoanPlan("1231MG00000000036HH3");
//        list2.add(pdo);
//        dos.setLeaseLoanPlan(list2);

        calculatorRepo.save(dos);
        return vo;
    }

    @Override
    public void delete(CalculatorDO vo) {
        vo = calculatorRepo.findOne("1231MG00000000036YJJ");
        calculatorRepo.delete(vo);
    }

    @Override
    public CalculatorDO update(CalculatorDO vo) {
        vo = calculatorRepo.findOne("1231MG00000000036YJJ");
        vo.setQuotName("杨佳进测试报价方案名称2");
        List<InoutPlanPDO> list = vo.getInoutPlanMarket();
        //修改字表数据
        InoutPlanPDO pdo = list.get(0);
        pdo.setLeaseTime("2019-10-24 00:00:00");
        list.add(0,pdo);
        //删除
        list.remove(list.size()-1);
        //添加
        InoutPlanPDO inoutPlanPDO = new InoutPlanPDO();
        inoutPlanPDO.setPkInoutPlan("1234MG00000000036HH1");
        InoutPlanPDO inoutPlanPDO2 = new InoutPlanPDO();
        inoutPlanPDO2.setPkInoutPlan("1234MG00000000036HH2");
        list.add(inoutPlanPDO);
        list.add(inoutPlanPDO2);

        vo.setInoutPlanMarket(list);
        calculatorRepo.saveAndFlush(vo);

        return vo;
    }

    @Override
    public CalculatorDO findOne(String pk) {
        return calculatorRepo.findOne(pk);
    }

    @Override
    public CalculatorVO findByPk(String pk) {
        return calculatorRepo.findByPk(pk);
    }

    @Override
    public CalculatorVO findChildListById(String id) {
        CalculatorDO dos = calculatorRepo.findOne(id);
        CalculatorVO vo = DozerUtils.convert(dos,CalculatorVO.class);
        //......
        return vo;
    }

    @Override
    public List calOperateLease(CalculatorVO vo) {
        ArithmeticCoreParam acp = BaseAppUtils.buildCalBusinessParam(vo);
        List<CalArithmeticVO> listC = CalCommonArithmeticUtils.getRentPlan(acp);
        List<LeasePlanVO> list = CalCommonArithmeticUtils.getResultRentList(listC);
        return list;
    }

    @Override
    public List calMakeResults() {
        return null;
    }

    @Override
    public List calAccountingShare() {
        return null;
    }

    @Override
    public List calBatchBusinessC() {
        return null;
    }

    @Override
    public BigDecimal calDayIRR() {
        return null;
    }

    @Override
    public CalculatorDTO findByIsSql(String pkLeaseCalculator) {
        return calculatorRepo.findByIsSql(pkLeaseCalculator);
    }

    @Override
    public Map<String,Object> findByIsSql2(String pkLeaseCalculator) {
        return calculatorRepo.findByIsSql2(pkLeaseCalculator);
    }

    @Override
    public CalculatorDTO findByPkLeaseCalculator(String pkLeaseCalculator, Class<CalculatorDTO> type) {
        return calculatorRepo.findByPkLeaseCalculator(pkLeaseCalculator,CalculatorDTO.class);
    }

    @Override
    public List<CalculatorVO> findListByPk(String pk) {
        return calculatorRepo.findListByPk(pk);
    }



}
