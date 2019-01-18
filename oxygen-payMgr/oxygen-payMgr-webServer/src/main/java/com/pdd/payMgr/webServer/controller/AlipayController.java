package com.pdd.payMgr.webServer.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.druid.util.StringUtils;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConstants;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.pdd.common.core.params.returns.MsgReturn;
import com.pdd.payMgr.common.params.AlipayGenerateParams;
import com.pdd.payMgr.common.params.AlipayNotifyParams;
import com.pdd.payMgr.webServer.core.AlipayConfig;

/**
 * 这个控制器跟alipay后台交互 完成生成订单、签名等操作
 * 
 * @author Wu.Liang
 * @Date 2018年3月2日
 */
@RestController
@RequestMapping("/payMgr")
public class AlipayController {
	private static Logger LOG = Logger.getLogger(AlipayController.class);
	/**
	 * 支付宝：通知接口
	 */
	public static final String NOTIFY_URL_ALIPAY = "http://60.191.35.250:8084/oxygen-payMgr-webServer/payMgr/notify_alipay";
	public static final AlipayClient alipayClient;

	/**
	 * 类加载时初始化AlipayClient URL 支付宝网关（固定） https://openapi.alipay.com/gateway.do
	 * APP_ID APPID即创建应用后生成 APP_PRIVATE_KEY 开发者应用私钥，由开发者自己生成 FORMAT 参数返回格式，只支持json
	 * json（固定） CHARSET 请求和签名使用的字符编码格式，支持GBK和UTF-8 开发者根据实际工程编码配置 ALIPAY_PUBLIC_KEY
	 * 支付宝公钥，由支付宝生成 SIGN_TYPE 商户生成签名字符串所使用的签名算法类型，目前支持RSA2和RSA，推荐使用RSA2 RSA2
	 */
	static {
		alipayClient = new DefaultAlipayClient(AlipayConfig.URL_GENERATE_ALIPAY, AlipayConfig.PARTNER,
				AlipayConfig.APP_PRIVATE_KEY, AlipayConstants.FORMAT_JSON, AlipayConstants.CHARSET_UTF8,
				AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConstants.SIGN_TYPE_RSA2);
	}

