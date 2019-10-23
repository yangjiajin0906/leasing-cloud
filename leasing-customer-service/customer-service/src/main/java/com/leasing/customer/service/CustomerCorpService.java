package com.leasing.customer.service;

import com.leasing.common.base.web.ResResult;
import com.leasing.customer.dao.vo.CustomerCorpAllVO;

import java.util.List;
import java.util.Map;

/**
 * 单位客户服务接口
 */
public interface CustomerCorpService {


    ResResult delete(String pkCustomer);
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


    /**
     * 校验客户名称是否重复
     * @param customerName 客户名称
     * @return com.leasing.common.base.web.ResResult
     */
    ResResult validateCustomerName(String customerName);

    /**
     * 根据查询客户证件号码是否重复
     * @param identityNo 客户证件号
     * @return com.leasing.common.base.web.ResResult
     */
    ResResult validateIdentityNo(String identityNo);
}
