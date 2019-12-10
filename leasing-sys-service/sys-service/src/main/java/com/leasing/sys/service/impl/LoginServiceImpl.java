package com.leasing.sys.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.leasing.common.entity.foundation.vo.UserVO;
import com.leasing.common.utils.base.DataParseUtils;
import com.leasing.common.utils.base.TokenUtil;
import com.leasing.sys.dao.repository.LoginClientRepo;
import com.leasing.sys.entity.dto.ClientDO;
import com.leasing.sys.entity.vo.ClientVO;
import com.leasing.common.repository.sys.DiySessionRepo;
import com.leasing.sys.service.LoginService;
import com.leasing.common.entity.common.vo.DiySession;
import com.leasing.sys.util.Encode;
import org.apache.commons.lang.StringUtils;
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
        JSONObject json = JSONObject.parseObject(data);
        String username = "";
        String password = "";
        if(json!=null && json.get("username") != null && !StringUtils.isEmpty(json.get("username").toString())){
            username = json.get("username").toString();
        }
        if(json!=null && json.get("password") != null && !StringUtils.isEmpty(json.get("password").toString())) {
            password = json.get("password").toString();
        }
//        UserVO userVO = validateUser(username,"1003", new Encode().encode(password));
//        if(userVO != null){   //验证通过存在该用户 则存入session
//            HttpSession session = request.getSession();
//            session.setAttribute("user", userVO);
//        }
        UserVO userVO = validateUser(username,"1003",new Encode().encode(password));
        if(userVO != null){
            checkSession(userVO);
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
    private void checkSession(UserVO userVO){
        //根据数据库的用户信息查询Token
        String token = TokenUtil.getToken(userVO.getUserName());
        userVO.setTokenid(token);
        DiySession session = diySessionRepo.getSession(token);
        //为生成Token准备
        if (null == session) {
            //第一次登陆
            session = diySessionRepo.createSession(token);
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
    public void logout(String data) {
        //将登陆用户的session删除
        UserVO user = DataParseUtils.jsonToBean(data,"user",UserVO.class);
//        request.getSession().removeAttribute("user");
        diySessionRepo.delete(user.getTokenid());
    }
}