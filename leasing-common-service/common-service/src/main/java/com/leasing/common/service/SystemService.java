package com.leasing.common.service;

import com.leasing.common.entity.common.dos.SystemDO;

public interface SystemService {
    SystemDO findOne(String pk);
}
