package com.leasing.communication.service;

import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.communication.entity.dos.AccruedDO;
import com.leasing.communication.entity.dos.CbBadContractDO;
import com.leasing.communication.entity.dos.CbContractDO;
import com.leasing.communication.entity.dto.CbBadContractImpDTO;
import com.leasing.communication.entity.dto.CbContractImpDTO;
import com.leasing.communication.entity.query.AccruedQuery;
import com.leasing.communication.entity.vo.CbBadContractVO;
import com.leasing.communication.entity.vo.CbContractVO;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-12-3
 * @author:lvcna@yonyou.com
 * @description: 2C业务不良合同接口处理
 **/
public interface CbBadContractService {

    /**
     * 下载文件
     * @param file 数据
     * @return
     */
    List<CbBadContractImpDTO> dataImp(File file);

    /**
     * DTO转DO 数据转换
     * @param list 数据
     * @return
     */
    List<CbBadContractDO> dataConvert(List<CbBadContractImpDTO> list);

    /**
     * 保存数据
     * @param list 数据
     * @return
     */
    void save(List<CbBadContractDO> list);

    /**
     * 客户列表分页信息查询
     * @param pagination 分页条件
     * @param baseQuery 查询条件
     * @param queryName JPQL名称
     * @return
     */
    PageQueryData<CbBadContractVO> pageQuery(Pagination pagination, BaseQuery baseQuery, String queryName);

}
