package com.leasing.common.util;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

import java.util.Collections;

@Configuration
public class RedisLock {
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";
    private static final String LOCK_SUCCESS = "OK";
    private static final Long RELEASE_SUCCESS = 1L;

    /**
     * @param expireTime 毫秒
     */
    public static boolean Lock(Jedis jedis, String lockName, String resourcePath, int expireTime) {
        String result = jedis.set(lockName, resourcePath, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
        if (LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }

    public static boolean unLock(Jedis jedis, String lockName, String resourcePath) {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockName), Collections.singletonList(resourcePath));
        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }
}