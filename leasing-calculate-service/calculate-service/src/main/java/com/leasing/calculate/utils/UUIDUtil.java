package com.leasing.calculate.utils;

import java.util.UUID;

/**
 * Created by jiaoshy on 2018-2-27.
 */
public class UUIDUtil {

    private static long lastTime;

    private UUIDUtil() {
        throw new Error("工具类，禁止实例化！");
    }

    public static String randomUUID() {
        return UUID.randomUUID().toString().substring(0,10)+ UUID.randomUUID().toString().substring(0,10);
    }

    public static String getUUID() {
        return "0" +(getTimeStr() + UUID.randomUUID().toString().substring(0,8)).toUpperCase();
    }

    public static String getTimeStr() {
        long timeMillis = System.currentTimeMillis();
        if(timeMillis > lastTime) {
            lastTime = timeMillis;
        } else {
            timeMillis = ++lastTime;
        }
        return  Long.toHexString(timeMillis).substring(0,11);
    }
}
