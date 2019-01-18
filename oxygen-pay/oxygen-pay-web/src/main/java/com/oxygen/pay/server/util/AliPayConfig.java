package com.oxygen.pay.server.util;


import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.oxygen.common.util.PropertiesFileUtil;

/**
 * Created by yangxy on 2017/10/20.
 * 配置公共参数
 * 创建者 科帮网
 * 创建时间	2017年7月27日
 */
public final class AliPayConfig {

    /**
     * 私有的默认构造子，保证外界无法直接实例化
     */
    private AliPayConfig(){};
    /**
     * 参数类型
     */
    public static String PARAM_TYPE = "json";
    /**
     * 编码
     */
    public static String CHARSET = "UTF-8";
    /**
     * 类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例
     * 没有绑定关系，而且只有被调用到才会装载，从而实现了延迟加载
     */
    private static class SingletonHolder{
        /**
         * 静态初始化器，由JVM来保证线程安全
         */
        private  static AlipayClient alipayClient = new DefaultAlipayClient(
                PropertiesFileUtil.getInstance().get("alipay.gateway"), PropertiesFileUtil.getInstance().get("alipay.appid"),
                PropertiesFileUtil.getInstance().get("alipay.rsa.private_key"), PARAM_TYPE, CHARSET,
                PropertiesFileUtil.getInstance().get("alipay.alipay_public_key"),
                PropertiesFileUtil.getInstance().get("alipay.sign_type"));
    }
    /**
     * 支付宝APP请求客户端实例
     * @Author  科帮网
     * @return  AlipayClient
     * @Date	2017年7月27日
     * 更新日志
     * 2017年7月27日  科帮网 首次创建
     *
     */
    public static AlipayClient getAlipayClient(){
        return SingletonHolder.alipayClient;
    }
}