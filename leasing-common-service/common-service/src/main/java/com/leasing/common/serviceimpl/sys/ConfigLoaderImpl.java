package com.leasing.common.serviceimpl.sys;

import com.leasing.common.service.sys.ConfigLoader;
import com.leasing.common.utils.tools.ConfigFactory;
import com.leasing.common.utils.tools.FileUtils;
import com.leasing.common.utils.base.SystemPropertyUtil;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @project:leasing-cloud
 * @date:2019/11/4
 * @author:wangjc@yonyou.com
 * @description:
 **/
@Service("ConfigLoaderImpl")
public class ConfigLoaderImpl implements ConfigLoader {
    public ConfigLoaderImpl() {
        ConfigFactory.setConfigLoader(this);
    }


    public byte[] loadConfigFile(String path) {
        InputStream in = null;

        byte[] file1;
        try {
            in = ConfigLoaderImpl.class.getClassLoader().getResourceAsStream(path);
            String file;
            if (in == null) {
                return null;
            }

            if (SystemPropertyUtil.get("test") != null) {
                file = ConfigLoaderImpl.class.getClassLoader().getResource(path).getFile();

                try {
                    file = (new File(file)).getCanonicalFile().getName();
                } catch (IOException arg13) {
                    throw new RuntimeException(arg13);
                }

                if (!path.endsWith(file)) {
                    System.out.println(path + "--" + file);
                    throw new RuntimeException("文件名称大小写不匹配--" + path + "--" + file);
                }
            }

            file1 = FileUtils.readFile(in);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception arg12) {
                    arg12.printStackTrace();
                }
            }

        }

        return file1;
    }
}