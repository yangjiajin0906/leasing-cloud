package com.leasing.customer.service;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.customer.dao.query.CustMedicalQualifyQuery;
import com.leasing.customer.dao.vo.CustMedicalQualifyVO;

/**
 * @project:leasing-cloud
 * @date:2019-10-31
 * @author:zhangzhhn@yonyou.com
 * @description: 医院资质信息服务接口
 **/
public interface CustMedicalQualifyService {

    PageQueryData<CustMedicalQualifyVO> pageQuery(Pagination pagination, CustMedicalQualifyQuery qualifyQuery);
}