package com.leasing.customer.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.entity.customer.dto.CustomerDTO;
import com.leasing.common.entity.customer.dto.CustomerPersonDTO;
import com.leasing.common.entity.sys.vo.ParameterVO;
import com.leasing.common.enums.base.Billstatus;
import com.leasing.common.enums.constant.CodeRuleKey;
import com.leasing.common.enums.constant.FuncCodeConstant;
import com.leasing.common.enums.constant.ParamValueConstant;
import com.leasing.common.enums.constant.PubEnumsConstant;
import com.leasing.common.utils.sys.CodeRuleUtil;
import com.leasing.common.utils.sys.ParamTypeUtils;
import com.leasing.common.utils.base.*;
import com.leasing.common.utils.sys.ResultUtils;
import com.leasing.common.utils.tools.DozerUtils;
import com.leasing.customer.dao.dos.*;
import com.leasing.customer.dao.query.CustContactQuery;
import com.leasing.customer.dao.query.CustomerCorpQuery;
import com.leasing.customer.dao.repository.CustomerCorpRepo;
import com.leasing.customer.dao.vo.*;
import com.leasing.customer.service.*;
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
@Transactional
public class CustomerCorpServiceImpl implements CustomerCorpService {

    @Resource
    private CustomerCorpRepo customerCorpRepo;
    @Resource
    private CustomerService customerService;
    @Resource
    private CustRelatedCompanyService companyService;
    @Resource
    private CustContactService contactService;
    @Resource
    private CustomerRelationService relationService;
    @Resource
    private CustShareHoldersService holdersService;

    @Override
    public boolean validateCustomerUnique(CustomerCorpAllVO vo) {
        String wheresql = "";

        if (vo.getPk() == null) {
            wheresql = "vo.customerName = '" + vo.getCustomerName() + "'";
        } else {
            wheresql = "vo.customerName = '" + vo.getCustomerName() + "' and vo.pkCustomer <> '" + vo.getPk()
                    + "' and vo.ifNew = '" + PubEnumsConstant.IF_YES + "'";
        }
        return BaseBusinessUtils.checkUniqueFields(vo, new String[]{"customerName"}, wheresql);

    }


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
            deleteSub(pkCustomer);
            // 3.删除表中数据
            customerService.deleteByPkCustomer(pkCustomer);
            customerCorpRepo.deleteById(vo.getPkCustomerCorp());
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
            vo.setPkCustomer(BaseBusinessUtils.getOID());
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
        this.save(corpDO);
        checkMethod(vo);
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
    public boolean validateCredit(CustomerCorpAllVO vo) {
        //如果是征信客户进入
        Short if_warrant_cust = 0;
        if(if_warrant_cust.equals(vo.getIfWarrantCust())){
            boolean crditFlag = false;
            if(vo.getLoanCardNo() == null){
                //判断贷款卡号是否输入
                crditFlag = true;
            }
            boolean shareFlag = checkShareAndCust(vo);

            return !crditFlag && !shareFlag;
        }
        return true;
    }

    @Override
    public void effect(CustomerCorpAllVO vo) {
        vo.setBillstatus(Billstatus.APPROVE.getShort());
        vo.setEffectiveDate(DateUtils.getCurDate());
        customerService.save(DozerUtils.convert(vo, CustomerDO.class));
    }

