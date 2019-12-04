package com.leasing.common.repository.sys;

import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.BaseRepository;
import com.leasing.common.entity.foundation.vo.UserVO;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends BaseRepository<UserVO, BaseQuery, UserVO, String> {
    
}
