package com.leasing.sys.service;

/**
 * @project:leasing-cloud
 * @date:2019-10-15
 * @author:wangjc@yonyou.com
 * @description:
 **/
import com.leasing.sys.entity.dos.DFuncMenuDO;
import com.leasing.sys.entity.vo.DFuncMenuVO;

import java.util.List;
import java.util.Map;

public interface DFuncMenuService {
//    List<DFuncMenuDO> getAllMenu();
//
//    void addDfuncMenu(DFuncMenuDO vo);
//
    DFuncMenuDO findByPkFuncmenu(String pk);
//
//    void updateDfuncMenu(DFuncMenuDO vo);
//
//    void deleteDfuncMenu(String pk);

    List<DFuncMenuVO>getFuncmenu();

    void updateDFuncMenu(DFuncMenuDO dos);


}
