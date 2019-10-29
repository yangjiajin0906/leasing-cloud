package com.leasing.sys.dao;

/**
 * @project:leasing-cloud
 * @date:2019/10/15
 * @author:wangjc@yonyou.com
 * @description:
 **/
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.support.StringModalType;
import com.leasing.sys.entity.dos.DFuncMenuDO;
import com.leasing.sys.entity.vo.DFuncMenuVO;
import com.leasing.common.base.repository.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DFuncMenuRepo extends BaseRepository<DFuncMenuDO,BaseQuery,DFuncMenuVO ,String> {


    public void deleteDFuncMenuDOByPkFuncmenu(String pk);



    @Modifying
    @Query(value = "update DFuncMenuDO s set s.billstatus =?1 where s.pkFuncmenu =?2 and s.ts=?3")
    void updateDFuncmenu(Short billstatus, String pk, StringModalType ts);


}