	/**
	 * @描述：生成支付宝的订单字符串
	 * @作者：Wu.Liang
	 * @param alipayGenerateParams
	 * @return 携带支付字符串的对象
	 */
	@PostMapping("/getPayUrl_alipay")
	public MsgReturn<String> getPayUrl(AlipayGenerateParams alipayGenerateParams) {
		MsgReturn<String> msg = new MsgReturn<String>();
		if(StringUtils.isEmpty(alipayGenerateParams.getOutTradeNo())) {
			msg.failed("订单号不可为空");
			return msg;
		}
		if(StringUtils.isEmpty(alipayGenerateParams.getTotalAmount())) {
			msg.failed("订单金额不可为空");
			return msg;
		}
		if(StringUtils.isEmpty(alipayGenerateParams.getSubject())) {
			msg.failed("订单标题不可为空");
			return msg;
		}
		if(StringUtils.isEmpty(alipayGenerateParams.getBody())) {
			msg.failed("订单详情描述不可为空");
			return msg;
		}
		try {
			// 生成alipay客户端
			String alipayOrderString = generate(alipayGenerateParams);

			if (alipayOrderString == null || "".equals(alipayOrderString)) {
				msg.failed();
			} else {
				msg.success();
				msg.setReturnObj(alipayOrderString);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			msg.exception();
		}
		return msg;
	}

	/**
	 * 接收alipay服务器通知消息
	 * @auther Wu.Liang
	 * @Date 2018年3月5日
	 * @param alipayNotifyParams
	 * @return
	 */
	@RequestMapping("/notify_alipay")
	public MsgReturn<String> notify_alipay(HttpServletRequest request, AlipayNotifyParams alipayNotifyParams){
		MsgReturn<String> msg = new MsgReturn<String>();
		try {
			//获取支付宝POST过来反馈信息
			Map<String,String> params = new HashMap<String,String>();
			Map requestParams = request.getParameterMap();
			LOG.info("#########################################################################################################");
			for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			    String name = (String) iter.next();
			    String[] values = (String[]) requestParams.get(name);
			    String valueStr = "";
			    for (int i = 0; i < values.length; i++) {
			        valueStr = (i == values.length - 1) ? valueStr + values[i]
			                    : valueStr + values[i] + ", ";
			  	}
			    //乱码解决，这段代码在出现乱码时使用。
				//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			    LOG.info(name + " : " + valueStr);
				params.put(name, valueStr);
			}
			//切记alipaypublickey是支付宝的公钥，请去open.alipay.com对应应用下查看。
			//boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
			boolean flag = AlipaySignature.rsaCheckV1(params, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConstants.CHARSET_UTF8, AlipayConstants.SIGN_TYPE_RSA2);
			if(flag) {
				if(AlipayConfig.TRADE_STATUS_WAIT_BUYER_PAY.equals(alipayNotifyParams.getTrade_status())) {
					LOG.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>TRADE_STATUS_WAIT_BUYER_PAY<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
					
					// *****************后期待开发******************
					
				}else if(AlipayConfig.TRADE_STATUS_TRADE_CLOSED.equals(alipayNotifyParams.getTrade_status())) {
					LOG.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>TRADE_STATUS_TRADE_CLOSED<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
					
					// *****************后期待开发******************
					
					
				}else if(AlipayConfig.TRADE_STATUS_TRADE_SUCCESS.equals(alipayNotifyParams.getTrade_status())) {
					LOG.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>TRADE_STATUS_TRADE_SUCCESS<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
					
					// *****************后期待开发******************
					
				}else if(AlipayConfig.TRADE_STATUS_TRADE_FINISHED.equals(alipayNotifyParams.getTrade_status())) {
					LOG.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>TRADE_STATUS_TRADE_FINISHED<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
					
					// *****************后期待开发******************
					
					
				}else {
					msg.failed("从支付宝接收到的订单状态有误：" + alipayNotifyParams.getTrade_status());
				}
			}else{
				msg.failed("加密验证失败");
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			msg.exception();
		}
		return msg;
	}

	/**
	 * 私有方法，获取生成支付宝订单号
	 * 返回对象字符串示例：“alipay_sdk=alipay-sdk-java-dynamicVersionNo&app_id=2088411854873388&biz_content=%7B%22out_trade_no%22%3A%22s12345645634343434343%22%2C%22subject%22%3A%22hehe%22%2C%22total_amount%22%3A%220.01%22%7D&charset=UTF-8&format=json&method=alipay.trade.app.pay&notify_url=http%3A%2F%2F60.191.35.250%3A8084%2Foxygen-payMgr-webServer%2FpayMgr%2Fnotify&sign=LkPnOGpg88RzxbHmpL5y2hkSBc%2Bsjpmm8fDVof7sCEfVmbTqjrMno3NKwUD1Xxlh6Am4ALvBYcEQSdAjTz4ELI2ff5V23MbYnDxAv8ItkroLgY3fsQE3s6ypq0I%2FuqxWm7pnNkJ2ASMcKX%2FHPLn0LFt0MhdL5e7CUnEyAYAyp232z4Q8lmEZD%2FsxNswyG0lct%2FkDaO3tyQMya%2BD7UNdo2YCSyfjlS6PRwjQ3mxVa0ZD3X9cwfbmV3O%2BbHkdGWkvcdNGDk92awtrlYyc48sh7LMG4qWNVBLdoeE3O4v6K6ESbac2ZH%2Fx21xcn3tzcYISWDljxz%2BJxaBOgkYzfNEJYSA%3D%3D&sign_type=RSA2&timestamp=2018-03-05+15%3A46%3A11&version=1.0”
	 * 
	 * @auther Wu.Liang
	 * @Date 2018年3月5日
	 * @param alipayGenerateParams
	 * @return
	 */
	private String generate(AlipayGenerateParams alipayGenerateParams) {
		// 实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
		AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
		// SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model 和 biz_content 同时存在的情况下取 biz_content)。
		AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
		model.setBody(alipayGenerateParams.getBody());
		model.setTimeoutExpress(alipayGenerateParams.getTimeoutExpress());
		model.setProductCode(AlipayConfig.PRODUCT_CODE_QUICK_MSECURITY_PAY);
		model.setSubject(alipayGenerateParams.getSubject());
		model.setOutTradeNo(alipayGenerateParams.getOutTradeNo());
		model.setTotalAmount(alipayGenerateParams.getTotalAmount());
		request.setNotifyUrl(NOTIFY_URL_ALIPAY);
		request.setBizModel(model);
		// 这里和普通的接口调用不同，使用的是sdkExecute
		AlipayTradeAppPayResponse response = null;
		String orderString = null;
		try {
			// 就是orderString 可以直接给客户端请求，无需再做处理。
			response = alipayClient.sdkExecute(request);
			orderString = response.getBody();
		} catch (AlipayApiException e) {
			LOG.error(e.getMessage());
		}
		return orderString;
	}
}
