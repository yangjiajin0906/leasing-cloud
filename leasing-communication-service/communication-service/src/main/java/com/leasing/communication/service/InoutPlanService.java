package com.leasing.communication.service;

import com.leasing.communication.entity.dos.CbInoutPlanDO;

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
    CbInoutPlanDO save(CbInoutPlanDO vo);

    /**
     * 批量保存方法
     * @param vo
     * @return
     */
    void save(List<CbInoutPlanDO> list);

    /**
     * 删除方法
     * @param vo
     */
    void delete(CbInoutPlanDO vo);

    /**
     * 更新方法
     * @param vo
     */
    CbInoutPlanDO update(CbInoutPlanDO vo);

    /**
     * 单体查询
     * @return
     */
    CbInoutPlanDO findOne(String pk);
}