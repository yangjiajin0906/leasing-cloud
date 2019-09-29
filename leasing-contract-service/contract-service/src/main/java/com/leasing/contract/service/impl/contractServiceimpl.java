package com.leasing.contract.service.impl;

import com.leasing.contract.entity.ContractVO;
import com.leasing.contract.repository.ContractRepository;
import com.leasing.contract.service.contractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @project:leasing-cloud
 * @date:2019/9/23
 * @author:wangjc@yonyou.com
 * @description:
 **/
@Service("contractService")
@Transactional
public class contractServiceimpl implements contractService {

    /**
     * 注: 除原生sql外 jpa接口与repository接口均不可用下划线给实体命名,违反规则无法启动服务
     */
    @Resource
    ContractRepository contractRepository;

    @Override
    public ContractVO findContractbyCode(String cont_code){
        return contractRepository.findbyContractCode(cont_code);
    }

    @Override
    public List<ContractVO> findContractbyCondition(){
        return  contractRepository.findContractbyCondition();
    }

    @Override
    public  void updateContractNamebyCode(String cont_name,String cont_code){
        contractRepository.updateContractNamebyCode(cont_name,cont_code);
    }

    @Override
    public ContractVO findbyContractPk(String pk){return contractRepository.findbyContractPk(pk);}

    @Override
    public Optional<ContractVO>findByPk(String pk){return contractRepository.findById(pk);}

    @Override
    public void save(ContractVO vo) {
        contractRepository.save(vo);
    }

    @Override
    public void update(ContractVO vo) {contractRepository.saveAndFlush(vo);}



//    @Override
//    public List<ContractVO>findByCont_codeAndCont_name(String cont_code,String cont_name){
//        return contractRepository.findByCont_codeAndCont_name(cont_code,cont_name);
//    }

}