package com.leasing.customer.service;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.customer.dao.dos.CustContactDO;
import com.leasing.customer.dao.query.CustContactQuery;
import com.leasing.customer.dao.vo.CustContactVO;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-10-31
 * @author:zhangzhhn@yonyou.com
 * @description: 联系人服务接口
 **/
public interface CustContactService {

    /**
     * 分页查询
     *
     * @param pagination 分页
     * @param query      查询条件
     * @return 分页列表
     */
    PageQueryData<CustContactVO> pageQuery(Pagination pagination, CustContactQuery query);

    /**
     * 根据条件查询列表
     *
     * @param query 查询条件
     * @return 查询列表
     */
    List<CustContactVO> query(CustContactQuery query);

    /**
     * 保存
     *
     * @param vo 保存对象
     */
    void save(CustContactDO vo);

    void batchSave(List<CustContactDO> list);
}