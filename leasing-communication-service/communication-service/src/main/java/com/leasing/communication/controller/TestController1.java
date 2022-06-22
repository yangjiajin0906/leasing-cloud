package com.leasing.communication.controller;

import com.leasing.common.base.web.ResResult;
import com.leasing.common.entity.calculate.vo.base.InoutPlanVO;
import com.leasing.common.entity.calculate.vo.base.LeasePlanVO;
import com.leasing.common.entity.calculate.vo.cal.CalBusinessParam;
import com.leasing.communication.entity.vo.AccrualVO;
import com.leasing.communication.service.arithmetic.ApportionService;
import com.leasing.common.utils.sys.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/12/11
 * @author:wangjc@yonyou.com
 * @description:
 **/
@RestController
@RequestMapping(value = "/leasing/test")
public class TestController1 {
    @Autowired
    ApportionService apportionService;

    /**
     * 测试计算分摊数据
     */
    @RequestMapping(value = "/testFen")
    public ResResult ListAccount(){
        List<LeasePlanVO> list = new ArrayList<LeasePlanVO>();
        LeasePlanVO vo = new LeasePlanVO();
        vo.setCal_date("2019-07-30");
        vo.setPlan_date("2019-07-30");
        vo.setLease_time("1");
        vo.setTrans_type("10301");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("7500000")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("7500000")));
        vo.setLease_corpus(BigDecimal.ZERO);
        vo.setLease_corpus_fin(BigDecimal.ZERO);
        vo.setLease_interest(BigDecimal.ZERO);
        vo.setLease_interest_fin(BigDecimal.ZERO);
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2019-07-30");
        vo.setPlan_date("2019-07-30");
        vo.setLease_time("投放日");
        vo.setTrans_type("10101");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("100000000")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("100000000")));
        vo.setLease_corpus(BigDecimal.ZERO);
        vo.setLease_corpus_fin(BigDecimal.ZERO);
        vo.setLease_interest(BigDecimal.ZERO);
        vo.setLease_interest_fin(BigDecimal.ZERO);
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2019-10-30");
        vo.setPlan_date("2019-10-30");
        vo.setLease_time("1");
        vo.setTrans_type("10201");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_corpus(BigDecimal.valueOf(Double.parseDouble("5580266.22")));
        vo.setLease_corpus_fin(BigDecimal.valueOf(Double.parseDouble("5580266.22")));
        vo.setLease_interest(BigDecimal.valueOf(Double.parseDouble("1491250")));
        vo.setLease_interest_fin(BigDecimal.valueOf(Double.parseDouble("1491250")));
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2020-01-30");
        vo.setPlan_date("2020-01-30");
        vo.setLease_time("2");
        vo.setTrans_type("10201");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_corpus(BigDecimal.valueOf(Double.parseDouble("5663481.94")));
        vo.setLease_corpus_fin(BigDecimal.valueOf(Double.parseDouble("5663481.94")));
        vo.setLease_interest(BigDecimal.valueOf(Double.parseDouble("1408034.28")));
        vo.setLease_interest_fin(BigDecimal.valueOf(Double.parseDouble("1408034.28")));
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2020-04-30");
        vo.setPlan_date("2020-04-30");
        vo.setLease_time("3");
        vo.setTrans_type("10201");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_corpus(BigDecimal.valueOf(Double.parseDouble("5747938.61")));
        vo.setLease_corpus_fin(BigDecimal.valueOf(Double.parseDouble("5747938.61")));
        vo.setLease_interest(BigDecimal.valueOf(Double.parseDouble("1323577.61")));
        vo.setLease_interest_fin(BigDecimal.valueOf(Double.parseDouble("1323577.61")));
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2020-07-30");
        vo.setPlan_date("2020-07-30");
        vo.setLease_time("4");
        vo.setTrans_type("10201");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_corpus(BigDecimal.valueOf(Double.parseDouble("5833654.75")));
        vo.setLease_corpus_fin(BigDecimal.valueOf(Double.parseDouble("5833654.75")));
        vo.setLease_interest(BigDecimal.valueOf(Double.parseDouble("1237861.47")));
        vo.setLease_interest_fin(BigDecimal.valueOf(Double.parseDouble("1237861.47")));
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2020-10-30");
        vo.setPlan_date("2020-10-30");
        vo.setLease_time("5");
        vo.setTrans_type("10201");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_corpus(BigDecimal.valueOf(Double.parseDouble("5920649.13")));
        vo.setLease_corpus_fin(BigDecimal.valueOf(Double.parseDouble("5920649.13")));
        vo.setLease_interest(BigDecimal.valueOf(Double.parseDouble("1150867.09")));
        vo.setLease_interest_fin(BigDecimal.valueOf(Double.parseDouble("1150867.09")));
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2021-01-30");
        vo.setPlan_date("2021-01-30");
        vo.setLease_time("6");
        vo.setTrans_type("10201");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_corpus(BigDecimal.valueOf(Double.parseDouble("6008940.81")));
        vo.setLease_corpus_fin(BigDecimal.valueOf(Double.parseDouble("6008940.81")));
        vo.setLease_interest(BigDecimal.valueOf(Double.parseDouble("1062575.41")));
        vo.setLease_interest_fin(BigDecimal.valueOf(Double.parseDouble("1062575.41")));
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2021-04-30");
        vo.setPlan_date("2021-04-30");
        vo.setLease_time("7");
        vo.setTrans_type("10201");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_corpus(BigDecimal.valueOf(Double.parseDouble("6098549.14")));
        vo.setLease_corpus_fin(BigDecimal.valueOf(Double.parseDouble("6098549.14")));
        vo.setLease_interest(BigDecimal.valueOf(Double.parseDouble("972967.08")));
        vo.setLease_interest_fin(BigDecimal.valueOf(Double.parseDouble("972967.08")));
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2021-07-30");
        vo.setPlan_date("2021-07-30");
        vo.setLease_time("8");
        vo.setTrans_type("10201");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_corpus(BigDecimal.valueOf(Double.parseDouble("6189493.75")));
        vo.setLease_corpus_fin(BigDecimal.valueOf(Double.parseDouble("6189493.75")));
        vo.setLease_interest(BigDecimal.valueOf(Double.parseDouble("882022.47")));
        vo.setLease_interest_fin(BigDecimal.valueOf(Double.parseDouble("882022.47")));
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2021-10-30");
        vo.setPlan_date("2021-10-30");
        vo.setLease_time("9");
        vo.setTrans_type("10201");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_corpus(BigDecimal.valueOf(Double.parseDouble("6281794.57")));
        vo.setLease_corpus_fin(BigDecimal.valueOf(Double.parseDouble("6281794.57")));
        vo.setLease_interest(BigDecimal.valueOf(Double.parseDouble("789721.65")));
        vo.setLease_interest_fin(BigDecimal.valueOf(Double.parseDouble("789721.65")));
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2022-01-30");
        vo.setPlan_date("2022-01-30");
        vo.setLease_time("10");
        vo.setTrans_type("10201");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_corpus(BigDecimal.valueOf(Double.parseDouble("6375471.84")));
        vo.setLease_corpus_fin(BigDecimal.valueOf(Double.parseDouble("6375471.84")));
        vo.setLease_interest(BigDecimal.valueOf(Double.parseDouble("696044.38")));
        vo.setLease_interest_fin(BigDecimal.valueOf(Double.parseDouble("696044.38")));
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2022-04-30");
        vo.setPlan_date("2022-04-30");
        vo.setLease_time("11");
        vo.setTrans_type("10201");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_corpus(BigDecimal.valueOf(Double.parseDouble("6470546.06")));
        vo.setLease_corpus_fin(BigDecimal.valueOf(Double.parseDouble("6470546.06")));
        vo.setLease_interest(BigDecimal.valueOf(Double.parseDouble("600970.16")));
        vo.setLease_interest_fin(BigDecimal.valueOf(Double.parseDouble("600970.16")));
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2022-07-30");
        vo.setPlan_date("2022-07-30");
        vo.setLease_time("12");
        vo.setTrans_type("10201");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_corpus(BigDecimal.valueOf(Double.parseDouble("6567038.08")));
        vo.setLease_corpus_fin(BigDecimal.valueOf(Double.parseDouble("6567038.08")));
        vo.setLease_interest(BigDecimal.valueOf(Double.parseDouble("504478.14")));
        vo.setLease_interest_fin(BigDecimal.valueOf(Double.parseDouble("504478.14")));
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2022-10-30");
        vo.setPlan_date("2022-10-30");
        vo.setLease_time("13");
        vo.setTrans_type("10201");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_corpus(BigDecimal.valueOf(Double.parseDouble("6664969.03")));
        vo.setLease_corpus_fin(BigDecimal.valueOf(Double.parseDouble("6664969.03")));
        vo.setLease_interest(BigDecimal.valueOf(Double.parseDouble("406547.19")));
        vo.setLease_interest_fin(BigDecimal.valueOf(Double.parseDouble("406547.19")));
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2023-01-30");
        vo.setPlan_date("2023-01-30");
        vo.setLease_time("14");
        vo.setTrans_type("10201");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_corpus(BigDecimal.valueOf(Double.parseDouble("6764360.38")));
        vo.setLease_corpus_fin(BigDecimal.valueOf(Double.parseDouble("6764360.38")));
        vo.setLease_interest(BigDecimal.valueOf(Double.parseDouble("307155.84")));
        vo.setLease_interest_fin(BigDecimal.valueOf(Double.parseDouble("307155.84")));
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2023-04-30");
        vo.setPlan_date("2023-04-30");
        vo.setLease_time("1");
        vo.setTrans_type("10302");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("428483.78")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("428483.78")));
        vo.setLease_corpus(BigDecimal.ZERO);
        vo.setLease_corpus_fin(BigDecimal.ZERO);
        vo.setLease_interest(BigDecimal.ZERO);
        vo.setLease_interest_fin(BigDecimal.ZERO);
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2023-04-30");
        vo.setPlan_date("2023-04-30");
        vo.setLease_time("15");
        vo.setTrans_type("10201");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_corpus(BigDecimal.valueOf(Double.parseDouble("6865233.91")));
        vo.setLease_corpus_fin(BigDecimal.valueOf(Double.parseDouble("6865233.91")));
        vo.setLease_interest(BigDecimal.valueOf(Double.parseDouble("206282.31")));
        vo.setLease_interest_fin(BigDecimal.valueOf(Double.parseDouble("206282.31")));
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2023-07-30");
        vo.setPlan_date("2023-07-30");
        vo.setLease_time("16");
        vo.setTrans_type("10201");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_corpus(BigDecimal.valueOf(Double.parseDouble("6967611.78")));
        vo.setLease_corpus_fin(BigDecimal.valueOf(Double.parseDouble("6967611.78")));
        vo.setLease_interest(BigDecimal.valueOf(Double.parseDouble("103904.44")));
        vo.setLease_interest_fin(BigDecimal.valueOf(Double.parseDouble("103904.44")));
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2023-07-30");
        vo.setPlan_date("2023-07-30");
        vo.setLease_time("2");
        vo.setTrans_type("10302");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_corpus(BigDecimal.ZERO);
        vo.setLease_corpus_fin(BigDecimal.ZERO);
        vo.setLease_interest(BigDecimal.ZERO);
        vo.setLease_interest_fin(BigDecimal.ZERO);
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2023-07-30");
        vo.setPlan_date("2023-07-30");
        vo.setLease_time("1");
        vo.setTrans_type("10204");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("100")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("100")));
        vo.setLease_corpus(BigDecimal.ZERO);
        vo.setLease_corpus_fin(BigDecimal.ZERO);
        vo.setLease_interest(BigDecimal.ZERO);
        vo.setLease_interest_fin(BigDecimal.ZERO);
        vo.setLease_cash_tax(BigDecimal.valueOf(Double.parseDouble("5.66")));
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        List<InoutPlanVO> result = apportionService.createAccount(list);
        return ResultUtils.successWithData(result);
    }


    /**
     * 测试计算计提数据
     */
    @RequestMapping(value = "/testAccrual")
    public ResResult ListCoderule1(){
        List<LeasePlanVO> list = new ArrayList<LeasePlanVO>();
        LeasePlanVO vo = new LeasePlanVO();
        vo.setCal_date("2019-07-30");
        vo.setPlan_date("2019-07-30");
        vo.setLease_time("1");
        vo.setTrans_type("10301");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("7500000")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("7500000")));
        vo.setLease_corpus(BigDecimal.ZERO);
        vo.setLease_corpus_fin(BigDecimal.ZERO);
        vo.setLease_interest(BigDecimal.ZERO);
        vo.setLease_interest_fin(BigDecimal.ZERO);
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2019-07-30");
        vo.setPlan_date("2019-07-30");
        vo.setLease_time("投放日");
        vo.setTrans_type("10101");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("100000000")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("100000000")));
        vo.setLease_corpus(BigDecimal.ZERO);
        vo.setLease_corpus_fin(BigDecimal.ZERO);
        vo.setLease_interest(BigDecimal.ZERO);
        vo.setLease_interest_fin(BigDecimal.ZERO);
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2019-10-30");
        vo.setPlan_date("2019-10-30");
        vo.setLease_time("1");
        vo.setTrans_type("10201");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_corpus(BigDecimal.valueOf(Double.parseDouble("5580266.22")));
        vo.setLease_corpus_fin(BigDecimal.valueOf(Double.parseDouble("5580266.22")));
        vo.setLease_interest(BigDecimal.valueOf(Double.parseDouble("1491250")));
        vo.setLease_interest_fin(BigDecimal.valueOf(Double.parseDouble("1491250")));
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2020-01-30");
        vo.setPlan_date("2020-01-30");
        vo.setLease_time("2");
        vo.setTrans_type("10201");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_corpus(BigDecimal.valueOf(Double.parseDouble("5663481.94")));
        vo.setLease_corpus_fin(BigDecimal.valueOf(Double.parseDouble("5663481.94")));
        vo.setLease_interest(BigDecimal.valueOf(Double.parseDouble("1408034.28")));
        vo.setLease_interest_fin(BigDecimal.valueOf(Double.parseDouble("1408034.28")));
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2020-04-30");
        vo.setPlan_date("2020-04-30");
        vo.setLease_time("3");
        vo.setTrans_type("10201");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_corpus(BigDecimal.valueOf(Double.parseDouble("5747938.61")));
        vo.setLease_corpus_fin(BigDecimal.valueOf(Double.parseDouble("5747938.61")));
        vo.setLease_interest(BigDecimal.valueOf(Double.parseDouble("1323577.61")));
        vo.setLease_interest_fin(BigDecimal.valueOf(Double.parseDouble("1323577.61")));
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2020-07-30");
        vo.setPlan_date("2020-07-30");
        vo.setLease_time("4");
        vo.setTrans_type("10201");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_corpus(BigDecimal.valueOf(Double.parseDouble("5833654.75")));
        vo.setLease_corpus_fin(BigDecimal.valueOf(Double.parseDouble("5833654.75")));
        vo.setLease_interest(BigDecimal.valueOf(Double.parseDouble("1237861.47")));
        vo.setLease_interest_fin(BigDecimal.valueOf(Double.parseDouble("1237861.47")));
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2020-10-30");
        vo.setPlan_date("2020-10-30");
        vo.setLease_time("5");
        vo.setTrans_type("10201");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_corpus(BigDecimal.valueOf(Double.parseDouble("5920649.13")));
        vo.setLease_corpus_fin(BigDecimal.valueOf(Double.parseDouble("5920649.13")));
        vo.setLease_interest(BigDecimal.valueOf(Double.parseDouble("1150867.09")));
        vo.setLease_interest_fin(BigDecimal.valueOf(Double.parseDouble("1150867.09")));
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2021-01-30");
        vo.setPlan_date("2021-01-30");
        vo.setLease_time("6");
        vo.setTrans_type("10201");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_corpus(BigDecimal.valueOf(Double.parseDouble("6008940.81")));
        vo.setLease_corpus_fin(BigDecimal.valueOf(Double.parseDouble("6008940.81")));
        vo.setLease_interest(BigDecimal.valueOf(Double.parseDouble("1062575.41")));
        vo.setLease_interest_fin(BigDecimal.valueOf(Double.parseDouble("1062575.41")));
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2021-04-30");
        vo.setPlan_date("2021-04-30");
        vo.setLease_time("7");
        vo.setTrans_type("10201");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_corpus(BigDecimal.valueOf(Double.parseDouble("6098549.14")));
        vo.setLease_corpus_fin(BigDecimal.valueOf(Double.parseDouble("6098549.14")));
        vo.setLease_interest(BigDecimal.valueOf(Double.parseDouble("972967.08")));
        vo.setLease_interest_fin(BigDecimal.valueOf(Double.parseDouble("972967.08")));
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2021-07-30");
        vo.setPlan_date("2021-07-30");
        vo.setLease_time("8");
        vo.setTrans_type("10201");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_corpus(BigDecimal.valueOf(Double.parseDouble("6189493.75")));
        vo.setLease_corpus_fin(BigDecimal.valueOf(Double.parseDouble("6189493.75")));
        vo.setLease_interest(BigDecimal.valueOf(Double.parseDouble("882022.47")));
        vo.setLease_interest_fin(BigDecimal.valueOf(Double.parseDouble("882022.47")));
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2021-10-30");
        vo.setPlan_date("2021-10-30");
        vo.setLease_time("9");
        vo.setTrans_type("10201");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_corpus(BigDecimal.valueOf(Double.parseDouble("6281794.57")));
        vo.setLease_corpus_fin(BigDecimal.valueOf(Double.parseDouble("6281794.57")));
        vo.setLease_interest(BigDecimal.valueOf(Double.parseDouble("789721.65")));
        vo.setLease_interest_fin(BigDecimal.valueOf(Double.parseDouble("789721.65")));
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2022-01-30");
        vo.setPlan_date("2022-01-30");
        vo.setLease_time("10");
        vo.setTrans_type("10201");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_corpus(BigDecimal.valueOf(Double.parseDouble("6375471.84")));
        vo.setLease_corpus_fin(BigDecimal.valueOf(Double.parseDouble("6375471.84")));
        vo.setLease_interest(BigDecimal.valueOf(Double.parseDouble("696044.38")));
        vo.setLease_interest_fin(BigDecimal.valueOf(Double.parseDouble("696044.38")));
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2022-04-30");
        vo.setPlan_date("2022-04-30");
        vo.setLease_time("11");
        vo.setTrans_type("10201");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_corpus(BigDecimal.valueOf(Double.parseDouble("6470546.06")));
        vo.setLease_corpus_fin(BigDecimal.valueOf(Double.parseDouble("6470546.06")));
        vo.setLease_interest(BigDecimal.valueOf(Double.parseDouble("600970.16")));
        vo.setLease_interest_fin(BigDecimal.valueOf(Double.parseDouble("600970.16")));
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2022-07-30");
        vo.setPlan_date("2022-07-30");
        vo.setLease_time("12");
        vo.setTrans_type("10201");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_corpus(BigDecimal.valueOf(Double.parseDouble("6567038.08")));
        vo.setLease_corpus_fin(BigDecimal.valueOf(Double.parseDouble("6567038.08")));
        vo.setLease_interest(BigDecimal.valueOf(Double.parseDouble("504478.14")));
        vo.setLease_interest_fin(BigDecimal.valueOf(Double.parseDouble("504478.14")));
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2022-10-30");
        vo.setPlan_date("2022-10-30");
        vo.setLease_time("13");
        vo.setTrans_type("10201");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_corpus(BigDecimal.valueOf(Double.parseDouble("6664969.03")));
        vo.setLease_corpus_fin(BigDecimal.valueOf(Double.parseDouble("6664969.03")));
        vo.setLease_interest(BigDecimal.valueOf(Double.parseDouble("406547.19")));
        vo.setLease_interest_fin(BigDecimal.valueOf(Double.parseDouble("406547.19")));
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2023-01-30");
        vo.setPlan_date("2023-01-30");
        vo.setLease_time("14");
        vo.setTrans_type("10201");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_corpus(BigDecimal.valueOf(Double.parseDouble("6764360.38")));
        vo.setLease_corpus_fin(BigDecimal.valueOf(Double.parseDouble("6764360.38")));
        vo.setLease_interest(BigDecimal.valueOf(Double.parseDouble("307155.84")));
        vo.setLease_interest_fin(BigDecimal.valueOf(Double.parseDouble("307155.84")));
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2023-04-30");
        vo.setPlan_date("2023-04-30");
        vo.setLease_time("1");
        vo.setTrans_type("10302");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("428483.78")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("428483.78")));
        vo.setLease_corpus(BigDecimal.ZERO);
        vo.setLease_corpus_fin(BigDecimal.ZERO);
        vo.setLease_interest(BigDecimal.ZERO);
        vo.setLease_interest_fin(BigDecimal.ZERO);
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2023-04-30");
        vo.setPlan_date("2023-04-30");
        vo.setLease_time("15");
        vo.setTrans_type("10201");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_corpus(BigDecimal.valueOf(Double.parseDouble("6865233.91")));
        vo.setLease_corpus_fin(BigDecimal.valueOf(Double.parseDouble("6865233.91")));
        vo.setLease_interest(BigDecimal.valueOf(Double.parseDouble("206282.31")));
        vo.setLease_interest_fin(BigDecimal.valueOf(Double.parseDouble("206282.31")));
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2023-07-30");
        vo.setPlan_date("2023-07-30");
        vo.setLease_time("16");
        vo.setTrans_type("10201");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_corpus(BigDecimal.valueOf(Double.parseDouble("6967611.78")));
        vo.setLease_corpus_fin(BigDecimal.valueOf(Double.parseDouble("6967611.78")));
        vo.setLease_interest(BigDecimal.valueOf(Double.parseDouble("103904.44")));
        vo.setLease_interest_fin(BigDecimal.valueOf(Double.parseDouble("103904.44")));
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2023-07-30");
        vo.setPlan_date("2023-07-30");
        vo.setLease_time("2");
        vo.setTrans_type("10302");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("7071516.22")));
        vo.setLease_corpus(BigDecimal.ZERO);
        vo.setLease_corpus_fin(BigDecimal.ZERO);
        vo.setLease_interest(BigDecimal.ZERO);
        vo.setLease_interest_fin(BigDecimal.ZERO);
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        vo = new LeasePlanVO();
        vo.setCal_date("2023-07-30");
        vo.setPlan_date("2023-07-30");
        vo.setLease_time("1");
        vo.setTrans_type("10204");
        vo.setLease_cash(BigDecimal.valueOf(Double.parseDouble("100")));
        vo.setLease_cash_fin(BigDecimal.valueOf(Double.parseDouble("100")));
        vo.setLease_corpus(BigDecimal.ZERO);
        vo.setLease_corpus_fin(BigDecimal.ZERO);
        vo.setLease_interest(BigDecimal.ZERO);
        vo.setLease_interest_fin(BigDecimal.ZERO);
        vo.setLease_cash_tax(BigDecimal.valueOf(Double.parseDouble("5.66")));
        vo.setTax_rate(Short.parseShort("1"));
        list.add(vo);
        List<InoutPlanVO> inout_plan_market = apportionService.createAccount(list);
        List<AccrualVO> result = apportionService.createAccrual(inout_plan_market);
        return ResultUtils.successWithData(result);
    }
}