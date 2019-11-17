package com.leasing.communication.service.impl;

import com.leasing.communication.entity.dos.InoutPlanDO;
import com.leasing.communication.repository.InoutPlanRepo;
import com.leasing.communication.service.InoutPlanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service("communication.InoutPlanServiceImpl")
public class InoutPlanServiceImpl implements InoutPlanService {
    @Resource
    InoutPlanRepo inoutPlanRepo;


    @Override
    public InoutPlanDO save(InoutPlanDO vo) {
        return inoutPlanRepo.saveEntity(vo);
    }

    @Override
    public void save(List<InoutPlanDO> list) {
        inoutPlanRepo.saveAll(list);
    }

    @Override
    public void delete(InoutPlanDO vo) {
        inoutPlanRepo.delete(vo);
    }

    @Override
    public InoutPlanDO update(InoutPlanDO vo) {
        return inoutPlanRepo.updateEntity(vo);
    }

    @Override
    public InoutPlanDO findOne(String pk) {
        return inoutPlanRepo.findOne(pk);
    }
}