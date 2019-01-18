package com.oxygen.upms.rpc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 服务启动类
 * Created by yangxy on 2017/9/3.
 */
public class OxygenUpmsRpcServiceApplication {

	private static Logger _log = LoggerFactory.getLogger(OxygenUpmsRpcServiceApplication.class);

	public static void main(String[] args) {
		_log.info(">>>>> oxygen-upms-rpc-service 正在启动 <<<<<");
		new ClassPathXmlApplicationContext("classpath:META-INF/spring/*.xml");
		_log.info(">>>>> oxygen-upms-rpc-service 启动完成 <<<<<");
	}

}
