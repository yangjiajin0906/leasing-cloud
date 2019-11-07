package com.leasing.sys.controller;

import com.leasing.common.vo.foundation.UserVO;
import com.leasing.sys.service.LoginService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
     * @return com.leasing.common.vo.foundation.UserVO
     */
    @RequestMapping(value = "/login")
    public UserVO login(String data){
        UserVO userVO = loginClientService.login(data);
        return userVO;
    }

    /**
     * @description 注销
     * @author Yangjiajin
     * @date 2019/11/6 10:36
     * @param []
     * @return void
     */
    @RequestMapping(value = "/logout")
    public void logout(@RequestBody String data){
        loginClientService.logout(data);
    }

}