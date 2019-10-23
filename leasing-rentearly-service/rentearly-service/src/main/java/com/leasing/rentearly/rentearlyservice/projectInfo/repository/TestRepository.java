package com.leasing.rentearly.rentearlyservice.projectInfo.repository;


import com.leasing.common.base.repository.BaseRepository;
import com.leasing.common.base.repository.support.StringModalType;
import com.leasing.rentearly.rentearlyservice.projectInfo.enity.ProjectInfoVO;
import com.leasing.rentearly.rentearlyservice.projectInfo.enity.dos.ProjectInfoDO;
import com.leasing.rentearly.rentearlyservice.projectInfo.enity.refVO.ProjectInfoRefVO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/10/21
 * @author:jiaoshy@yonyou.com
 * @description:
 **/
public interface TestRepository extends BaseRepository<ProjectInfoDO, String> {


    /**
     * 投影参照 自定义SQL-VO
     *
     * @param pk
     * @param type
     * @param <S>
     * @return
     */
    @Query(value = "select new com.leasing.rentearly.rentearlyservice.projectInfo.enity.refVO.ProjectInfoRefVO(b.pkProjectInfo,b.projectCode,b.projectName,b.pkProjectApproval) from ProjectInfoDO b where b.pkProjectInfo =?1")
    <S> Collection<S> findTest6(String pk, Class<S> type);

    /**
     * 投影参照 动态
     *
     * @param pk
     * @param type
     * @param <S>
     * @return
     */
    <S> Collection<S> findByPkProjectInfo(String pk, Class<S> type);

    /**
     * 参照投影-自定义SQL-DTO
     *
     * @param pk
     * @param type
     * @param <S>
     * @return
     */
    @Query(value = "select new com.leasing.rentearly.rentearlyservice.projectInfo.enity.refVO.ProjectInfoRefVO(b.pkProjectInfo,b.projectCode,b.projectName,b.pkProjectApproval) from ProjectInfoDTO b where b.pkProjectInfo =?1")
    <S> Collection<S> findTest4(String pk, Class<S> type);


    /**
     * 连接查询
     *
     * @param prjName
     * @return
     */
    @Query(value = "select b from ProjectInfoVO b left join fetch b.pkPrjManager k where k.userName = ?1")
    List<ProjectInfoVO> findTest(String prjName);

    /**
     * 出现N+1
     *
     * @param pk
     * @return
     */
    @Query(value = "select k from ProjectInfoVO k left join ProjectInfoDO  c on k.pkProjectInfo = c.pkProjectInfo where k.pkProjectInfo = ?1")
    List<ProjectInfoVO> findTest2(String pk);

    /**
     * 出现N+1
     *
     * @param pk
     * @return
     */
    @Query(value = "select k from ProjectInfoVO k left join fetch ProjectInfoDO  c on k.pkProjectInfo = c.pkProjectInfo where k.pkProjectInfo = ?1")
    List<ProjectInfoVO> findTest3(String pk);

    /**
     * 直接到底层查询 此时不会出现N+1
     *
     * @param pk
     * @return
     */
    @Query(value = "select k from ProjectInfoVO k left join fetch k.pkPrjManager c " +
            "left join fetch c.pkOrg l left join fetch l.parentPk p where k.pkProjectInfo = ?1")
    List<ProjectInfoVO> findFetch(String pk);

    /**
     * 直接到底层 不会出现懒加载 N+1
     *
     * @return
     */
    @Query(value = "select k from ProjectInfoVO k left join fetch k.pkPrjManager c " +
            "left join fetch c.pkOrg l left join fetch l.parentPk p ")
    List<ProjectInfoVO> findProjectALL();

    /**
     * 更新部分属性
     *
     * @param projectCode
     * @param pkProjectInfo
     * @param ts
     * @return
     */
    @Modifying
    @Query(value = "update ProjectInfoDO k set k.projectCode = :projectCode where k.pkProjectInfo = :pkProjectInfo and k.ts = :ts ")
    int updateTest(@Param("projectCode") String projectCode, @Param("pkProjectInfo") String pkProjectInfo, @Param("ts") StringModalType ts);

}
