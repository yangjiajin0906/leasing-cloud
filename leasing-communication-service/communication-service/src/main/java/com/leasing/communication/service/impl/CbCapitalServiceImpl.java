package com.leasing.communication.service.impl;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.utils.base.BaseBusinessUtils;
import com.leasing.common.utils.tools.DozerUtils;
import com.leasing.communication.entity.dos.CbCapitalDO;
import com.leasing.communication.entity.dos.CbCapitalDetailDO;
import com.leasing.communication.entity.query.CbCapitalQuery;
import com.leasing.communication.entity.vo.CbCapitalVO;
import com.leasing.communication.repository.CbCapitalDetailRepo;
import com.leasing.communication.repository.CbCapitalRepo;
import com.leasing.communication.service.CbCapitalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

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
    public void totalCapital(String capitalBatchNo) {
        List<CbCapitalDetailDO> list = detailRepo.queryAllByCapitalBatchNo(capitalBatchNo);

        if (list.size() > 0) {
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
}