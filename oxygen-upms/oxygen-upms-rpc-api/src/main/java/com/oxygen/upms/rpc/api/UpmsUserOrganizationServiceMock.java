package com.oxygen.upms.rpc.api;

import com.oxygen.common.base.BaseServiceMock;
import com.oxygen.upms.dao.model.UpmsUserOrganization;
import com.oxygen.upms.dao.mapper.UpmsUserOrganizationMapper;
import com.oxygen.upms.dao.model.UpmsUserOrganizationExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yangxy on 2017/9/12.
 */
public class UpmsUserOrganizationServiceMock extends BaseServiceMock<UpmsUserOrganizationMapper, UpmsUserOrganization,UpmsUserOrganizationExample> implements UpmsUserOrganizationService {
    private static Logger _log = LoggerFactory.getLogger(UpmsUserOrganizationServiceMock.class);

    @Override
    public int organization(String[] organizationIds, String id) {
        _log.info("UpmsUserOrganizationServiceMock => organization");
        return 0;
    }
}
