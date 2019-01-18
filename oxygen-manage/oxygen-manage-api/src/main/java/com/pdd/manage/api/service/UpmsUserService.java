package com.pdd.manage.api.service;

import com.pdd.manage.common.params.UserParams;
import com.pdd.manage.common.vo.UserVo;
/**
 * 
 * @作者： zhaoxin
 * @日期：2018年3月29日
 * @描述：用户
 */
public interface UpmsUserService {
	/**
	 * 
	 * @作者： zhaoxin
	 * @日期：2018年3月16日
	 * @描述：登录
	 */
	public UserVo checkUser(UserParams userParams) throws Exception;

	/**
	 * 
	 * @作者： zhaoxin
	 * @日期：2018年3月29日
	 * @描述：根据username获取UserVo
	 */
	public UserVo findUpmsUserByUsername(String username) throws Exception;
}
