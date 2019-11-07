package com.leasing.common.base.repository;

import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.entity.common.dos.CoderuleTypeDO;
import com.leasing.common.entity.common.vo.CoderuleTypeVO;
import org.springframework.stereotype.Repository;

@Repository
public interface CoderuleTypeRepo extends BaseRepository<CoderuleTypeDO, BaseQuery, CoderuleTypeVO,String>  {

}
