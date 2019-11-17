package com.leasing.sys.dao.repository;

import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.BaseRepository;
import com.leasing.common.vo.foundation.UserVO;
import com.leasing.sys.entity.dto.ClientDO;
import com.leasing.sys.entity.vo.ClientVO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019/11/5
 * @author:Yjj@yonyou.com
 * @description: 用户登录
 **/
@Repository
public interface LoginClientRepo extends BaseRepository<ClientDO, BaseQuery, ClientVO, String>{

    @Query(name="LoginClientRepo.validateUser")
    UserVO validateUser(String pkUserdeCode, String pkOrg, String pwd);
}