package com.leasing.sys.dao;

import com.leasing.sys.entity.vo.SystemVO;
import com.leasing.common.base.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019/10/16
 * @author:wangjc@yonyou.com
 * @description:
 **/
@Repository
public interface SystemRepository extends BaseRepository<SystemVO,String> {

}