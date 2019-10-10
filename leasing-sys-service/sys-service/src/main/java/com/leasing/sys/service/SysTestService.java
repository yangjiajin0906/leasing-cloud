package com.leasing.sys.service;

import com.leasing.sys.vo.SysTestVO;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-9-29
 * @author:lvcna@yonyou.com
 * @description:
 **/
public interface SysTestService {

    int update(SysTestVO vo);
    int insert(SysTestVO vo);
    int delete(SysTestVO vo);
    List<SysTestVO> queryAll();
    List<SysTestVO> pageQuery(SysTestVO vo);
    SysTestVO findOne(Long pk);
}
