package com.pdd.manage.api.service;

import com.pdd.manage.common.params.SystemParams;
import com.pdd.manage.common.vo.SystemVo;

public interface UpmsSystemService {

	/**
	 * 
	 * @作者： zhaoxin
	 * @日期：2018年3月21日
	 * @描述：新增系统
	 */
	public SystemVo addSystem(SystemParams systemParams) throws Exception;
}
