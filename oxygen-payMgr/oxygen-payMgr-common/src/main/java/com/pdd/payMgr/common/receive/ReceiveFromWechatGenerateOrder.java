package com.pdd.payMgr.common.receive;


/**
 * 从微信Api接收到的参数对象
 * （生成订单接口）
 * @author Wu.Liang
 * @Date 2018年3月6日
 */
public class ReceiveFromWechatGenerateOrder {
	private String return_code;
	private String return_msg;
	
	/*-----------------以下字段在return_code为SUCCESS的时候有返回 ------------------*/
	private String appid;	//应用APPID  是 String(32) wx8888888888888888 调用接口提交的应用ID 
	private String mch_id;	//商户号  是 String(32) 1900000109 调用接口提交的商户号 
	private String device_info;	//设备号  否 String(32) 013467007045764 调用接口提交的终端设备号， 
	private String nonce_str;	//随机字符串  是 String(32) 5K8264ILTKCH16CQ2502SI8ZNMTM67VS 微信返回的随机字符串 
	private String sign;	//签名  是 String(32) C380BEC2BFD727A4B6845133519F3AD6 微信返回的签名，详见签名算法 
	private String result_code; //业务结果  是 String(16) SUCCESS SUCCESS/FAIL 
	private String err_code;	//错误代码  否 String(32) SYSTEMERROR 详细参见第6节错误列表 
	private String err_code_des;	//错误代码描述  否 String(128) 系统错误 错误返回的信息描述 

	/*-----------------以下字段在return_code 和result_code都为SUCCESS的时候有返回  ------------------*/
	private String trade_type;	//交易类型  是 String(16) JSAPI 调用接口提交的交易类型，取值如下：JSAPI，NATIVE，APP，详细说明见参数规定 
	private String prepay_id;	//预支付交易会话标识  是 String(64) wx201410272009395522657a690389285100 微信生成的预支付回话标识，用于后续接口调用中使用，该值有效期为2小时
	public String getReturn_code() {
		return return_code;
	}
	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}
	public String getReturn_msg() {
		return return_msg;
	}
	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getMch_id() {
		return mch_id;
	}
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	public String getDevice_info() {
		return device_info;
	}
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getResult_code() {
		return result_code;
	}
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}
	public String getErr_code() {
		return err_code;
	}
	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}
	public String getErr_code_des() {
		return err_code_des;
	}
	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public String getPrepay_id() {
		return prepay_id;
	}
	public void setPrepay_id(String prepay_id) {
		this.prepay_id = prepay_id;
	}
}
