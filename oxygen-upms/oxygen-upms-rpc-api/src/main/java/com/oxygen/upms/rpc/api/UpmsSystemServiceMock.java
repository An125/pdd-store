package com.oxygen.upms.rpc.api;

import com.oxygen.common.base.BaseServiceMock;
import com.oxygen.upms.dao.model.UpmsSystem;
import com.oxygen.upms.dao.mapper.UpmsSystemMapper;
import com.oxygen.upms.dao.model.UpmsSystemExample;

/**
 * 降级实现UpmsSystemService接口
 * Created by yangxy on 2017/3/20.
 */
public class UpmsSystemServiceMock extends BaseServiceMock<UpmsSystemMapper,UpmsSystem,UpmsSystemExample> implements UpmsSystemService {
}
