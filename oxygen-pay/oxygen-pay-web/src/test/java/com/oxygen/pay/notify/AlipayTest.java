package com.oxygen.pay.notify;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.oxygen.common.util.PropertiesFileUtil;

/**
 * Created by yangxy on 2017/10/23.
 */
public class AlipayTest {

    public static void main(String[] args) {
        // 实例化客户端
        AlipayClient alipayClient = new DefaultAlipayClient(PropertiesFileUtil.getInstance().get("alipay.gateway"),
                PropertiesFileUtil.getInstance().get("alipay.appid"),
                PropertiesFileUtil.getInstance().get("alipay.rsa.private_key"),
                PropertiesFileUtil.getInstance().get("alipay.format"),
                PropertiesFileUtil.getInstance().get("alipay.charset"),
                PropertiesFileUtil.getInstance().get("alipay.rsa.public_key"),
                PropertiesFileUtil.getInstance().get("alipay.sign_type")); //获得初始化的AlipayClient
        // 实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
        // SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        model.setBody("APP支付");
        model.setSubject("APP支付");
        model.setOutTradeNo("20179081");
        model.setTimeoutExpress("30m");
        model.setTotalAmount("1");
        model.setProductCode("QUICK_MSECURITY_PAY");
        request.setBizModel(model);
        request.setNotifyUrl("https://blog.52itstyle.com");
        try {
            // 这里和普通的接口调用不同，使用的是sdkExecute
            AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
            System.out.println(response.getBody());// 就是orderString
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
    }
}
