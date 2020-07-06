package com.example.liang.setting.commons.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/7/2 19:35
 */
public class SecretUtil {

    private static String salt = "zhangsht";

    /**
     * MD5加密
     *
     * @param src 要加密的串
     * @return 加密后的字符串
     */
    public static String MD5(String src){
        Md5Hash md5Hash = new Md5Hash(src,salt);
        return md5Hash.toString();
    }

}