    @Override
    public boolean checkShareAndCust(CustomerCorpAllVO vo) {
        List<CustRelatedCompanyVO> companyVOS = companyService.findByPkCustomer(vo.getPkCustomer());
        List<CustShareHoldersDO> holdersDOS = holdersService.getCustShareHolders(vo.getPkCustomer());
        return companyVOS.size() == 0 || holdersDOS.size() == 0;
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
        //1. 删除法定代表人、实际控制人、其他联系人、家族企业
        companyService.deleteByCustomer(pkCustomer);

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


    // 检查客户的法定代表人与实际控制人的信息是否发生变化
    private void checkMethod(CustomerCorpAllVO vo) {
        //法定代表人
        updateLegal(vo);
        //实际控制人
        updateActual(vo);
    }

    /**
     * 法定代表人
     */
    private void updateLegal(CustomerCorpAllVO vo) {
        //查询高管信息中的法定代表人
        List<CustRelatedCompanyVO> list = companyService.getCustRelatedCompany(vo.getPk(), PubEnumsConstant.RELATION_EXECUTIVE,
                PubEnumsConstant.EXECUTIVE_LEGAL);

        if (list != null && list.size() > 0) {
            CustRelatedCompanyVO companyVO = list.get(0);
            //高管的主键
            String companyPk = companyVO.getPkCustRelatedCompany();
            if (vo.getPkCustomerPerson() == null) {
                deleteLegal(vo.getPkCustomer(), companyPk);
            } else {
                //主表中的法定代表人
                CustomerPersonDTO pkCustomerPerson = vo.getPkCustomerPerson();

                //高管的法定代表人的主键和code
                CustomerDTO pkCustomerRef = companyVO.getPkCustomerRef();

                //code值一致但法定代表人主键不一致
                if (pkCustomerPerson.getCustomerCode().equals(pkCustomerRef.getCustomerCode())
                        && !vo.getPkCustomerPerson().getPkCustomer().equals(pkCustomerRef.getPkCustomer())) {
                    //修改高管法定代表人的PK
                    CustRelatedCompanyDO companyDO = companyService.findById(companyPk);
                    companyDO.setPkCustomerRef(pkCustomerPerson.getPkCustomer());
                    companyService.save(companyDO);

                } else if (!pkCustomerPerson.getCustomerCode().equals(pkCustomerRef.getCustomerCode())) {//code值不一致

                    deleteLegal(vo.getPkCustomer(), companyPk);
                    insertLegal(vo);
                }
            }

        } else {
            if (vo.getPkCustomerPerson() != null) {
                insertLegal(vo);
            }
        }
    }

    /**
     * 实际控制人
     */
    private void updateActual(CustomerCorpAllVO vo) {
        //查询其他关系的实际控制人
        List<CustRelatedCompanyVO> list = companyService.getCustRelatedCompany(vo.getPkCustomer(), PubEnumsConstant.RELATION_OTHER);


        if (vo.getActualControl() == null) {
            if (list != null && list.size() > 0) {
                CustRelatedCompanyVO companyVO = list.get(0);
                String pk = companyVO.getPkCustRelatedCompany();
                deleteActual(vo, pk);
            }
        } else {
            //主表中的实际控制人
            CustomerDTO actualControl = vo.getActualControl();

            //跟其他关系 校验实际控制人是否一致
            if (list != null && list.size() > 0) {
                //update
                CustRelatedCompanyVO companyVO = list.get(0);
                //数据项主键
                String pk = companyVO.getPkCustRelatedCompany();
                //其他关系 关联客户的主键和code
                CustomerDTO pkCustomerRef = companyVO.getPkCustomerRef();
                //code值一致但法定代表人主键不一致
                if (actualControl.getCustomerCode().equals(pkCustomerRef.getCustomerCode())
                        && !actualControl.getPkCustomer().equals(pkCustomerRef.getPkCustomer())) {
                    //修改其他关系 关联客户的PK
                    CustRelatedCompanyDO companyDO = companyService.findById(pk);
                    companyDO.setPkCustomerRef(actualControl.getPkCustomer());
                    companyService.save(companyDO);

                } else if (!actualControl.getCustomerCode().equals(pkCustomerRef.getCustomerCode())) {//code值不一致

                    deleteActual(vo, pk);
                    insertActual(vo, actualControl.getPkCustomer());
                }
            } else {
                insertActual(vo, actualControl.getPkCustomer());
            }
        }

    }

    /**
     * 删高管法定代表人
     */
    private void deleteLegal(String pkCustomer, String pk) {
        //删高管法定代表人
        companyService.batchDelete(pkCustomer, PubEnumsConstant.RELATION_EXECUTIVE, PubEnumsConstant.EXECUTIVE_LEGAL);

        //修改其它联系人
        CustContactQuery query = new CustContactQuery();
        query.setPkCustomer(pkCustomer);
        query.setContactType(PubEnumsConstant.CONTACT_TYPE_LEGAL_REPRESENTATIVE);
        List<CustContactVO> contactList = contactService.query(query);
        List<CustContactDO> toSaveList = new ArrayList<>();

        if (contactList != null && contactList.size() > 0) {
            for (CustContactVO contactVO : contactList) {
                // 联系人类型变更为其他
                contactVO.setContactType(PubEnumsConstant.CONTACT_TYPE_OTHER);
                toSaveList.add(DozerUtils.convert(contactVO, CustContactDO.class));
            }
        }
        contactService.batchSave(toSaveList);

        //删关联关系
        relationService.deleteByPkCustSubTable(pk);
    }


    /**
     * 删其他关系 实际控制人
     */
    private void deleteActual(CustomerCorpAllVO vo, String pk) {
        //删其他关系 实际控制人
        companyService.batchDelete(vo.getPkCustomer(), PubEnumsConstant.RELATION_OTHER);
        //修改其它联系人
        CustContactQuery query = new CustContactQuery();
        query.setPkCustomer(vo.getPkCustomer());
        query.setContactType(PubEnumsConstant.CONTACT_TYPE_ACTUAL_CONTROL);
        List<CustContactVO> contactList = contactService.query(query);
        List<CustContactDO> toSaveList = new ArrayList<>();
        if (contactList != null && contactList.size() > 0) {
            for (CustContactVO contactVO : contactList) {
                // 联系人类型变更为其他
                contactVO.setContactType(PubEnumsConstant.CONTACT_TYPE_OTHER);
                toSaveList.add(DozerUtils.convert(contactVO, CustContactDO.class));
            }
        }
        contactService.batchSave(toSaveList);

        //删关联关系
        relationService.deleteByPkCustSubTable(pk);
    }

    /**
     * 新增法定代表人
     */
    private void insertLegal(CustomerCorpAllVO vo) {
        CustomerPersonDTO pkCustomerPerson = vo.getPkCustomerPerson();
        //新增法定代表人

        String relationRole = getRelationRole(ParamValueConstant.LEGAL_REPRESENTATIVE_CODE);
        CustRelatedCompanyDO companyDO = new CustRelatedCompanyDO();
        companyDO.setPkCustRelatedCompany(BaseBusinessUtils.getOID());
        companyDO.setPkCustomer(vo.getPkCustomer());
        companyDO.setPkCustomerRef(pkCustomerPerson.getPkCustomer());
        companyDO.setRelationClass(PubEnumsConstant.RELATION_INCIDENCE);
        companyDO.setRelationRole(relationRole);
        companyDO.setBilltype(PubEnumsConstant.RELATION_EXECUTIVE);
        companyDO.setExecutiveType(PubEnumsConstant.EXECUTIVE_LEGAL);
        companyDO.setBillstatus(Billstatus.INITALIZE.getShort());
        companyDO.setPkOperator(vo.getPkOperator().getPk());
        companyDO.setOperateDate(DateUtils.getCurDate());
        companyDO.setOperateTime(DateUtils.getCurDateTime());
        companyDO.setPkOrg(vo.getPkOrg().getPkOrg());
        companyService.save(companyDO);
        //新增其他联系人
        this.saveContract(vo);
        //新增关联关系
        this.saveRelation(vo, companyDO, true);

    }

    /**
     * 新增实际控制人
     */
    private void insertActual(CustomerCorpAllVO vo, String actualControl) {
        //新增实际控制人
        CustRelatedCompanyDO companyDO = new CustRelatedCompanyDO();
        companyDO.setPkCustRelatedCompany(BaseBusinessUtils.getOID());
        companyDO.setPkCustomer(vo.getPkCustomer());
        companyDO.setPkCustomerRef(actualControl);
        companyDO.setRelationClass(PubEnumsConstant.RELATION_INCIDENCE);
        companyDO.setRelationRole(getRelationRole(ParamValueConstant.ACTUAL_CONTROL_CODE));
        companyDO.setBilltype(PubEnumsConstant.RELATION_OTHER);
        companyDO.setExecutiveType(null);
        companyDO.setBillstatus(Billstatus.INITALIZE.getShort());
        companyDO.setPkOperator(vo.getPkOperator().getPk());
        companyDO.setOperateDate(DateUtils.getCurDate());
        companyDO.setOperateTime(DateUtils.getCurDateTime());
        companyDO.setPkOrg(vo.getPkOrg().getPkOrg());
        companyService.save(companyDO);
        //新增其他联系人
        CustomerDTO refVO = vo.getActualControl();

        CustContactDO contactDO = new CustContactDO();
        contactDO.setPkCustContact(BaseBusinessUtils.getOID());
        contactDO.setPkCustomer(vo.getPkCustomer());
        contactDO.setIfMajorContact(PubEnumsConstant.IF_NO);
        contactDO.setCustomerName(refVO.getCustomerName());
        contactDO.setIdentityCardNumb(refVO.getIdentityNo());
        contactDO.setDepartment(null);
        contactDO.setDuty(null);
        contactDO.setMobile(null);
        contactDO.setEmail(refVO.getCompanyMailbox());
        contactDO.setOfficePhone(refVO.getPhone());
        contactDO.setFax(refVO.getFax());
        contactDO.setHomePhone(null);
        contactDO.setBillstatus(Billstatus.INITALIZE.getShort());
        contactDO.setPkOperator(vo.getPkOperator().getPk());
        contactDO.setPkOrg(vo.getPkOrg().getPkOrg());
        contactDO.setOperateDate(DateUtils.getCurDate());
        contactDO.setOperateTime(DateUtils.getCurDateTime());
        contactDO.setIdentityType(refVO.getIdentityType());
        contactDO.setContactType(PubEnumsConstant.CONTACT_TYPE_ACTUAL_CONTROL);
        contactDO.setCustomerCode(refVO.getCustomerCode());
        contactDO.setInitialPk(contactDO.getPkCustContact());
        contactService.save(contactDO);
        //新增关联关系
        this.saveRelation(vo, companyDO, false);

    }

    private void saveContract(CustomerCorpAllVO vo) {
        //新增其他联系人
        CustomerPersonDTO refVO = vo.getPkCustomerPerson();
        CustContactDO contactDO = new CustContactDO();
        contactDO.setPkCustContact(BaseBusinessUtils.getOID());
        contactDO.setPkCustomer(vo.getPkCustomer());
        contactDO.setIfMajorContact(PubEnumsConstant.IF_NO);
        contactDO.setCustomerName(vo.getCustomerName());
        contactDO.setIdentityType(refVO.getIdentityType());
        contactDO.setIdentityCardNumb(refVO.getIdentityNo());
        contactDO.setDepartment(refVO.getDepartment());
        contactDO.setDuty(refVO.getDuty());
        contactDO.setMobile(refVO.getMobile());
        contactDO.setEmail(refVO.getEmail());
        contactDO.setOfficePhone(refVO.getEmployerTel());
        contactDO.setFax(refVO.getFax());
        contactDO.setHomePhone(refVO.getHomePhone());
        contactDO.setBillstatus(Billstatus.INITALIZE.getShort());
        contactDO.setPkOperator(vo.getPkOperator().getPk());
        contactDO.setOperateDate(DateUtils.getCurDate());
        contactDO.setOperateTime(DateUtils.getCurDateTime());
        contactDO.setPkOrg(vo.getPkOrg().getPkOrg());
        contactDO.setContactType(PubEnumsConstant.CONTACT_TYPE_LEGAL_REPRESENTATIVE);
        contactDO.setCustomerCode(refVO.getCustomerCode());
        contactDO.setInitialPk(contactDO.getPkCustContact());
        contactService.save(contactDO);
    }

    private void saveRelation(CustomerCorpAllVO vo, CustRelatedCompanyDO companyDO, boolean isLegal) {
        String relationCustomer;
        // 法人
        if (isLegal) {
            relationCustomer = vo.getPkCustomerPerson().getPkCustomer();
            //正向
            saveRelation(PubEnumsConstant.RELATION_DIRECTION, vo, companyDO.getPkCustRelatedCompany(), relationCustomer,
                    getRelationRole(ParamValueConstant.LEGAL_REPRESENTATIVE_CODE));
            // 反向
            saveRelation(PubEnumsConstant.RELATION_DIRECTION_REVERSE, vo, companyDO.getPkCustRelatedCompany(),
                    relationCustomer, getRelationRole(ParamValueConstant.COMPANY_CODE));
            //
        } else {
            relationCustomer = vo.getActualControl().getPkCustomer();
            //正向
            saveRelation(PubEnumsConstant.RELATION_DIRECTION, vo, companyDO.getPkCustRelatedCompany(), relationCustomer,
                    getRelationRole(ParamValueConstant.ACTUAL_CONTROL_CODE));
            // 反向
            saveRelation(PubEnumsConstant.RELATION_DIRECTION_REVERSE, vo, companyDO.getPkCustRelatedCompany(),
                    relationCustomer, getRelationRole(ParamValueConstant.BE_CONTROL_ENTERPRISE_CODE));
        }
        //新增关联关系

    }

    private void saveRelation(Short reverseFlag, CustomerCorpAllVO vo, String pkCustRelatedCompany,
                              String relationCustomer, String relationRole) {

        CustomerRelationDO relationDO = new CustomerRelationDO();
        relationDO.setPkCustomerRelation(BaseBusinessUtils.getOID());
        if (PubEnumsConstant.RELATION_DIRECTION.equals(reverseFlag)) {
            relationDO.setPkCustomerRef(relationCustomer);
            relationDO.setPkCustomerRef2(vo.getPkCustomer());
        } else {
            relationDO.setPkCustomerRef(vo.getPkCustomer());
            relationDO.setPkCustomerRef2(relationCustomer);
        }
        relationDO.setRelationRole(relationRole);
        relationDO.setRelationClass(PubEnumsConstant.RELATION_INCIDENCE);
        relationDO.setBillstatus(Billstatus.INITALIZE.getShort());
        relationDO.setPkOperator(vo.getPkOperator().getPk());
        relationDO.setOperateDate(DateUtils.getCurDate());
        relationDO.setOperateTime(DateUtils.getCurDateTime());
        relationDO.setPkOrg(vo.getPkOrg().getPkOrg());
        relationDO.setPkCustChildTable(pkCustRelatedCompany);
        relationDO.setRelationDirection(reverseFlag);
        relationDO.setRelationStatus(PubEnumsConstant.RELATION_STATUS_NORMAL);
        relationService.save(relationDO);
    }

    // 根据参数值查询客户关系参照
    public String getRelationRole(String paramValue) {
        List<ParameterVO> list = ParamTypeUtils.findByParamTypeAndParamValue(1, paramValue);
        if (list != null && list.size() > 0) {
            ParameterVO map = list.get(0);
            return map.getPkParameter();
        }
        return null;
    }
}