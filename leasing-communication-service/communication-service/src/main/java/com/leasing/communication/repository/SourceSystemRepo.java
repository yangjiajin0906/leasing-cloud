package com.leasing.communication.repository;

import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.entity.BaseVO;
import com.leasing.common.base.repository.BaseRepository;
import com.leasing.communication.entity.dos.SourceSystemDO;
import com.leasing.communication.entity.dto.SourceSystemDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-12-8
 * @author:lvcna@yonyou.com
 * @description:
 **/
@Repository
public interface SourceSystemRepo extends BaseRepository<SourceSystemDO, BaseQuery, BaseVO, String> {

    @Query(value = " select a from SourceSystemDTO a ")
    List<SourceSystemDTO> findAllDTO();

}
