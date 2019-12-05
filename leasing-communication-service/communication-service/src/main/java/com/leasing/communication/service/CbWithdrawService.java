package com.leasing.communication.service;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.communication.entity.dos.CbWithdrawDO;
import com.leasing.communication.entity.dos.CbWithdrawDetailDO;
import com.leasing.communication.entity.query.CbWithdrawQuery;
import com.leasing.communication.entity.vo.CbWithdrawVO;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/11/12
 * @author:Yjj@yonyou.com
 * @description: 2c付款信息导入
 **/
public interface CbWithdrawService {

    void gatherWithdraw(String batchNo);
    /**
     * 分页查询
     *
     * @param pagination 分页
     * @param queryVO    查询条件
     * @return 分页列表
     */
    PageQueryData<CbWithdrawVO> pageQuery(Pagination pagination, CbWithdrawQuery queryVO);

    /**
     *
     * 根据批次号查询子表
     * @return 子表列表
     */
    List<CbWithdrawDetailDO> queryDetailByBatchNo(String batchNo);

    /**
     * 保存方法
     *
     * @param vo
     * @return
     */
    CbWithdrawDO save(CbWithdrawDO vo);

    /**
     * 批量保存方法
     *
     * @param list
     * @return
     */
    void save(List<CbWithdrawDO> list);

    /**
     * 删除方法
     *
     * @param vo
     */
    void delete(CbWithdrawDO vo);

    /**
     * 更新方法
     *
     * @param vo
     */
    CbWithdrawDO update(CbWithdrawDO vo);

    /**
     * 单体查询
     *
     * @return
     */
    CbWithdrawDO findOne(String pk);
}