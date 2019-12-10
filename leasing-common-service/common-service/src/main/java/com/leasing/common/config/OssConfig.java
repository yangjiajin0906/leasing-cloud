package com.leasing.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @project:leasing-cloud
 * @date:2019-12-4
 * @author:lvcna@yonyou.com
 * @description: C端业务平台阿里OSS服务器配置
 **/
@Configuration
public class OssConfig {

    /** 服务器配置信息 **/
    /**
     * 终端地址
     */
    public static String endPoint;
    /**
     * 用户 KeyId
     */
    public static String accessKeyId;
    /**
     * 用户密码
     */
    public static String accessKeySecret;
    /**
     * 仓库名
     */
    public static String bucketName;

    @Value("${aliyun.oss.endPoint:default}")
    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    @Value("${aliyun.oss.accessKeyId:default}")
    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    @Value("${aliyun.oss.accessKeySecret:default}")
    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    @Value("${aliyun.oss.bucketName:default}")
    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }
}
