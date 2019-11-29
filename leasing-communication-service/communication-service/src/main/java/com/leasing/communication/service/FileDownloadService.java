package com.leasing.communication.service;

import com.leasing.communication.entity.dos.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/11/25
 * @author:Yjj@yonyou.com
 * @description: 2c处理文件下载校验
 **/
public interface FileDownloadService {

    /**
     * @description 处理客户文件
     * @author Yangjiajin
     * @date 2019/11/25 11:54
     * @param fileName 文件名称
     * @return Customer2DO
     */
    List<Customer2DO> downloadFileCus(String fileName) throws IOException;

    /**
     * @description 处理合同文件
     * @author Yangjiajin
     * @date 2019/11/25 11:54
     * @param fileName 文件名称
     * @return Customer2DO
     */
    List<Contract2DO> downloadFileCon(String fileName) throws IOException;

    /**
     * @description 处理付款文件
     * @author Yangjiajin
     * @date 2019/11/25 11:54
     * @param fileName 文件名称
     * @return Customer2DO
     */
    List<Withdraw2DO> downloadFileWit(String fileName) throws IOException;

    /**
     * @description 处理收款文件
     * @author Yangjiajin
     * @date 2019/11/25 11:54
     * @param fileName 文件名称
     * @return Customer2DO
     */
    List<Capital2DO> downloadFileCap(String fileName) throws IOException;

    /**
     * @description 处理票据文件
     * @author Yangjiajin
     * @date 2019/11/25 11:54
     * @param fileName 文件名称
     * @return Customer2DO
     */
    List<InvoiceApply2DO> downloadFileInv(String fileName) throws IOException;

    /**
     * @description 处理租金计划文件
     * @author Yangjiajin
     * @date 2019/11/25 11:54
     * @param fileName 文件名称
     * @return Customer2DO
     */
    List<InoutPlan2DO> downloadFileIno(String fileName) throws IOException;

    /**
     * @description 通过 文件全路径 批量处理文件
     * @author Yangjiajin
     * @date 2019/11/25 11:54
     * @param filePathName 路径名称
     * @return com.aliyun.oss.model.OSSObject
     */
    void listFile(String filePathName) throws IOException;

    /**
     * @description 把文件存在mongo里
     * @author Yangjiajin
     * @date 2019/11/26 14:34
     * @param fileName 文件名称, ins 输入流, contentType文件类型
     * @return void
     */
    void saveMongoFile(String fileName, InputStream ins, String contentType);

    /**
     * @description 从mongo中取出文件
     * @author Yangjiajin
     * @date 2019/11/26 14:37
     * @param fileId
     * @return void
     */
    void downMongoFile(String fileId);
}