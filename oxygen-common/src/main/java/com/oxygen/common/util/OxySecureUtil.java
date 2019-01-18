package com.oxygen.common.util;

import com.xiaoleilu.hutool.crypto.SecureUtil;


/**
 * Created by Administrator on 2017/8/30.
 */
public class OxySecureUtil {

    /**
     * 加盐
     * @return
     */
    public static String salt() {
        return SecureUtil.simpleUUID();
    }


    /**
     * 加密
     * @param password
     * @param salt
     * @return
     */
    public static String encryptPassword(String password, String salt) {
        return SecureUtil.sha1(password + salt);
    }

}
