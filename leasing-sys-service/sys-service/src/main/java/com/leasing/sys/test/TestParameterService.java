package com.leasing.sys.test;

import com.leasing.common.base.repository.support.Pagination;
import com.leasing.sys.dao.dos.ParameterDO;


import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-10-12
 * @author:lvcna@yonyou.com
 * @description:
 **/
public interface TestParameterService {

    /**
     * 保存方法
     * @param vo
     * @return
     */
    ParameterDO save(ParameterDO vo);

    /**
     * 删除方法
     * @param vo
     */
    void delete(ParameterDO vo);

    /**
     * 更新方法
     * @param vo
     */
    ParameterDO update(ParameterDO vo);

    /**
     * 查询单个实体类（包含子表）
     * @return
     */
    ParameterDO findOne(String pk);

    /**
     * 分页查询
     * @return
     */
    List<ParameterDO> pageQuery(ParameterDO vo, Pagination pagination);

    List findtotal();


    Object test1();



}
