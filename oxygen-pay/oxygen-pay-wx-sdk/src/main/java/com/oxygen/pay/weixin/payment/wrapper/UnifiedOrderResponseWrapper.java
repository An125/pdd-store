package com.oxygen.pay.weixin.payment.wrapper;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.oxygen.pay.weixin.base.BaseSettings;
import com.oxygen.pay.weixin.payment.bean.UnifiedOrderResponse;

/**
 * Created by yangxy on 2017/10/17.
 */
public class UnifiedOrderResponseWrapper extends BaseSettings {

    @JsonUnwrapped
    private UnifiedOrderResponse response;

    public UnifiedOrderResponse getResponse() {
        return response;
    }

    public void setResponse(UnifiedOrderResponse response) {
        this.response = response;
    }
}
