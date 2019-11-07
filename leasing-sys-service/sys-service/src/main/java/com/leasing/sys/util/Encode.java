package com.leasing.sys.util;

/**
 * @description DES密码加密
 * @author Yangjiajin
 * @date 2019/11/6 10:33
 * @param
 * @return
 */
public class Encode {


    public String decode(String s) {
        String res = "";
        DES des = new DES(getKey());
        byte[] sBytes = s.getBytes();

        for(int i = 0; i < sBytes.length / 16; ++i) {
            byte[] theBytes = new byte[8];

            for(int x = 0; x <= 7; ++x) {
                byte byte1 = (byte)(sBytes[16 * i + 2 * x] - 97);
                byte result = (byte)(sBytes[16 * i + 2 * x + 1] - 97);
                theBytes[x] = (byte)(byte1 * 16 + result);
            }

            long var10 = des.bytes2long(theBytes);
            byte[] var11 = new byte[8];
            des.long2bytes(des.decrypt(var10), var11);
            res = res + new String(var11);
        }

        return res.trim();
    }

    public String encode(String s) {
        String res = "";
        DES des = new DES(getKey());
        byte space = 32;
        byte[] sBytes = s.getBytes();
        int length = sBytes.length;
        int newLength = length + (8 - length % 8) % 8;
        byte[] newBytes = new byte[newLength];

        int i;
        for(i = 0; i < newLength; ++i) {
            if(i <= length - 1) {
                newBytes[i] = sBytes[i];
            } else {
                newBytes[i] = space;
            }
        }

        for(i = 0; i < newLength / 8; ++i) {
            byte[] theBytes = new byte[8];

            for(int x = 0; x <= 7; ++x) {
                theBytes[x] = newBytes[8 * i + x];
            }

            long var16 = des.bytes2long(theBytes);
            byte[] result = new byte[8];
            des.long2bytes(des.encrypt(var16), result);
            byte[] doubleResult = new byte[16];

            for(int j = 0; j < 8; ++j) {
                doubleResult[2 * j] = (byte)((((char)result[j] & 240) >> 4) + 97);
                doubleResult[2 * j + 1] = (byte)(((char)result[j] & 15) + 97);
            }

            res = res + new String(doubleResult);
        }

        return res;
    }

    private static long getKey() {
        return 1231234234L;
    }

}
