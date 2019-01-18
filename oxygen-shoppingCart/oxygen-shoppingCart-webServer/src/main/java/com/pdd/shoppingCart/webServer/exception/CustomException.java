package com.pdd.shoppingCart.webServer.exception;

/**
 * 
 * @作者： zhaoxin
 * @日期：2018年4月3日
 * @描述：自定义异常类:系统自定义的异常类型，针对预期的异常，需要在程序中抛出此类的异常,实际开发中可能要定义多种异常类型
 */
public class CustomException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4656062083783126308L;
	//异常信息
	private String expMessage;

	public CustomException(String msg) {
		super(msg);
		this.expMessage = msg;
	}

	public String getExpMessage() {
		return expMessage;
	}

	public void setExpMessage(String expMessage) {
		this.expMessage = expMessage;
	}
	
}
