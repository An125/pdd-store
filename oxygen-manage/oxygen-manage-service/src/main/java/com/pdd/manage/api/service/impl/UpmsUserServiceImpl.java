package com.pdd.manage.api.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oxygen.common.util.AESUtil;
import com.pdd.manage.api.service.UpmsUserService;
import com.pdd.manage.common.params.UserParams;
import com.pdd.manage.common.po.UpmsUser;
import com.pdd.manage.common.po.UpmsUserExample;
import com.pdd.manage.common.vo.UserVo;
import com.pdd.manage.service.mapper.UpmsUserMapper;

@Service("upmsUserService")
public class UpmsUserServiceImpl implements UpmsUserService {
	@Autowired
	private UpmsUserMapper upmsUserMapper;

	/**
	 * 登录
	 */
	@Override
	public UserVo checkUser(UserParams userParams) throws Exception {
		UpmsUserExample example = new UpmsUserExample();
		example.createCriteria().andUsernameEqualTo(userParams.getUsername())
				.andPasswordEqualTo(AESUtil.AESEncode(userParams.getPassword()));
		List<UpmsUser> userList = upmsUserMapper.selectByExample(example);
		if (userList != null && !userList.isEmpty()) {
			UserVo userVo = new UserVo();
			//将userList的属性拷贝到UserVo
			BeanUtils.copyProperties(userList.get(0), userVo);
			return userVo;
		} else {
			return null;
		}
	}

	/**
	 * 根据用户名查询
	 */
	@Override
	public UserVo findUpmsUserByUsername(String username) {
		UpmsUserExample example = new UpmsUserExample();
		example.createCriteria().andUsernameEqualTo(username);
		List<UpmsUser> userList = upmsUserMapper.selectByExample(example);
		if(userList!=null&&!userList.isEmpty()) {
			UserVo userVo = new UserVo();
			BeanUtils.copyProperties(userList.get(0), userVo);
			return userVo;
		}else {
			return null;
		}
	}

}
