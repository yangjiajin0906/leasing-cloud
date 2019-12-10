package com.leasing.common.config;

import com.aliyun.oss.OSSClient;

/**
 * @project:leasing-cloud
 * @date:2019-12-5
 * @author:lvcna@yonyou.com
 * @description: 枚举单例,获取Oss Client
 **/
public enum OssConfigure {
    //C端业务平台
    OSS_CONFIGURE;

    private OSSClient ossClient = null;

    /**
     * 初始化C端业务平台实例
     */
    private OssConfigure(){
        ossClient = new OSSClient(OssConfig.endPoint, OssConfig.accessKeyId, OssConfig.accessKeySecret);
    }

    /**
     * 获取C端业务平台实例
     * @return OSSClient
     */
    public OSSClient getOssClient(){
        return ossClient;
    }
}
