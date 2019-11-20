package com.leasing.customer.dao.repository;

import com.leasing.common.base.repository.BaseRepository;
import com.leasing.customer.dao.dos.CustAssetsDO;
import com.leasing.customer.dao.query.CustAssetsQuery;
import com.leasing.customer.dao.vo.CustAssetsVO;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019-11-12
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Repository("customer.CustAssetsRepo")
public interface CustAssetsRepo extends BaseRepository<CustAssetsDO, CustAssetsQuery, CustAssetsVO, String> {


}