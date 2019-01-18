package com.oxygen.upms.rpc.api;


import com.oxygen.common.base.BaseServiceMock;
import com.oxygen.upms.dao.mapper.UpmsUserRoleMapper;
import com.oxygen.upms.dao.model.UpmsUserRole;
import com.oxygen.upms.dao.model.UpmsUserRoleExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* 降级实现UpmsUserRoleService接口
* Created by yangxy on 2017/9/20.
*/
public class UpmsUserRoleServiceMock extends BaseServiceMock<UpmsUserRoleMapper, UpmsUserRole, UpmsUserRoleExample> implements UpmsUserRoleService {

    private static Logger _log = LoggerFactory.getLogger(UpmsUserRoleServiceMock.class);

    @Override
    public int role(String[] roleIds, String id) {
        _log.info("UpmsUserRoleServiceMock => role");
        return 0;
    }

}
