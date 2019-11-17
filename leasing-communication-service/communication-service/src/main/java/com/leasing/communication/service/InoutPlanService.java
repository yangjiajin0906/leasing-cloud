package com.leasing.communication.service;

import com.leasing.communication.entity.dos.ContractDO;
import com.leasing.communication.entity.dos.InoutPlanDO;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/11/12
 * @author:Yjj@yonyou.com
 * @description: 2c租金计划信息导入
 **/
public interface InoutPlanService {
    /**
     * 保存方法
     * @param vo
     * @return
     */
    InoutPlanDO save(InoutPlanDO vo);

    /**
     * 批量保存方法
     * @param vo
     * @return
     */
    void save(List<InoutPlanDO> list);

    /**
     * 删除方法
     * @param vo
     */
    void delete(InoutPlanDO vo);

    /**
     * 更新方法
     * @param vo
     */
    InoutPlanDO update(InoutPlanDO vo);

    /**
     * 单体查询
     * @return
     */
    InoutPlanDO findOne(String pk);
}