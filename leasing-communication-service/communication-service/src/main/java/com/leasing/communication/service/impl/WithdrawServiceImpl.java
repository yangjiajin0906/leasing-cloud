package com.leasing.communication.service.impl;

import com.leasing.communication.entity.dos.WithdrawDO;
import com.leasing.communication.repository.WithdrawRepo;
import com.leasing.communication.service.WithdrawService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Transactional
@Service("communication.WithdrawServiceImpl")
public class WithdrawServiceImpl implements WithdrawService {
    @Resource
    WithdrawRepo withdrawRepo;
    

    @Override
    public WithdrawDO save(WithdrawDO vo) {
        return withdrawRepo.saveEntity(vo);
    }

    @Override
    public void delete(WithdrawDO vo) {
        withdrawRepo.delete(vo);
    }

    @Override
    public WithdrawDO update(WithdrawDO vo) {
        return withdrawRepo.updateEntity(vo);
    }

    @Override
    public WithdrawDO findOne(String pk) {
        return withdrawRepo.findOne(pk);
    }
}