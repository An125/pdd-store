package com.pdd.appVersion.api.service;

import com.pdd.appVersion.common.params.AppVersionParams;
import com.pdd.appVersion.common.vo.AppVersionVo;

public interface AppVersionService {
	
	/**
	 * 
	 * @作者： zhaoxin
	 * @日期：2018年7月6日
	 * @描述：查询版本号
	 */
	public AppVersionVo selectVersion(AppVersionParams appVersionParams) throws Exception;
}
