package com.leasing.communication.service;

import com.leasing.communication.entity.dos.CbContractDO;
import com.leasing.communication.entity.dto.CbContractImpDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-12-3
 * @author:lvcna@yonyou.com
 * @description: 2C业务合同接口处理
 **/
public interface CbContractService {

    List<CbContractImpDTO> dataImp(MultipartFile file);


    List<CbContractDO> dataConvert(List<CbContractImpDTO> list);


    void save(List<CbContractDO> list);

}
