package com.leasing.common.base.repository.support;

import com.leasing.common.base.entity.BaseDO;
import com.leasing.common.base.entity.BaseEntity;
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.entity.BaseVO;
import com.leasing.common.base.repository.BaseRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.engine.spi.NamedQueryDefinition;
import org.hibernate.internal.SessionImpl;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @project:leasing-cloud
 * @date:2019-10-10
 * @author:lvcna@yonyou.com
 * @description: Spring Data Jpa 自定义基类
 **/
@Transactional(readOnly = true)
public class BaseRepositoryImpl<T extends BaseEntity, Q extends BaseQuery, V extends BaseVO, ID extends Serializable>
        extends SimpleJpaRepository<T, ID> implements BaseRepository<T, Q, V, ID> {

    Log log = LogFactory.getLog(this.getClass());

    private EntityManager entityManager;

    public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;

    }
    @Override
    public T findOne(ID id) {
        Assert.notNull(id, "查询主键不能为空!");
        Optional<T> result = findById(id);
        if (!result.isPresent()) return null;
        return result.get();
    }

    @Override
    public <S extends T> S saveEntity(S entity) {
        Assert.isInstanceOf(BaseDO.class, entity);
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public <S extends T> S updateEntity(S entity) {
        Assert.isInstanceOf(BaseDO.class, entity);
        return entityManager.merge(entity);
    }

    @Override
    public <S extends T> S save(S entity) {
        Assert.isInstanceOf(BaseDO.class, entity);
        return super.save(entity);
    }

    @Override
    public PageQueryData<V> pageQuery(Pagination pagination, Q query, String queryName) {
        return this.pageQuerySupport(pagination, query, queryName,false);
    }

    @Override
    public PageQueryData pageQueryNative(Pagination pagination, Q query, String queryName) {
        return pageQuerySupport(pagination, query, queryName, true);
    }

    @Override
    public List<V>pageQuery( Q query, String queryName) {
        PageQueryData pageQueryData = this.pageQuerySupport(null, query, queryName,false);
        return pageQueryData.getPageData();
    }

    @Override
    public List pageQueryNative( Q query, String queryName) {
        PageQueryData pageQueryData = pageQuerySupport(null, query, queryName, true);
        return pageQueryData.getPageData();
    }
    /**
     * 处理分页查询
     * @param pagination
     * @param query
     * @param queryName
     * @param ifNative true : 原生SQL false：JPQL
     * @return
     */
    private PageQueryData pageQuerySupport(Pagination pagination, Q query, String queryName,Boolean ifNative){
        log.debug("开始分页查询-----------:");
        String sql = getQueryByName(queryName);
        QuerySupport querySupport = QuerySupport.getInstance();
        String countName = querySupport.countWhere(queryName);
        String count = getQueryByName(countName);
        //处理查询sql的形式
        QueryDataParam queryDataParam = querySupport.queryWhere(query, sql, ifNative);
        //处理count查询参数的形式
        QueryDataParam countDataParam = querySupport.queryWhere(query, count, ifNative);
        String querySql = sql;
        String countSql = count;
        if(queryDataParam.getIfArrange()){
            querySql = queryDataParam.getSql();
            countSql = countDataParam.getSql();
        }
        Query queryResult,countResult = null;
        if(ifNative){
            queryResult = entityManager.createNativeQuery(querySql);
            countResult = entityManager.createNativeQuery(countSql);
        } else {
            queryResult = entityManager.createQuery(querySql);
            countResult = entityManager.createQuery(countSql);
        }

        log.debug("分页整理SQL打印:-----------:");
        log.debug(querySql);
        log.debug(countSql);

        Map<String,Object> paramMap = queryDataParam.getParamMap();
        for (Iterator<String> key = paramMap.keySet().iterator(); key.hasNext(); ) {
            String paramKey = key.next();
            queryResult.setParameter(paramKey, paramMap.get(paramKey));
        }
        for (Iterator<String> key = paramMap.keySet().iterator(); key.hasNext(); ) {
            String paramKey = key.next();
            countResult.setParameter(paramKey, paramMap.get(paramKey));
        }
        log.debug("分页整理参数打印:-----------:");
        log.debug(paramMap.values());
        long total = Long.valueOf(countResult.getSingleResult().toString());
        if(pagination == null){    //不分页处理
            pagination = new Pagination(0,Integer.parseInt(String.valueOf(total)));
        }
        queryResult.setFirstResult(pagination.getFirstResult()).setMaxResults(pagination.getPageSize());
        List result = queryResult.getResultList();
        PageQueryData pageQueryData = new PageQueryData(total, pagination.getPageSize(), result);
        return pageQueryData;
    }

    @Override
    public <S> S findOne(ID id, Class<S> S) {
        Assert.notNull(id, "查询主键不能为空!");
        Optional<S> result = Optional.ofNullable(entityManager.find(S, id));
        return result.get();
    }

    @Override
    public List<Map<String, Object>> findByNative(String sql) {
        Assert.notNull(sql, "查询SQL不能为空!");
        Query query = entityManager.createNativeQuery(sql);
        query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.getResultList();

    }

    @Override
    public List<Map<String, Object>> findByNativeName(String name) {
        Assert.notNull(name, "查询QueryName不能为空!");
        Query query = entityManager.createNamedQuery(name);
        query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.getResultList();
    }


    /**
     * 根据QureryName获取工厂中的查询实例
     * @param name
     * @return
     */
    @SuppressWarnings("getNamedQueryRepository() => (since 5.2) it will be " +
            "replaced with the new QueryEngine concept introduced in 6.0")
    private String getQueryByName(String name){
        Assert.notNull(name, "JPA QueryName 不可为空!");
        NamedQueryDefinition namedQueryDefinition = null;
        namedQueryDefinition = ((SessionImpl)this.entityManager.getDelegate()).getFactory()
                .getNamedQueryRepository().getNamedQueryDefinition(name);
        if(namedQueryDefinition == null){
            namedQueryDefinition = ((SessionImpl)this.entityManager.getDelegate()).getFactory()
                    .getNamedQueryRepository().getNamedSQLQueryDefinition(name);
        }
        Assert.notNull(namedQueryDefinition, "未找到 JPA Query " + name + " 查询实例!");
        Assert.hasText(namedQueryDefinition.getQueryString(), "未找到 JPA Query " + name + " 查询实例对象!");
        return namedQueryDefinition.getQueryString();
    }

    @Override
    public List findByJPQL(String jpql) {
        Assert.notNull(jpql, "JPA Query JPQL 不可为空!");
        entityManager.getDelegate();
        List result = entityManager.createQuery(jpql).getResultList();
        return result;
    }

    @Override
    public PageQueryRefData<V> pageQueryRefData(Pagination pagination, Q query, String queryName) {
        PageQueryData<V> pageQueryData = this.pageQuerySupport(pagination, query, queryName,false);
        PageQueryRefData<V> pageQueryRefData = new PageQueryRefData<>();
        pageQueryRefData.setPageData(pageQueryData.getPageData());
        pageQueryRefData.setTotal(pageQueryData.getTotal());
        pageQueryData.setPageCount(pageQueryData.getPageCount());;
        return pageQueryRefData;
    }
}
