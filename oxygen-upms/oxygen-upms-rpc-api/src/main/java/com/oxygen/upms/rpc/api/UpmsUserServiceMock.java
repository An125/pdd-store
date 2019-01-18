package com.oxygen.upms.rpc.api;

import com.oxygen.common.base.BaseServiceMock;
import com.oxygen.upms.dao.model.UpmsUser;
import com.oxygen.upms.dao.mapper.UpmsUserMapper;
import com.oxygen.upms.dao.model.UpmsUserExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yangxy on 2017/9/12.
 */
public class UpmsUserServiceMock extends BaseServiceMock<UpmsUserMapper,UpmsUser,UpmsUserExample> implements UpmsUserService{
    private static Logger _log = LoggerFactory.getLogger(UpmsUserServiceMock.class);

    @Override
    public UpmsUser createUser(UpmsUser upmsUser) {
        _log.info("UpmsUserServiceMock => createUser");
        return null;
    }
}
