package com.leasing.common.service;
/**
 * @project:leasing-cloud
 * @date:2019/11/1
 * @author:wangjc@yonyou.com
 * @description:编码规则接口
 **/
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.entity.common.dos.CoderuleDO;
import com.leasing.common.entity.common.vo.CoderuleVO;

import java.util.List;
import java.util.Map;

public interface CoderuleService {
    /**
     * 查询全部编码规则数据
     */
    PageQueryData<CoderuleVO> ListCoderule();

    /**
     * 查询单个编码规则VO对象
     */
    CoderuleVO getCoderule(String pk);

    /**
     * 查询单个编码规则DO对象
     */
    CoderuleDO getCoderuleDO(String pk);

    /**
     * 更新数据
     */
    void updateCoderule(CoderuleDO dos);

    /**
     * 保存数据
     */
    void saveCoderule(CoderuleDO dos);

    /**
     * 删除数据
     */
    void deleteCoderule(CoderuleDO dos);

    /**
     * 根据节点编号及参数名称获取编码规则设置主表信息(单据状态为已复核后的数据)
     */
    List<Map<String,Object>> findCoderuleByFuncCodeAndVariableName(String funcCode,String variableName);

    /**
     * 获取非序列号的设置信息(编码规则子表的数据)
     */
    List<Map<String,Object>> getCodeRuleTypeWithNoLiquid(String pk_coderule);

    /**
     * 获取序列号的设置信息(编码规则子表的数据)
     */
    List<Map<String,Object>> getCodeRuleTypeWithLiquid(String pk_coderule,String refer_sort);

}
