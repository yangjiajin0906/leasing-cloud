package com.leasing.contract.entity;

import com.leasing.common.entity.StringModalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "yls_test_user")
@EntityListeners(AuditingEntityListener.class)
public class ContractVO extends Auditable<String>{
//    @Id
//    private String pk_contract;
//    private String pk_initial;
//    private String cont_code;
//    private String cont_name;

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


    //    @Override
//    public String toString() {
//        final StringBuffer sb = new StringBuffer("ContractVO{");
//        sb.append("pk_contract=").append(pk_contract);
//        sb.append(", pk_initial='").append(pk_initial).append('\'');
//        sb.append(", cont_code=").append(cont_code);
//        sb.append(", cont_name=").append(cont_name);
//        sb.append('}');
//        return sb.toString();
//    }
}