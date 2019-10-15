package com.leasing.common.repository;

import com.leasing.common.repository.support.Pagination;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-10-13
 * @author:lvcna@yonyou.com
 * @description:
 **/
public interface TestRepository<T, ID> extends PagingAndSortingRepository<T, ID> {

    void Test();

    T findOne(ID id);

    List<T> pageQuery(Pagination pagination, T t);
}
