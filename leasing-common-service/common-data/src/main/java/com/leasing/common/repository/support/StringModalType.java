/**
 * 自定义String类型支持 @Version注解 实现乐观锁机制管理
 */
package com.leasing.common.repository.support;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserVersionType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Date;


public class StringModalType implements UserVersionType{
    private String version;

    private static final int[] SQL_TYPES = { Types.VARCHAR};

    @Override
    public Object next(Object current, SharedSessionContractImplementor session) {
        StringModalType modal =new StringModalType();
        modal.setVersion(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        //return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        return modal;
    }

    @Override
    public Object seed(SharedSessionContractImplementor session) {
        StringModalType modal =new StringModalType();
        modal.setVersion(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        //return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        return modal;
    }


    @Override
    public int compare(Object o1, Object o2) {
        StringModalType modal1 = (StringModalType) o1;
        StringModalType modal2 = (StringModalType) o2;
        if(modal1.getVersion().equals(modal2.getVersion())){
            return 0;
        }
        return -1;
    }

    @Override
    public int[] sqlTypes() {
        return SQL_TYPES;
    }

    @Override
    public Class returnedClass() {
        return StringModalType.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        if (x == y)
            return true;
        if (x == null || y == null)
            return false;
        StringModalType modal1 = (StringModalType) x;
        StringModalType modal2 = (StringModalType) y;
        //return modal1.getVersion().equals(modal2.getVersion());
        return new EqualsBuilder() //使用EqualsBuilder类来方便地进行比对
                .append(modal1.getVersion(),modal2.getVersion()).isEquals();
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        StringModalType modal = (StringModalType) x;
        return new HashCodeBuilder()//使用HashCodeBuilder类来方便地进行比对
                .append(modal.getVersion())
                .toHashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws HibernateException, SQLException {
        if (rs.wasNull())
            return null;
        if (rs.wasNull())
            return null;
        String version = rs.getString(names[0]);
        StringModalType vo = new StringModalType(version);
        return vo;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {
        StringModalType version = (StringModalType) value;
        if (value == null) {
            st.setNull(index, Types.VARCHAR);
        } else {
            st.setString(index, version.getVersion());
        }
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return value;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return null;
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return null;
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return null;
    }

    public StringModalType() {
        super();
    }

    public StringModalType(String version) {
        super();
        this.version=version;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
