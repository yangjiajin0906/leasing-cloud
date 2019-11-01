package com.leasing.customer.dao.repository;

import com.leasing.common.base.repository.BaseRepository;
import com.leasing.customer.dao.dos.CustBankAccountDO;
import com.leasing.customer.dao.query.CustBankAccountQuery;
import com.leasing.customer.dao.vo.CustBankAccountVO;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019-10-31
 * @author:zhangzhhn@yonyou.com
 * @description: yls_cust_bank_account
 **/
@Repository("customer.CustBankAccountRepo")
public interface CustBankAccountRepo extends BaseRepository<CustBankAccountDO, CustBankAccountQuery, CustBankAccountVO, String>{

}