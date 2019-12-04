package com.leasing.common.repository.sys;
/**
 * @project:leasing-cloud
 * @date:2019/10/31
 * @author:wangjc@yonyou.com
 * @description:编码规则配置存储库层接口
 **/
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.BaseRepository;
import com.leasing.common.entity.common.dos.CoderuleDO;
import com.leasing.common.entity.common.vo.CoderuleVO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CoderuleRepo extends BaseRepository<CoderuleDO, BaseQuery, CoderuleVO,String> {

    @Query(value = "select A.PK_CODERULE as PK_CODERULE,A.CODE_RULE_NAME as CODE_RULE_NAME FROM YLS_CODERULE A" +
            " INNER JOIN SM_FUNCREGISTER B ON A.BUSINESS_POINT = B.CFUNID" +
            " WHERE B.FUN_CODE = :funcCode AND A.VARIABLE_NAME = :variableName AND A.BILLSTATUS = :billstatus ",nativeQuery = true)
    List<Map<String,Object>> findCoderuleByFuncCodeAndVariableName(@Param("funcCode")String funcCode
            ,@Param("variableName")String variableName,@Param("billstatus")Short billstatus);

    @Query(value = "SELECT A.RULE_CODE,A.BIT_NUMBER,A.FILL_SIGN FROM YLS_CODERULE_TYPE A" +
            " WHERE PK_CODERULE = :pkCoderule AND RULE_CODE <> :ruleCode  ",nativeQuery = true)
    List<Map<String,Object>> getCodeRuleTypeWithNoLiquid(@Param("pkCoderule")String pkCoderule,@Param("ruleCode")String ruleCode);

    @Query(value = "SELECT A.PK_CODERULE_TYPE,A.PK_CODERULE,A.CODERULE_TYPE,A.RULE_CODE,A.BIT_NUMBER,A.FILL_SIGN,A.REFER_SORT," +
            " A.INITIAL_VALUE FROM YLS_CODERULE_TYPE A WHERE PK_CODERULE = :pkCoderule AND RULE_CODE = :ruleCode " +
            " AND (REFER_SORT IS NULL OR REFER_SORT = :referSort)",nativeQuery = true)
    List<Map<String,Object>> getCodeRuleTypeWithLiquid(@Param("pkCoderule")String pkCoderule,@Param("ruleCode")String ruleCode,@Param("referSort")String referSort);


}
