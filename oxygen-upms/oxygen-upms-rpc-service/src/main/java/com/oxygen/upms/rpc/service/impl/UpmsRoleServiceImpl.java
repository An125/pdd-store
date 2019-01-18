package com.oxygen.upms.rpc.service.impl;

import com.oxygen.common.annotation.BaseService;
import com.oxygen.common.base.BaseServiceImpl;
import com.oxygen.upms.dao.mapper.UpmsRoleMapper;
import com.oxygen.upms.dao.model.UpmsRole;
import com.oxygen.upms.dao.model.UpmsRoleExample;
import com.oxygen.upms.rpc.api.UpmsRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UpmsRoleService实现
* Created by yangxy on 2017/9/15.
*/
@Service
@Transactional
@BaseService
public class UpmsRoleServiceImpl extends BaseServiceImpl<UpmsRoleMapper, UpmsRole, UpmsRoleExample> implements UpmsRoleService {

    private static Logger _log = LoggerFactory.getLogger(UpmsRoleServiceImpl.class);

    @Autowired
    UpmsRoleMapper upmsRoleMapper;

}