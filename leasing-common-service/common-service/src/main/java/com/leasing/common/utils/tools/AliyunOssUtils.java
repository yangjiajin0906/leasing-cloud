package com.leasing.common.utils.tools;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.leasing.common.config.OssConfig;
import com.leasing.common.config.OssConfigure;

import java.util.ArrayList;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-12-4
 * @author:lvcna@yonyou.com
 * @description: 阿里云OSS服务工具类
 **/
public class AliyunOssUtils {

    /**
     * 默认阿里云OSS配置
     * 根据仓库名称,文件夹获取文件夹下所有文件集合
     * @param folder
     */
    public static ObjectListing downLoadByDir(String bucketName, String folder){
        return OssConfigure.OSS_CONFIGURE.getOssClient().listObjects(bucketName, folder);
    }

    /**
     * 默认阿里云OSS配置
     * 根据文件夹获取文件夹下所有文件集合->默认配置仓库名
     * @param folder
     */
    public static ObjectListing downLoadByDir(String folder){
        return downLoadByDir(OssConfig.bucketName, folder);
    }

    /**
     * 按照仓库名下载路径下所有文件
     * @param folder 文件路径
     * @param bucketName 仓库名
     * @return
     */
    public static List<OSSObject> loadFileByDir(String bucketName, String folder){
        List<OSSObject> ossObjects = new ArrayList<>();
        ObjectListing listing = downLoadByDir(bucketName, folder);
        if(null != listing && null != listing.getObjectSummaries() && listing.getObjectSummaries().size() > 0){
            for(OSSObjectSummary ossObjectSummary : listing.getObjectSummaries()){
                ossObjects.add(downLoadByKey(ossObjectSummary.getKey()));
            }
        } else {
            return null;
        }
        return ossObjects;
    }

    /**
     * 按照路径下载文件夹下所有文件
     * @param folder 路径
     * @return
     */
    public static List<OSSObject> loadFileByDir(String folder){
        return loadFileByDir(OssConfig.bucketName, folder);
    }

    /**
     * 默认阿里云OSS配置
     * 根据文件Key获取文件,默认仓库名
     * @param key
     */
    public static OSSObject downLoadByKey(String key){
        return downLoadByKey(OssConfig.bucketName, key);
    }

    /**
     * 默认阿里云OSS配置
     * 根据仓库名和文件Key获取单个文件
     * @param bucketName
     * @param key
     * @return
     */
    public static OSSObject downLoadByKey(String bucketName, String key){
        OSSObject ossObject = OssConfigure.OSS_CONFIGURE.getOssClient().getObject(bucketName, key);
        return ossObject;
    }

    /**
     * 自定义阿里云OSS服务配置
     * @param endPoint 终端地址
     * @param keyId OSS服务Key
     * @param keySecret OSS服务密码
     * @param bucketName 仓库名
     * @param key 文件key
     * @return
     */
    public static OSSObject downLoadByKey(String endPoint, String keyId, String keySecret, String bucketName, String key){
        OSSClient ossClient = new OSSClient(endPoint, keyId, keySecret);
        OSSObject ossObject = ossClient.getObject(bucketName, key);
        ossClient.shutdown();
        return ossObject;
    }

    /**
     * 自定义阿里云OSS服务配置
     * @param endPoint 终端地址
     * @param keyId OSS服务Key
     * @param keySecret OSS服务密码
     * @param bucketName 仓库名
     * @param dir 文件夹路径
     * @return
     */
    public static ObjectListing downLoadByDir(String endPoint, String keyId, String keySecret, String bucketName, String dir){
        OSSClient ossClient = new OSSClient(endPoint, keyId, keySecret);
        ObjectListing objectListing = ossClient.listObjects(bucketName, dir);
        ossClient.shutdown();
        return objectListing;
    }
}
