package com.oxygen.upms.rpc.api;

import com.alibaba.fastjson.JSONArray;
import com.oxygen.common.base.BaseService;
import com.oxygen.upms.dao.model.UpmsRolePermission;
import com.oxygen.upms.dao.model.UpmsRolePermissionExample;

/**
 * Created by yangxy on 2017/9/12.
 */
public interface UpmsRolePermissionService extends BaseService<UpmsRolePermission,UpmsRolePermissionExample> {
    int rolePermission(JSONArray datas, String id);
}
