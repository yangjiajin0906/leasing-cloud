package com.leasing.customer.service;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.customer.dao.dos.CustomerAuthDO;
import com.leasing.customer.dao.query.CustomerAuthQuery;
import com.leasing.customer.dao.vo.CustomerAuthVO;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-11-07
 * @author:zhangzhhn@yonyou.com
 * @description: 客户权限服务接口
 **/
public interface CustomerAuthService {

    /**
     * 分页查询
     *
     * @param pagination 分页
     * @param query      查询条件
     * @return 分页列表
     */
    PageQueryData<CustomerAuthVO> pageQuery(Pagination pagination, CustomerAuthQuery query);

    /**
     * 取消授权
     *
     * @param authVO 取消授权客户
     */
    void recoverAuth(CustomerAuthVO authVO);

    /**
     * 取消授权
     *
     * @param authDO 取消授权客户
     */
    void recoverAuth(CustomerAuthDO authDO);


    /**
     * 授权
     *
     * @param list 授权列表
     */
    void doAuth(List<CustomerAuthVO> list);

}