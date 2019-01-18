package com.oxygen.pay.weixin.payment.wrapper;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.oxygen.pay.weixin.base.BaseSettings;
import com.oxygen.pay.weixin.payment.bean.UnifiedOrderRequest;

/**
 * Created by yangxy on 2017/10/17.
 */
@JacksonXmlRootElement(localName = "xml")
public class UnifiedOrderRequestWrapper extends BaseSettings {

    @JsonUnwrapped
    private UnifiedOrderRequest request;

    public void setRequest(UnifiedOrderRequest request) {
        this.request = request;
    }

    public UnifiedOrderRequest getRequest() {
        return request;
    }
}