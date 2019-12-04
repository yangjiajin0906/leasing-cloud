package com.leasing.common.repository.sys;

/**
 * @project:leasing-cloud
 * @date:2019/10/15
 * @author:wangjc@yonyou.com
 * @description:
 **/
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.BaseRepository;
import com.leasing.common.base.repository.support.StringModalType;
import com.leasing.common.entity.common.dos.DFuncMenuDO;
import com.leasing.common.entity.common.vo.DFuncMenuVO;
import com.leasing.common.entity.common.vo.SystemVO;
import com.leasing.common.entity.foundation.vo.OrgDTO;
import com.leasing.common.entity.foundation.vo.RoleVO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DFuncMenuRepo extends BaseRepository<DFuncMenuDO,BaseQuery,DFuncMenuVO ,String> {


    public void deleteDFuncMenuDOByPkFuncmenu(String pk);



    @Modifying
    @Query(value = "update DFuncMenuDO s set s.billstatus =?1 where s.pkFuncmenu =?2 and s.ts=?3")
    void updateDFuncmenu(Short billstatus, String pk, StringModalType ts);


    @Query(value = "select distinct s from RoleOrgVO r left join r.pkCorp rp left join PowerMenuVO p on p.pkRole = r.pkRole " +
            " left join DFuncMenuVO s on s.pkFuncmenu = p.pkFuncmenu left join fetch s.pkParent pm left join fetch s.pkSystem ps " +
            " left join fetch s.pkOrg po left join fetch s.pkDept pd left join fetch s.pkOperator pu " +
            " where r.pkRole = :pkRole and r.pkCorp = :pkCorp and s.pkSystem = :pkSystem ")
    List<DFuncMenuVO> ListPowerFuncMenu(@Param("pkRole") RoleVO pkRole, @Param("pkCorp") OrgDTO pkCorp, @Param("pkSystem") SystemVO pkSystem);


    @Query(value = "select distinct s from UserVO u inner join UserRoleVO r on r.pkUser = u.pkUserdeUser left join PowerMenuVO p " +
            " on p.pkRole = r.pkGroup left join DFuncMenuVO s on s.pkFuncmenu = p.pkFuncmenu left join fetch s.pkParent pm " +
            " left join fetch s.pkSystem ps left join fetch s.pkOrg po left join fetch s.pkDept pd left join fetch s.pkOperator pu " +
            " left join fetch pu.pkOrg where u.pkUser = :pkUser and s.pkSystem = :pkSystem ")
    List<DFuncMenuVO> ListPowerFuncMenuByUser(@Param("pkUser") String pkUser, @Param("pkSystem") SystemVO pkSystem);

}
