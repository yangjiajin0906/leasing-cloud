package com.leasing.communication.controller;

import com.leasing.communication.entity.Person;
import com.leasing.communication.service.CustomerService;
import com.leasing.communication.utils.EasyPoiUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/11/12
 * @author:Yjj@yonyou.com
 * @description:
 **/
@RestController
@RequestMapping(value = "/leasing/communication/customer")
public class CustomerController {

    @Resource
    CustomerService customerService;

    /**
     * @description 导入
     * @author Yangjiajin
     * @date 2019/11/8 14:21
     * @param filePath
     * @return void
     */
    @RequestMapping("importCustomerInfo")
    public void importCustomerInfo(String filePath){
        //解析excel，
        List<Person> personList = EasyPoiUtils.importExcel(filePath,1,1,Person.class);
    }
}