package com.leasing.common.repository.sys;

import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.BaseRepository;
import com.leasing.common.entity.common.dos.PowerMenuDO;
import com.leasing.common.entity.common.vo.PowerMenuVO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019/11/5
 * @author:wangjc@yonyou.com
 * @description:权限分配存储库接口
 **/
@Repository
public interface PowerMenuRepo extends BaseRepository<PowerMenuDO, BaseQuery, PowerMenuVO, String> {

    @Modifying
    @Query(value = "delete from PowerMenuDO p where p.pkRole = :pkRole and p.pkOrg = :pkOrg ")
    void deletePowerMenu(@Param("pkRole")String pkRole, @Param("pkOrg")String pkOrg);
}
