package com.leasing.common.utils.base;

import com.alibaba.fastjson.JSONObject;
import com.leasing.common.entity.common.vo.DiySession;
import com.leasing.common.entity.customer.dto.DeptDTO;
import com.leasing.common.entity.customer.dto.OrgDTO;
import com.leasing.common.entity.foundation.vo.UserVO;
import com.leasing.common.exception.BaseException;
import com.leasing.common.repository.sys.DiySessionRepo;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @project:leasing-cloud
 * @date:2019/12/9
 * @author:wangjc@yonyou.com
 * @description:
 **/
@Component
public class ClientUtils {
    @Resource
    DiySessionRepo diySessionRepo;

    public static ClientUtils clientUtils;

    @PostConstruct
    public void init(){
        clientUtils = this;
    }

    public static final String LOGIN_USER = "user";   //登录用户使用编码
    public static final String LOGIN_TOKEN = "token";   //登录的token编码

    public static HttpServletRequest getRequest(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        return request;
    }

    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    /**
     * 返回系统当前登录人
     */
    public static UserVO getCurUser(){
        String token = getRequest().getHeader(LOGIN_TOKEN);
        if(token != null && !token.trim().equals("")){
            DiySession session = clientUtils.diySessionRepo.getSession(token);
            if(session == null) {
                throw new BaseException("当前登录token已经失效,无法获取登录用户");
            }
            return JSONObject.parseObject(session.getAttribute("userVO").toString(),UserVO.class);
        }
        return null;
    }

    /**
     * 返回系统当前登录人的部门
     */
    public static DeptDTO getCurDept(){
        UserVO uservo = getCurUser();
        if(uservo != null){
            return uservo.getPkDeptdoc();
        }
        return null;
    }

    /**
     * 返回系统当前登录人的机构
     */
    public static OrgDTO getCurCorp(){
        UserVO uservo = getCurUser();
        if(uservo != null){
            return uservo.getPkOrg();
        }
        return null;
    }

}