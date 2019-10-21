package com.leasing.sys.dao.repository;

import com.leasing.common.base.repository.BaseRepository;
import com.leasing.common.base.repository.support.StringModalType;
import com.leasing.sys.dao.dos.ParameterDO;
import com.leasing.sys.dao.vo.ParameterVO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-10-11
 * @author:lvcna@yonyou.com
 * @description:
 **/
public interface ParameterRepository extends BaseRepository<ParameterDO,String> {



    @Query(value = "select b from ParameterVO b " +
            " left join ParamTypeDTO m on b.pkParamType = m.pkParamType " +
            " where b.paramCode = ?1 ")
    List<ParameterVO> findTest(String pk);

    @Query(value = "select b from ParameterVO b " +
            " left join fetch b.pkParamType t" +
            " where b.paramCode = ?1 ")
    List<ParameterVO> findTest1(String pk);

    @Query(value = "select b from ParameterVO b " +
            " left join fetch ParamTypeDTO m on b.pkParamType = m.pkParamType " +
            " where b.paramCode = ?1 ")
    List<ParameterVO> findTest2(String pk);

    @Query(value = "select b,m.paramVarname from ParameterVO b " +
            " left join fetch b.pkParamType m " +
            " where m.paramCode = ?1 ")
    List<ParameterVO> findTest3(String pk);

    /**
     * 迫切左连接
     *
     *
     */
    @Query(value = "select b from ParameterVO b " +
            " left join fetch b.pkParamType m " +
            " left join fetch m.pkOperator r " +
            " left join fetch r.pkOrg g " +
            " where m.paramCode = ?1 ")
    List<ParameterVO> findTest4(String pk);

    @Query(value = "select b from ParameterVO b " +
            " left join fetch b.pkParamType m " +
            " where m.paramCode = ?1 ")
    List<ParameterVO> findTest5(String pk);

    @Query(value = "select new com.leasing.common.refvo.sys.ParameterRefVO(b.pkParameter,b.paramName,b.paramCode,b.paramValue) from ParameterDO b where b.paramCode = ?1")
    <S> Collection<S> findTest6(String pk,Class<S> type);

    <S> Collection<S> findByParamCode(String pk, Class<S> type);

    List<ParameterDO> findAll();

    @Query(value = "select new com.leasing.common.refvo.sys.ParameterRefVO(b.pkParameter,b.paramName,b.paramCode,b.paramValue) from ParameterDTO b where b.paramCode = ?1")
    <S> Collection<S> findTest7(String pk,Class<S> type);

    @Modifying
    @Query(value = "update ParameterDO d set d.memo = :memo where d.pkParameter = :pk and d.ts = :ts")
    int updateMemo(@Param("memo") String memo,@Param("pk") String pk,@Param("ts") StringModalType ts);
}
