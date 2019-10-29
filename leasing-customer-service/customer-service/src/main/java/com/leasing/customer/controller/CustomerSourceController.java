package com.leasing.customer.controller;

import com.leasing.common.base.web.ResResult;
import com.leasing.common.utils.ResultUtils;
import com.leasing.customer.dao.vo.CustRelatedCompanyVO;
import com.leasing.customer.service.CustRelatedCompanyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-10-29
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@RestController
@RequestMapping("/customer")
public class CustomerSourceController {

    @Resource
    private CustRelatedCompanyService service;


    @PostMapping("/querySourceByCustomer")
    public ResResult querySourceByCustomer(String data) {

        List<CustRelatedCompanyVO> list = service.findByCustomer("0001MG00000000029381");
        return ResultUtils.successWithData(list);
    }

}