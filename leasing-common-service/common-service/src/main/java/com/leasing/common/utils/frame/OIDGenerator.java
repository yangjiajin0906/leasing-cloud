package com.leasing.common.utils.frame;

import com.leasing.common.utils.tools.OIDUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

/**
 * @project:leasing-cloud
 * @date:2019-12-10
 * @author:lvcna@yonyou.com
 * @description: 主键生成器
 **/
public class OIDGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object o) throws HibernateException {
        return OIDUtils.getOid();
    }
}
