package com.leasing.customer.service.impl;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.customer.dao.query.CustMedicalQualifyQuery;
import com.leasing.customer.dao.repository.CustMedicalQualifyRepo;
import com.leasing.customer.dao.vo.CustMedicalQualifyVO;
import com.leasing.customer.service.CustMedicalQualifyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-10-31
 * @author:zhangzhhn@yonyou.com
 * @description: 医院资质服务接口实现类
 **/
@Service("customer.CustMedicalQualifyService")
public class CustMedicalQualifyServiceImpl implements CustMedicalQualifyService {
    @Resource
    private CustMedicalQualifyRepo repo;
    @Override
    public PageQueryData<CustMedicalQualifyVO> pageQuery(Pagination pagination, CustMedicalQualifyQuery qualifyQuery) {
        return repo.pageQuery(pagination, qualifyQuery, "");
    }
}