package com.leasing.communication.repository;

import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.BaseRepository;
import com.leasing.communication.entity.dos.Customer2DO;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019/11/12
 * @author:Yjj@yonyou.com
 * @description: 2c客户信息导入
 **/
@Repository
public interface CustomerRepo extends BaseRepository<Customer2DO,BaseQuery,Customer2DO,String> {
}
