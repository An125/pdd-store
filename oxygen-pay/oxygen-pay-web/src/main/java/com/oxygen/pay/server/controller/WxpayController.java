package com.oxygen.pay.server.controller;

import com.oxygen.common.util.PropertiesFileUtil;
import com.oxygen.pay.weixin.base.ConstantUtil;
import com.oxygen.pay.weixin.exception.WxRuntimeException;
import com.oxygen.pay.weixin.payment.bean.UnifiedOrderRequest;
import com.oxygen.pay.weixin.payment.wrapper.UnifiedOrderRequestWrapper;
import com.oxygen.pay.weixin.syntony.ResponseHandler;
import com.oxygen.pay.weixin.syntony.WXRequestUtil;
import com.oxygen.pay.weixin.util.HttpKit;
import com.oxygen.pay.weixin.util.JsonMapper;
import com.oxygen.pay.weixin.util.SignatureUtil;
import com.oxygen.pay.weixin.util.XmlObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;

/**
 * Created by yangxy on 2017/10/18.
 */
@Controller
@RequestMapping("/wxpay")
@Api(value = "weixin", description = "微信支付")
public class WxpayController {
    private static Logger _log = LoggerFactory.getLogger(WxpayController.class);

    @ApiOperation(value = "unifiedOrder")
    @RequestMapping(value = "/unifiedOrder", method = RequestMethod.POST)
    @ResponseBody
    public String unifiedOrder(UnifiedOrderRequest unifiedOrderRequest) {
        UnifiedOrderRequestWrapper wrapper = new UnifiedOrderRequestWrapper();
        wrapper.setRequest(unifiedOrderRequest);
        wrapper.setAppId(PropertiesFileUtil.getInstance().get("weixin.appid"));
        wrapper.setMchId(PropertiesFileUtil.getInstance().get("weixin.mchid"));
        wrapper.setSignType(PropertiesFileUtil.getInstance().get("weixin.sign_type"));
        wrapper.setNonce("oxygen"+System.currentTimeMillis());
        String key = PropertiesFileUtil.getInstance().get("weixin.key");

        SortedMap<String, Object> unifiedOrderRequestMap = JsonMapper.nonEmptyMapper().getMapper().convertValue(wrapper, SortedMap.class);
        String v = SignatureUtil.sign(unifiedOrderRequestMap, key);
        wrapper.setSign(v);
        String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
        try {
            String xml = XmlObjectMapper.nonEmptyMapper().toXml(wrapper);
            String response = HttpKit.post(url, xml);
            System.out.println(response);
            //UnifiedOrderResponseWrapper responseWrapper = XmlObjectMapper.defaultMapper().fromXml(response, UnifiedOrderResponseWrapper.class);
        } catch (Exception e) {
            throw new WxRuntimeException(999, "pre order failed:" + e.getMessage());
        }
        return "test";
    }

    @ApiOperation(value = "notifyurl")
    @RequestMapping(value = "/notifyurl", method = RequestMethod.POST)
    @ResponseBody
    public String notify_url(HttpServletRequest request,
                             HttpServletResponse response) throws Exception {

        ServletInputStream instream = request.getInputStream();
        //System.out.println("instream:" + instream);
        StringBuffer sb = new StringBuffer();
        int len = -1;
        String root = "fail";

        byte[] buffer = new byte[1024];

        while ((len = instream.read(buffer)) != -1) {
            sb.append(new String(buffer, 0, len));

        }
        instream.close();
        String a = sb.toString();
        //System.out.println(a);
        Map<String, String> map = WXRequestUtil.doXMLParseWithSorted(a);// 接受微信的通知参数
        System.out.println("map:" + map);
        Map<String, String> return_data = new HashMap<String, String>();

        // 创建支付应答对象
        ResponseHandler resHandler = new ResponseHandler(request, response);

        resHandler.setAllparamenters(map);
        resHandler.setKey(ConstantUtil.PARTNER_KEY);

        // 判断签名
        if (resHandler.isTenpaySign()) {

            _log.info("签名成功");
            System.out.println("map.get(return_code).toString()"
                    + map.get("return_code").toString());
            if (!map.get("return_code").toString().equals("SUCCESS")) {

                return_data.put("return_code", "FAIL");
                return_data.put("return_msg", "return_code不正确");
            } else {
                System.out.println("else");
                if (!map.get("result_code").toString().equals("SUCCESS")) {
                    return_data.put("return_code", "FAIL");
                    return_data.put("return_msg", "result_code不正确");
                }

                _log.info("return_data" + return_data);
                String out_trade_no = map.get("out_trade_no").toString();
                String time_end = map.get("time_end").toString();
                BigDecimal total_fee = new BigDecimal(map.get("total_fee").toString());
                System.out.println("out_trade_no:" + out_trade_no);
                // 付款完成后，支付宝系统发送该交易状态通知
                System.out.println("交易成功");
                //PayNotifyDao.nd(out_trade_no);
                root = "Success";
            }
            System.out.println("return_data" + return_data);

        }
        return root;
    }
}
