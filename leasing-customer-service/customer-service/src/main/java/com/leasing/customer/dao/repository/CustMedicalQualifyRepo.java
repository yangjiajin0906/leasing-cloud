package com.leasing.customer.dao.repository;

import com.leasing.common.base.repository.BaseRepository;
import com.leasing.customer.dao.dos.CustMedicalQualifyDO;
import com.leasing.customer.dao.query.CustMedicalQualifyQuery;
import com.leasing.customer.dao.vo.CustMedicalQualifyVO;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019-10-31
 * @author:zhangzhhn@yonyou.com
 * @description: 医院资质信息表
 **/
@Repository("customer.CustMedicalQualifyRepo")
public interface CustMedicalQualifyRepo extends BaseRepository<CustMedicalQualifyDO, CustMedicalQualifyQuery, CustMedicalQualifyVO, String> {
}