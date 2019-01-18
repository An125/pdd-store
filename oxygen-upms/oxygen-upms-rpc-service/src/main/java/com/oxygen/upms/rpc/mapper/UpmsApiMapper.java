package com.oxygen.upms.rpc.mapper;



import com.oxygen.upms.dao.model.UpmsPermission;
import com.oxygen.upms.dao.model.UpmsRole;

import java.util.List;

/**
 * 用户VOMapper
 * Created by yangxy on 2017/09/15.
 */
public interface UpmsApiMapper {

	// 根据用户id获取所拥有的权限
	List<UpmsPermission> selectUpmsPermissionByUpmsUserId(String upmsUserId);

	// 根据用户id获取所属的角色
	List<UpmsRole> selectUpmsRoleByUpmsUserId(String upmsUserId);
	
}