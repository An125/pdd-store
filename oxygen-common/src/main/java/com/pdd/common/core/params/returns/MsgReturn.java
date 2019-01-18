package com.pdd.common.core.params.returns;

import com.pdd.common.core.params.page.Page;

public class MsgReturn<T> {
	/**
	 * 返回消息：请求出现异常，请您稍后再试
	 */
	private static final String MSGRETURN_EXCEPTION = "请求出现异常，请您稍后再试";
	/**
	 * 返回消息：找不到您需要的数据
	 */
	private static final String MSGRETURN_FAILED = "找不到您需要的数据";
	/**
	 * 返回消息：请求成功
	 */
	private static final String MSGRETURN_SUCCESS = "请求成功";
	// 返回  boolean 值：true 成功；false 失败
	private boolean reflag;
	
	// 返回的提示信息，比如：“注册用户成功！”
	private String msg;
	
	// 访问返回的消息代码：比如：200、404、500……
	private int accessCode;
	
	// 确定转接地址
	private String confirmUrl;
	
	// 取消转接地址
	private String cancelUrl;
	
	// 返回的单个业务对象
	private T returnObj;
	
	// 返回的一整页数据
	private Page<T> returnPage;

	/**
	 * 构造方法
	 */
	public MsgReturn() {
		// 打回消息设置为 true
		this.reflag = true;
	}
	
	/**
	 * 请求出现异常的时候在 catch 里调用此方法。
	 */
	public void exception() {
		this.reflag = false;
		this.accessCode = 500;
		this.msg = MSGRETURN_EXCEPTION;
	}
	
	/**
	 * 请求成功
	 */
	public void success() {
		this.reflag = true;
		this.accessCode = 200;
		this.msg = MSGRETURN_SUCCESS;
	}
	
	/**
	 * 请求成功
	 * @param msgInfo 返回的提示信息
	 */
	public void success(String msgInfo) {
		this.reflag = true;
		this.accessCode = 200;
		this.msg = msgInfo;
	}
	
	/**
	 * 请求数据失败，找不到数据
	 */
	public void failed() {
		this.reflag = false;
		this.accessCode = 404;
		this.msg = MSGRETURN_FAILED;
	}
	
	/**
	 * 请求数据失败，找不到数据
	 * @param msgInfo 提示信息
	 */
	public void failed(String msgInfo) {
		this.reflag = false;
		this.accessCode = 404;
		this.msg = msgInfo;
	}
	
	public boolean isReflag() {
		return reflag;
	}

	public void setReflag(boolean reflag) {
		this.reflag = reflag;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getAccessCode() {
		return accessCode;
	}

	public void setAccessCode(int accessCode) {
		this.accessCode = accessCode;
	}

	public String getConfirmUrl() {
		return confirmUrl;
	}

	public void setConfirmUrl(String confirmUrl) {
		this.confirmUrl = confirmUrl;
	}

	public String getCancelUrl() {
		return cancelUrl;
	}

	public void setCancelUrl(String cancelUrl) {
		this.cancelUrl = cancelUrl;
	}

	public T getReturnObj() {
		return returnObj;
	}

	public void setReturnObj(T returnObj) {
		this.returnObj = returnObj;
	}

	public Page<T> getReturnPage() {
		return returnPage;
	}

	public void setReturnPage(Page<T> returnPage) {
		this.returnPage = returnPage;
	}
}
