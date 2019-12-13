package com.leasing.communication.service;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.communication.entity.dos.AccruedDO;
import com.leasing.communication.entity.query.AccruedQuery;
import com.leasing.communication.entity.vo.AccruedChildVO;
import com.leasing.communication.entity.vo.AccruedVO;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/11/21
 * @author:Yjj@yonyou.com
 * @description: 2c月末计提
 **/
public interface AccruedService {
    /**
     * 客户列表分页信息查询
     * @param pagination 分页条件
     * @param leaseAccruedQuery 查询条件
     * @param queryName JPQL名称
     * @return
     */
    PageQueryData<AccruedVO> pageQuery(Pagination pagination, AccruedQuery leaseAccruedQuery, String queryName);

    /**
     * @description 根据机构和月份生产计提
     * @author Yangjiajin
     * @date 2019/11/28 14:30
     * @param pkOrg 机构
     * @param currentMonth 月份
     * @return com.leasing.communication.entity.vo.AccruedVO
     */
    AccruedVO onAdd(String pkOrg, String currentMonth, List<AccruedVO> list);

    /**
     * 保存方法
     * @param vo
     * @return
     */
    AccruedDO save(AccruedDO vo);

    /**
     * 删除方法
     * @param vo
     */
    void delete(AccruedDO vo);

    /**
     * 更新方法
     * @param vo
     */
    AccruedDO update(AccruedDO vo);

    /**
     * 单体查询
     * @return
     */
    AccruedDO findOne(String pk);

    /**
     * 查询单个子表VO
     * @return
     */
    AccruedChildVO findByPk(String pk);

    /**
     * 提交
     * @return
     */
    AccruedVO submit(AccruedVO vo);

    /**
     * 审核
     * @return
     */
    AccruedVO exeCheck(AccruedVO vo);

    /**
     * 联查凭证
     * @return
     */
    AccruedVO queryVoucher(AccruedVO vo);

    /**
     * @description
     * @author Yangjiajin
     * @date 2019/12/12 16:39
     * @param
     * @return
     */
    void updateAccruedFlag(AccruedDO dos, final Short if_begin);
}