package com.leasing.customer.controller;

import com.alibaba.fastjson.JSON;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.enums.constant.PubEnumsConstant;
import com.leasing.common.exception.BaseException;
import com.leasing.common.utils.base.BaseBusinessUtils;
import com.leasing.common.utils.base.ResultUtils;
import com.leasing.customer.dao.dos.CustomerDO;
import com.leasing.customer.dao.query.CustomerCorpQuery;
import com.leasing.customer.dao.vo.CustomerAuthApplyVO;
import com.leasing.customer.dao.vo.CustomerAuthVO;
import com.leasing.customer.dao.vo.CustomerCorpAllVO;
import com.leasing.customer.dao.vo.CustomerVO;
import com.leasing.customer.service.CustomerCorpService;
import com.leasing.customer.service.CustomerService;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-10-21
 * @author:zhangzhhn@yonyou.com
 * @description: 单位客户维护
 **/
@RestController
@RequestMapping(value = "/leasing/customer")
public class CustomerCorpController {

    @Resource
    private CustomerCorpService customerCorpService;
    @Resource
    private CustomerService customerService;


    /**
     * 根据客户主键查询客户详细信息
     *
     * @param pkCustomer 客户主键
     * @return com.leasing.common.base.web.ResResult
     */
    @PostMapping(value = "/findOne")
    public ResResult corpFindOne(String pkCustomer) {
        CustomerCorpAllVO vo = customerCorpService.findOneAllByPkCustomer(pkCustomer);
        return ResultUtils.successWithData(vo);
    }

    /**
     * 根据查询条件查询单位客户分页查询 (已生效)
     *
     * @param query 客户查询条件
     * @return com.leasing.common.base.web.ResResult
     */
    @PostMapping(value = "/list")
    public ResResult corpList(String query) {
        CustomerCorpQuery customerCorpQuery = JSON.parseObject(query, CustomerCorpQuery.class);
        Pagination pagination = new Pagination(1, 50);
        return ResultUtils.successWithData(customerCorpService.pageQuery(pagination, customerCorpQuery));
    }


    /**
     * 校验客户名称是否重复
     *
     * @param customerName 客户名称
     * @return com.leasing.common.base.web.ResResult
     * 中如果data 是0则没有重复，否则有重复
     */
    @PostMapping(value = "/validateCustomerName")
    public ResResult validateCustomerName(String customerName) {
        return customerCorpService.validateCustomerName(customerName);
    }


    /**
     * 校验客户证件号码是否重复
     *
     * @param identityNo 客户名称
     * @return com.leasing.common.base.web.ResResult
     * 中如果data 是0则没有重复，否则有重复
     */
    @PostMapping(value = "/validateIdentityNo")
    public ResResult validateIdentityNo(String identityNo) {
        return customerCorpService.validateIdentityNo(identityNo);
    }


    /**
     * 保存客户
     *
     * @param data 客户数据
     * @return 客户信息
     */
    @PostMapping(value = "/save")
    public ResResult save(String data) {
//        CustomerCorpAllVO vo = JSON.parseObject(data, CustomerCorpAllVO.class);

        CustomerCorpAllVO ddd = customerCorpService.findOneAllByPkCustomer("0001MG00000000028981");
        String temp = JSON.toJSONString(ddd);
        CustomerCorpAllVO vo = JSON.parseObject(temp, CustomerCorpAllVO.class);
        vo.setCustomerName("我爱北京天安门");

        vo.setNationalTax("125117014516483921");
        vo.setLandTax("125117014516483921");
        vo.setLicenseNo("125117014516483921");
        vo.setPkCustomer(null);
        vo.setPkCustomerCorp(null);


        //1.校验客户是否存在
        boolean uniqueFlag = customerCorpService.validateCustomerUnique(vo);
        if (uniqueFlag) {
            CustomerDO customerDO = customerService.findOneByCustomerName(vo.getCustomerName());
            // 1.1 存在且客户有效时
            if (PubEnumsConstant.CUST_TYPE_EFFECTIVE.equals(customerDO.getCustomerStatus())){
                return ResultUtils.success("当前客户已存在，是否发起申请权限？");
            } else {
                //1.2 客户已存在 且冻结时
                customerDO.setCustomerStatus(PubEnumsConstant.CUST_TYPE_EFFECTIVE);
                //todo 变更为当前操作人
                customerDO.setCustomerManager("1003A910000000008U8W");
                //todo 变更为当前所在人的部门
                customerDO.setPkDept("1003111000000000003O");

                // todo  此时应该向客户历史表中增加历史数据
                return  ResultUtils.success();
            }
        }

        //2.校验客户 税务登记证号(国税)、税务登记证号(地税)与 营业执照号码 唯一
        String exception = customerCorpService.checkUnique(vo);

        //3.如果违反唯一性校验 抛出信息
        if (StringUtils.isNotBlank(exception)) {
            return ResultUtils.failure(exception);
        }

        //4. 初始化相关的操作信息，如果是修改 如果是保存客户，
        CustomerCorpAllVO resVO = customerCorpService.save(vo);
        return ResultUtils.successWithData(resVO);
    }

    /**
     * 删除单位客户 （只有生效才可以删除）
     *
     * @param data 单位客户
     * @return 删除成功
     */
    @PostMapping(value = "/delete")
    public ResResult delete(String data) {

        CustomerCorpAllVO vo = JSON.parseObject(data, CustomerCorpAllVO.class);
//        CustomerCorpAllVO vo = customerCorpService.findOneAllByPkCustomer("0001MG00000000029143");
        //删除
        Boolean flag = customerCorpService.delete(vo);
        return flag ? ResultUtils.success("删除成功!") : ResultUtils.failure("客户已生效，不能删除！");
    }


    /**
     * 客户生效前征信接口数据完整性校验 (提交时先调用)
     *
     * @param data 客户信息
     */
    @PostMapping(value = "/validateCredit")
    public ResResult validateCredit(String data) {
        CustomerCorpAllVO vo = JSON.parseObject(data, CustomerCorpAllVO.class);
        //调用客户生效方法
        customerCorpService.effect(vo);
        return ResultUtils.success("操作成功！");
    }

    /**
     * 客户生效
     *
     * @param data 客户信息
     */
    @PostMapping(value = "/effect")
    public ResResult effect(String data) {
//        CustomerCorpAllVO vo = JSON.parseObject(data, CustomerCorpAllVO.class);
//        c7eaeec8d6b943b8a02c
        CustomerCorpAllVO ddd = customerCorpService.findOneAllByPkCustomer("13af36bebc434a3cb0e9");
        String temp = JSON.toJSONString(ddd);
        CustomerCorpAllVO vo = JSON.parseObject(temp, CustomerCorpAllVO.class);
        //调用客户生效方法
        customerCorpService.effect(vo);
        return ResultUtils.success("操作成功！");
    }

    /**
     * 提交申请
     *
     * @param data 提交申请
     * @return
     */
    @PostMapping(value = "/submit")
    public ResResult submit(String data) {
        return null;
    }

    /**
     * 申请授权
     *
     * @param data 申请信息 CustomerAuthApplyVO
     * @return
     */
    @PostMapping(value = "/applyAuth")
    public ResResult applyAuth(String data) {
        CustomerAuthApplyVO vo = JSON.parseObject(data, CustomerAuthApplyVO.class);
        return customerCorpService.applyAuth(vo);
    }

}