package com.leasing.sys.test;

import com.leasing.common.entity.common.dos.DFuncMenuDO;
import com.leasing.common.entity.common.vo.DFuncMenuVO;

import java.util.List;

public interface TestDozerService {
    DFuncMenuDO findByPkFuncmenu(String pk);

    List<DFuncMenuVO> getFuncmenu();

    void updateDFuncMenu(DFuncMenuDO dos);
}
