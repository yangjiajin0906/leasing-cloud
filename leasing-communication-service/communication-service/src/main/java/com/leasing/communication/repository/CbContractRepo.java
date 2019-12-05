package com.leasing.communication.repository;

import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.BaseRepository;
import com.leasing.communication.entity.dos.CbContractDO;
import com.leasing.communication.entity.vo.CbContractVO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-12-3
 * @author:lvcna@yonyou.com
 * @description: 2C合同数据库接口
 **/
@Repository
public interface CbContractRepo extends BaseRepository<CbContractDO, BaseQuery, CbContractVO, String> {

    @Query(" select a from CbContractVO a " +
            " left join fetch a.customerProvince b " +
            " left join fetch a.customerCity c " +
            " left join fetch a.customerRegion d " +
            " left join fetch a.pkSystem e")
    List<CbContractVO> queryForPage();

}
