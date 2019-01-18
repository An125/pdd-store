package com.oxygen.pay.notify;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.oxygen.pay.weixin.base.ConstantUtil;
import com.oxygen.pay.weixin.syntony.ResponseHandler;
import com.oxygen.pay.weixin.syntony.WXRequestUtil;

public class test {
	public static void main(String[] args) throws Exception {
		notify_url();
	}
	public static String notify_url() throws Exception{
	String strxml = "<xml><appid><![CDATA[wx7a4478b2180fa338]]></appid><bank_type><![CDATA[CFT]]></bank_type><cash_fee><![CDATA[1]]></cash_fee><device_info><![CDATA[68C97A93-D220-4B8F-A6E3-0491CA8A3E20]]></device_info><fee_type><![CDATA[CNY]]></fee_type><is_subscribe><![CDATA[N]]></is_subscribe><mch_id><![CDATA[1487814122]]></mch_id><nonce_str><![CDATA[1393660110]]></nonce_str><openid><![CDATA[otA01xKiiJFs1Pa36hQBoxOonl3M]]></openid><out_trade_no><![CDATA[014898955921453472]]></out_trade_no><result_code><![CDATA[SUCCESS]]></result_code><return_code><![CDATA[SUCCESS]]></return_code><sign><![CDATA[61BF5E9FD53335C7FB369EF4191521B1]]></sign><time_end><![CDATA[20170920144204]]></time_end><total_fee>1</total_fee><trade_type><![CDATA[APP]]></trade_type><transaction_id><![CDATA[4200000008201709203187607456]]></transaction_id></xml>";

	//System.out.println(a);
	Map<String, String> map = WXRequestUtil.doXMLParseWithSorted(strxml);// 接受微信的通知参数
	
	System.out.println("map:" + map);
	Map<String, String> return_data = new HashMap<String, String>();

	// 创建支付应答对象
	ResponseHandler resHandler = new ResponseHandler(null, null);

	resHandler.setAllparamenters(map);
	resHandler.setKey(ConstantUtil.PARTNER_KEY);

	// 判断签名
	if (resHandler.isTenpaySign()) {
		System.out.println("签名成功");
		System.out.println("map.get(return_code).toString()"
				+ map.get("return_code").toString());
		if (!map.get("return_code").toString().equals("SUCCESS")) {

			return_data.put("return_code", "FAIL");
			return_data.put("return_msg", "return_code不正确");
		} else {
			System.out.println("else");
			if (!map.get("result_code").toString().equals("SUCCESS")) {
				return_data.put("return_code", "FAIL");
				return_data.put("return_msg", "result_code不正确");
			}
			System.out.println("return_data" + return_data);

			String out_trade_no = map.get("out_trade_no").toString();
			String time_end = map.get("time_end").toString();
			BigDecimal total_fee = new BigDecimal(map.get("total_fee").toString());
			System.out.println("out_trade_no:"+out_trade_no);
			// 付款完成后，支付宝系统发送该交易状态通知
			
			System.out.println("交易成功");
		} 
		System.out.println("return_data" + return_data);
	}
	return null;
}
}

