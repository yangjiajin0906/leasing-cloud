package com.leasing.common.entity.foundation;

import com.leasing.common.entity.base.BaseBusiEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project:leasing-cloud
 * @date:2019-10-10
 * @author:lvcna@yonyou.com
 * @description:
 **/
@Entity
@Table(name="bd_deptdoc")
public class DeptVO extends BaseBusiEntity {

    @Id
    private String pkDeptdoc;

    private String pkCorp;
    private String deptcode;
    private String deptname;
    //部门负责人
    private String pkPsndoc;
    //部门分管领导
    private String pkPsndoc3;


    public String getTableName() {
        return "bd_deptdoc";
    }



    public String getPk() {
        return pkDeptdoc;
    }

    public void setPk(String pk) {
        this.pkDeptdoc = pk;
    }

    public String getPkDeptdoc() {
        return pkDeptdoc;
    }

    public void setPkDeptdoc(String pkDeptdoc) {
        this.pkDeptdoc = pkDeptdoc;
    }

    public String getPkCorp() {
        return pkCorp;
    }

    public void setPkCorp(String pkCorp) {
        this.pkCorp = pkCorp;
    }

    public String getDeptcode() {
        return deptcode;
    }

    public void setDeptcode(String deptcode) {
        this.deptcode = deptcode;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getPkPsndoc() {
        return pkPsndoc;
    }

    public void setPkPsndoc(String pkPsndoc) {
        this.pkPsndoc = pkPsndoc;
    }

    public String getPkPsndoc3() {
        return pkPsndoc3;
    }

    public void setPkPsndoc3(String pkPsndoc3) {
        this.pkPsndoc3 = pkPsndoc3;
    }


}
