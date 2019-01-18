package com.pdd.manage.webServer.exception;

/**
 * 
 * @作者： zhaoxin
 * @日期：2018年4月3日
 * @描述：系统自定义的异常类型，针对预期的异常，需要在程序中抛出此类的异常,实际开发中可能要定义多种异常类型
 */
public class CustomException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4656062083783126308L;
	//异常信息
	private String message;

	public CustomException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
