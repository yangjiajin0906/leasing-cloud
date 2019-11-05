package com.leasing.customer.service.impl;

import com.leasing.common.enums.constant.PubEnumsConstant;
import com.leasing.customer.dao.vo.CustomerCorpAllVO;
import com.leasing.customer.dao.vo.CustomerVO;
import com.leasing.customer.service.CustomerCorpApplyService;
import com.leasing.customer.service.CustomerService;
import com.leasing.common.utils.base.BaseBusinessUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-11-01
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Service("customer.CustomerCorpApplyService")
public class CustomerCorpApplyServiceImpl implements CustomerCorpApplyService {
    @Resource
    private CustomerService customerService;

    @Override
    public String checkUnique(CustomerCorpAllVO vo) {

        String wheresql = "";

        StringBuffer exception = new StringBuffer();

        if (vo.getNationalTax() != null) {
            if (vo.getPk() == null) {
                wheresql = "vo.national_tax = '" + vo.getNationalTax() + "'";
            } else {
                wheresql = "vo.national_tax = '" + vo.getNationalTax() + "' and vo.pk_customer <> '" + vo.getPk()
                        + "' and vo.if_new = '" + PubEnumsConstant.IF_YES + "'";
            }

            if (BaseBusinessUtils.checkUniqueFields(vo, new String[]{"national_tax"}, wheresql)) {
                exception.append("税务登记证号(国税)须唯一,请检查.\n");
            }
        }

        if (vo.getLandTax() != null) {
            if (vo.getPk() == null) {
                wheresql = "vo.land_tax = '" + vo.getLandTax() + "'";
            } else {
                wheresql = "vo.land_tax = '" + vo.getLandTax() + "' and vo.pk_customer <> '" + vo.getPk()
                        + "' and vo.if_new = '" + PubEnumsConstant.IF_YES + "'";
            }

            if (BaseBusinessUtils.checkUniqueFields(vo, new String[]{"land_tax"}, wheresql)) {
                exception.append("税务登记证号(地税)须唯一,请检查.");
            }
        }

        if (vo.getLicenseNo() != null) {
            if (vo.getPk() == null) {
                wheresql = "vo.license_no = '" + vo.getLicenseNo() + "'";
            } else {
                wheresql = "vo.license_no = '" + vo.getLicenseNo() + "' and vo.pk_customer <> '" + vo.getPk()
                        + "' and vo.if_new = '" + PubEnumsConstant.IF_YES + "'";
            }

            if (BaseBusinessUtils.checkUniqueFields(vo, new String[]{"license_no"}, wheresql)) {
                exception.append("营业执照号码须唯一,请检查.");
            }
        }
        return exception.toString();
    }

    @Override
    public CustomerVO queryCustomerStatusByName(String customerName) {

        List<CustomerVO> list = customerService.queryCustomerStatusByName(customerName, PubEnumsConstant.CUST_TYPE_STORAGE, PubEnumsConstant.CUSTOMER_TYPE_CORP);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}