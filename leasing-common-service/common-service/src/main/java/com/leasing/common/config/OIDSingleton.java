package com.leasing.common.config;

import com.leasing.common.utils.frame.SnowflakeIdWorker;

/**
 * @project:leasing-cloud
 * @date:2019-12-10
 * @author:lvcna@yonyou.com
 * @description: 主键生成器单例
 **/
public enum OIDSingleton {
    SNOWFLAKEID,
    ;
    private SnowflakeIdWorker snowflakeIdWorker;

    private OIDSingleton(){
        snowflakeIdWorker = new SnowflakeIdWorker(0, 0);
    }

    public SnowflakeIdWorker getOidWorker(){
        return snowflakeIdWorker;
    }

}
