package com.leasing.sys.service.impl;

import com.leasing.common.vo.foundation.UserVO;
import com.leasing.sys.dao.repository.LoginClientRepo;
import com.leasing.sys.entity.dto.ClientDO;
import com.leasing.sys.entity.vo.ClientVO;
import com.leasing.sys.repository.DiySessionRepo;
import com.leasing.sys.service.LoginService;
import com.leasing.sys.util.DiySession;
import com.leasing.sys.util.Encode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * @project:leasing-cloud
 * @date:2019/11/5
 * @author:Yjj@yonyou.com
 * @description: 用户业务层
 **/
@Transactional
@Service("sys.LoginClientServiceImpl")
public class LoginServiceImpl implements LoginService {

    @Resource
    LoginClientRepo loginClientRepo;

    @Resource
    DiySessionRepo diySessionRepo;

    @Override
    public UserVO validateUser(String pkUserdeCode, String pkOrg,  String pwd) {
        return loginClientRepo.validateUser(pkUserdeCode, pkOrg , pwd);
    }

    @Override
    public ClientDO findOne(String pkUser) {
        return loginClientRepo.findOne(pkUser);
    }

    @Override
    public ClientVO findOne(String pkUser, Class<ClientVO> s) {
        return loginClientRepo.findOne(pkUser, s);
    }

    @Override
    public ClientDO save(ClientDO clientDO) {
        return loginClientRepo.save(clientDO);
    }

    @Override
    public ClientDO update(ClientDO clientDO) {
        return loginClientRepo.updateEntity(clientDO);
    }

    @Override
    public void delete(ClientDO clientDO) {
        loginClientRepo.delete(clientDO);
    }

    @Override
    public UserVO login(String data) {
        String token = "DIY-1573096948527-0d8a4d78";
        UserVO userVO = validateUser("heyuanyuan","1003",new Encode().encode("1"));
        if(userVO != null){
            checkSession(userVO, token);
        }
        return userVO;
    }

    /**
     * @description 持久化登录用户数据
     * @author Yangjiajin
     * @date 2019/11/6 10:36
     * @param
     * @return
     */
    private void checkSession(UserVO userVO, String token){
        //根据数据库的用户信息查询Token
        DiySession session = diySessionRepo.getSession(token);
        //为生成Token准备
        if (null == session) {
            //第一次登陆
            session = diySessionRepo.createSession();
            session.setAttribute("userVO",userVO);
            session.setIp("127.0.0.1");
        }else{
            //再次登陆就更新Token信息
            session.setLastAccessedTime(session.getCreationTime());
            session.setCreationTime(System.currentTimeMillis());
        }
        diySessionRepo.save(session);
    }

    /**
     * 用户已在别处登录， 当前用户被迫下线
     */
    private void forcedToLogoff(UserVO userVO){

    }

    @Override
    public void logout(String token) {
        diySessionRepo.delete(token);
    }
}