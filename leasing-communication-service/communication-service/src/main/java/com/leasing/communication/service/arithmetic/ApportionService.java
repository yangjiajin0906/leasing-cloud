package com.leasing.communication.service.arithmetic;

import com.leasing.common.entity.calculate.vo.base.InoutPlanVO;
import com.leasing.common.entity.calculate.vo.base.LeasePlanVO;
import com.leasing.common.entity.calculate.vo.cal.CalBusinessParam;
import com.leasing.communication.entity.vo.AccrualVO;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/12/10
 * @author:wangjc@yonyou.com
 * @description: 算法计算接口
 **/
public interface ApportionService {
    /**
     * 计算会计分摊表接口
     */
    public List<InoutPlanVO> createAccount(List<LeasePlanVO> lease_fin);

    /**
     * 计算会计计提表接口
     */
    public List<AccrualVO> createAccrual(List<InoutPlanVO> inout_plan_market);
}
