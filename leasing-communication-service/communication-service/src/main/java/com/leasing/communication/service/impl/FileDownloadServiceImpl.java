package com.leasing.communication.service.impl;

import com.aliyun.oss.model.OSSObject;
import com.leasing.communication.entity.dos.*;
import com.leasing.communication.service.FileDownloadService;
import com.leasing.communication.utils.AliyunOssUtil;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.bson.types.ObjectId;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/11/25
 * @author:Yjj@yonyou.com
 * @description: 2c文件处理类
 **/
@Service("communication.FileDownloadServiceImpl")
public class FileDownloadServiceImpl implements FileDownloadService {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(FileDownloadServiceImpl.class);

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Override
    public List<CustomerDO> downloadFileCus(String fileName) throws IOException {
        OSSObject ossObject = AliyunOssUtil.downloadFile(fileName);
        InputStream inputStream = ossObject.getObjectContent();
        //解析excel
        List<CustomerDO> list = new ArrayList<>();
        ossObject.close();
        inputStream.close();
        return list;
    }

    @Override
    public List<ContractDO> downloadFileCon(String fileName) throws IOException {
        return null;
    }

    @Override
    public List<CbWithdrawDO> downloadFileWit(String fileName) throws IOException {
        return null;
    }

    @Override
    public List<CbCapitalDO> downloadFileCap(String fileName) throws IOException {
        return null;
    }

    @Override
    public List<CbInvoiceApplyDetailDO> downloadFileInv(String fileName) throws IOException {
        return null;
    }

    @Override
    public List<InoutPlanDO> downloadFileIno(String fileName) throws IOException {
        return null;
    }

    @Override
    public void listFile(String filePathName) {

    }

    /**
     * @description
     * @author Yangjiajin
     * @date 2019/11/26 14:34
     * @param fileName 文件名称, ins 输入流, contentType文件类型
     * @return void
     */
    public void saveMongoFile(String fileName, InputStream ins, String contentType){
        // 将文件存储到mongodb中
        ObjectId objectId = gridFsTemplate.store(ins, fileName, contentType);
        logger.info("保存成功，objectId:" + objectId);
    }

    @Override
    public void downMongoFile(String fileId) {
        Query query = Query.query(Criteria.where("_id").is(fileId));
        // 查询单个文件
        GridFSFile gridFSFile = gridFsTemplate.findOne(query);
    }
}