package com.leasing.sys.test;

import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.BaseRepository;
import com.leasing.common.base.repository.support.StringModalType;
import com.leasing.sys.entity.dos.DFuncMenuDO;
import com.leasing.sys.entity.vo.DFuncMenuVO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TestDozerRepository extends BaseRepository<DFuncMenuDO, DFuncMenuVO, BaseQuery,String> {
    public DFuncMenuDO findByPkFuncmenu(String pk);

    public void deleteDFuncMenuDOByPkFuncmenu(String pk);

    @Query(name = "DFuncMenuVO.getDFuncmenu")
    List<DFuncMenuVO> getDFuncmenu();

    @Modifying
    @Query(value = "update DFuncMenuDO s set s.menuPath =?1 where s.pkFuncmenu =?2 and s.ts=?3")
    int updateDFuncmenu(String menupath, String pk, StringModalType ts);
}
