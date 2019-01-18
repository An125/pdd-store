package com.oxygen.upms.rpc.api;

import com.oxygen.common.base.BaseService;
import com.oxygen.upms.dao.model.UpmsUserRole;
import com.oxygen.upms.dao.model.UpmsUserRoleExample;

/**
 * Created by yangxy on 2017/9/12.
 */
public interface UpmsUserRoleService extends BaseService<UpmsUserRole,UpmsUserRoleExample> {
    int role(String[] roleIds, String id);
}
