package com.leasing.customer.service.impl;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.utils.tools.DozerUtils;
import com.leasing.customer.dao.dos.CustomerAuthDO;
import com.leasing.customer.dao.query.CustomerAuthQuery;
import com.leasing.customer.dao.repository.CustomerAuthRepo;
import com.leasing.customer.dao.vo.CustomerAuthVO;
import com.leasing.customer.service.CustomerAuthService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-11-07
 * @author:zhangzhhn@yonyou.com
 * @description: 客户权限接口实现类
 **/
@Service("customer.CustomerAuthServiceImpl")
public class CustomerAuthServiceImpl implements CustomerAuthService {
    @Resource
    private CustomerAuthRepo repo;

    @Override
    public PageQueryData<CustomerAuthVO> pageQuery(Pagination pagination, CustomerAuthQuery query) {

        return repo.pageQuery(pagination, query, "customerAuth");
    }

    @Override
    public void recoverAuth(CustomerAuthVO authVO) {
        this.recoverAuth(DozerUtils.convert(authVO, CustomerAuthDO.class));
    }

    @Override
    public void recoverAuth(CustomerAuthDO authDO) {
        repo.delete(authDO);
    }

    @Override
    public void doAuth(List<CustomerAuthVO> list) {

    }
}