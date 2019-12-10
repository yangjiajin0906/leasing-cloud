package com.leasing.communication.system.schedule;

import com.leasing.communication.entity.dto.FileOssLogDTO;
import com.leasing.communication.service.CbFileOssService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;


/**
 * @project:leasing-cloud
 * @date:2019-12-8
 * @author:lvcna@yonyou.com
 * @description: C端业务平台OSS文件导入定时任务
 **/
@Component
public class FileOSSImpTask {

    @Resource
    CbFileOssService cbFileOssService;

    @Scheduled(cron = "0 15 1 ? * *")
    public void fileImpForOSS(){
        List<FileOssLogDTO> logDTOS = cbFileOssService.fileImportByDate();
    }

}
