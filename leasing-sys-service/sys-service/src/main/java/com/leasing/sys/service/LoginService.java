package com.leasing.sys.service;

import com.leasing.common.entity.foundation.vo.UserVO;
import com.leasing.sys.entity.dto.ClientDO;
import com.leasing.sys.entity.vo.ClientVO;

import javax.servlet.http.HttpServletRequest;

/**
 * @project:leasing-cloud
 * @date:2019/11/5
 * @author:Yjj@yonyou.com
 * @description: 用户业务层
 **/
public interface LoginService {
    /**
     * @description 验证登录
     * @author Yangjiajin
     * @date 2019/11/5 17:53
     * @param [userCode, pwd, pkOrg]
     * @return com.leasing.common.entity.foundation.vo.UserVO
     */
    UserVO validateUser(String pkUserdeCode, String pkOrg, String pwd);

    /**
     * @description 查询DO
     * @author Yangjiajin
     * @date 2019/11/6 10:44
     * @param [pkUser]
     * @return com.leasing.sys.entity.dto.ClientDO
     */
    ClientDO findOne(String pkUser);

    /**
     * @description 查询DO
     * @author Yangjiajin
     * @date 2019/11/6 10:44
     * @param [pkUser]
     * @return com.leasing.sys.entity.dto.ClientDO
     */
    ClientVO findOne(String pkUser, Class<ClientVO> s);

    /**
     * @description 保存
     * @author Yangjiajin
     * @date 2019/11/6 11:07
     * @param [clientDO]
     * @return com.leasing.sys.entity.dto.ClientDO
     */
    ClientDO save(ClientDO clientDO);

    /**
     * @description 更新
     * @author Yangjiajin
     * @date 2019/11/6 11:07
     * @param [clientDO]
     * @return com.leasing.sys.entity.dto.ClientDO
     */
    ClientDO update(ClientDO clientDO);

    /**
     * @description 删除
     * @author Yangjiajin
     * @date 2019/11/6 11:07
     * @param [clientDO]
     * @return void
     */
    void delete(ClientDO clientDO);

    /**
     * @description 登录方法
     * @author Yangjiajin
     * @date 2019/11/7 10:27
     * @param [data]
     * @return com.leasing.common.entity.foundation.vo.UserVO
     */
    UserVO login(String data);

    /**
     * @description 系统注销
     * @author Yangjiajin
     * @date 2019/11/7 10:27
     * @param [data]
     * @return void
     */
    void logout(String data);
}