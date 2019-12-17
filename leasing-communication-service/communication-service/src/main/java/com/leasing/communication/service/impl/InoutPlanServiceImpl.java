package com.leasing.communication.service.impl;

import com.leasing.communication.entity.dos.CbInoutPlanDO;
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
    public CbInoutPlanDO save(CbInoutPlanDO vo) {
        return inoutPlanRepo.saveEntity(vo);
    }

    @Override
    public void save(List<CbInoutPlanDO> list) {
        inoutPlanRepo.saveAll(list);
    }

    @Override
    public void delete(CbInoutPlanDO vo) {
        inoutPlanRepo.delete(vo);
    }

    @Override
    public CbInoutPlanDO update(CbInoutPlanDO vo) {
        return inoutPlanRepo.updateEntity(vo);
    }

    @Override
    public CbInoutPlanDO findOne(String pk) {
        return inoutPlanRepo.findOne(pk);
    }
}