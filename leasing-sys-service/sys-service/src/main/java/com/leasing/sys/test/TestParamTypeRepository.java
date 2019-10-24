package com.leasing.sys.test;

import com.leasing.common.base.repository.BaseRepository;
import com.leasing.sys.dao.dos.ParamTypeDO;
import com.leasing.sys.dao.query.ParamTypeQuery;
import com.leasing.sys.dao.vo.ParameterVO;

/**
 * @project:leasing-cloud
 * @date:2019-10-16
 * @author:lvcna@yonyou.com
 * @description:
 **/
public interface TestParamTypeRepository extends BaseRepository<ParamTypeDO,ParameterVO,ParamTypeQuery,String> {


    ParamTypeDO findOne(String pk);


}
