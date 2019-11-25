package com.leasing.communication.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @project:leasing-cloud
 * @date:2019/11/22
 * @author:Yjj@yonyou.com
 * @description:
 **/
@Component
@PropertySource(value = "classpath:bootstrap.yml")
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliyunOSSConfig implements InitializingBean {

    private String endPoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
    private String fileHost;

    //仓库名称
    public static String BUCKE_NAME;
    //地域节点
    public static String END_POINT;
    //AccessKey ID
    public static String AccessKey_ID;
    //Access Key Secret
    public static String AccessKey_Secret;
    //仓库中的某个文件夹
    public static String FILE_HOST;

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getFileHost() {
        return fileHost;
    }

    public void setFileHost(String fileHost) {
        this.fileHost = fileHost;
    }

    @Override
    public String toString() {
        return "AliyunOSSConfig{" +
                "endPoint='" + endPoint + '\'' +
                ", accessKeyId='" + accessKeyId + '\'' +
                ", accessKeySecret='" + accessKeySecret + '\'' +
                ", bucketName='" + bucketName + '\'' +
                ", fileHost='" + fileHost + '\'' +
                '}';
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        BUCKE_NAME = bucketName;
        END_POINT = endPoint;
        AccessKey_ID = accessKeyId;
        AccessKey_Secret = accessKeySecret;
        FILE_HOST = fileHost;
    }
}