package com.oxygen.shop.server;

import com.oxygen.common.base.BaseInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 系统接口
 * Created by yangxy on 2017/9/11.
 */
public class Initialize implements BaseInterface {

	private static Logger _log = LoggerFactory.getLogger(Initialize.class);

	@Override
	public void init() {
		_log.info(">>>>> 系统初始化");
	}

}
