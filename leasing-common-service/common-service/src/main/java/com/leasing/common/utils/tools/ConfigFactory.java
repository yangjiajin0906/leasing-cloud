package com.leasing.common.utils.tools;


import com.leasing.common.service.sys.ConfigLoader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;

/**
 * @project:leasing-cloud
 * @date:2019/11/4
 * @author:wangjc@yonyou.com
 * @description:xml解析工厂 返回Document
 **/
@Component
public class ConfigFactory {

    static ConfigLoader configLoader;

    public static ConfigLoader getConfigLoader() {
        return configLoader;
    }

    public static void setConfigLoader(ConfigLoader configLoader) {
        ConfigFactory.configLoader = configLoader;
    }

    public static InputStream getInputStream(String path) {
        byte[] result = getConfigLoader().loadConfigFile(path);
        return result == null ? null : new ByteArrayInputStream(result);
    }

    public static String getPropertiesValue(String filePath, String paramertKey) {
        Properties properties = new Properties();

        try {
            properties.load(getInputStream(filePath));
        } catch (IOException arg3) {
            throw new RuntimeException(arg3);
        }

        return (String) properties.get(paramertKey);
    }

    public static Document getXmlConfig(String path) {
        try {
            InputStream ex = getInputStream(path);
            if (ex == null) {
                return null;
            } else {
                Document arg2;
                try {
                    Document e1 = XMLUtils.getDocumentBuilder().parse(ex);
                    arg2 = e1;
                } finally {
                    if (ex != null) {
                        ex.close();
                    }

                }

                return arg2;
            }
        } catch (Exception arg7) {
            RuntimeException e = new RuntimeException("ConfigFactory.getXmlConfig: " + path);
            e.initCause(arg7);
            throw e;
        }
    }
}