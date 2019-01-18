package com.oxygen.pay.weixin.base;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by yangxy on 2017/10/17.
 */
public class BaseSettings {
    @JsonProperty("appid")
    private String appId;

    @JsonProperty("mch_id")
    private String mchId;

    @JsonProperty("nonce_str")
    private String nonce;

    private String sign;

    @JsonProperty("sign_type")
    private String signType;

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }
}
