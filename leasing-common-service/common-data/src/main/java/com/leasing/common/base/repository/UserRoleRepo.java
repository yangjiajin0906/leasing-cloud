package com.leasing.common.base.repository;

import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.vo.foundation.UserRoleVO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/11/6
 * @author:wangjc@yonyou.com
 * @description:
 **/
@Repository
public interface UserRoleRepo extends BaseRepository<UserRoleVO, BaseQuery, UserRoleVO, String>{

    /**
     * 查询指定用户对应角色的所有关联关系
     */
    @Query(value = "select s from UserRoleVO s left join fetch s.pkOrg o left join RoleVO r on r.pkRole = s.pkGroup " +
            "left join UserVO u on s.pkUser = u.pkUserdeUser where u.pkUser = :pkUser ")
    List<UserRoleVO> ListUserRole(@Param("pkUser")String pkUser);
}