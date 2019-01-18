package com.oxygen.pay.server.util;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.oxygen.common.util.PropertiesFileUtil;
import com.oxygen.pay.server.model.Product;
import com.oxygen.pay.weixin.base.PayConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yangxy on 2017/10/20.
 */
public class AliPayUtil {

    private static Logger _log = LoggerFactory.getLogger(AliPayUtil.class);

    /**
     * pc端网页支付
     * @param product
     * @return
     */
    public static String aliPayPc(Product product) {
        _log.info("支付宝PC支付下单");
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        //前台回调地址 http 自定义
        String returnUrl = PropertiesFileUtil.getInstance().get("alipay.returnUrl");
        alipayRequest.setReturnUrl(returnUrl);//前台通知
        String notify_url = PropertiesFileUtil.getInstance().get("alipay.notifyUrl");
        alipayRequest.setNotifyUrl(notify_url);//后台回调

        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", product.getOutTradeNo());
        bizContent.put("total_amount", product.getTotalFee());//订单金额:元

        bizContent.put("subject",product.getSubject());//订单标题

       // bizContent.put("seller_id", Configs.getPid());//实际收款账号，一般填写商户PID即可

        bizContent.put("product_code", "FAST_INSTANT_TRADE_PAY");//电脑网站支付

        bizContent.put("body", "两个苹果五毛钱");
        String biz = bizContent.toString().replaceAll("\"", "'");
        alipayRequest.setBizContent(biz);
        _log.info("业务参数:"+alipayRequest.getBizContent());
        String form = PayConstant.FAILED;
        try {
            form = AliPayConfig.getAlipayClient().pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            _log.error("支付宝构造表单失败",e);
        }
        return form;
    }

    /**
     * 手机网页支付
     * @param product
     * @return
     */
    public static String aliPayMobile(Product product) {
        _log.info("支付宝手机支付下单");
        AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();
        //前台回调地址 http 自定义
        String returnUrl = PropertiesFileUtil.getInstance().get("alipay.returnUrl");
        alipayRequest.setReturnUrl(returnUrl);//前台通知
        String notify_url = PropertiesFileUtil.getInstance().get("alipay.notifyUrl");
        alipayRequest.setNotifyUrl(notify_url);//后台回调

        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", product.getOutTradeNo());
        bizContent.put("total_amount", product.getTotalFee());//订单金额:元

        bizContent.put("subject",product.getSubject());//订单标题

        //bizContent.put("seller_id", Configs.getPid());//实际收款账号，一般填写商户PID即可

        bizContent.put("product_code", "QUICK_WAP_PAY");//手机网页支付

        bizContent.put("body", "两个苹果五毛钱");
        String biz = bizContent.toString().replaceAll("\"", "'");
        alipayRequest.setBizContent(biz);
        _log.info("业务参数:"+alipayRequest.getBizContent());
        String form = PayConstant.FAILED;
        try {
            form = AliPayConfig.getAlipayClient().pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            _log.error("支付宝构造表单失败",e);
        }
        return form;
    }
    /**
     * app端支付
     * @param product
     * @return
     */
    public static String appPay(Product product) {
        String orderString = PayConstant.FAILED;
        // 实例化客户端

        AlipayClient alipayClient = AliPayConfig.getAlipayClient();
        // 实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay

        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
        // SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。

        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        model.setBody(product.getBody());
        model.setSubject(product.getSubject());
        model.setOutTradeNo(product.getOutTradeNo());
        model.setTimeoutExpress("30m");
        model.setTotalAmount(product.getTotalFee());
        model.setProductCode("QUICK_MSECURITY_PAY");
        request.setBizModel(model);
        String notify_url = PropertiesFileUtil.getInstance().get("alipay.notifyUrl");
        request.setNotifyUrl(notify_url);
        try {
            // 这里和普通的接口调用不同，使用的是sdkExecute
            AlipayTradeAppPayResponse response = alipayClient
                    .sdkExecute(request);
            orderString  = response.getBody();//就是orderString 可以直接给客户端请求，无需再做处理。
            //System.out.println(response.getBody());
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return orderString ;
    }
}
