package com.leasing.common.entity.common.vo;

import com.leasing.common.base.entity.BaseBusinessVO;
import com.leasing.common.entity.common.dos.CoderuleTypeDO;
import com.leasing.common.entity.sys.dto.ParameterDTO;
import com.leasing.common.entity.foundation.vo.UserVO;

import javax.persistence.*;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/11/1
 * @author:wangjc@yonyou.com
 * @description:编码规则VO (因为功能菜单业务节点重做 此处未确定使用形式  目前使用String修饰businessPoint)
 **/
@Entity
@Table(name="YLS_CODERULE")
@NamedQueries({
        @NamedQuery(name = "ListCoderule", query = "SELECT b from CoderuleVO b" +
                " left join fetch b.pkOrg " +
                " left join fetch b.pkOperator " +
                " left join fetch b.pkDept " +
                " left join fetch b.pkChecker " +
                " left join fetch b.variableName"),
        @NamedQuery(name = "ListCoderule.count", query = "SELECT count(b.pkCoderule) FROM CoderuleVO b")
})
public class CoderuleVO extends BaseBusinessVO {
    public String getTableName(){return "yls_coderule";}

    public String getPk(){return pkCoderule;}

    public void setPk(String pkCoderule){this.pkCoderule = pkCoderule;}

    public CoderuleVO(){}

    @Id
    private String pkCoderule;

    /**
     * 租赁类别
     */
    private Short rentalCategory;

    /**
     *业务节点
     */
    private String businessPoint;

    /**
     * 变量名称
     */
    @ManyToOne
    @JoinColumn(name = "variableName")
    private ParameterDTO variableName;

    /**
     * 编码规则名称
     */
    private String codeRuleName;

    /**
     * 复核人
     */
    @ManyToOne
    @JoinColumn(name = "pkChecker")
    private UserVO pkChecker;

    /**
     * 复核日期
     */
    private String checkDate;

    /**
     * 复核时间
     */
    private String checkTime;

    @Transient
    private List<CoderuleTypeDO> coderuleType;

    public String getPkCoderule() {
        return pkCoderule;
    }

    public void setPkCoderule(String pkCoderule) {
        this.pkCoderule = pkCoderule;
    }

    public Short getRentalCategory() {
        return rentalCategory;
    }

    public void setRentalCategory(Short rentalCategory) {
        this.rentalCategory = rentalCategory;
    }

    public String getBusinessPoint() {
        return businessPoint;
    }

    public void setBusinessPoint(String businessPoint) {
        this.businessPoint = businessPoint;
    }

    public ParameterDTO getVariableName() {
        return variableName;
    }

    public void setVariableName(ParameterDTO variableName) {
        this.variableName = variableName;
    }

    public String getCodeRuleName() {
        return codeRuleName;
    }

    public void setCodeRuleName(String codeRuleName) {
        this.codeRuleName = codeRuleName;
    }

    public UserVO getPkChecker() {
        return pkChecker;
    }

    public void setPkChecker(UserVO pkChecker) {
        this.pkChecker = pkChecker;
    }

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public List<CoderuleTypeDO> getCoderuleType() {
        return coderuleType;
    }

    public void setCoderuleType(List<CoderuleTypeDO> coderuleType) {
        this.coderuleType = coderuleType;
    }
}