package com.oxygen.upms.rpc.service.impl;

import com.oxygen.common.annotation.BaseService;
import com.oxygen.common.base.BaseServiceImpl;
import com.oxygen.upms.dao.mapper.UpmsOrganizationMapper;
import com.oxygen.upms.dao.model.UpmsOrganization;
import com.oxygen.upms.dao.model.UpmsOrganizationExample;
import com.oxygen.upms.rpc.api.UpmsOrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UpmsOrganizationService实现
* Created by yangxy on 2017/9/15.
*/
@Service
@Transactional
@BaseService
public class UpmsOrganizationServiceImpl extends BaseServiceImpl<UpmsOrganizationMapper, UpmsOrganization, UpmsOrganizationExample> implements UpmsOrganizationService {

    private static Logger _log = LoggerFactory.getLogger(UpmsOrganizationServiceImpl.class);

    @Autowired
    UpmsOrganizationMapper upmsOrganizationMapper;

}