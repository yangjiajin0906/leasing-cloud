package com.leasing.communication.service.impl;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.communication.entity.dos.CapitalDO;
import com.leasing.communication.entity.query.CapitalQueryVO;
import com.leasing.communication.repository.CapitalRepo;
import com.leasing.communication.service.CapitalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service("communication.CapitalServiceImpl")
public class CapitalServiceImpl implements CapitalService {
    @Resource
    CapitalRepo capitalRepo;


    @Override
    public PageQueryData<CapitalDO> pageQuery(Pagination pagination, CapitalQueryVO queryVO) {
        List list = capitalRepo.findAll();
        PageQueryData<CapitalDO> pageQueryData = new PageQueryData<>();
        pageQueryData.setPageData(list);
        pageQueryData.setTotal(100);
        pageQueryData.setPageCount(10);
        return pageQueryData;
    }

    @Override
    public CapitalDO save(CapitalDO vo) {
        return capitalRepo.saveEntity(vo);
    }

    @Override
    public void save(List<CapitalDO> list) {
        capitalRepo.saveAll(list);
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