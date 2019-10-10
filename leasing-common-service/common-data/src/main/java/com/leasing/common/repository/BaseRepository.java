package com.leasing.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @project:leasing-cloud
 * @date:2019-9-24
 * @author:lvcna@yonyou.com
 * @description:
 **/
@NoRepositoryBean
public interface BaseRepository<T, ID> extends JpaRepository<T, ID> {

}
