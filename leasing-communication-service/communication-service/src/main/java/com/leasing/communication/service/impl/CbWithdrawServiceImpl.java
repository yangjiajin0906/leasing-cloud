package com.leasing.communication.service.impl;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.utils.base.BaseBusinessUtils;
import com.leasing.communication.entity.dos.CbWithdrawDO;
import com.leasing.communication.entity.dos.CbWithdrawDetailDO;
import com.leasing.communication.entity.dto.CbWithdrawDetailDTO;
import com.leasing.communication.entity.query.CbWithdrawQuery;
import com.leasing.communication.entity.vo.CbWithdrawVO;
import com.leasing.communication.repository.CbWithdrawDetailRepo;
import com.leasing.communication.repository.CbWithdrawRepo;
import com.leasing.communication.service.CbWithdrawDetailService;
import com.leasing.communication.service.CbWithdrawService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
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
    public void gatherWithdraw(String fileName) {
        fileName = "20191129-pay-1.xls";
        List<CbWithdrawDetailDTO> importExcelList = detailService.getImportList(fileName);
        List<CbWithdrawDetailDO> list = detailService.refConvert(importExcelList);

        CbWithdrawDO mainDO = new CbWithdrawDO();
        if (list != null && list.size() > 0) {
            CbWithdrawDetailDO firstDetailVO = list.get(0);
//            WithdrawDO ado = DozerUtils.convert(firstDetailVO, WithdrawDO.class);
            String mainPk = BaseBusinessUtils.getOID();
            mainDO.setPayeeName(firstDetailVO.getPayeeName());
            mainDO.setPaymentBatchNo(firstDetailVO.getPaymentBatchNo());
            mainDO.setRealPayDate(firstDetailVO.getRealPayDate());
            mainDO.setReceivingAccount(firstDetailVO.getReceivingAccount());
            mainDO.setOpeningBank(firstDetailVO.getOpeningBank());
            mainDO.setAccountNumber(firstDetailVO.getAccountNumber());
            mainDO.setLeaseType(firstDetailVO.getLeaseType());
            mainDO.setPaymentAccount(firstDetailVO.getPaymentAccount());
            mainDO.setRealPayDate(firstDetailVO.getRealPayDate());
            mainDO.setPkCurrency(firstDetailVO.getPkCurrency());
            mainDO.setCompanyMainBody(firstDetailVO.getCompanyMainBody());
            mainDO.setActualLoanAmount(BigDecimal.ZERO);
            mainDO.setContAmount(BigDecimal.ZERO);
            mainDO.setPkWithdraw(mainPk);
            mainDO.setPkSys(firstDetailVO.getPkSys());
            mainDO.setBillstatus(firstDetailVO.getBillstatus());
            mainDO.setPkOperator(firstDetailVO.getPkOperator());
            mainDO.setPkDept(firstDetailVO.getPkDept());
            mainDO.setPkOrg(firstDetailVO.getPkOrg());
            for (CbWithdrawDetailDO detaildO : list) {
                //实际投放金额汇总
                mainDO.setActualLoanAmount(mainDO.getActualLoanAmount().add(detaildO.getActualLoanAmount()));
                //合同金额汇总
                mainDO.setContAmount(mainDO.getContAmount().add(detaildO.getContAmount()));
                detaildO.setPkWithdraw(mainPk);
                detaildO.setPkWithdrawDetail(BaseBusinessUtils.getOID());
            }
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
}