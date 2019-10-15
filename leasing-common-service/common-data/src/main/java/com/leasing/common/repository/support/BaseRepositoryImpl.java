package com.leasing.common.repository.support;

import com.leasing.common.entity.base.BusinessEntity;
import com.leasing.common.repository.BaseRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-10-10
 * @author:lvcna@yonyou.com
 * @description:
 **/
@NoRepositoryBean
@Transactional(readOnly = true)
public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T,ID> implements BaseRepository<T,ID> {

    private EntityManager entityManager;

    public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
    }

    public T findOne(ID id) {
        Assert.notNull(id, "查询主键不能为空!");
        System.out.println("ttttttt");
        T entity = findById(id).get();
        return entity;
    }

    @Override
    public List<T> pageQuery(Pagination pagination, T t) {
        int curPage = pagination.getCurPage() - 1;
        int pageSize = pagination.getPageSize();
        PageRequest.of(curPage,pageSize);
        return null;
    }



}
