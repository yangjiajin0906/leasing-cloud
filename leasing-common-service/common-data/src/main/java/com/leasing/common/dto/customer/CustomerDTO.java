package com.leasing.common.dto.customer;

import com.leasing.common.vo.foundation.DeptVO;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

/**
 * @project:leasing-cloud
 * @date:2019-10-21
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Entity
@Table(name = "yls_customer")
public class CustomerDTO {

    @Id
    private String pkCustomer;

    private String customerName;

    private String customerCode;

    @ManyToOne
    @JoinColumn(name = "pkDept")
    @Fetch(FetchMode.JOIN)
    private DeptVO pkDept;

    public CustomerDTO(String pkCustomer) {
        this.pkCustomer = pkCustomer;
    }
    public CustomerDTO() {

    }

    public String getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(String pkCustomer) {
        this.pkCustomer = pkCustomer;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public DeptVO getPkDept() {
        return pkDept;
    }

    public void setPkDept(DeptVO pkDept) {
        this.pkDept = pkDept;
    }
}