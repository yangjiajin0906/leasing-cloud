package com.leasing.communication.service;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.communication.entity.dos.CbWithdrawDetailDO;
import com.leasing.communication.entity.dto.CbWithdrawDetailDTO;
import com.leasing.communication.entity.query.CbWithdrawDetailQuery;
import com.leasing.communication.entity.vo.CbWithdrawDetailVO;
import com.leasing.common.base.repository.support.Pagination;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-12-02
 * @author:zhangzhhn@yonyou.com
 * @description: 付款详细子表
 **/
public interface CbWithdrawDetailService {

    /**
     * 分页查询
     *
     * @param pagination 分页
     * @param queryVO    查询条件
     * @return 分页列表
     */
    PageQueryData<CbWithdrawDetailVO> pageQuery(Pagination pagination, CbWithdrawDetailQuery queryVO);

    /**
     * 参照转换
     *
     * @param list EXCEL导入数据
     * @return 转换参照后的数据
     */
    List<CbWithdrawDetailDO> refConvert(List<CbWithdrawDetailDTO> list);


}