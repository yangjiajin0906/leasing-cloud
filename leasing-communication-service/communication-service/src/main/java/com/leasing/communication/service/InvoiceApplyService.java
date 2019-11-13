package com.leasing.communication.service;

import com.leasing.communication.entity.dos.InvoiceApplyDO;

/**
 * @project:leasing-cloud
 * @date:2019/11/12
 * @author:Yjj@yonyou.com
 * @description: 2c票据信息导入
 **/
public interface InvoiceApplyService {
    /**
     * 保存方法
     * @param vo
     * @return
     */
    InvoiceApplyDO save(InvoiceApplyDO vo);

    /**
     * 删除方法
     * @param vo
     */
    void delete(InvoiceApplyDO vo);

    /**
     * 更新方法
     * @param vo
     */
    InvoiceApplyDO update(InvoiceApplyDO vo);

    /**
     * 单体查询
     * @return
     */
    InvoiceApplyDO findOne(String pk);
}