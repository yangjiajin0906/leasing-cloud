package com.leasing.communication.entity.param;

import com.aliyun.oss.model.OSSObject;
import com.leasing.communication.entity.dto.FileOssLogDTO;
import com.leasing.communication.entity.dto.SourceSystemDTO;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-12-8
 * @author:lvcna@yonyou.com
 * @description: 导入文件参数实体类
 **/
public class FileImpParam {

    /**
     * 业务类型
     */
    private String businessType;

    /**
     * 业务接口Bean名称
     */
    private String beanName;

    /**
     * 业务类型枚举
     */
    private Integer impType;


    /**
     * 方法名字
     */
    private String methodName;

    /**
     * 导入顺序
     */
    private Integer order;

    /**
     * 文件集合
     */
    private List<OSSObject> fileList;

    /**
     * 日志业务对象
     */
    private FileOssLogDTO logDTO;

    /**
     * 导入文件来源系统
     */
    private SourceSystemDTO systemVO;

    public static FileImpParam initInstance(){
        return new FileImpParam();
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public Integer getImpType() {
        return impType;
    }

    public void setImpType(Integer impType) {
        this.impType = impType;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public List<OSSObject> getFileList() {
        return fileList;
    }

    public void setFileList(List<OSSObject> fileList) {
        this.fileList = fileList;
    }

    public FileOssLogDTO getLogDTO() {
        return logDTO;
    }

    public void setLogDTO(FileOssLogDTO logDTO) {
        this.logDTO = logDTO;
    }

    public SourceSystemDTO getSystemVO() {
        return systemVO;
    }

    public void setSystemVO(SourceSystemDTO systemVO) {
        this.systemVO = systemVO;
    }
}
