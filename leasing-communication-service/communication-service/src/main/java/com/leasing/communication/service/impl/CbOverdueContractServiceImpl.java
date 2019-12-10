package com.leasing.communication.service.impl;

import com.aliyun.oss.model.OSSObject;
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.entity.foundation.vo.CurrtypeVO;
import com.leasing.common.utils.tools.DozerUtils;
import com.leasing.common.utils.tools.ExcelUtils;
import com.leasing.communication.entity.dos.CbBadContractDO;
import com.leasing.communication.entity.dos.CbEarlySettlementDO;
import com.leasing.communication.entity.dos.CbOverdueContractDO;
import com.leasing.communication.entity.dto.*;
import com.leasing.communication.entity.vo.CbEarlySettlementVO;
import com.leasing.communication.entity.vo.CbOverdueContractVO;
import com.leasing.communication.repository.CbEarlySettlementRepo;
import com.leasing.communication.repository.CbOverdueContractRepo;
import com.leasing.communication.service.CbEarlySettlementService;
import com.leasing.communication.service.CbOverdueContractService;
import com.leasing.communication.utils.EntityCacheUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @project:leasing-cloud
 * @date:2019-12-3
 * @author:lvcna@yonyou.com
 * @description: 2C逾期合同接口实现类
 **/
@Transactional
@Service("communication.CbOverdueContractServiceImpl")
public class CbOverdueContractServiceImpl implements CbOverdueContractService {

    @Resource
    CbOverdueContractRepo cbOverdueContractRepo;

    @Override
    public List<CbOverdueContractImpDTO> dataImp(File file) {
        List<CbOverdueContractImpDTO> contList = ExcelUtils.convertExcel(file, CbOverdueContractImpDTO.class);
        return contList;
    }

    @Override
    public List<CbOverdueContractDO> dataConvert(List<CbOverdueContractImpDTO> list) {
        Map<String, String> soruceSystemMap = EntityCacheUtils.cacheEntityField("SourceSystemDTO", "systemCode",
                "pkSourceSystem", SourceSystemDTO.class);
        Map<String, String> currtypeMap = EntityCacheUtils.cacheEntityField("CurrtypeVO", "currtypecode",
                "pkCurrtype", CurrtypeVO.class);
        List<CbOverdueContractDO> cList = new ArrayList<>();
        for(CbOverdueContractImpDTO dto : list){
            CbOverdueContractDO cbOverdueContractDO = DozerUtils.convert(dto, CbOverdueContractDO.class);
            cbOverdueContractDO.setPkSys(soruceSystemMap.get(dto.getPkSys()));
            cbOverdueContractDO.setPkCurrency(currtypeMap.get(dto.getPkCurrency()));
            cList.add(cbOverdueContractDO);
        }
        return cList;
    }

    @Override
    public void save(List<CbOverdueContractDO> list) {
        for(CbOverdueContractDO dos: list){
            dos.setPkOverdueContract(UUID.randomUUID().toString().replace("-","").substring(0, 20));
        }
        cbOverdueContractRepo.saveAll(list);
    }

    @Override
    public PageQueryData<CbOverdueContractVO> pageQuery(Pagination pagination, BaseQuery baseQuery, String queryName) {
        return cbOverdueContractRepo.pageQuery(pagination, baseQuery, queryName);
    }

    @Override
    public FileOssLogDTO dataImp(OSSObject param) {
        FileOssLogDTO logDTO = new FileOssLogDTO(param.getKey());
        try {
            List<CbOverdueContractImpDTO> contList = ExcelUtils.convertExcel(param.getObjectContent(), param.getKey(), CbOverdueContractImpDTO.class);
            save(dataConvert(contList));
            logDTO.setDataNum(Long.valueOf(contList.size()));
        } catch (IOException e) {
            e.printStackTrace();
            logDTO.setLogMsg(e.getMessage());
            logDTO.setFlag(false);
        } finally {
            try {
                param.close();
            } catch (IOException e) {
                e.printStackTrace();
                logDTO.setLogMsg(e.getMessage());
                logDTO.setFlag(false);
            }
        }
        return logDTO;

    }
}
