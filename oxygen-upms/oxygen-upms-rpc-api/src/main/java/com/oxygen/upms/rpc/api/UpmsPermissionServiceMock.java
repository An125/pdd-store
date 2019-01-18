package com.oxygen.upms.rpc.api;

import com.alibaba.fastjson.JSONArray;
import com.oxygen.common.base.BaseServiceMock;
import com.oxygen.upms.dao.model.UpmsPermission;
import com.oxygen.upms.dao.mapper.UpmsPermissionMapper;
import com.oxygen.upms.dao.model.UpmsPermissionExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yangxy on 2017/9/12.
 */
public class UpmsPermissionServiceMock extends BaseServiceMock<UpmsPermissionMapper,UpmsPermission,UpmsPermissionExample> implements UpmsPermissionService {

    private static Logger _log = LoggerFactory.getLogger(UpmsPermissionServiceMock.class);

    @Override
    public JSONArray getTreeByRoleId(String roleId) {
        _log.info("UpmsPermissionServiceMock => getTreeByRoleId");
        return null;
    }

    @Override
    public JSONArray getTreeByUserId(String usereId, Byte type) {
        _log.info("UpmsPermissionServiceMock => getTreeByUserId");
        return null;
    }
}
