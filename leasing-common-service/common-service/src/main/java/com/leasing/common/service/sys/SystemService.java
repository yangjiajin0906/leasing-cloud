package com.leasing.common.service.sys;

import com.leasing.common.entity.common.dos.SystemDO;
import com.leasing.common.entity.common.vo.SystemVO;

import java.util.List;

public interface SystemService {
    SystemDO findOne(String pk);

    /**
     * 获取系统内部所有的系统列表
     */
    List<SystemVO> ListSystem();
}
