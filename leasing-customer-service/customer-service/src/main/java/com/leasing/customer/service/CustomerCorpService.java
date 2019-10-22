package com.leasing.customer.service;

import com.leasing.customer.dao.vo.CustomerCorpAllVO;

import java.util.List;
import java.util.Map;

/**
 * 单位客户服务接口
 */
public interface CustomerCorpService {


    /**
     * 根据客户主键查询客户详情
     *
     * @param pkCustomer 客户主键
     * @return 自定义实体类 CustomerCorpAllVO
     */
    CustomerCorpAllVO findOneAllByPkCustomer(String pkCustomer);


    /**
     * 根据查询条件查询列表
     *
     * @param conditions 查询条件
     * @return 符合查询条件列表
     */
    List<CustomerCorpAllVO> findListByConditions(Map<String, Object> conditions);



    /**
     * 如果前台传过来 CustomerCorpAllVO 需要拆分成 CustomerCorpDO 与 CustomerDO分别保存
     *
     * @param vo CustomerCorpAllVO
     */
    void saveOrUpdate(CustomerCorpAllVO vo);



    /**
     * 更新客户状态
     * @param billstatus 客户新状态
     * @param pkCustomer 客户新主键
     */
    void updateBillStatus(String billstatus, String pkCustomer);
}
