package com.oxygen.shop.common.constant;

import com.oxygen.common.base.BaseResult;

/**
 * shop系统常量枚举类
 * Created by yangxy on 2017/9/18.
 */
public class ShopResult extends BaseResult {

    public ShopResult(ShopResultConstant shopResultConstant, Object data) {
        super(shopResultConstant.getCode(), shopResultConstant.getMessage(), data);
    }

}
