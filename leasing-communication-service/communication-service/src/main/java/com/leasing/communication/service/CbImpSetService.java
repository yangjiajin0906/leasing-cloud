package com.leasing.communication.service;

import com.leasing.common.base.entity.BaseQuery;
import com.leasing.communication.entity.dos.CbImpSetDO;
import com.leasing.communication.entity.dos.SourceSystemDO;
import com.leasing.communication.entity.dto.CbImpSetDTO;
import com.leasing.communication.entity.dto.SourceSystemDTO;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-12-8
 * @author:lvcna@yonyou.com
 * @description: C端业务接口导入配置接口
 **/
public interface CbImpSetService {

    CbImpSetDO save(CbImpSetDO cbImpSetDO);

    List<CbImpSetDO> pageQuery(BaseQuery query);

    CbImpSetDO findOne(String pk);

    /**
     * 按照来源系统查询导入模板
     * @param systemDTO
     * @return
     */
    CbImpSetDTO findBySystem(SourceSystemDTO systemDTO);

}
