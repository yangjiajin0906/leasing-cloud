package com.leasing.communication.service.impl;

import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.entity.foundation.vo.CurrtypeVO;
import com.leasing.common.utils.tools.DozerUtils;
import com.leasing.common.utils.tools.ExcelUtils;
import com.leasing.communication.entity.dos.CbBadContractDO;
import com.leasing.communication.entity.dos.CbEarlySettlementDO;
import com.leasing.communication.entity.dto.CbBadContractImpDTO;
import com.leasing.communication.entity.dto.CbEarlySettlementImpDTO;
import com.leasing.communication.entity.vo.CbBadContractVO;
import com.leasing.communication.entity.vo.CbEarlySettlementVO;
import com.leasing.communication.entity.vo.SourceSystemVO;
import com.leasing.communication.repository.CbBadContractRepo;
import com.leasing.communication.repository.CbEarlySettlementRepo;
import com.leasing.communication.service.CbBadContractService;
import com.leasing.communication.service.CbEarlySettlementService;
import com.leasing.communication.utils.EntityCacheUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @project:leasing-cloud
 * @date:2019-12-3
 * @author:lvcna@yonyou.com
 * @description: 2C提前结清接口实现类
 **/
@Transactional
@Service("communication.CbEarlySettlementServiceImpl")
public class CbEarlySettlementServiceImpl implements CbEarlySettlementService {

    @Resource
    CbEarlySettlementRepo cbEarlySettlementRepo;

    @Override
    public List<CbEarlySettlementImpDTO> dataImp(File file) {
        List<CbEarlySettlementImpDTO> contList = ExcelUtils.convertExcel(file, CbEarlySettlementImpDTO.class);
        return contList;
    }

    @Override
    public List<CbEarlySettlementDO> dataConvert(List<CbEarlySettlementImpDTO> list) {
        Map<String, String> soruceSystemMap = EntityCacheUtils.cacheEntityField("SourceSystemVO", "systemCode",
                "pkSourceSystem", SourceSystemVO.class);
        Map<String, String> currtypeMap = EntityCacheUtils.cacheEntityField("CurrtypeVO", "currtypecode",
                "pkCurrtype", CurrtypeVO.class);
        List<CbEarlySettlementDO> cList = new ArrayList<>();
        for(CbEarlySettlementImpDTO dto : list){
            CbEarlySettlementDO cbEarlySettlementDO = DozerUtils.convert(dto, CbEarlySettlementDO.class);
            cbEarlySettlementDO.setPkContract(UUID.randomUUID().toString().replace("-","").substring(0,20));
            cbEarlySettlementDO.setPkSys(soruceSystemMap.get(dto.getPkSys()));
            cbEarlySettlementDO.setPkCurrency(soruceSystemMap.get(dto.getPkCurrency()));
            cList.add(cbEarlySettlementDO);
        }
        return cList;
    }

    @Override
    public void save(List<CbEarlySettlementDO> list) {
        cbEarlySettlementRepo.saveAll(list);
    }

    @Override
    public PageQueryData<CbEarlySettlementVO> pageQuery(Pagination pagination, BaseQuery baseQuery, String queryName) {
        return cbEarlySettlementRepo.pageQuery(pagination, baseQuery, queryName);
    }
}
