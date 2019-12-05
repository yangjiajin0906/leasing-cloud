package com.leasing.communication.service.impl;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.utils.base.BaseBusinessUtils;
import com.leasing.communication.entity.dos.WithdrawDO;
import com.leasing.communication.entity.dos.WithdrawDetailDO;
import com.leasing.communication.entity.query.WithdrawQueryVO;
import com.leasing.communication.entity.vo.WithdrawDetailVO;
import com.leasing.communication.entity.vo.WithdrawVO;
import com.leasing.communication.repository.WithdrawDetailRepo;
import com.leasing.communication.repository.WithdrawRepo;
import com.leasing.communication.service.WithdrawService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Transactional
@Service("communication.WithdrawServiceImpl")
public class WithdrawServiceImpl implements WithdrawService {
    @Resource
    private WithdrawRepo withdrawRepo;

    @Resource
    private WithdrawDetailRepo detailRepo;


    @Override
    public void gatherWithdraw(String batchNo) {
        List<WithdrawDetailDO> list = queryDetailByBatchNo(batchNo);

        WithdrawDO mainDO = new WithdrawDO();
        if (list != null && list.size() > 0) {
            WithdrawDetailDO firstDetailVO = list.get(0);
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
            for (WithdrawDetailDO detaildO : list){
                //实际投放金额汇总
                mainDO.setActualLoanAmount(mainDO.getActualLoanAmount().add(detaildO.getActualLoanAmount()));
                //合同金额汇总
                mainDO.setContAmount(mainDO.getContAmount().add(detaildO.getContAmount()));
                detaildO.setPkWithdraw(mainPk);
            }
            save(mainDO);
            detailRepo.saveAll(list);

        }
    }

    @Override
    public PageQueryData<WithdrawVO> pageQuery(Pagination pagination, WithdrawQueryVO queryVO) {
        return  withdrawRepo.pageQuery(pagination, queryVO, "WithdrawPageQuery");
    }

    @Override
    public List<WithdrawDetailDO> queryDetailByBatchNo(String batchNo) {
        return detailRepo.queryAllByPaymentBatchNo(batchNo);
    }

    @Override
    public WithdrawDO save(WithdrawDO vo) {
        return withdrawRepo.saveEntity(vo);
    }

    @Override
    public void save(List<WithdrawDO> list) {
        withdrawRepo.saveAll(list);
    }

    @Override
    public void delete(WithdrawDO vo) {
        withdrawRepo.delete(vo);
    }

    @Override
    public WithdrawDO update(WithdrawDO vo) {
        return withdrawRepo.updateEntity(vo);
    }

    @Override
    public WithdrawDO findOne(String pk) {
        return withdrawRepo.findOne(pk);
    }
}