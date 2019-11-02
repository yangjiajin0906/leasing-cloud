package com.leasing.common.base.repository;

import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.entity.common.dos.CoderuleDO;
import com.leasing.common.entity.common.vo.CoderuleVO;
import org.springframework.stereotype.Repository;

@Repository
public interface CoderuleRepo extends BaseRepository<CoderuleDO, BaseQuery, CoderuleVO,String>  {

}
