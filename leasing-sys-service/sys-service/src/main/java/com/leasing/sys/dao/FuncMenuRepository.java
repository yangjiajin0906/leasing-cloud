package com.leasing.sys.dao;

import com.leasing.common.entity.sys.FuncMenuVO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-9-24
 * @author:lvcna@yonyou.com
 * @description:
 **/
@Repository
public interface FuncMenuRepository extends MongoRepository<FuncMenuVO,Long> {

    List<FuncMenuVO> findByTarget(String target);

    List<FuncMenuVO> findByName(String name);

}
