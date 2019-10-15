package com.leasing.sys.service;

import com.leasing.common.entity.sys.common.ParameterVO;
import com.leasing.common.repository.support.Pagination;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-10-12
 * @author:lvcna@yonyou.com
 * @description:
 **/
public interface ParameterService {

    /**
     * 保存方法
     * @param vo
     * @return
     */
    ParameterVO save(ParameterVO vo);

    /**
     * 删除方法
     * @param vo
     */
    void delete(ParameterVO vo);

    /**
     * 更新方法
     * @param vo
     */
    ParameterVO update(ParameterVO vo);

    /**
     * 查询单个实体类（包含子表）
     * @return
     */
    ParameterVO findOne(String pk);

    /**
     * 分页查询
     * @return
     */
    List<ParameterVO> pageQuery(ParameterVO vo, Pagination pagination);



}
