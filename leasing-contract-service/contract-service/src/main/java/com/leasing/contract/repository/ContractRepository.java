package com.leasing.contract.repository;

import com.leasing.contract.entity.ContractVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContractRepository extends JpaRepository<ContractVO,String> {


    @Query(value = "select * from yls_test_user where pk=?",nativeQuery = true)
    ContractVO findbyContractCode(String cont_code);

    @Query(value = "select * from yls_contract c where rownum<=10",nativeQuery = true)
    List<ContractVO> findContractbyCondition();

    @Query(value ="update yls_contract set cont_name = ? where cont_code =?",nativeQuery = true)
    @Modifying
    void updateContractNamebyCode(String cont_name,String cont_code);

    @Query(value = "select * from yls_test_user w where w.pk = ?1",nativeQuery = true)
    ContractVO findbyContractPk(String pk);


//    List<ContractVO>findByCont_codeAndCont_name(String cont_code,String cont_name);
}
