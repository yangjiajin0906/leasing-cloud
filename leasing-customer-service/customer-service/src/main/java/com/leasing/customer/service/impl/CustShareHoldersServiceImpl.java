package com.leasing.customer.service.impl;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.dto.customer.CustomerDTO;
import com.leasing.customer.dao.query.CustShareHoldersQuery;
import com.leasing.customer.dao.repository.CustShareHoldersRepo;
import com.leasing.customer.dao.vo.CustShareHoldersVO;
import com.leasing.customer.service.CustShareHoldersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-10-29
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Service("customer.CustShareHoldersService")
public class CustShareHoldersServiceImpl implements CustShareHoldersService {
    @Resource
    private CustShareHoldersRepo repo;

    @Override
    public PageQueryData<CustShareHoldersVO> pageQuery(Pagination pagination, CustShareHoldersQuery query) {
        return repo.pageQuery(pagination, query, "CustShareHoldersPageQuery");
    }
}