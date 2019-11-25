package com.leasing.communication.controller;

import com.aliyun.oss.model.OSSObject;
import com.leasing.communication.entity.dos.Customer2DO;
import com.leasing.communication.utils.AliyunOssUtil;
import com.leasing.communication.utils.ExcelUtil;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/11/21
 * @author:Yjj@yonyou.com
 * @description:
 **/
@RestController
@RequestMapping(value = "/leasing/communication/file")
public class FileUploadController {

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 通过文件名解析文件
     */
    @RequestMapping("/download")
    @ResponseBody
    public String download() throws IOException {
        Long startTime = new Date().getTime();
        OSSObject ossObject = AliyunOssUtil.downloadFile("temp/2019-11-22/CUSTOMER.xls");
        InputStream inputStream = ossObject.getObjectContent();
        //解析excel
        List<Customer2DO> list = ExcelUtil.importExcel(inputStream,Customer2DO.class,"CUSTOMER.xls");
        Long endTime = new Date().getTime();
        System.out.println("导入了【"+list.size()+"】行数据，共计用时"+(endTime-startTime)/1000 + "秒");
        inputStream.close();
        return "success";
    }

    /**
     * 列出某个文件夹下的所有文件
     */
    @RequestMapping("/testListFile")
    @ResponseBody
    public String testListFile() {
        List<OSSObject> list = AliyunOssUtil.listFile();
        return "success";
    }

    /**
     * 测试上传文件到阿里云OSS存储
     *
     * @return
     */
    @RequestMapping("/testUpload")
    @ResponseBody
    public String testUpload() {
        File file = new File("E:\\excel\\客户.xls");
        AliyunOssUtil.upLoad(file);
        return "success";
    }
    /**
     * 通过文件名下载文件保存在本地
     */
    @RequestMapping("/testDownload")
    @ResponseBody
    public String testDownload() {
        AliyunOssUtil.downloadFile(
                "temp/2019-11-22/CUSTOMER.xls","E:/CUSTOMER.xls");
        return "success";
    }

    @RequestMapping("delete")
    public String delete(@RequestParam("fileName") String objectName)
            throws Exception {
        AliyunOssUtil.delete(objectName);
        return "success";
    }

}