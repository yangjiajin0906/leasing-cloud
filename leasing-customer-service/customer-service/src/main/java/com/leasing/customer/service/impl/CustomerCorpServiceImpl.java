package com.leasing.customer.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.enums.base.Billstatus;
import com.leasing.common.enums.constant.CodeRuleKey;
import com.leasing.common.enums.constant.FuncCodeConstant;
import com.leasing.common.enums.constant.PubEnumsConstant;
import com.leasing.common.utils.base.*;
import com.leasing.customer.dao.dos.CustomerCorpDO;
import com.leasing.customer.dao.dos.CustomerDO;
import com.leasing.customer.dao.query.CustomerCorpQuery;
import com.leasing.customer.dao.repository.CustomerCorpRepo;
import com.leasing.customer.dao.vo.*;
import com.leasing.customer.service.CustomerCorpService;
import com.leasing.customer.service.CustomerService;
import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
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
    public String checkUnique(CustomerCorpAllVO vo) {

        String wheresql = "";

        StringBuilder exception = new StringBuilder();

        if (vo.getNationalTax() != null) {
            if (vo.getPk() == null) {
                wheresql = "vo.nationalTax = '" + vo.getNationalTax() + "'";
            } else {
                wheresql = "vo.nationalTax = '" + vo.getNationalTax() + "' and vo.pkCustomer <> '" + vo.getPk()
                        + "' and vo.ifNew = '" + PubEnumsConstant.IF_YES + "'";
            }

            if (BaseBusinessUtils.checkUniqueFields(vo, new String[]{"nationalTax"}, wheresql)) {
                exception.append("税务登记证号(国税)须唯一,请检查.\n");
            }
        }

        if (vo.getLandTax() != null) {
            if (vo.getPk() == null) {
                wheresql = "vo.landTax = '" + vo.getLandTax() + "'";
            } else {
                wheresql = "vo.landTax = '" + vo.getLandTax() + "' and vo.pkCustomer <> '" + vo.getPk()
                        + "' and vo.ifNew = '" + PubEnumsConstant.IF_YES + "'";
            }

            if (BaseBusinessUtils.checkUniqueFields(vo, new String[]{"landTax"}, wheresql)) {
                exception.append("税务登记证号(地税)须唯一,请检查.");
            }
        }

        if (vo.getLicenseNo() != null) {
            if (vo.getPk() == null) {
                wheresql = "vo.licenseNo = '" + vo.getLicenseNo() + "'";
            } else {
                wheresql = "vo.licenseNo = '" + vo.getLicenseNo() + "' and vo.pkCustomer <> '" + vo.getPk()
                        + "' and vo.ifNew = '" + PubEnumsConstant.IF_YES + "'";
            }

            if (BaseBusinessUtils.checkUniqueFields(vo, new String[]{"licenseNo"}, wheresql)) {
                exception.append("营业执照号码须唯一,请检查.");
            }
        }
        return exception.toString();
    }


    @Override
    @Transactional
    public Boolean delete(CustomerCorpAllVO vo) {
        String pkCustomer = vo.getPkCustomer();
        //1.删除前判断逻辑
        Boolean ifDelete = deleteBefore(pkCustomer);
        if (ifDelete) {
            // 2.删除关联表
            // deleteSub(pkCustomer); 因为暂存状态不能有关联页签  所以没必要
            // 3.删除表中数据
            customerService.deleteByPkCustomer(pkCustomer);
            customerCorpRepo.deleteById(pkCustomer);
        }
        return ifDelete;
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
//                deleteSub(pass);
                customerCorpRepo.batchDeleteByPks(pass);
                customerService.batchDelete(pass);
            } else {
                unPass.add(pk);
                for (String unpassPk : unPass) {

                }
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
    public PageQueryData<CustomerCorpAllVO> pageQuery(Pagination pagination, CustomerCorpQuery query) {
        if (query == null) {
            query = new CustomerCorpQuery();
        }
        query.setCustomerName("北京");
        return customerCorpRepo.pageQuery(pagination, query, "corpPageQuery");
    }

    @Override
    @Transactional
    public CustomerCorpAllVO save(CustomerCorpAllVO vo) {
        if (vo.getPk() == null) {
            // 获取客户编号
            String code = getCustomerCode();
            vo.setCustomerCode(code);
            vo.setOperateDate(DateUtils.getCurDate());
            vo.setOperateTime(DateUtils.getCurDateTime());
            vo.setBillstatus(Billstatus.INITALIZE.getShort());// 审核通过
//            vo.setPkDept(getClientENV().getPk_dept());
//            vo.setPk_prj_manager(getClientENV().getCurUser());
            vo.setPkCustomerCorp(BaseBusinessUtils.getOID());
        } else {
            /**sunlikun 增加修改客户信息请求crm接口*/
            String data = JSONObject.toJSONString(vo);
//            Properties properties = PropertiesUtils.loadProperties("factoring.properties");
//            String webUrl = properties.getProperty("crm").toString().trim();
//            String result =  HttpClientUtil.doPost(webUrl, data, "UTF-8", true);
//            /**end*/
//            ModifyTreeVOUtil modifyUtil = new ModifyTreeVOUtil(vo);
//            modifyUtil.createHeadVO();
        }

        // 如果没用冻结客户直接保存
//        vo.setPk_operator_lst(getClientENV().getCurUser());
        vo.setOperateDateLst(DateUtils.getCurDate());
        vo.setOperateTimeLst(DateUtils.getCurDateTime());
        vo.setAlteraStatus(PubEnumsConstant.ALTERA_STATUS_YSE);//允许修改

        CustomerCorpDO corpDO = DozerUtils.convert(vo, CustomerCorpDO.class);
        CustomerDO customerDO = DozerUtils.convert(vo, CustomerDO.class);
        customerService.save(customerDO);
        corpDO.setPkCustomer(customerDO.getPkCustomer());
        this.save(corpDO);

        return findOneAllByPkCustomer(customerDO.getPkCustomer());
    }

    @Override
    public void save(CustomerCorpVO vo) {
        customerService.save(new CustomerDO());
    }

    @Override
    public String getCustomerCode() {

        Map<String, String> map = new HashMap<>();
        map.put(CodeRuleKey.FUN_CODE, FuncCodeConstant.CUS_CORP_FUNCODE);
        map.put(CodeRuleKey.VARIABLE_NAME, CodeRuleKey.PK_CUSTOMER_CORP_CODE);
        return CodeRuleUtil.getCodeRule(map);
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

        CustomerDO customerDO = customerService.findOneByPkCustomer(pkCustomer);
        // 如果客户为暂存（未生效）时可以删除
        return Billstatus.INITALIZE.getShort().equals(customerDO.getBillstatus());
    }
}