package com.leasing.common.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * @project:leasing-cloud
 * @date:2019/9/27
 * @author:wangjc@yonyou.com
 * @description:
 **/
@Configuration
public class RedisConfig {

    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;

    @Bean
    public JedisPool redisPoolFactory() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        return new JedisPool(jedisPoolConfig, host, port);
    }

    @Bean("customRedisTemplate")
    public RedisTemplate<String,String> redisTemplate(
            RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, String> template = new RedisTemplate<String,String>();

        //jackson可以自定义redis反序列化存储类型  如有需要可使用
//        Jackson2JsonRedisSerializer<Object> j =new Jackson2JsonRedisSerializer<Object>(Object.class);
        // value值的序列化采用fastJsonRedisSerializer
        template.setValueSerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new StringRedisSerializer());
        //key的序列化采用StringRedisSerializer
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());

        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

}