package com.leasing.sys.entity;

import com.leasing.common.entity.StringModalType;
import com.leasing.common.entity.base.BaseBusiEntity;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @project:leasing-cloud
 * @date:2019/9/24
 * @author:wangjc@yonyou.com
 * @description:
 **/
@Entity
@Table(name = "yls_test_user")
public class ContractVO extends BaseBusiEntity {
//    @Id
//    private String pk_contract;
//    private String pk_initial;
//    private String cont_code;
//    private String cont_name;

    public String getTableName() {
            return"yls_test_user";
    };

    @Id
    private String pk;
    private String name;
    private String code;

    private String content;

    public StringModalType getVersion() {
        return version;
    }

    public void setVersion(StringModalType version) {
        this.version = version;
    }

    @Version
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm:ss")//格式：年-月-日 时：分：秒
//    //格式化到后台
//    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH-mm:ss")
    private StringModalType version;

    @PrePersist
    public void prePersist() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        content = formatter.format(new Date());
    }

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ContractVO() {

    }


    public ContractVO(String pk, String name, String code, String content, StringModalType version) {
        this.pk = pk;
        this.name = name;
        this.code = code;
        this.content = content;
        this.version = version;
    }

    public String toString() {
        final StringBuffer sb = new StringBuffer("ContractVO{");
        sb.append("pk=").append(pk);
        sb.append(", name='").append(name).append('\'');
        sb.append(", code=").append(code);
        sb.append(", content=").append(content);
        sb.append('}');
        return sb.toString();
    }
}