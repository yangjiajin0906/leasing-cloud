package com.leasing.communication.service;

import com.leasing.communication.entity.dos.WithdrawDO;

/**
 * @project:leasing-cloud
 * @date:2019/11/12
 * @author:Yjj@yonyou.com
 * @description: 2c付款信息导入
 **/
public interface WithdrawService {
    /**
     * 保存方法
     * @param vo
     * @return
     */
    WithdrawDO save(WithdrawDO vo);

    /**
     * 删除方法
     * @param vo
     */
    void delete(WithdrawDO vo);

    /**
     * 更新方法
     * @param vo
     */
    WithdrawDO update(WithdrawDO vo);

    /**
     * 单体查询
     * @return
     */
    WithdrawDO findOne(String pk);
}