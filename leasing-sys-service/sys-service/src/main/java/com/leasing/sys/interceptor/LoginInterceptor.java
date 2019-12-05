package com.leasing.sys.interceptor;

import com.leasing.common.exception.BaseException;
import com.leasing.sys.repository.DiySessionRepo;
import com.leasing.sys.util.DiySession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @project:leasing-cloud
 * @date:2019/11/6
 * @author:Yjj@yonyou.com
 * @description: session拦截器
 **/
public class LoginInterceptor implements HandlerInterceptor {

    @Resource
    DiySessionRepo diySessionRepo;

    //提供查询
    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {}
    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {}
    @Override
    public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
        //登录的接口放行
        if (arg0.getRequestURI().contains("/login") || arg0.getRequestURI().contains("/listSystem")
                || arg0.getRequestURI().contains("/error") || arg0.getRequestURI().contains("/static")) {
            return true;
        }
        arg1.setContentType("text/html;charset=utf-8");
        ServletOutputStream resultWriter = arg1.getOutputStream();
        //判断session中是否存在当前登录用户  无则重定向回登录页
        Object object = arg0.getSession().getAttribute("user");
        if (null == object) {
            resultWriter.write("306".getBytes());
            resultWriter.flush();
            resultWriter.close();
            return false;
        }
        return true;
    }
}