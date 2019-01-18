package com.oxygen.upms.rpc.api;

import com.oxygen.common.base.BaseServiceMock;
import com.oxygen.upms.dao.model.UpmsLog;
import com.oxygen.upms.dao.mapper.UpmsLogMapper;
import com.oxygen.upms.dao.model.UpmsLogExample;

/**
 * 降级实现UpmsSystemService接口
 * Created by yangxy on 2017/3/20.
 */
public class UpmsLogServiceMock extends BaseServiceMock<UpmsLogMapper, UpmsLog,UpmsLogExample> implements UpmsLogService {
}
