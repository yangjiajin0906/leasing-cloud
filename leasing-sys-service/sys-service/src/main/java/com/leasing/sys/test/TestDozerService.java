package com.leasing.sys.test;

import com.leasing.sys.entity.dos.DFuncMenuDO;
import com.leasing.sys.entity.vo.DFuncMenuVO;

import java.util.List;

public interface TestDozerService {
    DFuncMenuDO findByPkFuncmenu(String pk);

    List<DFuncMenuVO> getFuncmenu();

    void updateDFuncMenu(DFuncMenuDO dos);
}
