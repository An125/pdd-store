package com.oxygen.upms.rpc.api;

import com.alibaba.fastjson.JSONArray;
import com.oxygen.common.base.BaseService;
import com.oxygen.upms.dao.model.UpmsPermission;
import com.oxygen.upms.dao.model.UpmsPermissionExample;

/**
 * Created by yangxy on 2017/9/12.
 */
public interface UpmsPermissionService extends BaseService<UpmsPermission,UpmsPermissionExample> {
    JSONArray getTreeByRoleId(String roleId);

    JSONArray getTreeByUserId(String usereId, Byte type);
}
