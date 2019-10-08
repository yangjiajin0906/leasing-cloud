package com.leasing.project.repository;

import com.leasing.project.vo.ProjectInfoVO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : jiaoshy@yonyou.com
 * @project : leasing-cloud
 * @date :  2019/9/25
 * @description:
 **/
@Repository
public interface TestRepository extends JpaRepository<ProjectInfoVO, String> {

    /**
     * 通过主键查询
     *
     * @param pk
     * @return
     */
    List<ProjectInfoVO> findByPrimaryKey(String pk);

    /**
     * 自定义查询
     *
     * @param pk
     * @return 占位符
     */
    @Query("select pro from ProjectInfoVO pro where pro.primaryKey = ?1")
    ProjectInfoVO getByPrimaryKey(String pk);

    /**
     * 通过绑定
     *
     * @param primaryKey
     * @param ts
     * @return
     */
    @Query("select u from ProjectInfoVO  u where u.primaryKey = :primaryKey and u.ts = :ts")
    ProjectInfoVO getByPrimaryKeyAndTs(@Param("primaryKey") String primaryKey, @Param("ts") String ts);

    /**
     * 通过原生SQL 查询
     *
     * @param pk
     * @return
     */
    @Query(value = "select * from yls_project_info where pk_project_info = ?1", nativeQuery = true)
    List<ProjectInfoVO> queryByPrimaryKey(String pk);

    /**
     * 通过绑定 原生SQL 查询
     *
     * @param primaryKey
     * @return
     */
    @Query(value = "select  * from yls_project_info where pk_project_info = :primaryKey", nativeQuery = true)
    List<ProjectInfoVO> queryObjByPrimaryKey(@Param("primaryKey") String primaryKey);


}
