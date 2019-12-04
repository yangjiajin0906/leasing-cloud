package com.leasing.common.refvo.base;

import com.leasing.common.base.entity.BaseRefVO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/10/18
 * @author:wangjc@yonyou.com
 * @description:机构参照测试类VO
 **/
@Entity
@Table(name = "sm_org")
public class OrgrefVO extends BaseRefVO {

    @Override
    public String[] getFieldCode(){
        return new String[] {"orgCode","orgName"};
    }

    @Override
    public String[] getFieldName(){
        return new String[] {"机构编码","机构名称"};
    }

    @Override
    public String getPk(){return pkOrg;}
    @Override
    public void setPk(String pkOrg){this.pkOrg = pkOrg;}
    @Override
    public String getCode() {
        return orgCode;
    }
    @Override
    public void setCode(String orgCode) {
        this.orgCode = orgCode;
    }
    @Override
    public String getName() {
        return orgName;
    }
    @Override
    public void setName(String orgName) {
        this.orgName = orgName;
    }

    @Id
    private String pkOrg;
    private String orgCode;
    private String orgName;
    private String parentPk;

    @Transient
    private List<OrgrefVO> children;

    public String getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(String pkOrg) {
        this.pkOrg = pkOrg;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getParentPk() {
        return parentPk;
    }

    public void setParentPk(String parentPk) {
        this.parentPk = parentPk;
    }

    public List<OrgrefVO> getChildren() {
        return children;
    }

    public void setChildren(List<OrgrefVO> children) {
        this.children = children;
    }

    public OrgrefVO(String pkOrg, String orgCode, String orgName, String parentPk){
        this.pkOrg = pkOrg;
        this.orgCode = orgCode;
        this.orgName = orgName;
        this.parentPk = parentPk;
    }
    public OrgrefVO(){}
}