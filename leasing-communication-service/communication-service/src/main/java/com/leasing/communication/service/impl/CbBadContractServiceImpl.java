package com.leasing.communication.service.impl;

import com.aliyun.oss.model.OSSObject;
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.entity.foundation.vo.CurrtypeVO;
import com.leasing.common.utils.tools.DozerUtils;
import com.leasing.common.utils.tools.ExcelUtils;
import com.leasing.communication.entity.dos.CbBadContractDO;
import com.leasing.communication.entity.dos.CbContractDO;
import com.leasing.communication.entity.dto.CbBadContractImpDTO;
import com.leasing.communication.entity.dto.CbContractImpDTO;
import com.leasing.communication.entity.dto.FileOssLogDTO;
import com.leasing.communication.entity.dto.SourceSystemDTO;
import com.leasing.communication.entity.vo.CbBadContractVO;
import com.leasing.communication.entity.vo.CbContractVO;
import com.leasing.communication.repository.CbBadContractRepo;
import com.leasing.communication.repository.CbContractRepo;
import com.leasing.communication.service.CbBadContractService;
import com.leasing.communication.service.CbContractService;
import com.leasing.communication.utils.EntityCacheUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
 * @description: 2C不良合同接口实现类
 **/
@Transactional
@Service("communication.CbBadContractServiceImpl")
public class CbBadContractServiceImpl implements CbBadContractService {

    @Resource
    CbBadContractRepo cbBadContractRepo;

    @Override
    public List<CbBadContractImpDTO> dataImp(File file) {
        List<CbBadContractImpDTO> contList = ExcelUtils.convertExcel(file, CbBadContractImpDTO.class);
        return contList;
    }

    @Override
    public List<CbBadContractDO> dataConvert(List<CbBadContractImpDTO> list) {
        Map<String, String> soruceSystemMap = EntityCacheUtils.cacheEntityField("SourceSystemDTO", "systemCode",
                "pkSourceSystem", SourceSystemDTO.class);
        Map<String, String> currtypeMap = EntityCacheUtils.cacheEntityField("CurrtypeVO", "currtypecode",
                "pkCurrtype", CurrtypeVO.class);
        List<CbBadContractDO> cList = new ArrayList<>();
        for(CbBadContractImpDTO dto : list){
            CbBadContractDO cbBadContractDO = DozerUtils.convert(dto, CbBadContractDO.class);
            cbBadContractDO.setPkSys(soruceSystemMap.get(dto.getPkSys()));//来源系统
            cbBadContractDO.setPkCurrency(currtypeMap.get(dto.getPkCurrency()));//币种
            cList.add(cbBadContractDO);
        }
        return cList;
    }

    @Override
    public void save(List<CbBadContractDO> list) {
        cbBadContractRepo.saveAll(list);
    }

    @Override
    public PageQueryData<CbBadContractVO> pageQuery(Pagination pagination, BaseQuery baseQuery, String queryName) {
        return cbBadContractRepo.pageQuery(pagination, baseQuery, queryName);
    }

    @Override
    public FileOssLogDTO dataImp(OSSObject param) {
        FileOssLogDTO logDTO = new FileOssLogDTO(param.getKey());
        try {
            List<CbBadContractImpDTO> contList = ExcelUtils.convertExcel(param.getObjectContent(), param.getKey(), CbBadContractImpDTO.class);
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
