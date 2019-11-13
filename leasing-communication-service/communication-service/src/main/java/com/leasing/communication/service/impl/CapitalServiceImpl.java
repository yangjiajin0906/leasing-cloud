package com.leasing.communication.service.impl;

import com.leasing.communication.entity.dos.CapitalDO;
import com.leasing.communication.repository.CapitalRepo;
import com.leasing.communication.service.CapitalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Transactional
@Service("communication.CapitalServiceImpl")
public class CapitalServiceImpl implements CapitalService {
    @Resource
    CapitalRepo capitalRepo;

    @Override
    public CapitalDO save(CapitalDO vo) {
        return capitalRepo.saveEntity(vo);
    }

    @Override
    public void delete(CapitalDO vo) {
        capitalRepo.delete(vo);
    }

    @Override
    public CapitalDO update(CapitalDO vo) {
        return capitalRepo.updateEntity(vo);
    }

    @Override
    public CapitalDO findOne(String pk) {
        return capitalRepo.findOne(pk);
    }
}