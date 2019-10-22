package com.leasing.sys.serviceimpl;

import com.leasing.sys.entity.vo.SystemVO;
import com.leasing.sys.dao.SystemRepository;
import com.leasing.sys.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @project:leasing-cloud
 * @date:2019/10/16
 * @author:wangjc@yonyou.com
 * @description:
 **/
@Service("SystemServiceImpl")
public class SystemServiceImpl implements SystemService {
    @Autowired
    SystemRepository systemRepository;

    @Override
    public SystemVO findOne(String pk){
        return  systemRepository.findOne(pk);
    }
}