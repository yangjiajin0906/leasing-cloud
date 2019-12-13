package com.leasing.common.base.repository;

import com.leasing.common.base.entity.BaseRefVO;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.PageQueryRefData;
import com.leasing.common.base.repository.support.Pagination;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Map;


/**
 * @project:leasing-cloud
 * @date:2019-9-24
 * @author:lvcna@yonyou.com
 * @description: T=DO层实体对象 | V=VO展现层实体对象 | ID=主键
 **/
@NoRepositoryBean
public interface BaseRepository<T, Q, V, ID> extends JpaRepositoryImplementation<T, ID> {

    /**
     * 按主键查找单个对象
     *
     * @param id
     * @return
     */
    T findOne(ID id);

    /**
     * 保存业务对象
     * @param entity
     * @param <S>
     * @return
     */
    <S extends T> S saveEntity(S entity);

    /**
     * 更新业务对象
     * @param entity
     * @param <S>
     * @return
     */
    <S extends T> S updateEntity(S entity);

    /**
     * 分页查询,根据动态JPQL查询集合
     * @param pagination
     * @param query
     * @param queryName
     * @return
     */
    PageQueryData<V> pageQuery(Pagination pagination, Q query, String queryName);

    /**
     * 分页查询,根据原生SQL查询
     * @param pagination
     * @param query
     * @param queryName
     * @return
     */
    PageQueryData pageQueryNative(Pagination pagination, Q query,String queryName);

    /**
     * 动态查找单个对象
     *
     * @param id
     * @param S   自定义类型
     * @param <S>
     * @return
     */
    <S> S findOne(ID id, Class<S> S);

    /**
     * 根据原生SQL查询结果集
     * @param sql
     * @return
     */
    List<Map<String, Object>> findByNative(String sql);

    /**
     * 根据原生SQL queryName查询结果集合
     * @param name
     * @return
     */
    List<Map<String, Object>> findByNativeName(String name);

    /**
     * 根据动态JPQL查询集合
     * @param query
     * @param queryName
     * @return
     */
    List<V> pageQuery( Q query, String queryName);

    /**
     * 根据原生SQL查询
     * @param query
     * @param queryName
     * @return
     */
    List pageQueryNative( Q query,String queryName);


    /**
     * 根据JPQL 查询结果结合 (不使用name)
     */
    List findByJPQL(String jpql);


    <S extends BaseRefVO> PageQueryRefData<S> pageQueryRefData(Pagination pagination, Q query, String queryName, S entity);

    <S extends BaseRefVO> List<S> pageQueryRefData(Q query, String queryName, S entity);

}
