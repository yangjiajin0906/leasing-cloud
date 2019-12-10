package com.leasing.communication.service.impl;

import com.aliyun.oss.model.OSSObject;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.utils.base.BaseBusinessUtils;
import com.leasing.common.utils.tools.DozerUtils;
import com.leasing.common.utils.tools.ExcelUtils;
import com.leasing.communication.entity.dos.CbWithdrawDO;
import com.leasing.communication.entity.dos.CbWithdrawDetailDO;
import com.leasing.communication.entity.dto.CbWithdrawDetailDTO;
import com.leasing.communication.entity.dto.FileOssLogDTO;
import com.leasing.communication.entity.query.CbWithdrawQuery;
import com.leasing.communication.entity.vo.CbWithdrawVO;
import com.leasing.communication.repository.CbWithdrawDetailRepo;
import com.leasing.communication.repository.CbWithdrawRepo;
import com.leasing.communication.service.CbWithdrawDetailService;
import com.leasing.communication.service.CbWithdrawService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Transactional
@Service("communication.CbWithdrawService")
public class CbWithdrawServiceImpl implements CbWithdrawService {
    @Resource
    private CbWithdrawRepo withdrawRepo;

    @Resource
    private CbWithdrawDetailRepo detailRepo;

    @Resource
    private CbWithdrawDetailService detailService;


    @Override
    public void gatherWithdraw(List<CbWithdrawDetailDO> list) {
        if (list != null && list.size() > 0) {
            CbWithdrawDetailDO firstDetailVO = list.get(0);
            String mainPk = BaseBusinessUtils.getOID();
            CbWithdrawDO mainDO = DozerUtils.convert(firstDetailVO, CbWithdrawDO.class);
            mainDO.setPkWithdraw(mainPk);

            BigDecimal totalActualLoanAmount = BigDecimal.ZERO;
            BigDecimal totalContAmount = BigDecimal.ZERO;
            for (CbWithdrawDetailDO detaildO : list) {
                //实际投放金额汇总
                totalActualLoanAmount  = totalActualLoanAmount.add(detaildO.getActualLoanAmount());
                //合同金额汇总
                totalContAmount = totalContAmount.add(detaildO.getContAmount());
                detaildO.setPkWithdraw(mainPk);
                detaildO.setPkWithdrawDetail(BaseBusinessUtils.getOID());
            }

            mainDO.setActualLoanAmount(totalActualLoanAmount);
            mainDO.setContAmount(totalContAmount);
            save(mainDO);
            detailRepo.saveAll(list);

        }
    }

    @Override
    public PageQueryData<CbWithdrawVO> pageQuery(Pagination pagination, CbWithdrawQuery queryVO) {
        return withdrawRepo.pageQuery(pagination, queryVO, "WithdrawPageQuery");
    }

    @Override
    public List<CbWithdrawDetailDO> queryDetailByBatchNo(String batchNo) {
        return detailRepo.queryAllByPaymentBatchNo(batchNo);
    }

    @Override
    public CbWithdrawDO save(CbWithdrawDO vo) {
        return withdrawRepo.saveEntity(vo);
    }

    @Override
    public List<CbWithdrawDetailDO> dataConvert(List<CbWithdrawDetailDTO> list) {
        return null;
    }

    @Override
    public void save(List<CbWithdrawDO> list) {
        withdrawRepo.saveAll(list);
    }

    @Override
    public void delete(CbWithdrawDO vo) {
        withdrawRepo.delete(vo);
    }

    @Override
    public CbWithdrawDO update(CbWithdrawDO vo) {
        return withdrawRepo.updateEntity(vo);
    }

    @Override
    public CbWithdrawDO findOne(String pk) {
        return withdrawRepo.findOne(pk);
    }

    @Override
    public FileOssLogDTO dataImp(OSSObject param) {
        FileOssLogDTO logDTO = new FileOssLogDTO(param.getKey());
        try {
            List<CbWithdrawDetailDTO> contList = ExcelUtils.convertExcel(param.getObjectContent(), param.getKey(),
                    CbWithdrawDetailDTO.class);
            gatherWithdraw(detailService.refConvert(contList));
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