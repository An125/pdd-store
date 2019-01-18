package com.oxygen.shop.common.util;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.3
 *日期：2012-08-10
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
	
 *提示：如何获取安全校验码和合作身份者ID
 *1.用您的签约支付宝账号登录支付宝网站(www.alipay.com)
 *2.点击“商家服务”(https://b.alipay.com/order/myOrder.htm)
 *3.点击“查询合作者身份(PID)”、“查询安全校验码(Key)”

 *安全校验码查看时，输入支付密码后，页面呈灰色的现象，怎么办？
 *解决方法：
 *1、检查浏览器配置，不让浏览器做弹框屏蔽设置
 *2、更换浏览器或电脑，重新登录查询。
 */

public class AlipayConfig {
	
	//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	//appid
	
	// 合作身份者ID，以2088开头由16位纯数字组成的字符串
	public static String partner = "2088411854873388";
	//沙箱
	//public static String partner = "2016081600255095";
	
	// 收款支付宝账号，一般情况下收款账号就是签约账号
	public static String seller_email = "pddznkz@163.com";
	// 商户的私钥
	public static String key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCEU/6lYOWPAtFbA4UMuq3Kkzdf+IR6RBJ24Mf29RWJX4caXETeDm+koo6uBXOOBEXe+G23Ez9b/rD1MLCyiZr4hY5Ma6QtqPyOin7voAbNOdORlM3E5aFEiU9sYbw7pndJhos0zbKXZdIOdGXr9Xv7A/40hER9CBl4p33+JyHu8MJ29qM1nu31pj5rSF6ecPJ4hZeV34dSYM5UoxdGt0Kr88evSlkL7/Ni4el5NL8Ooy1oiSaXi0/WwplRtP5LszBocs+lwJbql+uAC546IPDWaM5a3IKhe+/DAwM9dL0syRySIZm/m1AtHWcDUJPbUq7muFoWS8QdpLn+G92zyGDHAgMBAAECggEASnEGG/r6qQ0owU6llpeeFQvkZvTjcfTBfmbNlzwgtXssAcROaa0tWSypn3QpoYb914ViE0+coSASZJzTilym9ZAMkSks3xLloTqAVkVsDh+tyYQwjcewhWHJcGs6/UOUb6Rkw3vEMC9zj/YjMC6VZIzGgLy32q6nxZxT4JobGNNBMIsHHd0dIbRMYUGW66ye58MIjQt3TCpR26ts8ImHTKDDzMt8khbLkfiDQKH+CNO0vzS5U029smQwi9hvPM1/8wi+ciqOnSDCXucBjzRY+/yBTueCFyBMgYLTwOza00N3TjhiJYSrUsu5N5UUmGczzOKuWjCgOa4Oc504SXExYQKBgQC8Ix2MNwjh1TkQKZAQ9BYPldODVs5DJqi/4gHEi/cnrj45eB3+AgRNx++OhvfBQAMJLSyFogSRVGOas0hfjfRHFN087rup6432MQV2XnzOo0ItqVWXNiNdc61tk7IvmsXletvZbO1xdz17eKpx3RVDkGrfb3Yil73qIS0sVQH5rQKBgQC0D2G3XBomsAMYKjyQycybJAImzKKjFGebTrx7jwQLLBe1ZRcD3t+/bjNzaGlGDre2HMykA51YjBRClVzn60qOxu2UwALkjg42FO/8/HUqR6qFZRzsmGhn24SncNFGfnF2koLhh0PZDFD9tguCarOnsOobNijMsmGFHAn35k46wwKBgQCskzmDaOhI36HcZYO1SXEDEthWXcYOauPYP6SHeixYxchmRvycB5WTE5d3Ee8p4WHnhPyWCCxQcyx6t4HnxPsSSN04C3UxRNWPwx/TmJC7q54E7JOKhSqjinzHSvfkGwD0o2IPa4/SySIopGMU10uuEkc2dbPTv4WBwrUBOWj6cQKBgDgnC9w41tb10SE6GsU0iaBgLGOZMacV9/GRLmqCAUrSp1okenb0jGaQoW7+QsZcVKJwfMkxb2Jr3O2e0uhokknQc8sNzlkki/4FrYoB2TAkRWNwUwLdzMGGzenB3yHS0OOfcT2QB3Kqyp80pIY5bGmBXKC71SFxB8SRJ/KtWfwtAoGAL38AH5aU86XB1o7IE8omO2k/Cru4796vBlozchJPaFH3wPrUqmnXL+XROLn8xzJf0yvctRLLRISte1pimkc0IiKXPgZV5xgRdQAVHZShYYpovKp1a7rSh6npcA3XFENggVe2Wz8EIktcEm3ND21pi7RAU1k+t837R0A9qpaRkuo=";
	//public static String key = "wxmypddjunlang888efb666znd6abc66";

	//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	

	// 调试用，创建TXT日志文件夹路径
	public static String log_path = "D:\\";

	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";
	
	// 签名方式 不需修改
	public static String sign_type = "MD5";

}

 