package com.leasing.communication.service;

import com.leasing.communication.entity.dos.CapitalDO;
import com.leasing.communication.entity.dos.CustomerDO;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/11/12
 * @author:Yjj@yonyou.com
 * @description: 2c收款信息导入
 **/
public interface CapitalService {
    /**
     * 保存方法
     * @param vo
     * @return
     */
    CapitalDO save(CapitalDO vo);

    /**
     * 批量保存方法
     * @param vo
     * @return
     */
    void save(List<CapitalDO> list);

    /**
     * 删除方法
     * @param vo
     */
    void delete(CapitalDO vo);

    /**
     * 更新方法
     * @param vo
     */
    CapitalDO update(CapitalDO vo);

    /**
     * 单体查询
     * @return
     */
    CapitalDO findOne(String pk);
}