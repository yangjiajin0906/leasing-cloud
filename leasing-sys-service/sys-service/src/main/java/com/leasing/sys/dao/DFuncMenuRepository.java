package com.leasing.sys.dao;

/**
 * @project:leasing-cloud
 * @date:2019/10/15
 * @author:wangjc@yonyou.com
 * @description:
 **/
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
public interface DFuncMenuRepository extends BaseRepository<DFuncMenuDO,String> {


    public DFuncMenuDO findByPkFuncmenu(String pk);

    public void deleteDFuncMenuDOByPkFuncmenu(String pk);

    @Query(name = "DFuncMenuVO.getDFuncmenu")
    List<DFuncMenuVO> getDFuncmenu();

//    @Query("select new com.leasing.sys.entity.vo.DFuncMenuVO(s,t.pkSystem,t.systemName) " +
//            "FROM DFuncMenuDO s left JOIN SystemVO t on s.pkSystem = t.pkSystem")
//    List<DFuncMenuVO> getDFuncmenu1();

    @Modifying
    @Query(value = "update DFuncMenuDO s set s.menuPath =?1 where s.pkFuncmenu =?2 and s.ts=?3")
    int updateDFuncmenu(String menupath, String pk, StringModalType ts);


}
