package com.leasing.common.utils.arithmetic;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import com.leasing.common.config.CalBusiConfig;
import com.leasing.common.entity.calculate.vo.base.CalculatorVO;
import com.leasing.common.entity.calculate.vo.base.InoutPlanVO;
import com.leasing.common.entity.calculate.vo.base.LeaseLoanPlanVO;
import com.leasing.common.entity.calculate.vo.base.LeasePlanVO;
import com.leasing.common.entity.calculate.vo.cal.CalBusinessParam;
import com.leasing.common.exception.BaseException;
import com.leasing.common.utils.base.ObjectUtil;
import com.leasing.common.utils.frame.SpringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestFulUtils {
    private static RestFulUtils restFulUtils;
    private static Log log = LogFactory.getLog(RestFulUtils.class);
    private final static String RESTTEMPLATE = "restTemplate";

    public static RestFulUtils getInstance() {
        if (restFulUtils == null) {
            synchronized (RestFulUtils.class) {
                if (restFulUtils == null) {
                    restFulUtils = new RestFulUtils();
                }
            }
        }
        return restFulUtils;
    }


    public Map  getAccountShareTable(List<LeasePlanVO> leasePlanVOs, CalBusinessParam calBusinessParam, Map irrEventMap) {

        String leasePlanString = JSON.toJSONString(leasePlanVOs);
        String calBusinessString = JSON.toJSONString(calBusinessParam);
        String irrEventString = JSON.toJSONString(irrEventMap);

        Map queryMap = new HashMap();
        queryMap.put("calParam", calBusinessString);
        queryMap.put("leasePlanVOs",leasePlanString);
        queryMap.put("irrEventMap", irrEventString);


        RestTemplate restTemplate  = (RestTemplate) SpringUtils.getBean(RESTTEMPLATE);
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8 ");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<Map> requestEntity = new HttpEntity<Map>(queryMap, headers);
        String url = CalBusiConfig.url+"/reCalInoutPlanController/getAccountShareTableNC";
        ResponseEntity<Map> responseEntity = restTemplate.postForEntity(url, requestEntity, Map.class);
        Map result = responseEntity.getBody();
        Iterator<String> keys = result.keySet().iterator();
        Map<String, LeasePlanVO> resultMap = new HashMap();
        while (keys.hasNext()) {
            String key = keys.next();
            String datak = JSON.toJSONString(result.get(key));
            LeasePlanVO leasePlanVO = JSONObject.parseObject(datak, LeasePlanVO.class);
            resultMap.put(key, leasePlanVO);
        }
        return resultMap;

    }

    /**
     *
     * @param vo  封装的报价Vo
     * @param source_billtype 业务类型
     * @param accrualWay  报价的计算方式
     * @param source_pk  业务单据的pk
     * @param yearHm   服务费年汇总信息
     * @param inoutPlan  参与计提计算的会计分摊收支计划
     * @param oldAccrual  旧计提数据
     * @return
     */
    public List getAccrual(CalculatorVO vo, String source_billtype, Short accrualWay, String source_pk, Map<String, ArrayList>
                           yearHm, List<InoutPlanVO> inoutPlan, List<Map> oldAccrual) {
        Map<String, Object> map = new HashMap<>();
        List list = new ArrayList();
        for(LeaseLoanPlanVO leaseLoanPlanVO: vo.getLeaseLoanPlan()){
            map.put("if_begin_plan",leaseLoanPlanVO.getIf_begin_plan());
            map.put("plan_date_loan",leaseLoanPlanVO.getPlan_date());
            list.add(map);
        }
        map = new HashMap<>();
        map.put("lease_loan_plan",list);
        map.put("plan_date_loan",vo.getPlanDateLoan());
        map.put("year_days_flow",vo.getYearDaysFlow());
        map.put("prepay_or_not",vo.getPrepayOrNot());
        String calVoString = JSON.toJSONString(map);
        String yearHmString = JSON.toJSONString(yearHm);
        list = new ArrayList();
        Map<String, Object> eventmap = new HashMap();
        for(InoutPlanVO inoutPlanVO: inoutPlan){
            map = new HashMap<>();
            eventmap = new HashMap<>();
            map.put("lease_time",inoutPlanVO.getLeaseTime());
            map.put("cal_date",inoutPlanVO.getCalDate());
            map.put("plan_date",inoutPlanVO.getPlanDate());
            eventmap.put("event_class_code",inoutPlanVO.getTransType().getEventClassCode());
            eventmap.put("event_class_name",inoutPlanVO.getTransType().getEventClassName());
            eventmap.put("event_code",inoutPlanVO.getTransType().getEventCode());
            eventmap.put("event_name",inoutPlanVO.getTransType().getEventName());
            eventmap.put("memo",inoutPlanVO.getTransType().getMemo());
            eventmap.put("code",inoutPlanVO.getTransType().getCode());
            eventmap.put("pk",inoutPlanVO.getTransType().getPk());
            eventmap.put("cash_direction",inoutPlanVO.getTransType().getCashDeriction());
            map.put("trans_type",eventmap);
            map.put("lease_cash",inoutPlanVO.getLeaseCash());
            map.put("lease_cash_tax",inoutPlanVO.getLeaseCashTax());
            map.put("lease_interest",inoutPlanVO.getLeaseInterest());
            map.put("lease_interest_tax",inoutPlanVO.getLeaseInterestTax());
            map.put("lease_corpus",inoutPlanVO.getLeaseCorpus());
            map.put("lease_corpus_tax",inoutPlanVO.getLeaseCorpusTax());
            map.put("lease_balance",inoutPlanVO.getLeaseBalance());
            map.put("make_method",inoutPlanVO.getMakeMethod());
            map.put("rent_type",inoutPlanVO.getRentType());
            map.put("lease_cash_in",inoutPlanVO.getLeaseCashFin());
            map.put("no_tax_interest",inoutPlanVO.getNoTaxInterest());
            map.put("no_tax_srvfee",inoutPlanVO.getNoTaxSrvfee());
            map.put("no_tax_otherin",inoutPlanVO.getNoTaxOtherin());
            map.put("no_tax_otherout",inoutPlanVO.getNoTaxOtherout());
            map.put("sum_tax",inoutPlanVO.getSumTax());
            map.put("tax_rate",inoutPlanVO.getTaxRate());
            map.put("input_tax",inoutPlanVO.getInputTax());
            map.put("input_tax_diff",inoutPlanVO.getInputTaxDiff());
            map.put("lease_cash_fin",inoutPlanVO.getLeaseCashFin());
            map.put("lease_corpus_fin",inoutPlanVO.getLeaseCorpusFin());
            map.put("lease_interest_fin",inoutPlanVO.getLeaseInterestFin());
            map.put("lease_cash_tax_fin",inoutPlanVO.getLeaseCashTaxFin());
            map.put("lease_interest_tax_fin",inoutPlanVO.getLeaseInterestTaxFin());
            map.put("lease_corpus_tax_fin",inoutPlanVO.getLeaseCorpusTaxFin());
            map.put("divide_cash",inoutPlanVO.getDivideCash());
            map.put("divide_corpus",inoutPlanVO.getDivideCorpus());
            map.put("divide_interest",inoutPlanVO.getDivideInterest());
            map.put("tax_mode",inoutPlanVO.getTaxMode());
            map.put("rent_memo",inoutPlanVO.getRentMemo());
            map.put("rent_event_type",inoutPlanVO.getRentEventType());
            list.add(map);
        }
        String inoutPlanString = JSON.toJSONString(list);
        String oldAccrualListString = JSON.toJSONString(oldAccrual);


        Map queryMap = new HashMap();
        queryMap.put("calVo", calVoString);
        queryMap.put("sourceBillType",source_billtype);
        queryMap.put("accrualWay", accrualWay);
        queryMap.put("sourcePk", source_pk);
        queryMap.put("yearHm", yearHmString);
        queryMap.put("inoutPlan", inoutPlanString);
        queryMap.put("oldAccrual", oldAccrualListString);


        RestTemplate restTemplate  = (RestTemplate) SpringUtils.getBean(RESTTEMPLATE);
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8 ");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<Map> requestEntity = new HttpEntity<Map>(queryMap, headers);
        String url = CalBusiConfig.url+"/reCalInoutPlanController/getAccrualCal";
        ResponseEntity<Map> responseEntity = restTemplate.postForEntity(url, requestEntity, Map.class);
        Map result = responseEntity.getBody();
        List resultlist = new ArrayList();
        if("200".equals(ObjectUtil.toString(result.get("code")))){
            resultlist = (List)result.get("result");
        }else{
            throw new BaseException(result.get("msg").toString());
        }
        return resultlist;

    }


}
