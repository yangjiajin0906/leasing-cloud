package com.leasing.communication.controller;

import com.aliyun.oss.model.OSSObject;
import com.leasing.communication.entity.dos.CustomerDO;
import com.leasing.communication.utils.AliyunOssUtil;
import com.leasing.communication.utils.ExcelUtil;
import com.mongodb.client.gridfs.GridFSFindIterable;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.bson.types.ObjectId;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * @project:leasing-cloud
 * @date:2019/11/21
 * @author:Yjj@yonyou.com
 * @description:
 **/
@RestController
@RequestMapping(value = "/leasing/communication/testFile")
public class TestFileController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestFileController.class);

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private MongoTemplate mongoTemplate;
    /**
     * 通过文件名解析文件
     */
    @RequestMapping("/download")
    @ResponseBody
    public String download() throws IOException {
        Long startTime = new Date().getTime();
        OSSObject ossObject = AliyunOssUtil.downloadFile("2019-11-25/客户.xls");
        InputStream inputStream = ossObject.getObjectContent();
        //解析excel
        List<CustomerDO> list = ExcelUtil.importExcel(inputStream,CustomerDO.class,"客户.xls");
        Long endTime = new Date().getTime();
        logger.info("导入了【"+list.size()+"】行数据，共计用时"+(endTime-startTime)/1000 + "秒");
        inputStream.close();
        return "success";
    }

    /**
     * 列出某个文件夹下的所有文件
     */
    @RequestMapping("/testListFile")
    @ResponseBody
    public String testListFile() {
        List<OSSObject> list = AliyunOssUtil.listFile("temp/");
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
        File file = new File("E:\\excel\\CUSTOMER.xls");
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

    @RequestMapping("uploadfile")
    public String uploadfile(MultipartFile multipartFile) throws IOException {
        String filePath = "E:\\excel\\客户.xls";
        File file = new File(filePath);
        InputStream inputStream = new FileInputStream(file);
        multipartFile = new MockMultipartFile(file.getName(), inputStream);
        // 获得提交的文件名
        String filename = multipartFile.getOriginalFilename();
        if("".equals(filename)){
            filename = multipartFile.getName();
        }
        // 获得文件输入流
        InputStream ins = multipartFile.getInputStream();
        // 获得文件类型
        String contenttype = multipartFile.getContentType();
        // 将文件存储到mongodb中,mongodb 将会返回这个文件的具体信息
        ObjectId gfs = gridFsTemplate.store(ins, filename, contenttype);

        Query query2 = query(Criteria.where("_id").is(gfs.toString()));
        Query query = query(Criteria.where("filename").is(filename));
        // 查询单个文件
        GridFSFile gfsfile = gridFsTemplate.findOne(query);
        GridFSFile gfsfile2 = gridFsTemplate.findOne(query2);
        return "success";
    }

    @RequestMapping("listFile")
    public String listFile() {
        Query query2 = query(Criteria.where("filename").is("CUSTOMER.xls"));
        GridFSFindIterable iterable= gridFsTemplate.find(query2);
        GridFSFile gridFSFile = null;
        Consumer<GridFSFile> action = System.out::println;
        Consumer<GridFSFile> action2 = GridFSFile::getObjectId;
        iterable.forEach(action);
        iterable.forEach(action2);
        GridFsResource[] txtFiles = gridFsTemplate.getResources(".xls");
        for (GridFsResource txtFile : txtFiles) {
            System.out.println(txtFile.getFilename());
        }
        return "success";
    }

}