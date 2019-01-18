package com.oxygen.upms.rpc.service.impl;


import com.oxygen.common.annotation.BaseService;
import com.oxygen.common.base.BaseServiceImpl;
import com.oxygen.upms.dao.mapper.UpmsUserRoleMapper;
import com.oxygen.upms.dao.model.UpmsUserRole;
import com.oxygen.upms.dao.model.UpmsUserRoleExample;
import com.oxygen.upms.rpc.api.UpmsUserRoleService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UpmsUserRoleService实现
* Created by yangxy on 2017/9/15.
*/
@Service
@Transactional
@BaseService
public class UpmsUserRoleServiceImpl extends BaseServiceImpl<UpmsUserRoleMapper, UpmsUserRole, UpmsUserRoleExample> implements UpmsUserRoleService {
    private static Logger _log = LoggerFactory.getLogger(UpmsUserRoleServiceImpl.class);

    @Autowired
    UpmsUserRoleMapper upmsUserRoleMapper;

    @Override
    public int role(String[] roleIds, String id) {
        int result = 0;
        // 删除旧记录
        UpmsUserRoleExample upmsUserRoleExample = new UpmsUserRoleExample();
        upmsUserRoleExample.createCriteria()
                .andUserIdEqualTo(id);
        upmsUserRoleMapper.deleteByExample(upmsUserRoleExample);
        // 增加新记录
        if (null != roleIds) {
            for (String roleId : roleIds) {
                if (StringUtils.isBlank(roleId)) {
                    continue;
                }
                UpmsUserRole upmsUserRole = new UpmsUserRole();
                upmsUserRole.setUserId(id);
                upmsUserRole.setRoleId(roleId);
                result = upmsUserRoleMapper.insertSelective(upmsUserRole);
            }
        }
        return result;
    }

}