package com.leasing.calculate.controller;

import com.leasing.calculate.entity.CalculatorVO;
import com.leasing.calculate.entity.InoutPlanPVO;
import com.leasing.calculate.service.CalculateService;
import com.leasing.common.api.feign.calculate.CalculatorTest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvcn on 2019-9-18.
 */
@RestController
@RequestMapping(value = "/leasing/calculate")
public class CalculatorTestController implements CalculatorTest {

    @Resource
    CalculateService calculateService;

    @Override
    @RequestMapping(value = "/testFeign")
    public String TestFeign(String str) {
        return "Test my fiegn interface "+ str;
    }

    @RequestMapping(value = "/queryPage",method = RequestMethod.POST)
    public List<CalculatorVO> queryPage() {
        List<CalculatorVO> list = calculateService.query();
        return list;
    }

    @RequestMapping(value = "/findAll")
    public List<CalculatorVO> findAll() {
        List<CalculatorVO> list = calculateService.findAll();
        return list;
    }

    @RequestMapping(value = "/findLike")
    public List<CalculatorVO> findLike() {
        List<CalculatorVO> list = calculateService.findLike("贵州遵义");
        return list;
    }

    @RequestMapping(value = "/findByTsLike")
    public List<CalculatorVO> findByTsLike(String ts) {
        ts = "2019-07-16 14:39:06";
        List<CalculatorVO> list = calculateService.findByTs(ts);
        return list;
    }

    @RequestMapping(value = "/findById")
    public CalculatorVO findById(String id) {
        id = "0001MG00000000036711";
        CalculatorVO vo = calculateService.findById(id);
        return vo;
    }

    @RequestMapping(value = "/save")
    public CalculatorVO save(CalculatorVO vo) {
        CalculatorVO vo01 = calculateService.findById("0001AA10000000053TK5");
        vo.setPk_lease_calculator("0001MG00000000036YJJ");
        vo.setQuot_code(vo01.getQuot_code());
        vo.setLease_commencement_date(vo01.getLease_commencement_date());
        vo.setLease_method(vo01.getLease_method());
        vo.setTotal_amount_equipment(vo01.getTotal_amount_equipment());
        vo.setNet_finance_cash(vo01.getNet_finance_cash());
        vo.setIf4basic(vo01.getIf4basic());
        vo.setBillstatus(vo01.getBillstatus());
        vo.setPlan_date_loan(vo01.getPlan_date_loan());
        vo.setPk_org(vo01.getPk_org());
        vo.setPk_limit_plan(vo01.getPk_limit_plan());
        vo.setPk_dept(vo01.getPk_dept());
        vo.setPk_grantor(vo01.getPk_grantor());
        vo.setTs("2019-09-26 00:00:00");
        vo.setPk_initial(vo01.getPk_initial());
        //字表数据
        List<CalculatorVO> list = calculateService.query();
        List<InoutPlanPVO> list2 = list.get(1).getInout_plan_market();
        List<InoutPlanPVO> arrayList = new ArrayList<>(list2.size());
        list2.forEach(authority -> arrayList.add(authority));
        vo.setInout_plan_market(arrayList);

        calculateService.save(vo);

        return vo;
    }

    @RequestMapping(value = "/update")
    public String update(CalculatorVO vo) {
        vo = calculateService.findById("0001MG00000000036YJJ");
        vo.setQuot_name("杨佳进测试报价方案名称2");
        //List<LeaseLoanPlanVO> list1 = list.get(1).getLease_loan_plan();
        //vo.setLease_loan_plan(list1);
//        List<InoutPlanPVO> list2 = list.get(1).getInout_plan_market();
//        List<InoutPlanPVO> arrayList = new ArrayList<>(list2.size());
//        list2.forEach(authority -> arrayList.add(authority));
        List<InoutPlanPVO> list2 = vo.getInout_plan_market();
        list2.remove(list2.size()-1);
        vo.setInout_plan_market(list2);
        //List<LeaseRulePVO> list3 = list.get(1).getLease_rule();
        //vo.setLease_rule(list3);
        calculateService.update(vo);
        return "1";
    }

    @RequestMapping(value = "/deleteById")
    public String deleteById(String id) {
        id = "0001MG00000000036YJJ";
        calculateService.deleteById(id);
        return "1";
    }

}
