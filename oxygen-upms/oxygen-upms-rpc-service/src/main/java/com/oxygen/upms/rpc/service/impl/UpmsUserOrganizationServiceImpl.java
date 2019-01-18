package com.oxygen.upms.rpc.service.impl;

import com.oxygen.common.annotation.BaseService;
import com.oxygen.common.base.BaseServiceImpl;
import com.oxygen.upms.dao.mapper.UpmsUserOrganizationMapper;
import com.oxygen.upms.dao.model.UpmsUserOrganization;
import com.oxygen.upms.dao.model.UpmsUserOrganizationExample;
import com.oxygen.upms.rpc.api.UpmsUserOrganizationService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * UpmsUserOrganizationService实现
 * Created by yangxy on 2017/9/15.
 */
@Service
@Transactional
@BaseService
public class UpmsUserOrganizationServiceImpl extends BaseServiceImpl<UpmsUserOrganizationMapper, UpmsUserOrganization, UpmsUserOrganizationExample> implements UpmsUserOrganizationService {

    private static Logger _log = LoggerFactory.getLogger(UpmsUserOrganizationServiceImpl.class);

    @Autowired
    UpmsUserOrganizationMapper upmsUserOrganizationMapper;

    @Override
    public int organization(String[] organizationIds, String id) {
        int result = 0;
        // 删除旧记录
        UpmsUserOrganizationExample upmsUserOrganizationExample = new UpmsUserOrganizationExample();
        upmsUserOrganizationExample.createCriteria()
                .andUserIdEqualTo(id);
        upmsUserOrganizationMapper.deleteByExample(upmsUserOrganizationExample);
        // 增加新记录
        if (null != organizationIds) {
            for (String organizationId : organizationIds) {
                if (StringUtils.isBlank(organizationId)) {
                    continue;
                }
                UpmsUserOrganization upmsUserOrganization = new UpmsUserOrganization();
                upmsUserOrganization.setUserId(id);
                upmsUserOrganization.setOrganizationId(organizationId);
                result = upmsUserOrganizationMapper.insertSelective(upmsUserOrganization);
            }
        }
        return result;
    }

}