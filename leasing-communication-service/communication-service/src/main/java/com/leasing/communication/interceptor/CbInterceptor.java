package com.leasing.communication.interceptor;

import com.leasing.common.entity.common.vo.DiySession;
import com.leasing.common.repository.sys.DiySessionRepo;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @project:leasing-cloud
 * @date:2019/12/10
 * @author:wangjc@yonyou.com
 * @description: C端服务单独设置拦截器  此处便捷处理   后期统一会删除
 **/
public class CbInterceptor implements HandlerInterceptor {
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
        //设置放行接口  业务服务此处无任何放行接口
//        if (arg0.getRequestURI().contains("/login") || arg0.getRequestURI().contains("/listSystem")
//                || arg0.getRequestURI().contains("/error") || arg0.getRequestURI().contains("/static")) {
//            return true;
//        }
        //临时测试加的!!!!!!
        if(arg0.getRequestURI().contains("/test")){
            return true;
        }
        arg1.setContentType("text/html;charset=utf-8");
        ServletOutputStream resultWriter = arg1.getOutputStream();
        //判断session中是否存在当前登录用户  无则重定向回登录页
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
//        Object object = arg0.getSession().getAttribute("user");
//        if (null == object) {
//            resultWriter.write("306".getBytes());
//            resultWriter.flush();
//            resultWriter.close();
//            return false;
//        }
        return true;
    }
}