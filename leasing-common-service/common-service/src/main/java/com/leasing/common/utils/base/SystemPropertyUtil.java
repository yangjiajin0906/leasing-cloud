package com.leasing.common.utils.base;
import java.util.Properties;
/**
 * @project:leasing-cloud
 * @date:2019/11/4
 * @author:wangjc@yonyou.com
 * @description:
 **/
public class SystemPropertyUtil {
    public static String SAMECHECKER = "CheckerSame";
    static Properties system = new Properties();

    public void setPropertys(Properties props) {
        String svrname = get("ServerName");
        if (svrname != null) {
            props.put("ServerName", svrname);
        }

        system.putAll(props);
    }

    public static String get(String key) {
        return system.getProperty(key);
    }

    public static void set(String key, String value) {
        system.setProperty(key, value);
    }

    static {
        system.putAll(System.getProperties());
    }
}