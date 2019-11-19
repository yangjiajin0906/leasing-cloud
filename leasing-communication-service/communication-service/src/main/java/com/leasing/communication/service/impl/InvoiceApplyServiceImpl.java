package com.leasing.communication.service.impl;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.utils.base.ObjectUtil;
import com.leasing.communication.entity.dos.InvoiceApplyDO;
import com.leasing.communication.entity.queryVO.InvoiceQueryVO;
import com.leasing.communication.repository.InvoiceApplyRepo;
import com.leasing.communication.service.InvoiceApplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/11/18
 * @author:jiaoshy@yonyou.com
 * @description:
 **/
@Transactional
@Service("communication.InvoiceApplyServiceImpl")
public class InvoiceApplyServiceImpl implements InvoiceApplyService {

    @Resource
    InvoiceApplyRepo invoiceApplyRepo;


    @Override
    public InvoiceApplyDO save(InvoiceApplyDO vo) {
        return null;
    }

    @Override
    public void save(List<InvoiceApplyDO> list) {

    }

    @Override
    public void delete(InvoiceApplyDO vo) {

    }

    @Override
    public InvoiceApplyDO update(InvoiceApplyDO vo) {
        return null;
    }

    @Override
    public InvoiceApplyDO findOne(String pk) {
        return null;
    }

    @Override
    public PageQueryData pageData(InvoiceQueryVO contractQueryVO, Pagination pagination) {
//        List list = invoiceApplyRepo.findAll();
        InvoiceApplyDO invoiceApplyDO = new InvoiceApplyDO();
        invoiceApplyDO.setBankAccount("cec");
        invoiceApplyDO.setContCode("999999");
        invoiceApplyDO.setEin("1");
        invoiceApplyDO.setCustomerName("张正海");
        invoiceApplyDO.setContName("张正海的合同");
        invoiceApplyDO.setEmployerName("张正海");
        invoiceApplyDO.setExcludingTax(ObjectUtil.toBigDecimal("122"));
        invoiceApplyDO.setPlanDate("2019-08-11");
        List list = new ArrayList();
        list.add(invoiceApplyDO);
        PageQueryData pageQueryData = new PageQueryData();
        pageQueryData.setPageData(list);
        pageQueryData.setTotal(100);
        pageQueryData.setPageCount(10);
        return pageQueryData;
    }
}
