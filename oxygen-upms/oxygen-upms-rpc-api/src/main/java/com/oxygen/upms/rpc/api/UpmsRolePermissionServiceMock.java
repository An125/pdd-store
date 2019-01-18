package com.oxygen.upms.rpc.api;

import com.alibaba.fastjson.JSONArray;
import com.oxygen.common.base.BaseServiceMock;
import com.oxygen.upms.dao.model.UpmsRolePermission;
import com.oxygen.upms.dao.mapper.UpmsRolePermissionMapper;
import com.oxygen.upms.dao.model.UpmsRolePermissionExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yangxy on 2017/9/12.
 */
public class UpmsRolePermissionServiceMock extends BaseServiceMock<UpmsRolePermissionMapper,UpmsRolePermission,UpmsRolePermissionExample> implements UpmsRolePermissionService {
    private static Logger _log = LoggerFactory.getLogger(UpmsRolePermissionServiceMock.class);

    @Override
    public int rolePermission(JSONArray datas, String id) {
        _log.info("UpmsRolePermissionServiceMock => rolePermission");
        return 0;
    }
}
