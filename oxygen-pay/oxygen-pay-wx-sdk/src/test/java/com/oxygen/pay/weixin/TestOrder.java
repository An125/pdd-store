package com.oxygen.pay.weixin;

import com.oxygen.pay.weixin.exception.WxRuntimeException;
import com.oxygen.pay.weixin.payment.bean.UnifiedOrderRequest;
import com.oxygen.pay.weixin.payment.wrapper.UnifiedOrderRequestWrapper;
import com.oxygen.pay.weixin.payment.wrapper.UnifiedOrderResponseWrapper;
import com.oxygen.pay.weixin.util.JsonMapper;
import com.oxygen.pay.weixin.util.SignatureUtil;
import com.oxygen.pay.weixin.util.XmlObjectMapper;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.SortedMap;

/**
 * Created by yangxy on 2017/10/16.
 */
public class TestOrder {
    public static void main(String[] args) {
        UnifiedOrderRequest unifiedOrderRequest = new UnifiedOrderRequest();
        unifiedOrderRequest.setBody("test");
        unifiedOrderRequest.setNotifyUrl("http://www.baidu.com");
        unifiedOrderRequest.setTotalFee(1);
        unifiedOrderRequest.setTradeType("APP");
        unifiedOrderRequest.setBillCreatedIp("114.114.114.114");
        unifiedOrderRequest.setTradeNumber("20170806125346");
        UnifiedOrderRequestWrapper wrapper = new UnifiedOrderRequestWrapper();
        wrapper.setRequest(unifiedOrderRequest);
        wrapper.setAppId("wx7a4478b2180fa338");
        wrapper.setMchId("1487814122");
        wrapper.setNonce("677C29C774EC3C1A32A3DC819040F9CD");
        wrapper.setSignType("MD5");

        String key = "wxmypddjunlang888efb666znd6abc66";

        SortedMap<String, Object> unifiedOrderRequestMap = JsonMapper.nonEmptyMapper().getMapper().convertValue(wrapper,SortedMap.class);
        String v = SignatureUtil.sign(unifiedOrderRequestMap, key);
        wrapper.setSign(v);
        String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
        try {
            String xml = XmlObjectMapper.nonEmptyMapper().toXml(wrapper);
            String response = httpPost(url,xml);
            UnifiedOrderResponseWrapper responseWrapper = XmlObjectMapper.defaultMapper().fromXml(response, UnifiedOrderResponseWrapper.class);
            System.out.println(responseWrapper.getResponse());
        } catch (Exception e) {
            throw new WxRuntimeException(999, "pre order failed:" + e.getMessage());
        }

    }


    private static String httpPost(String url, String content) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        if (content != null) {
            StringEntity entity = new StringEntity(content, Consts.UTF_8);
            httpPost.setEntity(entity);
        }

        try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
            StatusLine statusLine = response.getStatusLine();
            HttpEntity entity = response.getEntity();
            if (statusLine.getStatusCode() >= 300) {
                EntityUtils.consume(entity);
                throw new WxRuntimeException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
            }
            String responseContent = entity == null ? null : EntityUtils.toString(entity, Consts.UTF_8);
            return responseContent;
        } catch (IOException ex) {
            throw new WxRuntimeException(999, ex.getMessage());
        }
    }


}
