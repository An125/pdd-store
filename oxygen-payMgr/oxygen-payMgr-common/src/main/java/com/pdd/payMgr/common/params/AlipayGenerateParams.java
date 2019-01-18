package com.pdd.payMgr.common.params;

import java.io.Serializable;

/**
 * 
 * @author Wu.Liang
 * @Date 2018年3月5日
 */
public class AlipayGenerateParams implements Serializable{
	/**
	 * @auther Wu.Liang
	 * @Date 2018年3月5日
	 */
	private static final long serialVersionUID = 4064153594445382322L;
	private String outTradeNo;
	private String subject;
	private String totalAmount;
	private String body;
	private String timeoutExpress;
	public String getOutTradeNo() {
		return outTradeNo;
	}
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getTimeoutExpress() {
		return timeoutExpress;
	}
	public void setTimeoutExpress(String timeoutExpress) {
		this.timeoutExpress = timeoutExpress;
	}
}
