package com.leasing.common.base.repository;

import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.vo.foundation.RoleVO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepo extends BaseRepository<RoleVO, BaseQuery, RoleVO, String>  {

    /**
     * 查询某用户对应的所有角色情况
     */
    @Query(value = "select r from RoleVO r left join fetch r.pkCorp left join UserRoleVO ur on ur.pkGroup = r.pkRole " +
            " left join UserVO u on u.pkUserdeUser = ur.pkUser where u.pkUser = :pkUser ")
    List<RoleVO> ListRoleVO(@Param("pkUser")String pkUser);
}
