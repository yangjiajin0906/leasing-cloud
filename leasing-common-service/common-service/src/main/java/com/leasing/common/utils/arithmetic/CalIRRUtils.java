package com.leasing.common.utils.arithmetic;

import com.leasing.common.base.repository.support.BaseEntityRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @project:leasing-cloud
 * @date:2019/12/11
 * @author:wangjc@yonyou.com
 * @description: 计算IRR公共类
 **/
@Component
public class CalIRRUtils {
    @Resource
    BaseEntityRepository baseEntityRepository;

    public static  CalIRRUtils calIRRUtils;

    @PostConstruct
    public void init(){
        calIRRUtils = this;
    }

    /**
     * 查找对IRR影响的事件类别信息
     */
    public static Map<Short, Map<String, Integer>> getIrrEventInfo() {
        Map<Short, Map<String, Integer>> resultMap = new TreeMap<Short, Map<String,Integer>>();
        List list = calIRRUtils.baseEntityRepository.findByNativeName("getIrrEventInfo");
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i ++) {
                Map map = (Map) list.get(i);
                Short type = ((BigDecimal) map.get("IRR_TYPE_NAME")).shortValue();
                String key = (String) map.get("EVENT_CODE");
                Integer value = ((BigDecimal) map.get("VAL")).intValue();
                if (!resultMap.containsKey(type)) {
                    resultMap.put(type, new TreeMap<String, Integer>());
                }
                Map<String, Integer> valueMap = resultMap.get(type);
                valueMap.put(key, value);
            }
        }
        return resultMap;
    }
}