package com.leasing.customer.controller;

import com.alibaba.fastjson.JSON;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.enums.constant.PubEnumsConstant;
import com.leasing.common.exception.BaseException;
import com.leasing.customer.dao.vo.CustomerCorpAllVO;
import com.leasing.customer.dao.vo.CustomerVO;
import com.leasing.customer.service.CustomerCorpApplyService;
import com.leasing.customer.util.BaseBusinessUtils;
import org.apache.commons.lang.StringUtils;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-11-01
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
public class CustomerCorpApplyController {
    @Resource
    private CustomerCorpApplyService service;

    public ResResult save(String data) {
        CustomerCorpAllVO vo = JSON.parseObject(data, CustomerCorpAllVO.class);

        //校验客户 税务登记证号(国税)、税务登记证号(地税)与 营业执照号码 唯一
        String exception = service.checkUnique(vo);
        if (StringUtils.isNotBlank(exception)) {
            throw new BaseException(exception);
        }

        CustomerVO storageCustomer = service.queryCustomerStatusByName(vo.getCustomerName());
        // 如果存在客户冻结的情况，需要调用特殊的解冻程序
        if (storageCustomer != null) {
            if (storageCustomer.getCustomerType().shortValue() == PubEnumsConstant.CUSTOMER_TYPE_CORP.shortValue()) {

                vo.setCustomerStatus(PubEnumsConstant.IF_YES);

            }
        }
        return null;
    }
}