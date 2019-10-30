package com.leasing.customer.service.impl;

import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.utils.base.DozerUtils;
import com.leasing.common.utils.base.ResultUtils;
import com.leasing.customer.dao.dos.CustomerCorpDO;
import com.leasing.customer.dao.dos.CustomerDO;
import com.leasing.customer.dao.query.CustomerCorpQuery;
import com.leasing.customer.dao.repository.CustomerCorpRepo;
import com.leasing.customer.dao.vo.CustomerAuthApplyVO;
import com.leasing.customer.dao.vo.CustomerAuthVO;
import com.leasing.customer.dao.vo.CustomerCorpAllVO;
import com.leasing.customer.dao.vo.CustomerCorpVO;
import com.leasing.customer.service.CustomerCorpService;
import com.leasing.customer.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @project:leasing-cloud
 * @date:2019-10-22
 * @author:zhangzhhn@yonyou.com
 * @description: 客户服务接口实现类
 **/
@Service("customer.CustomerCorpService")
public class CustomerCorpServiceImpl implements CustomerCorpService {

    @Resource
    private CustomerCorpRepo customerCorpRepo;
    @Resource
    private CustomerService customerService;


    @Override
    @Transactional
    public ResResult delete(CustomerCorpAllVO vo) {
        String pkCustomer = vo.getPkCustomer();
        //逻辑删除
        boolean ifDelete = deleteBefore(pkCustomer);
        if (ifDelete) {
            // 2.删除关联表
            deleteSub(pkCustomer);
            // 3.删除表中数据
            customerService.deleteByPkCustomer(pkCustomer);
            customerCorpRepo.deleteById(pkCustomer);
            return ResultUtils.successWithData(pkCustomer);
        } else {
            return ResultUtils.failWithMsgData(pkCustomer, "该客户有未完成的业务，不能删除!");
        }

    }

    @Override
    public ResResult delete(List<String> pks) {
        // 删除前的检查
        List<String> pass = new ArrayList<>();
        // 删除校验不通过
        List<String> unPass = new ArrayList<>();
        for (String pk : pks) {
            if (deleteBefore(pk)) {
                pass.add(pk);
                //批量删除
                //删除子表
                deleteSub(pass);
                customerCorpRepo.batchDeleteByPks(pass);
                customerService.batchDelete(pass);
            } else {
                unPass.add(pk);
            }
        }
        return null;
    }

    @Override
    public CustomerCorpAllVO findOneAllByPkCustomer(String pkCustomer) {
        return customerCorpRepo.findOneAllByPkCustomer(pkCustomer);
    }

    @Override
    public CustomerCorpAllVO findOneAllByCustomerName(String customerName) {
        return customerCorpRepo.findOneAllByCustomerName(customerName);
    }


    @Override
    public List<CustomerCorpAllVO> pageQuery(Pagination pagination, CustomerCorpQuery query) {
        String JPQL = "select b from CustomerCorpAllVO b where b.ifNew = 0 ";
        return (List<CustomerCorpAllVO>) customerCorpRepo.pageQuery(pagination, query, JPQL);
    }

    @Override
    @Transactional
    public void save(CustomerCorpAllVO vo) {

        CustomerCorpDO corpDO = DozerUtils.convert(vo, CustomerCorpDO.class);
        CustomerDO customerDO = DozerUtils.convert(vo, CustomerDO.class);
        customerDO.setPkCustomer("customerDO");
        customerDO.setBillstatus(Short.valueOf("204")
        );
        customerService.save(customerDO);
        corpDO.setPkCustomer(customerDO.getPkCustomer());
        this.save(corpDO);
    }

    @Override
    public void save(CustomerCorpVO vo) {
        customerService.save(new CustomerDO());
    }

    @Override
    public ResResult validateCustomerName(String customerName) {
        return ResultUtils.successWithData(customerService.countCustomerName(customerName));
    }


    @Override
    public ResResult validateIdentityNo(String identityNo) {
        return ResultUtils.successWithData(customerService.countIdentityNo(identityNo));
    }

    @Override
    public ResResult applyAuth(CustomerAuthApplyVO vo) {

        //判断是否为部门开通权限

        //如果是   查询该部门下的所有人

        //批量保存申请
        return null;
    }

    @Override
    public ResResult doApplyAuth(List<CustomerAuthVO> vos) {
        return null;
    }

    @Override
    public ResResult queryAuth(String pkCustomer) {
        return null;
    }

    @Override
    public ResResult recoverAuth(List<CustomerAuthVO> list) {
        return null;
    }

    @Transactional
    void save(CustomerCorpDO customerCorpDO) {
        customerCorpRepo.save(customerCorpDO);
    }


    /**
     * 删除客户时 需要删除的子表
     *
     * @param pkCustomer 客户主键
     */
    private void deleteSub(String pkCustomer) {


    }

    /**
     * 批量删除子表
     *
     * @param pks 客户主键集合
     */
    private void deleteSub(List<String> pks) {

    }


    /**
     * 判断该客户是否可以删除逻辑
     *
     * @param pkCustomer 客户主键
     * @return Boolean true or false
     */
    private boolean deleteBefore(String pkCustomer) {

        return true;
    }
}