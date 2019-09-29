package  com.leasing.common.service.impl;
import com.alibaba.fastjson.JSON;
import com.leasing.common.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.concurrent.TimeUnit;
/**
 * @project:leasing-cloud
 * @date:2019/9/27
 * @author:wangjc@yonyou.com
 * @description:
 **/
@Service("redisService")
public class RedisServiceImpl implements RedisService {

    @Autowired
    @Qualifier("customRedisTemplate")
    private RedisTemplate<String, String> redisTemplate;


    //缓存插入数据
    @Override
    public <T> boolean set(String key, T value, long timeout) {
        try {

            //任意类型转换成String
            String val = beanToString(value);

            if (val == null || val.length() <= 0) {
                return false;
            }

            redisTemplate.opsForValue().set(key, val, timeout, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //缓存获取数据
    @Override
    public <T> T get(String key, Class<T> clazz) {
        try {
            String value = redisTemplate.opsForValue().get(key);

            return stringToBean(value, clazz);
        } catch (Exception e) {
            return null;
        }
    }

    //设置缓存失效时间
    @Override
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //获得缓存过期时间
    @Override
    public long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    //判断是否存在指定key值
    @Override
    public boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //删除key
    @Override
    @SuppressWarnings("unchecked")
    public void del(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }


    @Override
    //String字符串转化为相应Bean类
    @SuppressWarnings("unchecked")
    public <T> T stringToBean(String value, Class<T> clazz) {
        if (value == null || value.length() <= 0 || clazz == null) {
            return null;
        }

        if (clazz == int.class || clazz == Integer.class) {
            return (T) Integer.valueOf(value);
        } else if (clazz == long.class || clazz == Long.class) {
            return (T) Long.valueOf(value);
        } else if (clazz == String.class) {
            return (T) value;
        } else {
            return JSON.toJavaObject(JSON.parseObject(value), clazz);
        }
    }

    @Override
    //实体类转化为String存储
    public <T> String beanToString(T value) {

        if (value == null) {
            return null;
        }
        Class<?> clazz = value.getClass();
        if (clazz == int.class || clazz == Integer.class) {
            return "" + value;
        } else if (clazz == long.class || clazz == Long.class) {
            return "" + value;
        } else if (clazz == String.class) {
            return (String) value;
        } else {
            return JSON.toJSONString(value);
        }
    }
}
