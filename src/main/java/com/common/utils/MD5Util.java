package com.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密工具类
 * @author suhe
 * @since 2018年11月6日13:52:24
 * */
public class MD5Util {

    /**
     * md5
     * @description: TODO(加密)
     * @author suhe
     * @since 2018年11月6日13:52:36
     */
    public static String md5(String source) {
        String dest = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            char[] charArray = source.toCharArray();
            byte[] byteArray = new byte[charArray.length];
            for (int i = 0; i < charArray.length; i++) {
                byteArray[i] = (byte) charArray[i];
            }
            byte[] md5Bytes = md5.digest(byteArray);
            StringBuffer hexValue = new StringBuffer();
            for (int i = 0; i < md5Bytes.length; i++) {
                int val = ((int) md5Bytes[i]) & 0xff;
                if (val < 16) {
                    hexValue.append("0");
                }
                hexValue.append(Integer.toHexString(val));
            }
            dest = hexValue.toString();

        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dest;
    }
}
