package com.leasing.communication.controller;

import com.leasing.communication.service.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Map;

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
     * @param file
     * @return void
     */
    @RequestMapping("importCustomerInfo")
    public Map importCustomerInfo(MultipartFile file){
        customerService.saveMongoDB(file);
        return null;
    }

}