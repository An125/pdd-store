package com.oxygen.upms.rpc.service.impl;

import com.oxygen.common.annotation.BaseService;
import com.oxygen.common.base.BaseServiceImpl;
import com.oxygen.upms.dao.mapper.UpmsLogMapper;
import com.oxygen.upms.dao.model.UpmsLog;
import com.oxygen.upms.dao.model.UpmsLogExample;
import com.oxygen.upms.rpc.api.UpmsLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UpmsLogService实现
* Created by yangxy on 2017/9/11.
*/
@Service
@Transactional
@BaseService
public class UpmsLogServiceImpl extends BaseServiceImpl<UpmsLogMapper, UpmsLog, UpmsLogExample> implements UpmsLogService {

    private static Logger _log = LoggerFactory.getLogger(UpmsLogServiceImpl.class);

    @Autowired
    UpmsLogMapper upmsLogMapper;

}