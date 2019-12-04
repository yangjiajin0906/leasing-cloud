package com.leasing.communication.service;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.communication.entity.dos.InvoiceApplyDO;
import com.leasing.communication.entity.query.InvoiceQuery;

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

    /**
     * 分页查询
     * @param contractQueryVO
     * @param pagination
     * @return
     */
    PageQueryData pageData(InvoiceQuery contractQueryVO, Pagination pagination);
}