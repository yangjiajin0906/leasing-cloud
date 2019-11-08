package com.leasing.sys.entity.dto;

import com.leasing.common.base.entity.BaseDO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @project:leasing-cloud
 * @date:2019/11/5
 * @author:Yjj@yonyou.com
 * @description: 缓存用户登录信息
 **/
@Entity
@Table(name = "yls_login_log")
public class ClientDO extends BaseDO implements Serializable {

    @Id
    public String id;
    /**
     * 登录人
     */
    public String loginUser;
    /**
     * 登录系统
     */
    public String systemCode;
    /**
     * 登录地址
     */
    public String urlAddress;
    /**
     * 登录人IP
     */
    public String ip;
    /**
     * 节点编码
     */
    public String funcCode;
    /**
     * 节点名称
     */
    public String funcName;
    /**
     * 登录时间
     */
    public String loginTime;

    /**
     * 上次登录时间
     */
    public String lastTime;

    /**
     * 上次密码错误时间
     */
    public String errorTime;

    /**
     * 错误次数
     */
    public String errorNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getUrlAddress() {
        return urlAddress;
    }

    public void setUrlAddress(String urlAddress) {
        this.urlAddress = urlAddress;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getFuncCode() {
        return funcCode;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public String getErrorTime() {
        return errorTime;
    }

    public void setErrorTime(String errorTime) {
        this.errorTime = errorTime;
    }

    public String getErrorNumber() {
        return errorNumber;
    }

    public void setErrorNumber(String errorNumber) {
        this.errorNumber = errorNumber;
    }

    @Override
    public String getPk() {
        return id;
    }

    @Override
    public void setPk(String pk) {
        this.id = pk;
    }
}