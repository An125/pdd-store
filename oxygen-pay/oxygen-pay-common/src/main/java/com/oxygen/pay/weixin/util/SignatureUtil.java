package com.oxygen.pay.weixin.util;

import com.google.common.base.Joiner;
import com.xiaoleilu.hutool.crypto.SecureUtil;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by yangxy on 2017/10/17.
 */
public class SignatureUtil {

    public static void main(String[] args) {
        SortedMap<String, Object> map = new  TreeMap();
        map.put("test","111");
        map.put("test2","222");
        map.put("test3",null);
        String v = sign(map,"123");
        System.out.println(v);
    }

    public static String sign(Map<String, Object> map, String key) {
        String str = Joiner.on("&").withKeyValueSeparator("=").join(map);
        str += "&key=" + key;
        return SecureUtil.md5(str).toUpperCase();
    }
}
