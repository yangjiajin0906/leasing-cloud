package com.leasing.customer.dao.repository;

import com.leasing.common.base.repository.BaseRepository;
import com.leasing.customer.dao.dos.CustQualificationDO;
import com.leasing.customer.dao.query.CustQualificationQuery;
import com.leasing.customer.dao.vo.CustQualificationVO;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019-10-30
 * @author:zhangzhhn@yonyou.com
 * @description: 资质认证DAO
 **/
@Repository("customer.CustQualificationRepo")
public interface CustQualificationRepo extends BaseRepository<CustQualificationDO, CustQualificationQuery, CustQualificationVO, String> {


}