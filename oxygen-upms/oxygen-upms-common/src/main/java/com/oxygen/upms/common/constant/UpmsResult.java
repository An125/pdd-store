package com.oxygen.upms.common.constant;

import com.oxygen.common.base.BaseResult;

/**
 * upms系统常量枚举类
 * Created by yangxy on 2017/9/18.
 */
public class UpmsResult extends BaseResult {

    public UpmsResult(UpmsResultConstant upmsResultConstant, Object data) {
        super(upmsResultConstant.getCode(), upmsResultConstant.getMessage(), data);
    }

}
