package com.leasing.common.utils.base;

import java.io.*;

/**
 * @project:leasing-cloud
 * @date:2019/11/4
 * @author:wangjc@yonyou.com
 * @description:
 **/
public class FileUtils {
    public static byte[] readFile(File file) {
        try {
            byte[] ex = new byte[8192];
            if (file.length() == 0L) {
                return new byte[0];
            } else {
                FileInputStream fis = null;
                ByteArrayOutputStream baos = null;

                try {
                    fis = new FileInputStream(file);
                    baos = new ByteArrayOutputStream((new Long(file.length())).intValue());
                    boolean len = false;

                    int len1;
                    while ((len1 = fis.read(ex)) != -1) {
                        baos.write(ex, 0, len1);
                    }

                    byte[] arg4 = baos.toByteArray();
                    return arg4;
                } finally {
                    try {
                        if (fis != null) {
                            fis.close();
                        }

                        if (baos != null) {
                            baos.close();
                        }
                    } catch (IOException arg12) {
                        arg12.printStackTrace();
                    }

                }
            }
        } catch (Exception arg14) {
            throw new RuntimeException(arg14);
        }
    }


    public static byte[] readFile(InputStream fis) {
        try {
            byte[] ex = new byte[8192];
            ByteArrayOutputStream baos = null;

            try {
                baos = new ByteArrayOutputStream();
                boolean len = false;

                int len1;
                while ((len1 = fis.read(ex)) != -1) {
                    baos.write(ex, 0, len1);
                }

                byte[] arg3 = baos.toByteArray();
                return arg3;
            } finally {
                try {
                    if (fis != null) {
                        fis.close();
                    }

                    if (baos != null) {
                        baos.close();
                    }
                } catch (IOException arg11) {
                    arg11.printStackTrace();
                }

            }
        } catch (Exception arg13) {
            throw new RuntimeException(arg13);
        }
    }

}