package com.leasing.communication.service.impl;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.communication.entity.dos.WithdrawDO;
import com.leasing.communication.entity.query.WithdrawQueryVO;
import com.leasing.communication.repository.WithdrawRepo;
import com.leasing.communication.service.WithdrawService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service("communication.WithdrawServiceImpl")
public class WithdrawServiceImpl implements WithdrawService {
    @Resource
    WithdrawRepo withdrawRepo;

    @Override
    public PageQueryData<WithdrawDO> pageQuery(Pagination pagination, WithdrawQueryVO queryVO) {
        WithdrawDO withdrawDO = new WithdrawDO();

//        contractRepo.save(contractDO);
        List list = withdrawRepo.findAll();
        PageQueryData<WithdrawDO> pageQueryData = new PageQueryData<>();
        pageQueryData.setPageData(list);
        pageQueryData.setTotal(100);
        pageQueryData.setPageCount(10);
        return pageQueryData;
    }

    @Override
    public WithdrawDO save(WithdrawDO vo) {
        return withdrawRepo.saveEntity(vo);
    }

    @Override
    public void save(List<WithdrawDO> list) {
        withdrawRepo.saveAll(list);
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