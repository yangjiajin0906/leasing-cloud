package com.leasing.common.base.repository;

import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.vo.foundation.UserVO;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends BaseRepository<UserVO, BaseQuery, UserVO, String> {
    
}
