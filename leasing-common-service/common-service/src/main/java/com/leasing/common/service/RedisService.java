//package com.leasing.common.service;
//
//
//public interface RedisService {
//    /**
//     *
//     * 除 获取与赋值外  添加一些Util工具接口
//     */
//    //缓存置入
//    <T> boolean set(String key, T value, long timeout);
//
//    //缓存获取
//    <T> T get(String key, Class<T> clazz);
//
//    //指定缓存失效时间
//    public boolean expire(String key, long time);
//
//    //获取缓存过期时间 返回0代表永久有效
//    public long getExpire(String key);
//
//    //判断key是否存在 true为存在  false为不存在
//    public boolean hasKey(String key);
//
//    //删除指定key的缓存,可以传入多个值
//    public void del(String... key);
//
//
//    public <T> T stringToBean(String value, Class<T> clazz);
//    public <T> String beanToString(T value);
//
//
//}
