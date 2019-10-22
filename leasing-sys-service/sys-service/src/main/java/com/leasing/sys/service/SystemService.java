package com.leasing.sys.service;

import com.leasing.sys.entity.vo.SystemVO;

public interface SystemService {
    SystemVO findOne(String pk);
}
