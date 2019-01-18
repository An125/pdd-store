package com.pdd.payMgr.webServer.core;

/**
 * 微信支付的接口配置参数
 * @author Wu.Liang
 * @Date 2018年3月6日
 */
public class WechatConfig{
	/**
	 * 微信统一下单接口路径  
	 */
	public static final String REMOTE_API_GENERATE_WECHAT = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	/**
	 * 在微信开发平台登记的app应用id
	 */
	public static final String APP_ID = "wx7a4478b2180fa338";
	/**
	 * 应用对应的凭证 
	 */
	public static final String APP_SECRET = "cbfd5da7fda96398cbb868330e58e732";
	/**
	 *  微信商户号
	 */
    public static final String PARTNER = "1487814122";
    /**
     * 不是商户登录密码，是商户在微信平台设置的32位长度的api秘钥
     */
	public static final String PARTNER_KEY = "wxmypddjunlang888efb666znd6abc66";
	/**
	 * 获取access_token对应的url
	 */
	public static final String TOKENURL = "https://api.weixin.qq.com/cgi-bin/token";
    /**
     *  微信交易类型  : app
     */
    public static final String TRADE_TYPE_APP = "APP";
    /**
     *  微信交易类型  : 扫码支付
     */
    public static final String TRADE_TYPE_NATIVE = "NATIVE";
    /**
     * 返回结果码：成功
     */
    public static final String RETURN_CODE_SUCCESS = "SUCCESS";  
    /**
     * 返回结果码：失败
     */
    public static final String RETURN_CODE_FAIL = "FAIL";
}
