package com.leasing.common.base.repository.support;

import com.leasing.common.base.entity.BaseEntity;
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.entity.BaseVO;
import com.leasing.common.base.repository.BaseRepository;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @project:leasing-cloud
 * @date:2019-10-10
 * @author:lvcna@yonyou.com
 * @description:
 **/
@Transactional(readOnly = true)
public class BaseRepositoryImpl<T extends BaseEntity,Q extends BaseQuery,V extends BaseVO,ID extends Serializable>
        extends SimpleJpaRepository<T,ID> implements BaseRepository<T,Q,V,ID> {

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
        T entity = findById(id).get();
        return entity;
    }


    @Override
    public List<V> pageQuery(Pagination pagination, Q query) {
        int curPage = pagination.getCurPage() - 1;
        int pageSize = pagination.getPageSize();
        PageRequest.of(curPage,pageSize);

        return null;
    }

    @Override
    public List<V> pageQuery(Pagination pagination, Q query,String jpql) {
        int curPage = pagination.getCurPage() - 1;
        int pageSize = pagination.getPageSize();
        PageRequest.of(curPage,pageSize);

        return null;
    }

    @Override
    public <S> S findOne(ID id, Class<S> S) {

        return null;
    }

    @Override
    public <R> R findOneByJPQL(Class R, String jpql) {
        return null;
    }

    @Override
    public <R> List<R> findByNativeSql(Class R, String sql) {
        return null;
    }

    @Override
    public <R> R findOneByNativeSql(Class R, String sql) {
        return null;
    }

    @Override
    public List<Map<String, Object>> findByNativeSql(String sql) {
        Query query = entityManager.createNativeQuery(sql);
        query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List<Map<String,Object>> list = query.getResultList();
        return list;
    }

    @Override
    public Map<String, Object> findOneByNativeSql(String sql) {
        Query query = entityManager.createNativeQuery(sql);
        query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List<Map<String,Object>> list = query.getResultList();
        Assert.notEmpty(list,"未查询到数据,请检查!");
        return list.get(0);
    }

    @Override
    public List findByJPQL(Class R, String jpql) {
        entityManager.getDelegate();
        List result = entityManager.createQuery(jpql).getResultList();
        return result;
    }


}
