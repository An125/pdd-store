package com.oxygen.upms.rpc.api;

import com.oxygen.common.base.BaseService;
import com.oxygen.upms.dao.model.UpmsUserOrganization;
import com.oxygen.upms.dao.model.UpmsUserOrganizationExample;

/**
 * Created by yangxy on 2017/9/12.
 */
public interface UpmsUserOrganizationService extends BaseService<UpmsUserOrganization,UpmsUserOrganizationExample> {
    int organization(String[] organizationIds, String id);
}
