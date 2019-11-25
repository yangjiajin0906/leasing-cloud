package com.leasing.common.serviceimpl;

import com.leasing.common.entity.common.dos.SystemDO;
import com.leasing.common.base.repository.SystemRepository;
import com.leasing.common.entity.common.query.SystemQuery;
import com.leasing.common.entity.common.vo.SystemVO;
import com.leasing.common.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public SystemDO findOne(String pk){
        return  systemRepository.findOne(pk);
    }

    @Override
    public List<SystemVO> ListSystem(){return systemRepository.pageQuery(new SystemQuery(),"ListSystem");}
}