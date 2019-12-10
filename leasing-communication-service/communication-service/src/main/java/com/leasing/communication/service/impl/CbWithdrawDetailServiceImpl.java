package com.leasing.communication.service.impl;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.entity.foundation.vo.CurrtypeVO;
import com.leasing.common.utils.base.BaseBusinessUtils;
import com.leasing.common.utils.tools.DozerUtils;
import com.leasing.communication.entity.dos.CbWithdrawDetailDO;
import com.leasing.communication.entity.dto.CbWithdrawDetailDTO;
import com.leasing.communication.entity.dto.SourceSystemDTO;
import com.leasing.communication.entity.query.CbWithdrawDetailQuery;
import com.leasing.communication.entity.vo.CbWithdrawDetailVO;
import com.leasing.communication.repository.CbWithdrawDetailRepo;
import com.leasing.communication.service.CbWithdrawDetailService;
import com.leasing.communication.utils.EntityCacheUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @project:leasing-cloud
 * @date:2019-12-02
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Service("communication.CbWithdrawDetailService")
public class CbWithdrawDetailServiceImpl implements CbWithdrawDetailService {

    @Resource
    private CbWithdrawDetailRepo repo;

    @Override
    public PageQueryData<CbWithdrawDetailVO> pageQuery(Pagination pagination, CbWithdrawDetailQuery queryVO) {
        return repo.pageQuery(pagination, queryVO, "WithdrawDetailPageQuery");
    }

    @Override
    public List<CbWithdrawDetailDO> refConvert(List<CbWithdrawDetailDTO> list) {
        //系统来源
        Map<String, String> sourceSys = EntityCacheUtils.cacheEntityField("SourceSystemVO", "sourceSys",
                "pkSourceSystem", SourceSystemDTO.class);

        // 币种
        Map<String, String> currency = EntityCacheUtils.cacheEntityField("CurrtypeVO", "pkCurrtype",
                "pkCurrency", CurrtypeVO.class);

        List<CbWithdrawDetailDO> cbWithdrawDOS = new ArrayList<>();
        for (CbWithdrawDetailDTO dto : list) {
            CbWithdrawDetailDO drawDO = DozerUtils.convert(dto, CbWithdrawDetailDO.class);
            drawDO.setPkWithdraw(BaseBusinessUtils.getOID());
            drawDO.setPkSys(sourceSys.get("pkSourceSystem"));
            drawDO.setPkCurrency(currency.get("pkCurrency"));
            cbWithdrawDOS.add(drawDO);
        }
        return cbWithdrawDOS;
    }
}