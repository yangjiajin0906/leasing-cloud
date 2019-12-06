package com.leasing.communication.service.impl;

import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.utils.tools.DozerUtils;
import com.leasing.common.utils.tools.ExcelUtils;
import com.leasing.communication.entity.dos.CbInvoiceApplyDetailDO;
import com.leasing.communication.entity.dto.CbInvoiceApplyDetailImpDTO;
import com.leasing.communication.entity.vo.SourceSystemVO;
import com.leasing.communication.repository.CbInvoiceApplyRepo;
import com.leasing.communication.service.CbInvoiceApplyService;
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
 * @date:2019/11/18
 * @author:jiaoshy@yonyou.com
 * @description:
 **/
@Transactional
@Service("communication.InvoiceApplyServiceImpl")
public class CbInvoiceApplyServiceImpl implements CbInvoiceApplyService {

    @Resource
    CbInvoiceApplyRepo invoiceApplyRepo;


    @Override
    public CbInvoiceApplyDetailDO save(CbInvoiceApplyDetailDO vo) {
        return null;
    }

    @Override
    public void save(List<CbInvoiceApplyDetailDO> list) {

    }

    @Override
    public void delete(CbInvoiceApplyDetailDO vo) {

    }

    @Override
    public CbInvoiceApplyDetailDO update(CbInvoiceApplyDetailDO vo) {
        return null;
    }

    @Override
    public CbInvoiceApplyDetailDO findOne(String pk) {
        return null;
    }

    @Override
    public PageQueryData pageQuery(Pagination pagination, BaseQuery baseQuery, String queryName) {
        return invoiceApplyRepo.pageQuery(pagination, baseQuery, queryName);
    }

    @Override
    public List<CbInvoiceApplyDetailImpDTO> dataImp(File file) {
        List<CbInvoiceApplyDetailImpDTO> contList = ExcelUtils.convertExcel(file, CbInvoiceApplyDetailImpDTO.class);
        return contList;
    }

    @Override
    public List<CbInvoiceApplyDetailDO> dataConvert(List<CbInvoiceApplyDetailImpDTO> list) {
        Map<String, String> soruceSystemMap = EntityCacheUtils.cacheEntityField("SourceSystemVO", "systemCode",
                "pkSourceSystem", SourceSystemVO.class);
        List<CbInvoiceApplyDetailDO> cList = new ArrayList<>();
        for(CbInvoiceApplyDetailImpDTO dto : list){
            CbInvoiceApplyDetailDO cbEarlySettlementDO = DozerUtils.convert(dto, CbInvoiceApplyDetailDO.class);
            cbEarlySettlementDO.setPkInvoiceApplyDetail(UUID.randomUUID().toString().replace("-","").substring(0,20));
            cbEarlySettlementDO.setPkSys(soruceSystemMap.get(dto.getPkSys()));
            cList.add(cbEarlySettlementDO);
        }
        return cList;
    }
}
