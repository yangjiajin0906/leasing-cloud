package com.leasing.common.repository.support;

import com.leasing.common.repository.TestRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-10-13
 * @author:lvcna@yonyou.com
 * @description:
 **/
@NoRepositoryBean
public class TestRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements TestRepository<T, ID> {
    public TestRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }

    public TestRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
    }


    @Override
    public void Test() {
        System.out.println("succsucess");
    }

    @Override
    public T findOne(ID id) {
        System.out.println("findOne");
        return null;
    }

    @Override
    public List<T> pageQuery(Pagination pagination, T t) {
        System.out.println("pageQuery");
        return null;
    }
}
