package com.leasing.sys.dao;

import com.leasing.common.repository.BaseRepository;
import com.leasing.sys.vo.SysTestVO;

/**
 * @project:leasing-cloud
 * @date:2019-9-29
 * @author:lvcna@yonyou.com
 * @description:
 **/
public interface SysTestRepository extends BaseRepository<SysTestVO, Long> {

    SysTestVO findByPkSysTest(Long pk);


}
