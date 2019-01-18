package com.oxygen.upms.rpc.api;

import com.alibaba.fastjson.JSONArray;
import com.oxygen.common.base.BaseService;
import com.oxygen.upms.dao.model.UpmsUserPermission;
import com.oxygen.upms.dao.model.UpmsUserPermissionExample;

/**
 * Created by yangxy on 2017/9/12.
 */
public interface UpmsUserPermissionService extends BaseService<UpmsUserPermission,UpmsUserPermissionExample> {
    int permission(JSONArray datas, String id);
}
