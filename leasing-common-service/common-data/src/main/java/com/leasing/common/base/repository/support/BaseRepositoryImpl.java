package com.leasing.common.base.repository.support;

import com.leasing.common.base.entity.BaseEntity;
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.entity.BaseVO;
import com.leasing.common.base.repository.BaseRepository;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.query.internal.QueryImpl;
import org.hibernate.transform.Transformers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @project:leasing-cloud
 * @date:2019-10-10
 * @author:lvcna@yonyou.com
 * @description:
 **/
@Transactional(readOnly = true)
public class BaseRepositoryImpl<T extends BaseEntity, Q extends BaseQuery, V extends BaseVO, ID extends Serializable>
        extends SimpleJpaRepository<T, ID> implements BaseRepository<T, Q, V, ID> {

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
        Optional<T> result = findById(id);
        if (!result.isPresent()) return null;
        return result.get();
    }


    @Override
    public PageQueryData pageQuery(Pagination pagination, Q query) {
        PageQueryData pageQueryData = new PageQueryData();
        int curPage = pagination.getCurPage() > 0 ? pagination.getCurPage() - 1 : 0;
        int pageSize = pagination.getPageSize();
        Pageable pageable = PageRequest.of(curPage, pageSize);
        Page page = this.findAll(query.toSpec(), pageable);
        pageQueryData.setPageData(page.getContent());
        pageQueryData.setPageSize(page.getTotalPages());
        pageQueryData.setTotal(page.getTotalElements());
        return pageQueryData;
    }


    @Override
    public List<V> pageQuery(Pagination pagination, Q query, String jpql) {
        int curPage = pagination.getCurPage() > 0 ? pagination.getCurPage() - 1 : 0;
        int pageSize = pagination.getPageSize();
        int firstResult = curPage * pageSize;
        int maxResult = pageSize;
        Query queryResult = entityManager.createQuery(jpql);
        queryResult.setFirstResult(firstResult).setMaxResults(maxResult);
        return queryResult.getResultList();
    }

    @Override
    public <S> S findOne(ID id, Class<S> S) {
        Assert.notNull(id, "查询主键不能为空!");
        Optional<T> e = findById(id);
        return (S) e;
    }

    @Override
    public <R> R findOneByJPQL(Class R, String jpql, boolean byName) {
        Assert.notNull(jpql, "自定义jpql不能为空!");
        List resultList = findByJPQL(R,jpql,byName);
        if (resultList.isEmpty()) return null;
        return (R) resultList.get(0);
    }

    @Override
    public <R> List<R> findByNativeSql(Class R, String sql) {
        Assert.notNull(sql, "sql不可为空");
        Query query = entityManager.createNativeQuery(sql);
        query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.aliasToBean(R));
        return (List<R>) query.getResultList();
    }

    @Override
    public <R> R findOneByNativeSql(Class R, String sql) {
        Assert.notNull(sql, "sql不可为空");
        Query query = entityManager.createNativeQuery(sql);
        query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.aliasToBean(R));
        List list = query.getResultList();
        if (list.isEmpty()) return null;
        return (R) list.get(0);
    }

    @Override
    public List<Map<String, Object>> findByNativeSql(String sql,boolean byName) {
        Query query;
        if(byName){
            query = entityManager.createNamedQuery(sql);
        }else {
            query = entityManager.createNativeQuery(sql);

        }
        query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List<Map<String, Object>> list = query.getResultList();
        return list;
    }

    @Override
    public Map<String, Object> findOneByNativeSql(String sql,boolean byName) {
        List<Map<String, Object>> list = findByNativeSql(sql,byName);
        if (list.isEmpty()) return null;
        return list.get(0);
    }

    @Override
    public PageQueryData pageQuery(Pagination pagination, Q query, Sort sort) {
        PageQueryData pageQueryData = new PageQueryData();
        int curPage = pagination.getCurPage() > 0 ? pagination.getCurPage() - 1 : 0;
        int pageSize = pagination.getPageSize();
        Pageable pageable = PageRequest.of(curPage, pageSize, sort);
        Page page = this.findAll(query.toSpec(), pageable);
        pageQueryData.setPageData(page.getContent());
        pageQueryData.setPageSize(page.getTotalPages());
        pageQueryData.setTotal(page.getTotalElements());
        return pageQueryData;
    }

    @Override
    public List findByJPQL(Class R, String jpql, boolean byName) {
        Query queryResult;
        if (byName) {
            queryResult = entityManager.createNamedQuery(jpql);
        } else {
            queryResult = entityManager.createQuery(jpql);
        }
        return queryResult.getResultList();
    }


}
