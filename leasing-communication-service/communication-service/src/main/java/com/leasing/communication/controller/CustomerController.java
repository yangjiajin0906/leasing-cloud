package com.leasing.communication.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.entity.customer.dto.DeptDTO;
import com.leasing.common.entity.customer.dto.OrgDTO;
import com.leasing.common.entity.foundation.vo.UserVO;
import com.leasing.common.utils.base.ClientUtils;
import com.leasing.common.utils.base.DataParseUtils;
import com.leasing.common.utils.sys.ResultUtils;
import com.leasing.communication.entity.dos.CustomerDO;
import com.leasing.communication.entity.query.CustomerQuery;
import com.leasing.communication.service.CustomerService;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(value = "/ListCustomerDO")
    public ResResult ListCustomerDO(@RequestBody(required = false) String data){
        CustomerQuery customerQuery = DataParseUtils.jsonToBean(data,"wherecondition",CustomerQuery.class);
        Pagination pagination = DataParseUtils.jsonToBean(data,"pagination",Pagination.class);
        PageQueryData<CustomerDO> pageQueryData = customerService.ListCustomerDO(pagination,customerQuery,"getCustomerDOList");
        return ResultUtils.successWithData(pageQueryData);
    }

    @RequestMapping(value = "/saveCustomerDO")
    public ResResult saveCustomerDO(@RequestBody(required = false) CustomerDO dos){
        customerService.update(dos);
        return ResultUtils.successWithData(dos);
    }

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