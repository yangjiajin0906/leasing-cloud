package com.leasing.communication.service.impl;

import com.aliyun.oss.model.OSSObject;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.entity.foundation.vo.CurrtypeVO;
import com.leasing.common.utils.base.BaseBusinessUtils;
import com.leasing.common.utils.tools.DozerUtils;
import com.leasing.common.utils.tools.ExcelUtils;
import com.leasing.communication.entity.dos.CbCapitalDO;
import com.leasing.communication.entity.dos.CbCapitalDetailDO;
import com.leasing.communication.entity.dos.CbCapitalDetailImpDTO;
import com.leasing.communication.entity.dto.FileOssLogDTO;
import com.leasing.communication.entity.dto.SourceSystemDTO;
import com.leasing.communication.entity.query.CbCapitalQuery;
import com.leasing.communication.entity.vo.CbCapitalVO;
import com.leasing.communication.repository.CbCapitalDetailRepo;
import com.leasing.communication.repository.CbCapitalRepo;
import com.leasing.communication.service.CbCapitalService;
import com.leasing.communication.utils.EntityCacheUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Transactional
@Service("communication.CbCapitalService")
public class CbCapitalServiceImpl implements CbCapitalService {
    @Resource
    private CbCapitalRepo capitalRepo;
    @Resource
    private CbCapitalDetailRepo detailRepo;


    @Override
    public PageQueryData<CbCapitalVO> pageQuery(Pagination pagination, CbCapitalQuery query) {
        return capitalRepo.pageQuery(pagination, query, "capitalPageQuery");
    }

    @Override
    public void totalCapital(List<CbCapitalDetailDO> list) {
        if (list != null && list.size() > 0) {
            CbCapitalDO capitalDO;
            CbCapitalDetailDO detailDO = list.get(0);

            String mainPk = BaseBusinessUtils.getOID();
            capitalDO = DozerUtils.convert(detailDO, CbCapitalDO.class);

            capitalDO.setPkCapital(mainPk);
            capitalDO.setReceivableAmount(BigDecimal.ZERO);
            capitalDO.setIntoAccountAmount(BigDecimal.ZERO);
            for (CbCapitalDetailDO detail : list) {
                detail.setPkCapital(mainPk);
                capitalDO.setReceivableAmount(capitalDO.getReceivableAmount().add(detailDO.getReceivableAmount()));
                capitalDO.setIntoAccountAmount(capitalDO.getIntoAccountAmount().add(detail.getIntoAccountAmount()));
            }
            capitalRepo.save(capitalDO);
            detailRepo.saveAll(list);
        }
    }

    @Override
    public CbCapitalDO save(CbCapitalDO vo) {
        return capitalRepo.saveEntity(vo);
    }

    @Override
    public void save(List<CbCapitalDO> list) {
        capitalRepo.saveAll(list);
    }

    @Override
    public void delete(CbCapitalDO vo) {
        capitalRepo.delete(vo);
    }

    @Override
    public CbCapitalDO update(CbCapitalDO vo) {
        return capitalRepo.updateEntity(vo);
    }

    @Override
    public CbCapitalDO findOne(String pk) {
        return capitalRepo.findOne(pk);
    }

    @Override
    public List<CbCapitalDetailDO> dataConvert(List<CbCapitalDetailImpDTO> list) {
        //系统来源
        Map<String, String> sourceSys = EntityCacheUtils.cacheEntityField("SourceSystemVO", "sourceSys",
                "pkSourceSystem", SourceSystemDTO.class);

        // 币种
        Map<String, String> currency = EntityCacheUtils.cacheEntityField("CurrtypeVO", "pkCurrtype",
                "pkCurrency", CurrtypeVO.class);

        List<CbCapitalDetailDO> capitalDetailDOS = new ArrayList<>();
        for (CbCapitalDetailImpDTO dto : list) {
            CbCapitalDetailDO drawDO = DozerUtils.convert(dto, CbCapitalDetailDO.class);
            drawDO.setPkCapital(BaseBusinessUtils.getOID());
            drawDO.setPkSys(sourceSys.get("pkSourceSystem"));
            drawDO.setPkCurrency(currency.get("pkCurrency"));
            capitalDetailDOS.add(drawDO);
        }
        return capitalDetailDOS;
    }

    @Override
    public FileOssLogDTO dataImp(OSSObject param) {
        FileOssLogDTO logDTO = new FileOssLogDTO(param.getKey());
        try {
            List<CbCapitalDetailImpDTO> contList = ExcelUtils.convertExcel(param.getObjectContent(), param.getKey(),
                    CbCapitalDetailImpDTO.class);
            totalCapital(dataConvert(contList));
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