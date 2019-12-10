package com.leasing.communication.service;

import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.communication.entity.dos.CbEarlySettlementDO;
import com.leasing.communication.entity.dos.CbOverdueContractDO;
import com.leasing.communication.entity.dto.CbEarlySettlementImpDTO;
import com.leasing.communication.entity.dto.CbOverdueContractImpDTO;
import com.leasing.communication.entity.vo.CbEarlySettlementVO;
import com.leasing.communication.entity.vo.CbOverdueContractVO;

import java.io.File;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-12-3
 * @author:lvcna@yonyou.com
 * @description: 2C业务逾期合同接口处理
 **/
public interface CbOverdueContractService {

    /**
     * 下载文件
     * @param file 数据
     * @return
     */
    List<CbOverdueContractImpDTO> dataImp(File file);

    /**
     * DTO转DO 数据转换
     * @param list 数据
     * @return
     */
    List<CbOverdueContractDO> dataConvert(List<CbOverdueContractImpDTO> list);

    /**
     * 保存数据
     * @param list 数据
     * @return
     */
    void save(List<CbOverdueContractDO> list);

    /**
     * 客户列表分页信息查询
     * @param pagination 分页条件
     * @param baseQuery 查询条件
     * @param queryName JPQL名称
     * @return
     */
    PageQueryData<CbOverdueContractVO> pageQuery(Pagination pagination, BaseQuery baseQuery, String queryName);

}
