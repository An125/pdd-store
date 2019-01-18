package com.pdd.payMgr.webServer.core;

/**
 * 类名：AlipayConfig 功能：基础配置类 详细：设置帐户有关信息及返回路径 版本：3.3 日期：2012-08-10 说明：
 * 以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 * 该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 * 
 * 提示：如何获取安全校验码和合作身份者ID 1.用您的签约支付宝账号登录支付宝网站(www.alipay.com)
 * 2.点击“商家服务”(https://b.alipay.com/order/myOrder.htm)
 * 3.点击“查询合作者身份(PID)”、“查询安全校验码(Key)”
 * 
 * 安全校验码查看时，输入支付密码后，页面呈灰色的现象，怎么办？ 解决方法： 1、检查浏览器配置，不让浏览器做弹框屏蔽设置
 * 2、更换浏览器或电脑，重新登录查询。
 */
public class AlipayConfig {

	// ↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	/**
	 * 合作身份者ID，以2088开头由16位纯数字组成的字符串
	 */
	public static String PARTNER = "2017090108502817";
//	public static String PARTNER = "2088411854873388";
	/**
	 * 沙箱
	 */
	// public static String partner = "2016081600255095";
	/**
	 * 收款支付宝账号，一般情况下收款账号就是签约账号
	 */
	public static String SELLER_EMAIL = "pddznkz@163.com";
	/**
	 * 支付宝私钥
	 */
	public static String APP_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCTuFnvsSfxNH8xikpOT4G/hAhm1c1uyacZF2GZKdBySE0iX/iYVdsSTntRYZTErmDybxh7EE7FcjBLk8xnd45AruvfaJQgSWv+bGRkhLmo+OuE3EErBzsY+I5N7AYdHPfDBLJfiL80532exS3CwyLtPDkeKD1aMG7+UNLapYEqNBXXij0fJcpiomtw6RMpGiX7fDUGa7iTFbrqjXsGve25Dx0s+9hiYRfyjawxY3W0s+tw5RRUusSdXAhg5uRT6Tg351a5s8+uw9JOhL6dR6DoR1WCSkGZ0NP3kj8cyhxEZ+44Ppmj0NP/R9wtvkbqHFa/UswqbIHXR56iqgVXpHMVAgMBAAECggEACEreCZ2ZT2oSBdbsiu7dqsGfsx4ndSOu1LLCUNXPFMtIQTi//NU9Ag8TzyK6NjxPxuxDpIzqzxy051k5rUlB3BG1vgnh3togTN0K2bW1sm2e0wuGQQMb5y/01Rz9zt6UbgcyeDh1+2NPYv1Qr1FDAaxSzIWXxBtZ777bx1hpItRJxxaMLcYLa1rOCs/02XTC/zWA/EuN9e+76469DdPXj+js1DHUtzVuBi3XQzJuNskQKYHgC3A+UwYDx544ydusVEZ5TZDNLVN6mdQUM4HYFgBko6r/0g9L/mpdj1/G9eDIqXsOqCxx0WsTRXC6CotfWL1IDStjZxvbwFdjXsq/wQKBgQDUJmOyrWjaQmSIQy89Wat9Sgi8i3Jv2mCMfH40uqu8kuBbylSF+8RBwI7eM4lSONtSRX0zAu/rwqBQeRObSa5ILfDXsrPBiN0NBCh36rUA8GM3a20Kt+Rgcga3cwpzq22TF7VXel6h5ZpUdTUED8UyBgscrtpTulBCLWYCFS8DxQKBgQCyQL/iuWTmkKyRcaPewgeSxrV+D6Mw0eseeZCWxEAFVBMCcC01Pgj0SGkrBeAp8KiWw5VrWkL3Pn5KDsrWXBk+825rQ0C3gcbEXU9DCdP+IFsP0gBAM+K0rCOkfTD840/Eh1TaHhjH2tnOqSiBdbFm0iW+NAIIFeuKpeUwi9yXEQKBgHPuKosIcgTbRR6lQBpRdwH3RADsXvO6rQn4OetMmu5ogMwIK9ovs5aOyEOqe/7/bPJvYLRQhZUa/Qocr9crE18EI9lrIQnAZbNoM0kcbB8APeeZ/7NcvCLsDLmQ1wRQiIdZ7FHKYA4ubwB6MCdxCryESuw4rLwWUydmsZivxMpVAoGBAK9hd6p6YGVeGPwtRF8qpsrqCa4TcqvZDi14zCMayiaz9tQiTMii1aqMCDWVXV3GdAmKO9xY/aRH73esIDRSf2BpoM2WaPlkjY2shQzfgZ36db4WD7sbkcXTzGnN50IZ4OTrhjfo/ta8ZCqqUrk1dCtHPm1qvEj6UDqlSN+/7HURAoGBAJdZbfwrLHLJzZNBfvUvmPuSRi8wIBeFMWvmc0J6pN8gh2RpP55/bRAemJhKhAh0wLUXh+/yna185DqhZIsWr18AXDWpCyuX5Qas62HnTzWlWAWWS/Q9mrkD6IE2l0MwNdJJRm5dOBcGyMuO/Fx3Aeephvo+1+HzJeZaSO2FaSfT";
//	public static String APP_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCEU/6lYOWPAtFbA4UMuq3Kkzdf+IR6RBJ24Mf29RWJX4caXETeDm+koo6uBXOOBEXe+G23Ez9b/rD1MLCyiZr4hY5Ma6QtqPyOin7voAbNOdORlM3E5aFEiU9sYbw7pndJhos0zbKXZdIOdGXr9Xv7A/40hER9CBl4p33+JyHu8MJ29qM1nu31pj5rSF6ecPJ4hZeV34dSYM5UoxdGt0Kr88evSlkL7/Ni4el5NL8Ooy1oiSaXi0/WwplRtP5LszBocs+lwJbql+uAC546IPDWaM5a3IKhe+/DAwM9dL0syRySIZm/m1AtHWcDUJPbUq7muFoWS8QdpLn+G92zyGDHAgMBAAECggEASnEGG/r6qQ0owU6llpeeFQvkZvTjcfTBfmbNlzwgtXssAcROaa0tWSypn3QpoYb914ViE0+coSASZJzTilym9ZAMkSks3xLloTqAVkVsDh+tyYQwjcewhWHJcGs6/UOUb6Rkw3vEMC9zj/YjMC6VZIzGgLy32q6nxZxT4JobGNNBMIsHHd0dIbRMYUGW66ye58MIjQt3TCpR26ts8ImHTKDDzMt8khbLkfiDQKH+CNO0vzS5U029smQwi9hvPM1/8wi+ciqOnSDCXucBjzRY+/yBTueCFyBMgYLTwOza00N3TjhiJYSrUsu5N5UUmGczzOKuWjCgOa4Oc504SXExYQKBgQC8Ix2MNwjh1TkQKZAQ9BYPldODVs5DJqi/4gHEi/cnrj45eB3+AgRNx++OhvfBQAMJLSyFogSRVGOas0hfjfRHFN087rup6432MQV2XnzOo0ItqVWXNiNdc61tk7IvmsXletvZbO1xdz17eKpx3RVDkGrfb3Yil73qIS0sVQH5rQKBgQC0D2G3XBomsAMYKjyQycybJAImzKKjFGebTrx7jwQLLBe1ZRcD3t+/bjNzaGlGDre2HMykA51YjBRClVzn60qOxu2UwALkjg42FO/8/HUqR6qFZRzsmGhn24SncNFGfnF2koLhh0PZDFD9tguCarOnsOobNijMsmGFHAn35k46wwKBgQCskzmDaOhI36HcZYO1SXEDEthWXcYOauPYP6SHeixYxchmRvycB5WTE5d3Ee8p4WHnhPyWCCxQcyx6t4HnxPsSSN04C3UxRNWPwx/TmJC7q54E7JOKhSqjinzHSvfkGwD0o2IPa4/SySIopGMU10uuEkc2dbPTv4WBwrUBOWj6cQKBgDgnC9w41tb10SE6GsU0iaBgLGOZMacV9/GRLmqCAUrSp1okenb0jGaQoW7+QsZcVKJwfMkxb2Jr3O2e0uhokknQc8sNzlkki/4FrYoB2TAkRWNwUwLdzMGGzenB3yHS0OOfcT2QB3Kqyp80pIY5bGmBXKC71SFxB8SRJ/KtWfwtAoGAL38AH5aU86XB1o7IE8omO2k/Cru4796vBlozchJPaFH3wPrUqmnXL+XROLn8xzJf0yvctRLLRISte1pimkc0IiKXPgZV5xgRdQAVHZShYYpovKp1a7rSh6npcA3XFENggVe2Wz8EIktcEm3ND21pi7RAU1k+t837R0A9qpaRkuo=";
	/**
	 * 支付宝公钥
	 */
	public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAk7hZ77En8TR/MYpKTk+Bv4QIZtXNbsmnGRdhmSnQckhNIl/4mFXbEk57UWGUxK5g8m8YexBOxXIwS5PMZ3eOQK7r32iUIElr/mxkZIS5qPjrhNxBKwc7GPiOTewGHRz3wwSyX4i/NOd9nsUtwsMi7Tw5Hig9WjBu/lDS2qWBKjQV14o9HyXKYqJrcOkTKRol+3w1Bmu4kxW66o17Br3tuQ8dLPvYYmEX8o2sMWN1tLPrcOUUVLrEnVwIYObkU+k4N+dWubPPrsPSToS+nUeg6EdVgkpBmdDT95I/HMocRGfuOD6Zo9DT/0fcLb5G6hxWv1LMKmyB10eeoqoFV6RzFQIDAQAB";
//	public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoQAy6QzQ0hwB4t+hD9oUsQIUBN/2ysuaGEqFcxEs1uoJ+NBbwVcd0vyFq3zh1fm+bWhfmFWB1WxiFyG5HArZ5654h4uwV+ZovDCzifuamw+8ayqSF276sxalmVo635SR0kBFxzwFThv/3fO1CdwGDPR8SN0JGphV4/eg7+MhoqEyfDyVFhGlbi1ERU9owL4RgbKuNtWsUzL6epVvf9UyCOA+U1+EWuSbXc9yN1Dz1QMOqTOJsk/p3aT887sYPhIOGY7I1YG4EkO2kGk5i9Ljs0Dne2BoDnqeiaxFdPZmhdyPQcRJ2Dno8oiBitHSzLSCpxsFqAXeJ2Cm9O7oKSfx5QIDAQAB";
	/**
	 * 支付宝生成订单字串地址
	 */
	public static final String URL_GENERATE_ALIPAY = "https://openapi.alipay.com/gateway.do";
	/**
	 * 支付宝：产品码：“QUICK_MSECURITY_PAY”
	 */
	public static final String PRODUCT_CODE_QUICK_MSECURITY_PAY = "QUICK_MSECURITY_PAY";
	/**
	 * 签名方式 不需修改
	 */
	public static String SIGN_TYPE = "MD5";
	/**
	 * 支付宝：交易创建，等待买家付款
	 */
	public static final String TRADE_STATUS_WAIT_BUYER_PAY = "WAIT_BUYER_PAY";
	/**
	 * 支付宝：未付款交易超时关闭，或支付完成后全额退款
	 */
	public static final String TRADE_STATUS_TRADE_CLOSED = "TRADE_CLOSED";
	/**
	 * 支付宝：交易支付成功
	 */
	public static final String TRADE_STATUS_TRADE_SUCCESS = "TRADE_SUCCESS";
	/**
	 * 支付宝：交易结束，不可退款
	 */
	public static final String TRADE_STATUS_TRADE_FINISHED = "TRADE_FINISHED";
}
