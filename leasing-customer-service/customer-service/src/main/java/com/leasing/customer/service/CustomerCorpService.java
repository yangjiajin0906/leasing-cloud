package com.leasing.customer.service;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;
import com.leasing.customer.dao.query.CustomerCorpQuery;
import com.leasing.customer.dao.vo.*;

import java.util.List;
import java.util.Map;

/**
 * 单位客户服务接口
 */
public interface CustomerCorpService {


    /**
     * 检查客户唯一性
     *
     * @param vo 客户
     * @return 错误信息
     */
    String checkUnique(CustomerCorpAllVO vo);

    /**
     * 根据客户主键删除客户(仅支持客户未生效前的删除)
     *
     * @param vo 客户主键
     */
    Boolean delete(CustomerCorpAllVO vo);

    /**
     * 批量删除客户
     *
     * @param pks 主键集合
     * @return com.leasing.customer.dao.vo.ResResult
     */
    ResResult delete(List<String> pks);


    /**
     * 根据客户主键查询客户详情
     *
     * @param pkCustomer 客户主键
     * @return 自定义实体类 CustomerCorpAllVO
     */
    CustomerCorpAllVO findOneAllByPkCustomer(String pkCustomer);

    /**
     * 根据客户名称查询客户详情
     *
     * @param customerName 客户名称
     * @return 自定义实体类 CustomerCorpAllVO
     */
    CustomerCorpAllVO findOneAllByCustomerName(String customerName);


    /**
     * 分页查询列表
     *
     * @param pagination 分页
     * @param query      查询条件
     * @return List<CustomerCorpAllVO>
     */
    PageQueryData<CustomerCorpAllVO> pageQuery(Pagination pagination, CustomerCorpQuery query);


    /**
     * 如果前台传过来 CustomerCorpAllVO 需要拆分成 CustomerCorpDO 与 CustomerDO分别保存
     *
     * @param vo CustomerCorpAllVO
     */
    CustomerCorpAllVO save(CustomerCorpAllVO vo);

    /**
     * 保存
     */
    void save(CustomerCorpVO vo);


    /**
     * 生成客户编码
     *
     * @return 客户编码
     */
    String getCustomerCode();


    /**
     * 校验客户名称是否重复
     *
     * @param customerName 客户名称
     * @return com.leasing.common.base.web.ResResult
     */
    ResResult validateCustomerName(String customerName);

    /**
     * 根据查询客户证件号码是否重复
     *
     * @param identityNo 客户证件号
     * @return com.leasing.common.base.web.ResResult
     */
    ResResult validateIdentityNo(String identityNo);

    /**
     * 申请权限
     *
     * @param vo 申请客户列表
     * @return com.leasing.common.base.web.ResResult
     */
    ResResult applyAuth(CustomerAuthApplyVO vo);


    /**
     * 授权
     *
     * @param vos 授权信息
     * @return com.leasing.common.base.web.ResResult
     */
    ResResult doApplyAuth(List<CustomerAuthVO> vos);

    /**
     * 根据客户查询客户授权给哪些用户
     *
     * @param pkCustomer 客户主键
     * @return 用户列表
     */
    ResResult queryAuth(String pkCustomer);


    /**
     * 取消授权
     *
     * @param list
     * @return
     */
    ResResult recoverAuth(List<CustomerAuthVO> list);
}
