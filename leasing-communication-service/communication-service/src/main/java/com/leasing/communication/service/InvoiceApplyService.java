package com.leasing.communication.service;

import com.leasing.communication.entity.dos.InoutPlanDO;
import com.leasing.communication.entity.dos.InvoiceApplyDO;

import java.util.List;

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
     * 批量保存方法
     * @param vo
     * @return
     */
    void save(List<InvoiceApplyDO> list);

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