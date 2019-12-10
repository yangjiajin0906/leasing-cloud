package com.leasing.communication.repository;

import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.BaseRepository;
import com.leasing.communication.entity.dos.CbImpSetDO;
import com.leasing.communication.entity.dos.SourceSystemDO;
import com.leasing.communication.entity.dto.CbImpSetDTO;
import com.leasing.communication.entity.dto.SourceSystemDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019-12-8
 * @author:lvcna@yonyou.com
 * @description: C端业务导入文件设置
 **/
@Repository
public interface CbImpSetRepo extends BaseRepository<CbImpSetDO, BaseQuery, CbImpSetDO, String>{


    @Query(value = " select a from CbImpSetDTO a where a.pkSystem = :pkSystem " +
            " and a.effective = :flag ")
    CbImpSetDTO findByPkSystem(@Param("pkSystem") SourceSystemDTO pkSystem, @Param("flag") Short effective);



}
