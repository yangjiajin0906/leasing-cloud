package com.leasing.communication.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.*;
import com.leasing.communication.config.AliyunOSSConfig;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/11/22
 * @author:Yjj@yonyou.com
 * @description:
 **/
@Component
public class AliyunOssUtil {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AliyunOssUtil.class);

    private static String FILE_URL; //生成文件路径 预留参数，暂无用
    private static String bucketName = AliyunOSSConfig.BUCKE_NAME;
    private static String endpoint = AliyunOSSConfig.END_POINT;
    private static String accessKeyId = AliyunOSSConfig.AccessKey_ID;
    private static String accessKeySecret = AliyunOSSConfig.AccessKey_Secret;
    private static String fileHost = AliyunOSSConfig.FILE_HOST;
    //private volatile static OSSClient ossClient;

    /**
     * @description 获得OSSClient
     * @author Yangjiajin
     * @date 2019/11/22 14:25
     * @param []
     * @return com.aliyun.oss.OSSClient
     */
    public static OSSClient getOSSClient(){
//        if (ossClient == null) {
//            synchronized (AliyunOssUtil.class){
//                if (ossClient == null) {
//                    ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
//                }
//            }
//        }
//        return ossClient;
        return new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }

    /**
     * 根据文件名 获得文件流
     * @param fileName    要下载的文件名全路径
     */
    public static OSSObject downloadFile(String fileName) throws IOException {
        // 创建OSSClient实例。
        OSSClient ossClient = getOSSClient();
        // 下载OSS文件到本地文件。如果指定的本地文件存在会覆盖，不存在则新建。
        OSSObject object = ossClient.getObject(new GetObjectRequest(bucketName, fileHost + "/" + fileName));
        return object;
    }

    /**
     * 列举 test 文件下所有的文件
     * filePath 路径名称
     */
    public static List<OSSObject> listFile(String filePath) {
        // 创建OSSClient实例。
        OSSClient ossClient = getOSSClient();
        // 构造ListObjectsRequest请求。
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest(bucketName);
        //Delimiter 设置为 “/” 时，罗列该文件夹下的文件
        listObjectsRequest.setDelimiter("/");
        // 设置prefix参数来获取 filePathName 目录下的所有文件。
        listObjectsRequest.setPrefix(fileHost  + "/" +  filePath);
        // 列出文件。
        ObjectListing listing = ossClient.listObjects(listObjectsRequest);
        List<OSSObject> list = new ArrayList<>();
        // 遍历所有文件。
        String key = null; //每个文件的名字
        OSSObject ossObject = null; //每个文件对象
        for (OSSObjectSummary objectSummary : listing.getObjectSummaries()) {
            key = objectSummary.getKey();
            ossObject = ossClient.getObject(new GetObjectRequest(bucketName, key));
            list.add(ossObject);
        }
        // 遍历所有commonPrefix。
        for (String commonPrefix : listing.getCommonPrefixes()) {
            System.out.println(commonPrefix);
        }
        // 关闭OSSClient。
        ossClient.shutdown();
        return list;
    }

    /**
     * @description 删除
     * @author Yangjiajin
     * @date 2019/11/22 13:51
     * @param [objectName]
     * @return void
     */
    public static void delete(String objectName) {
        // 根据BucketName,objectName删除文件
        OSSClient ossClient = getOSSClient();
        ossClient.deleteObject(bucketName, objectName);
    }

    /**
     * 上传文件。
     *
     * @param file 需要上传的文件路径
     * @return 如果上传的文件是图片的话，会返回图片的"URL"，如果非图片的话会返回"非图片，不可预览。文件路径为：+文件路径"
     */
    public static void upLoad(File file) {
        logger.info("------OSS文件上传开始--------" + file.getName());
        // 判断文件
        if (file == null) {
            return;
        }
        // 创建OSSClient实例。
        OSSClient ossClient = getOSSClient();
        try {
            // 判断容器是否存在,不存在就创建
            if (!ossClient.doesBucketExist(bucketName)) {
                ossClient.createBucket(bucketName);
                CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                ossClient.createBucket(createBucketRequest);
            }
            // 设置文件路径和名称
            String fileUrl = fileHost + "/" + file.getName();
            // 上传文件
            PutObjectResult result = ossClient.putObject(new PutObjectRequest(bucketName, fileUrl, file));
            // 设置权限(公开读)
            //ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
            if (result != null) {
                logger.info("------OSS文件上传成功------" + fileUrl);
            }
        } catch (OSSException oe) {
            logger.error(oe.getMessage());
        } catch (ClientException ce) {
            logger.error(ce.getErrorMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }

    /**
     * 通过文件名下载文件到本地路径下
     *
     * @param filePathName    要下载的文件名(全路径)
     * @param localPathName 本地要创建的文件名
     */
    public static void downloadFile(String filePathName, String localPathName) {
        // 创建OSSClient实例。
        OSSClient ossClient = getOSSClient();
        // 下载OSS文件到本地文件。如果指定的本地文件存在会覆盖，不存在则新建。
        ObjectMetadata object = ossClient.getObject(new GetObjectRequest(bucketName, filePathName), new File(localPathName));
        // 关闭OSSClient。
        ossClient.shutdown();
    }

}