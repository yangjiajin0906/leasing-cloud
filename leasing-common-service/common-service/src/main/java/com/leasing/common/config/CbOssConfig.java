package com.leasing.common.config;

import org.springframework.stereotype.Component;

/**
 * @project:leasing-cloud
 * @date:2019-12-4
 * @author:lvcna@yonyou.com
 * @description: C端业务平台阿里OSS服务器配置
 **/
@Component
public class CbOssConfig {

    private String endPoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
    private String fileHost;

}
