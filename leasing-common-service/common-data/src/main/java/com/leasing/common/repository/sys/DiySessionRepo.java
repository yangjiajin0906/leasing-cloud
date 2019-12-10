package com.leasing.common.repository.sys;

import com.alibaba.fastjson.JSON;
import com.leasing.common.entity.common.vo.DiySession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.session.SessionProperties;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.session.SessionRepository;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * @project:leasing-cloud
 * @date:2019/11/6
 * @author:Yjj@yonyou.com
 * @description:
 **/
@Repository
public class DiySessionRepo implements SessionRepository<DiySession> {

    private final Logger logger = LoggerFactory.getLogger(DiySessionRepo.class);

    private SessionProperties sessionProperties;

    private RedisTemplate<String, String> redisTemplate;

    public DiySessionRepo(RedisTemplate<String, String> redisTemplate,
                                SessionProperties sessionProperties) {
        this.redisTemplate = redisTemplate;
        this.sessionProperties = sessionProperties;
    }

    @Override
    public DiySession createSession() {
        DiySession tokenSession = new DiySession();
        tokenSession.setMaxInactiveIntervalInSeconds((int)sessionProperties.getTimeout().getSeconds());
        if (logger.isDebugEnabled()) {
            logger.debug("create session: value = " + JSON.toJSONString(tokenSession));
        }
        return tokenSession;
    }

    public DiySession createSession(String token) {
        DiySession tokenSession = new DiySession(token);
        tokenSession.setMaxInactiveIntervalInSeconds((int)sessionProperties.getTimeout().getSeconds());
        if (logger.isDebugEnabled()) {
            logger.debug("create session: value = " + JSON.toJSONString(tokenSession));
        }
        return tokenSession;
    }

    @Override
    public void save(DiySession session) {
        if (session == null) {
            return;
        }
        String json = JSON.toJSONString(session);
        if (logger.isDebugEnabled()) {
            logger.debug("save session: value = " + json);
        }

        redisTemplate.boundValueOps(session.getId())
                .set(json, (int)sessionProperties.getTimeout().getSeconds(), TimeUnit.SECONDS);
    }

    @Override
    public DiySession getSession(String id) {
        BoundValueOperations boundValueOps = redisTemplate.boundValueOps(id);
        Object s = boundValueOps.get();
        if (s == null) {
            return null;
        }

        if (logger.isDebugEnabled()) {
            logger.debug("find session: value = " + s.toString());
        }

        try {
            DiySession session = JSON.parseObject(s.toString(), DiySession.class);
            if (session == null) {
                return null;
            }

            if (session.isExpired()) {
                return null;
            }

            session.setLastAccessedTime(System.currentTimeMillis());
            return session;
        } catch (Exception e) {
            logger.error("获取session异常", e);
        }
        return null;
    }

    @Override
    public void delete(String id) {
        DiySession session = getSession(id);
        if (session == null) {
            return;
        }
        if (logger.isDebugEnabled()) {
            logger.debug("delete session : id = " + id);
        }
        redisTemplate.delete(id);
    }

}