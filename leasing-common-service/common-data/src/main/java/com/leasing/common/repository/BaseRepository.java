package com.leasing.common.repository;

import com.leasing.common.repository.support.Pagination;
import org.springframework.data.jpa.repository.JpaRepository;
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

    T findOne(ID id);

    List<T> pageQuery(Pagination pagination,T t);

}
