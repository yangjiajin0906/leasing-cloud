package com.leasing.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @project:leasing-cloud
 * @date:2019-12-10
 * @author:lvcna@yonyou.com
 * @description:
 **/

@Component
public class SnowflakeIdConfig {

    private String test;
    @Value("#{${yl.oid.workId}}")
    private Map<String,String> workId;

    private String dataCenter;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }



    public void setWorkId(Map workId) {
        System.out.println(123);
        System.out.println(123);
    }

    public String getDataCenter() {
        return dataCenter;
    }

    public void setDataCenter(String dataCenter) {
        this.dataCenter = dataCenter;
    }
}
