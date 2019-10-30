package com.leasing.rentearly.rentearlyservice.projectInfo.repository;

import com.leasing.common.base.repository.BaseRepository;
import com.leasing.common.base.repository.support.StringModalType;
import com.leasing.rentearly.rentearlyservice.projectInfo.enity.ProjectInfoVO;
import com.leasing.rentearly.rentearlyservice.projectInfo.enity.dos.ProjectInfoDO;
import com.leasing.rentearly.rentearlyservice.projectInfo.enity.queryVO.ProjectQueryVO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/10/29
 * @author:jiaoshy@yonyou.com
 * @description: 普通项目审批
 **/
public interface ProjectInfoRepository extends BaseRepository<ProjectInfoDO, ProjectQueryVO, ProjectInfoVO, String> {

    /**
     * 排除N+1 的全查
     *
     * @return list
     */
    @Query(name = "ProjectInfoVO.queryForGrid")
    List<ProjectInfoVO> pageData();

    /**
     * 带有分页的查询
     *
     * @param pageable 分页对象
     * @return list
     */
    @Query(name = "ProjectInfoVO.queryForGrid")
    List<ProjectInfoVO> pageDataPage(Pageable pageable);

    /**
     * 查询单个VO
     *
     * @param pk 主键
     * @return vo
     */
    @Query(name = "ProjectInfoVO.findOne")
    ProjectInfoVO findOneVO(String pk);

    /**
     * 通过主键批量删除
     *
     * @param ids
     */
//    @Modifying
//    @Query(name = "ProjectInfoVO.deleteByIds")
//    void deleteByIds(@Param("ids") List<String> ids);

    /**
     * 更新单据状态
     * @param billstatus
     * @param pkProjectInfo
     * @param ts
     * @return
     */
    @Modifying
    @Query(name = "ProjectInfoVO.updateBillstatus")
    int updateBillstatus(@Param("billstatus") String billstatus, @Param("pkProjectInfo") String pkProjectInfo, @Param("ts") StringModalType ts);


}
