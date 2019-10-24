package com.leasing.common.base.repository;

import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Map;
import java.util.Optional;


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
     * 分页查询,查询当前存储库对象
     *
     * @param pagination
     * @param query
     * @return
     */
    PageQueryData pageQuery(Pagination pagination, Q query);

    /**
     * 分页查询,根据动态JPQL查询集合
     *
     * @param pagination
     * @param query
     * @return
     */
    List<V> pageQuery(Pagination pagination, Q query, String jpql);

    List<V> pageQueryName(Pagination pagination, Q query,String jpql);

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
     * 根据自定义JPQL返回指定类型结果集
     *
     * @param R      结果集泛型
     * @param jpql
     * @param byName 是否通过 jpql名称查询 true代表通过名称查询
     * @param <R>    结果集泛型
     * @return
     */
    <R> List<R> findByJPQL(Class<R> R, String jpql, boolean byName);

    /**
     * 根据自定义JPQL返回单个自定义实体对象
     *
     * @param R
     * @param jpql
     * @param <R>
     * @param byName 是否通过 jpql名称查询 true代表通过名称查询
     * @return
     */
    <R> R findOneByJPQL(Class R, String jpql, boolean byName);

    /**
     * 根据原生SQL返回单个自定义实体对象
     *
     * @param R
     * @param sql
     * @param <R>
     * @return
     */
    <R> List<R> findByNativeSql(Class R, String sql);

    /**
     * 根据原生SQL返回单个自定义实体对象
     *
     * @param R
     * @param sql
     * @param <R>
     * @return
     */
    <R> R findOneByNativeSql(Class R, String sql);

    /**
     * 根据传入的SQL检索单个对象
     * @param byName 是否通过名称
     * @param sql
     * @return 集合<map>
     */

    List<Map<String, Object>> findByNativeSql(String sql);
    List<Map<String, Object>> findByNativeSqlName(String name);

    List<Map<String, Object>> findByNativeSql(String sql,boolean byName);

    /**
     * 根据传入的SQL检索单个对象
     * @param byName 是否通过名称
     * @param sql
     * @return map
     */
    Map<String, Object> findOneByNativeSql(String sql,boolean byName);


    /**
     * 带排序的分页查询
     *
     * @param pagination 分页对象
     * @param query      查询条件
     * @param sort       排序方式
     * @return
     */
    PageQueryData pageQuery(Pagination pagination, Q query, Sort sort);


}
