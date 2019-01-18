package com.oxygen.pay.server.controller;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.oxygen.common.base.BaseController;
import com.oxygen.common.util.PropertiesFileUtil;
import com.oxygen.common.util.RequestUtil;
import com.oxygen.pay.server.model.Product;
import com.oxygen.pay.weixin.base.PayConstant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by yangxy on 2017/10/19.
 */
@Controller
@RequestMapping("/alipay")
@Api(value = "alipay", description = "支付宝支付")
public class AlipayController extends BaseController {
    private static Logger _log = LoggerFactory.getLogger(AlipayController.class);

    @Autowired
    private AlipayClient alipayClient;

    @Autowired
    private AlipayTradeWapPayRequest alipayTradeWapPayRequest;

    @Autowired
    private AlipayTradePagePayRequest alipayTradePagePayRequest;

    @Autowired
    private AlipayTradeAppPayRequest alipayTradeAppPayRequest;

    // 电脑网站支付
    @RequestMapping("/pay/pc")
    @ResponseBody
    @ApiOperation(value = "pc")
    public Object pc() throws Exception {
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", "pay2017" + System.currentTimeMillis());
        bizContent.put("total_amount", "0.01");
        bizContent.put("subject", "Iphone6 16G");
        bizContent.put("product_code", "FAST_INSTANT_TRADE_PAY");
        alipayTradePagePayRequest.setBizContent(bizContent.toString());
        return alipayClient.pageExecute(alipayTradePagePayRequest).getBody();
    }

    // 手机网站支付
    @RequestMapping("/pay/wap")
    @ResponseBody
    @ApiOperation(value = "wap")
    public Object wap() throws Exception {
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", "pay2017" + System.currentTimeMillis());
        bizContent.put("total_amount", "0.01");
        bizContent.put("subject", "Iphone6 16G");
        bizContent.put("product_code", "QUICK_WAP_PAY");
        alipayTradeWapPayRequest.setBizContent(bizContent.toString());
        return alipayClient.pageExecute(alipayTradeWapPayRequest).getBody();
    }

    //app支付
    @ApiOperation(value = "app支付服务端")
    @RequestMapping(value = "appPay", method = RequestMethod.POST)
    public Object app(Product product) throws Exception {
        _log.info("app支付服务端");
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        model.setBody(product.getBody());
        model.setSubject(product.getSubject());
        model.setOutTradeNo(product.getOutTradeNo());
        model.setTimeoutExpress("30m");
        model.setTotalAmount(product.getTotalFee());
        model.setProductCode("QUICK_MSECURITY_PAY");
        alipayTradeAppPayRequest.setBizModel(model);
        return alipayClient.sdkExecute(alipayTradeAppPayRequest).getBody();
    }

    // 异步通知
    @RequestMapping("/notifyUrl")
    @ResponseBody
    @ApiOperation(value = "notifyUrl")
    public Object notifyUrl(HttpServletRequest request) throws Exception {
        Map<String, String> parameterMap = RequestUtil.getParameterMap(request);
        // 验签
        boolean signVerified = AlipaySignature.rsaCheckV1(
                parameterMap,
                PropertiesFileUtil.getInstance().get("alipay.rsa.public_key"),
                PropertiesFileUtil.getInstance().get("alipay.charset"),
                PropertiesFileUtil.getInstance().get("alipay.sign_type"));
        if (!signVerified) {
            return PayConstant.FAILED;
        }
        return PayConstant.SUCCESS;
    }
}
