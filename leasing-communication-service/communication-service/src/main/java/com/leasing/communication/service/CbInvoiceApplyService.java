package com.leasing.communication.service;

import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.communication.entity.dos.CbInvoiceApplyDetailDO;
import com.leasing.communication.entity.dto.CbInvoiceApplyDetailImpDTO;

import java.io.File;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/11/12
 * @author:Yjj@yonyou.com
 * @description: 2c票据信息导入
 **/
public interface CbInvoiceApplyService {
    /**
     * 保存方法
     * @param vo
     * @return
     */
    CbInvoiceApplyDetailDO save(CbInvoiceApplyDetailDO vo);

    /**
     * 批量保存方法
     * @param vo
     * @return
     */
    void save(List<CbInvoiceApplyDetailDO> list);

    /**
     * 删除方法
     * @param vo
     */
    void delete(CbInvoiceApplyDetailDO vo);

    /**
     * 更新方法
     * @param vo
     */
    CbInvoiceApplyDetailDO update(CbInvoiceApplyDetailDO vo);

    /**
     * 单体查询
     * @return
     */
    CbInvoiceApplyDetailDO findOne(String pk);

    /**
     * 分页查询
     * @return
     */
    PageQueryData pageQuery(Pagination pagination, BaseQuery baseQuery, String queryName);

    /**
     * 下载文件
     * @param file 数据
     * @return
     */
    List<CbInvoiceApplyDetailImpDTO> dataImp(File file);

    /**
     * DTO转DO 数据转换
     * @param list 数据
     * @return
     */
    List<CbInvoiceApplyDetailDO> dataConvert(List<CbInvoiceApplyDetailImpDTO> list);

}