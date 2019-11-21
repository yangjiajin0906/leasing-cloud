package com.leasing.communication.service;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.communication.entity.dos.WithdrawDO;
import com.leasing.communication.entity.query.WithdrawQueryVO;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/11/12
 * @author:Yjj@yonyou.com
 * @description: 2c付款信息导入
 **/
public interface WithdrawService {

    /**
     * 分页查询
     *
     * @param pagination 分页
     * @param queryVO    查询条件
     * @return 分页列表
     */
    PageQueryData<WithdrawDO> pageQuery(Pagination pagination, WithdrawQueryVO queryVO);

    /**
     * 保存方法
     *
     * @param vo
     * @return
     */
    WithdrawDO save(WithdrawDO vo);

    /**
     * 批量保存方法
     *
     * @param vo
     * @return
     */
    void save(List<WithdrawDO> list);

    /**
     * 删除方法
     *
     * @param vo
     */
    void delete(WithdrawDO vo);

    /**
     * 更新方法
     *
     * @param vo
     */
    WithdrawDO update(WithdrawDO vo);

    /**
     * 单体查询
     *
     * @return
     */
    WithdrawDO findOne(String pk);
}