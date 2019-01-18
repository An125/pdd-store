package com.pdd.userMgr.api.service;

import com.pdd.userMgr.api.Vo.UserVo;
import com.pdd.userMgr.api.params.UserParams;

public interface StoreUserService {
	/**
	 * @描述：用户注册
	 * @作者：Wu.Liang
	 * @param userParams
	 * @return
	 * @throws Exception
	 */
	public UserVo addStoreUser(UserParams userParams) throws Exception;

	/**
	 * @描述：手机号是否可以使用
	 * @作者：Wu.Liang
	 * @param mobile
	 * @return
	 */
	public boolean isMobileCanUse(String mobile) throws Exception;

	/**
	 * @描述：验证用户是否存在
	 * @作者：Wu.Liang
	 * @param mobile 手机号
	 * @param password 密码
	 * @return
	 * @throws Exception
	 */
	public UserVo checkUser(String mobile, String password) throws Exception;

	/**
	 * 
	 * @作者： zhaoxin
	 * @日期：2018年7月4日
	 * @描述：图片上传
	 */
	public UserVo pictureUpload(String mobile,String fastDFS_Id) throws Exception;
	
}
