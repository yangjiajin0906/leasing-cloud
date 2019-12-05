package com.leasing.sys.controller;

import com.leasing.common.entity.foundation.vo.UserVO;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.utils.base.ResultUtils;
import com.leasing.common.vo.foundation.UserVO;
import com.leasing.sys.service.LoginService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @project:leasing-cloud
 * @date:2019/11/5
 * @author:Yjj@yonyou.com
 * @description: 登录接口
 **/
@RestController
@RequestMapping(value = "/leasing/sys")
public class LoginController {

    @Resource
    LoginService loginClientService;

    /**
     * @description 登录
     * @author Yangjiajin
     * @date 2019/11/6 10:36
     * @param [data]
     * @return com.leasing.common.entity.foundation.vo.UserVO
     */
    @RequestMapping(value = "/login")
    public ResResult login(@RequestBody String data, HttpServletRequest request){
        UserVO userVO = loginClientService.login(data,request);
        return ResultUtils.successWithData(userVO);
    }

    /**
     * @description 注销
     * @author Yangjiajin
     * @date 2019/11/6 10:36
     * @param []
     * @return void
     */
    @RequestMapping(value = "/logout")
    public void logout(@RequestBody String data, HttpServletRequest request){
        loginClientService.logout(data,request);
    }

}