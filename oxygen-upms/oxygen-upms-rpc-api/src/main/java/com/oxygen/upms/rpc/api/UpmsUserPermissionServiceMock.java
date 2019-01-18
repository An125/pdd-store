package com.oxygen.upms.rpc.api;

import com.alibaba.fastjson.JSONArray;
import com.oxygen.common.base.BaseServiceMock;
import com.oxygen.upms.dao.model.UpmsUserPermission;
import com.oxygen.upms.dao.mapper.UpmsUserPermissionMapper;
import com.oxygen.upms.dao.model.UpmsUserPermissionExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yangxy on 2017/9/12.
 */
public class UpmsUserPermissionServiceMock extends BaseServiceMock<UpmsUserPermissionMapper,UpmsUserPermission,UpmsUserPermissionExample> implements UpmsUserPermissionService{
    private static Logger _log = LoggerFactory.getLogger(UpmsUserPermissionServiceMock.class);

    @Override
    public int permission(JSONArray datas, String id) {
        _log.info("UpmsUserPermissionServiceMock => permission");
        return 0;
    }

}
