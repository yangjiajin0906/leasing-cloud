package com.leasing.communication.controller;

import com.leasing.communication.service.FileDownloadService;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @project:leasing-cloud
 * @date:2019/11/25
 * @author:Yjj@yonyou.com
 * @description: 2c文件下载类
 **/
@RestController
@RequestMapping(value = "/leasing/communication/fileDownload")
public class FileDownloadController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestFileController.class);

    @Resource
    FileDownloadService fileDownloadService;

    /**
     * 通过文件名解析文件
     * fileName 文件名称(带后缀) 例: CUSTOMER.xls
     */
    @RequestMapping("/downloadCus")
    @ResponseBody
    public String downloadCus(@RequestParam("fileName") String fileName) throws IOException {
        fileDownloadService.downloadFileCus(fileName);
        return "success";
    }

    /**
     * @description 处理合同文件
     * @author Yangjiajin
     * @date 2019/11/25 11:54
     * @param fileName 文件名称
     * @return Customer2DO
     */
    public String  downloadFileCon(String fileName) throws IOException {
        fileDownloadService.downloadFileCon(fileName);
        return "success";
    }

    /**
     * @description 处理付款文件
     * @author Yangjiajin
     * @date 2019/11/25 11:54
     * @param fileName 文件名称
     * @return Customer2DO
     */
    public String  downloadFileWit(String fileName) throws IOException {
        fileDownloadService.downloadFileWit(fileName);
        return "success";
    }

    /**
     * @description 处理收款文件
     * @author Yangjiajin
     * @date 2019/11/25 11:54
     * @param fileName 文件名称
     * @return Customer2DO
     */
    public String  downloadFileCap(String fileName) throws IOException {
        fileDownloadService.downloadFileCap(fileName);
        return "success";
    }

    /**
     * @description 处理票据文件
     * @author Yangjiajin
     * @date 2019/11/25 11:54
     * @param fileName 文件名称
     * @return Customer2DO
     */
    public String  downloadFileInv(String fileName) throws IOException {
        fileDownloadService.downloadFileInv(fileName);
        return "success";
    }

    /**
     * @description 处理租金计划文件
     * @author Yangjiajin
     * @date 2019/11/25 11:54
     * @param fileName 文件名称
     * @return Customer2DO
     */
    public String  downloadFileIno(String fileName) throws IOException {
        fileDownloadService.downloadFileIno(fileName);
        return "success";
    }

    /**
     * 列出某个文件夹下的所有文件
     * filePath 路径名称 例: temp
     */
    @RequestMapping("/listFile")
    @ResponseBody
    public String listFile(@RequestParam("filePath") String filePath) throws IOException {
        fileDownloadService.listFile(filePath);
        return "success";
    }
}