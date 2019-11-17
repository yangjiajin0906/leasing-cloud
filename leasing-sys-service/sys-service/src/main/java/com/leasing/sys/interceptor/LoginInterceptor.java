package com.leasing.sys.interceptor;

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
        //此处为不需要登录的接口放行
        if (arg0.getRequestURI().contains("/login") || arg0.getRequestURI().contains("/register")
                || arg0.getRequestURI().contains("/error") || arg0.getRequestURI().contains("/static")) {
            return true;
        }
        //权限路径拦截
        //PrintWriter resultWriter = arg1.getOutputStream();
        // TODO: 有时候用PrintWriter 回报 getWriter() has already been called for this response
        //换成ServletOutputStream就OK了
        arg1.setContentType("text/html;charset=utf-8");
        ServletOutputStream resultWriter = arg1.getOutputStream();
        final String headerToken=arg0.getHeader("token");
        //判断请求信息
        if(null==headerToken||headerToken.trim().equals("")){
            resultWriter.write("你没有token,需要登录".getBytes());
            resultWriter.flush();
            resultWriter.close();
            return false;
        }
        //解析Token信息
        try {
            //根据前台传过来的Token查找数据库Token
            DiySession session = diySessionRepo.getSession(headerToken);

            //数据库没有Token记录
            if(null == session) {
                resultWriter.write("我没有你的token？,需要登录".getBytes());
                resultWriter.flush();
                resultWriter.close();
                return false;
            }
            //数据库Token与客户Token比较
            if( !headerToken.equals(session.getToken()) ){
                resultWriter.print("你的token修改过？,需要登录");
                resultWriter.flush();
                resultWriter.close();
                return false;
            }
            //判断Token过期
            Long tokenDate= session.getCreationTime();//session创建时间
            int overTime=(int)(new Date().getTime()-tokenDate)/1000;
            int maxInactiveInterval=session.getMaxInactiveInterval(); //过期时间
            if(overTime > maxInactiveInterval){
                resultWriter.write("你的token过期了？,需要登录".getBytes());
                resultWriter.flush();
                resultWriter.close();
                return false;
            }

        } catch (Exception e) {
            resultWriter.write("反正token不对,需要登录".getBytes());
            resultWriter.flush();
            resultWriter.close();
            return false;
        }
        //最后才放行
        return true;
    }
}