package com.leasing.communication.service;

import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.communication.entity.dos.CbBadContractDO;
import com.leasing.communication.entity.dos.CbEarlySettlementDO;
import com.leasing.communication.entity.dto.CbBadContractImpDTO;
import com.leasing.communication.entity.dto.CbEarlySettlementImpDTO;
import com.leasing.communication.entity.vo.CbBadContractVO;
import com.leasing.communication.entity.vo.CbEarlySettlementVO;

import java.io.File;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-12-3
 * @author:lvcna@yonyou.com
 * @description: 2C业务提前结清接口处理
 **/
public interface CbEarlySettlementService {

    /**
     * 下载文件
     * @param file 数据
     * @return
     */
    List<CbEarlySettlementImpDTO> dataImp(File file);

    /**
     * DTO转DO 数据转换
     * @param list 数据
     * @return
     */
    List<CbEarlySettlementDO> dataConvert(List<CbEarlySettlementImpDTO> list);

    /**
     * 保存数据
     * @param list 数据
     * @return
     */
    void save(List<CbEarlySettlementDO> list);

    /**
     * 客户列表分页信息查询
     * @param pagination 分页条件
     * @param baseQuery 查询条件
     * @param queryName JPQL名称
     * @return
     */
    PageQueryData<CbEarlySettlementVO> pageQuery(Pagination pagination, BaseQuery baseQuery, String queryName);

}
