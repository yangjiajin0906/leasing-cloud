package com.leasing.sys.util;

import com.alibaba.fastjson.annotation.JSONField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.session.ExpiringSession;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @project:leasing-cloud
 * @date:2019/11/6
 * @author:Yjj@yonyou.com
 * @description: 自定义session
 **/
public final class DiySession implements ExpiringSession, Serializable {

    private final Logger logger = LoggerFactory.getLogger(DiySession.class);

    /**
     * id
     */
    private String id;

    /* token */
    private String token;

    /**
     * 创建时间
     */
    private long creationTime;

    /**
     * 属性
     */
    private Map<String, Object> attributes;

    /**
     * 上一次操作时间
     */
    private long lastAccessedTime;

    /**
     * 过期时间
     */
    private int maxInactiveInterval;

    /**
     * ip
     */
    private String ip;

    public DiySession() {
        // 这里可以改成自己sessionId的生成规则
        this("DIY-" + System.currentTimeMillis() + "-"
                + UUID.randomUUID().toString().substring(0, 8));
    }

    public DiySession(String id) {
        this.id = id;
        this.token = id;
        this.attributes = new HashMap<>();
        this.creationTime = System.currentTimeMillis();
        this.lastAccessedTime = this.creationTime;
        this.maxInactiveInterval = 60*60*24*1000;
    }

    public DiySession(ExpiringSession session) {
        if (session == null) {
            throw new IllegalArgumentException("session cannot be null");
        }
        this.id = session.getId();
        this.attributes = new HashMap<>();

        session.getAttributeNames().forEach(k -> {
            this.attributes.put(k, session.getAttribute(k));
        });

        this.lastAccessedTime = session.getLastAccessedTime();
        this.creationTime = session.getCreationTime();
        this.maxInactiveInterval = session.getMaxInactiveIntervalInSeconds();
    }

    @Override
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public long getCreationTime() {
        return this.creationTime;
    }

    public void setCreationTime(long creationTime) {
        this.creationTime = creationTime;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public int getMaxInactiveInterval() {
        return maxInactiveInterval;
    }

    public void setMaxInactiveInterval(int maxInactiveInterval) {
        this.maxInactiveInterval = maxInactiveInterval;
    }

    @Override
    public void setLastAccessedTime(long lastAccessedTime) {
        this.lastAccessedTime = lastAccessedTime;
    }

    @Override
    public long getLastAccessedTime() {
        return this.lastAccessedTime;
    }

    @JSONField(serialize = false, deserialize = false)
    @Override
    public void setMaxInactiveIntervalInSeconds(int interval) {
        this.maxInactiveInterval = interval;
    }

    @JSONField(serialize = false, deserialize = false)
    @Override
    public int getMaxInactiveIntervalInSeconds() {
        return this.maxInactiveInterval;
    }

    @JSONField(serialize = false, deserialize = false)
    @Override
    public boolean isExpired() {
        return isExpired(System.currentTimeMillis());
    }

    @JSONField(serialize = false, deserialize = false)
    @Override
    public <T> T getAttribute(String attributeName) {
        return (T) this.attributes.get(attributeName);
    }

    @JSONField(serialize = false, deserialize = false)
    @Override
    public Set<String> getAttributeNames() {
        return this.attributes.keySet();
    }

    @Override
    public void setAttribute(String attributeName, Object attributeValue) {
        if (attributeValue == null) {
            removeAttribute(attributeName);
        } else {
            this.attributes.put(attributeName, attributeValue);
        }
    }

    @Override
    public void removeAttribute(String attributeName) {
        this.attributes.remove(attributeName);
    }

    private boolean isExpired(long now) {
        if (this.maxInactiveInterval < 0) {
            return false;
        }
        return now - TimeUnit.SECONDS.toMillis(this.maxInactiveInterval) >= this.lastAccessedTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}