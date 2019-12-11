package com.leasing.communication.service;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.communication.entity.dos.CbCapitalDO;
import com.leasing.communication.entity.dos.CbCapitalDetailDO;
import com.leasing.communication.entity.dto.CbCapitalDetailImpDTO;
import com.leasing.communication.entity.query.CbCapitalQuery;
import com.leasing.communication.entity.vo.CbCapitalVO;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/11/12
 * @author:Yjj@yonyou.com
 * @description: 2c收款信息导入
 **/
public interface CbCapitalService extends CbFileImpService{

    /**
     * 分页查询
     *
     * @param pagination 分页
     * @param queryVO    查询条件
     * @return 分页列表
     */
    PageQueryData<CbCapitalVO> pageQuery(Pagination pagination, CbCapitalQuery queryVO);

    /**
     * 根据批次号汇总收款主表
     *
     * @param list 收款批次号
     */
    void totalCapital(List<CbCapitalDetailDO> list);

    /**
     * 保存方法
     *
     * @param vo
     * @return
     */
    CbCapitalDO save(CbCapitalDO vo);

    /**
     * 批量保存方法
     *
     * @param list
     * @return
     */
    void save(List<CbCapitalDO> list);

    /**
     * 删除方法
     *
     * @param vo
     */
    void delete(CbCapitalDO vo);

    /**
     * 更新方法
     *
     * @param vo
     */
    CbCapitalDO update(CbCapitalDO vo);

    /**
     * 单体查询
     *
     * @return
     */
    CbCapitalDO findOne(String pk);

    List<CbCapitalDetailDO> dataConvert(List<CbCapitalDetailImpDTO> list, String batchNo);
}