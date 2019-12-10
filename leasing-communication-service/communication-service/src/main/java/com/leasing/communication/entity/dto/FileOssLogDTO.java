package com.leasing.communication.entity.dto;

import com.leasing.common.base.entity.BaseDTO;
import com.leasing.common.base.repository.support.StringModalType;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * @project:leasing-cloud
 * @date:2019-12-9
 * @author:lvcna@yonyou.com
 * @description: OSS文件导入日志
 **/
@Entity
@Table(name = "yc_oss_log")
public class FileOssLogDTO extends BaseDTO{

    /**
     * 主键
     */
    @Id
    private String pkOssLog;

    /**
     * 成功标志
     */
    private Boolean flag;

    /**
     * 日志明细
     */
    private String logMsg;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 来源系统
     */
    private SourceSystemDTO sourceSystemDTO;

    /**
     * 加载日期
     */
    private String loadDate;

    /**
     * 业务类型
     */
    private String busiType;

    /**
     * 导入数据条数
     */
    private Long dataNum;

    /**
     * 时间戳
     */
    @Version
    private StringModalType ts;

    public FileOssLogDTO(String fileName){
        this.fileName = fileName;
        this.flag = true;
    }

    public FileOssLogDTO(){

    }

    public String getPkOssLog() {
        return pkOssLog;
    }

    public void setPkOssLog(String pkOssLog) {
        this.pkOssLog = pkOssLog;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public String getLogMsg() {
        return logMsg;
    }

    public void setLogMsg(String logMsg) {
        this.logMsg = logMsg;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public SourceSystemDTO getSourceSystemDTO() {
        return sourceSystemDTO;
    }

    public void setSourceSystemDTO(SourceSystemDTO sourceSystemDTO) {
        this.sourceSystemDTO = sourceSystemDTO;
    }

    public String getLoadDate() {
        return loadDate;
    }

    public void setLoadDate(String loadDate) {
        this.loadDate = loadDate;
    }

    public String getBusiType() {
        return busiType;
    }

    public void setBusiType(String busiType) {
        this.busiType = busiType;
    }

    public Long getDataNum() {
        return dataNum;
    }

    public void setDataNum(Long dataNum) {
        this.dataNum = dataNum;
    }

    public StringModalType getTs() {
        return ts;
    }

    public void setTs(StringModalType ts) {
        this.ts = ts;
    }
}
