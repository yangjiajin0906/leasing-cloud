package com.leasing.communication.service;

import com.aliyun.oss.model.OSSObject;
import com.leasing.communication.entity.dto.FileOssLogDTO;

/**
 * @project:leasing-cloud
 * @date:2019-12-8
 * @author:lvcna@yonyou.com
 * @description: 文件导入接口
 **/
public interface CbFileImpService {

    /**
     * 文件导入
     * @param param
     */
    FileOssLogDTO dataImp(OSSObject param);
}
