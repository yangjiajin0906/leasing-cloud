package com.leasing.contract.service;
import com.leasing.contract.entity.ContractVO;

import java.util.List;
import java.util.Optional;

public interface contractService{

    ContractVO findContractbyCode(String cont_code);

    List<ContractVO> findContractbyCondition();

    void updateContractNamebyCode(String cont_name,String cont_code);

    ContractVO findbyContractPk(String pk);

    Optional<ContractVO> findByPk(String pk);

    void save(ContractVO vo);

    void update(ContractVO vo);

//    List<ContractVO> findByCont_codeAndCont_name(String cont_code,String cont_name);

}
