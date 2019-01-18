package com.oxygen.upms.rpc.api;

import com.oxygen.common.base.BaseService;
import com.oxygen.upms.dao.model.UpmsUser;
import com.oxygen.upms.dao.model.UpmsUserExample;

/**
 * Created by yangxy on 2017/9/12.
 */
public interface UpmsUserService extends BaseService<UpmsUser, UpmsUserExample> {
    UpmsUser createUser(UpmsUser upmsUser);
}
