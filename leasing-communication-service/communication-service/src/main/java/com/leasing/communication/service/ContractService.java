package com.leasing.communication.service;

import com.leasing.communication.entity.dos.CapitalDO;
import com.leasing.communication.entity.dos.ContractDO;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/11/12
 * @author:Yjj@yonyou.com
 * @description: 2c合同信息导入
 **/
public interface ContractService {
    /**
     * 保存方法
     * @param vo
     * @return
     */
    ContractDO save(ContractDO vo);

    /**
     * 批量保存方法
     * @param vo
     * @return
     */
    void save(List<ContractDO> list);

    /**
     * 删除方法
     * @param vo
     */
    void delete(ContractDO vo);

    /**
     * 更新方法
     * @param vo
     */
    ContractDO update(ContractDO vo);

    /**
     * 单体查询
     * @return
     */
    ContractDO findOne(String pk);
}