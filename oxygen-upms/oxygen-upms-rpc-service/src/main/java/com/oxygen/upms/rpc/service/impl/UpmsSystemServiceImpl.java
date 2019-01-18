package com.oxygen.upms.rpc.service.impl;

import com.oxygen.common.annotation.BaseService;
import com.oxygen.common.base.BaseServiceImpl;
import com.oxygen.upms.dao.mapper.UpmsSystemMapper;
import com.oxygen.upms.dao.model.UpmsSystem;
import com.oxygen.upms.dao.model.UpmsSystemExample;
import com.oxygen.upms.rpc.api.UpmsSystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UpmsSystemService实现
* Created by yangxy on 2017/9/15.
*/
@Service
@Transactional
@BaseService
public class UpmsSystemServiceImpl extends BaseServiceImpl<UpmsSystemMapper, UpmsSystem, UpmsSystemExample> implements UpmsSystemService {

    private static Logger _log = LoggerFactory.getLogger(UpmsSystemServiceImpl.class);

    @Autowired
    UpmsSystemMapper upmsSystemMapper;

}