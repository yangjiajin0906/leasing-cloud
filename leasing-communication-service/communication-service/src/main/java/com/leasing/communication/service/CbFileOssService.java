package com.leasing.communication.service;

import com.aliyun.oss.model.OSSObject;
import com.leasing.communication.entity.dto.FileOssLogDTO;
import com.leasing.communication.entity.dto.SourceSystemDTO;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-12-5
 * @author:lvcna@yonyou.com
 * @description: C端业务系统文件管理接口
 **/
public interface CbFileOssService{

    /**
     * 根据传入路径获取该路径下所有文件
     * @param dir
     * @return
     */
    List<OSSObject> loadFileListByDir(String dir);

    /**
     * 根据文件Key获取文件
     * @param key
     * @return
     */
    OSSObject loadFileByKey(String key);

    /**
     * 下载当日附件
     * @return
     */
    List<OSSObject> loadFileListByDate(SourceSystemDTO sourceSystemDO);


    /**
     * 导入当日所有外部系统输入文件
     */
    List<FileOssLogDTO> fileImportByDate();



















}
