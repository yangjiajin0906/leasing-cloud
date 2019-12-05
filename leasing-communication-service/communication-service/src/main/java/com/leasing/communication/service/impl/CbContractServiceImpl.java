package com.leasing.communication.service.impl;

import com.leasing.common.utils.tools.DozerUtils;
import com.leasing.common.utils.tools.ExcelUtils;
import com.leasing.communication.entity.dos.CbContractDO;
import com.leasing.communication.entity.dto.CbContractImpDTO;
import com.leasing.communication.entity.vo.CbContractVO;
import com.leasing.communication.repository.CbContractRepo;
import com.leasing.communication.service.CbContractService;
import com.leasing.communication.utils.EntityCacheUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @project:leasing-cloud
 * @date:2019-12-3
 * @author:lvcna@yonyou.com
 * @description: 2C合同接口实现类
 **/
@Transactional
@Service("communication.CbContractServiceImpl")
public class CbContractServiceImpl implements CbContractService {

    @Resource
    CbContractRepo cbContractRepo;

    @Override
    public List<CbContractImpDTO> dataImp(MultipartFile file) {
        List<CbContractImpDTO> contList = ExcelUtils.convertExcel(file, CbContractImpDTO.class);
        return contList;
    }

    @Override
    public List<CbContractDO> dataConvert(List<CbContractImpDTO> list) {
        Map<String, String> areaclMap = EntityCacheUtils.cacheEntityField("AreaclVO", "areaclname",
                "pkAreacl", CbContractDO.class);
        Map<String, String> soruceSystemMap = EntityCacheUtils.cacheEntityField("SourceSystemVO", "systemCode",
                "pkSourceSystem", CbContractDO.class);
        List<CbContractDO> contractDOS = new ArrayList<>();
        for(CbContractImpDTO dto : list){
            CbContractDO contractDO = DozerUtils.convert(dto, CbContractDO.class);
            contractDO.setPkContract(UUID.randomUUID().toString().replace("-","").substring(0,20));
            contractDO.setCustomerProvince(areaclMap.get(dto.getCustomerProvince()));
            contractDO.setCustomerCity(areaclMap.get(dto.getCustomerCity()));
            contractDO.setCustomerRegion(areaclMap.get(dto.getCustomerRegion()));
            contractDO.setPkSystem(soruceSystemMap.get(dto.getSourceSystem()));
            contractDOS.add(contractDO);
        }
        return contractDOS;
    }

    @Override
    public void save(List<CbContractDO> list) {
        cbContractRepo.saveAll(list);
    }

    @Override
    public List<CbContractVO> testQuery() {

        return cbContractRepo.queryForPage();
    }
}
