package com.leasing.communication.service.impl;

import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.entity.common.dos.SystemDO;
import com.leasing.common.enums.constant.PubEnumsConstant;
import com.leasing.communication.entity.dos.CbImpSetDO;
import com.leasing.communication.entity.dos.SourceSystemDO;
import com.leasing.communication.entity.dto.CbImpSetDTO;
import com.leasing.communication.entity.dto.SourceSystemDTO;
import com.leasing.communication.repository.CbImpSetRepo;
import com.leasing.communication.service.CbImpSetService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-12-8
 * @author:lvcna@yonyou.com
 * @description:
 **/
@Service(value = "communication.CbImpSetServiceImpl")
public class CbImpSetServiceImpl implements CbImpSetService {

    @Resource
    CbImpSetRepo cbImpSetRepo;

    @Override
    public CbImpSetDO save(CbImpSetDO cbImpSetDO) {
        CbImpSetDO entity = cbImpSetRepo.save(cbImpSetDO);
        return entity;
    }

    @Override
    public List<CbImpSetDO> pageQuery(BaseQuery query) {

        return null;
    }

    @Override
    public CbImpSetDO findOne(String pk) {
        CbImpSetDO cbImpSetDO = cbImpSetRepo.findOne(pk);
        return cbImpSetDO;
    }

    @Override
    public CbImpSetDTO findBySystem(SourceSystemDTO systemDTO) {
        CbImpSetDTO cbImpSetDO = cbImpSetRepo.findByPkSystem(systemDTO, PubEnumsConstant.IF_EFFECTIVE_YES);
        return cbImpSetDO;
    }
}
