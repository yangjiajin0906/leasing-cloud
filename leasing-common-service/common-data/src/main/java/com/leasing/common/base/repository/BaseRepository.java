package com.leasing.common.base.repository;

import com.leasing.common.base.repository.support.Pagination;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;


/**
 * @project:leasing-cloud
 * @date:2019-9-24
 * @author:lvcna@yonyou.com
 * @description:
 **/
@NoRepositoryBean
public interface BaseRepository<T,ID> extends JpaRepositoryImplementation<T,ID> {

    /**
     * 按主键查找单个对象
     * @param id
     * @return
     */
    T findOne(ID id);

    List<T> pageQuery(Pagination pagination,T t);

    /**
     * 动态查找单个对象
     * @param id
     * @param S 自定义类型
     * @param <S>
     * @return
     */
    <S> S findOne(ID id,Class<S> S);

}
