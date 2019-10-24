package com.leasing.sys.service;

import com.leasing.sys.entity.dos.SystemDO;

public interface SystemService {
    SystemDO findOne(String pk);
}
