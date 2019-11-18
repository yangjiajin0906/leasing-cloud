package com.leasing.communication.service.impl;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.utils.base.ObjectUtil;
import com.leasing.communication.entity.dos.ContractDO;
import com.leasing.communication.entity.queryVO.ContractQueryVO;
import com.leasing.communication.repository.ContractRepo;
import com.leasing.communication.service.ContractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service("communication.ContractServiceImpl")
public class ContractServiceImpl implements ContractService {
    @Resource
    ContractRepo contractRepo;

    @Override
    public ContractDO save(ContractDO vo) {
        return contractRepo.saveEntity(vo);
    }

    @Override
    public void save(List<ContractDO> list) {
        contractRepo.saveAll(list);
    }

    @Override
    public void delete(ContractDO vo) {
        contractRepo.delete(vo);
    }

    @Override
    public ContractDO update(ContractDO vo) {
        return contractRepo.updateEntity(vo);
    }

    @Override
    public ContractDO findOne(String pk) {
        return contractRepo.findOne(pk);
    }

    @Override
    public PageQueryData pageData(ContractQueryVO contractQueryVO, Pagination pagination) {
        ContractDO contractDO = new ContractDO();
        createDO(contractDO);
//        contractRepo.save(contractDO);
        List list = contractRepo.findAll();
        PageQueryData pageQueryData = new PageQueryData();
        pageQueryData.setPageData(list);
        pageQueryData.setTotal(100);
        pageQueryData.setPageSize(10);
        return pageQueryData;
    }

    public void createDO(ContractDO contractDO){
        contractDO.setPkContract("11111111111111111111");
        contractDO.setContCode("888-00");
        contractDO.setBusinessName(0);
        contractDO.setContEndDate("2019-09-09");
        contractDO.setMarketIrr(ObjectUtil.toBigDecimal("0.98"));

    }
}