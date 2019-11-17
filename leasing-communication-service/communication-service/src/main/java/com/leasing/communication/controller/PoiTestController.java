package com.leasing.communication.controller;

import com.leasing.communication.entity.Person;
import com.leasing.communication.utils.PoiExcelUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/11/17
 * @author:Yjj@yonyou.com
 * @description:
 **/
@RestController
@RequestMapping(value = "/leasing/communication/poi")
public class PoiTestController {

    @RequestMapping("import")
    public void importCustomerInfoTest(MultipartFile file) throws Exception {
        Long startTime = new Date().getTime();
        String filePath  = "E:\\excel\\客户.xlsx";
        InputStream inputStream = new FileInputStream(new File(filePath));
        //InputStream inputStream2 = file.getInputStream();
        //解析excel
        List<Person> list = PoiExcelUtils.parse(inputStream,Person.class);
        Long endTime = new Date().getTime();
        System.out.println("导入了【"+list.size()+"】行数据，共计用时"+(endTime-startTime)/1000 + "秒");
    }
}