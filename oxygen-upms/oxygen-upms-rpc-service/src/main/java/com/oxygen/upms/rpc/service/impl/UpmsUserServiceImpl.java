package com.oxygen.upms.rpc.service.impl;
import com.oxygen.common.annotation.BaseService;
import com.oxygen.common.base.BaseServiceImpl;
import com.oxygen.upms.dao.mapper.UpmsUserMapper;
import com.oxygen.upms.dao.model.UpmsUser;
import com.oxygen.upms.dao.model.UpmsUserExample;
import com.oxygen.upms.rpc.api.UpmsUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UpmsUserService实现
* Created by yangxy on 2017/3/20.
*/
@Service
@Transactional
@BaseService
public class UpmsUserServiceImpl extends BaseServiceImpl<UpmsUserMapper, UpmsUser, UpmsUserExample> implements UpmsUserService {

    private static Logger _log = LoggerFactory.getLogger(UpmsUserServiceImpl.class);

    @Autowired
    UpmsUserMapper upmsUserMapper;

    @Override
    public UpmsUser createUser(UpmsUser upmsUser) {
        UpmsUserExample upmsUserExample = new UpmsUserExample();
        upmsUserExample.createCriteria()
                .andUsernameEqualTo(upmsUser.getUsername());
        long count = upmsUserMapper.countByExample(upmsUserExample);
        if (count > 0) {
            return null;
        }
        upmsUserMapper.insert(upmsUser);
        return upmsUser;
    }

}