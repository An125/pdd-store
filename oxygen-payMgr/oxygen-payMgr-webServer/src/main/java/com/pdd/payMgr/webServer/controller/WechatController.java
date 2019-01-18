package com.pdd.payMgr.webServer.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.github.wxpay.sdk.WXPay;
import com.pdd.common.core.params.returns.MsgReturn;
import com.pdd.payMgr.common.receive.ReceiveFromWechatNotify;
import com.pdd.payMgr.common.utils.WechatMd5Util;
import com.pdd.payMgr.common.utils.Xml2JsonUtil;
import com.pdd.payMgr.webServer.core.MyWXPayConfig;
import com.pdd.payMgr.webServer.core.WechatConfig;

/**
 * 微信支付的后台控制器
 * 
 * @author Wu.Liang
 * @Date 2018年3月6日
 */
@RestController
@RequestMapping("/payMgr")
public class WechatController {
	private static Logger LOG = Logger.getLogger(WechatController.class);
	private static MyWXPayConfig config;
	private static WXPay wxpay;
	/**
	 * 微信：通知接口
	 */
	public static final String NOTIFY_URL_WECHAT = "http://60.191.35.250:8084/oxygen-payMgr-webServer/payMgr/notify_wechat";

	static {
		try {
			// 支付配置加载
			config = new MyWXPayConfig(WechatController.class.getClassLoader().getResource("/").getPath() + "cert"
					+ File.separator + "apiclient_cert.p12");
			wxpay = new WXPay(config);
		} catch (Exception e) {
			LOG.error("WechatController 静态代码块 微信支付配置初始化失败: " + e.getMessage());
		}
	}

	/**
	 * 生成订单
	 * 
	 * @auther Wu.Liang
	 * @Date 2018年3月6日
	 * @param request
	 * @return
	 */
	@PostMapping("/getPayUrl_wechat")
	public MsgReturn<Map<String, String>> getPayUrl(HttpServletRequest request) {
		MsgReturn<Map<String, String>> result = new MsgReturn<Map<String, String>>();// 返回数据结果集合
		try {
			request.setCharacterEncoding("UTF-8");

			// String accessToken = request.getParameter("accessToken") == null ? null
			// : request.getParameter("accessToken").trim();

			// 订单编号
			String outTradeNo = request.getParameter("outTradeNo") == null ? null
					: request.getParameter("outTradeNo").trim();
			// 消费金额
			String totalAmount = request.getParameter("totalAmount") == null ? null
					: request.getParameter("totalAmount").trim();
			// 消费主题
			String subject = request.getParameter("subject") == null ? null : request.getParameter("subject").trim();

			// 产品编号
			// String productId = request.getParameter("productId") == null ? null
			// : request.getParameter("productId").trim();
			/*
			 * if(StringUtils.isEmpty(accessToken)){ result.failed("参数：accessToken 为空");
			 * result.setAccessCode(-1); return result; }
			 */
			if (StringUtils.isEmpty(outTradeNo)) {
				result.failed("参数：outTradeNo 为空");
				result.setAccessCode(-1);
				return result;
			}
			if (StringUtils.isEmpty(totalAmount)) {
				result.failed("参数：totalAmount 为空");
				result.setAccessCode(-1);
				return result;
			}
			if (StringUtils.isEmpty(subject)) {
				result.failed("参数：subject 为空");
				result.setAccessCode(-1);
				return result;
			}

			// if (StringUtils.isEmpty(productId)) {
			// result.failed("参数：productId 为空");
			// result.setAccessCode(-1);
			// return result;
			// }

			Map<String, String> data = new HashMap<String, String>();
			data.put("body", subject);
			data.put("out_trade_no", outTradeNo);
			data.put("device_info", "");
			data.put("fee_type", "CNY");
			data.put("total_fee", BigDecimal.valueOf(Long.parseLong(totalAmount)).toString());

			String ip = getIpAddr(request);
			if (StringUtils.isEmpty(ip)) {
				data.put("spbill_create_ip", "127.0.0.1");
			} else {
				data.put("spbill_create_ip", ip);
			}
			data.put("notify_url", NOTIFY_URL_WECHAT);
			data.put("trade_type", WechatConfig.TRADE_TYPE_APP); // 此处指定为扫码支付

			// 连接微信后台，生成企业微信订单
			Map<String, String> resp = wxpay.unifiedOrder(data);

			if ("SUCCESS".equals(resp.get("result_code"))) { // 统一生成订单成功
				result.success(resp.get("return_msg"));
				result.setAccessCode(200);
				result.setReturnObj(resp);
			} else { // 统一生成订单失败
				result.failed(resp.get("return_msg"));
				result.setAccessCode(-1);
				result.setReturnObj(resp);
			}
		} catch (IOException e) {
			result.setMsg(e.getMessage());
			result.setAccessCode(-1);
		} catch (Exception e) {
			result.setMsg(e.getMessage());
			result.setAccessCode(-1);
		}

		return result;
	}

	/**
	 * 微信订单回调接口
	 * 
	 * @return
	 */
	@PostMapping("/notify_wechat")
	public void notify(HttpServletRequest request, HttpServletResponse response) {
		InputStream in = null;
		ByteArrayOutputStream out = null;
		PrintWriter writer = null;
		try {
			// 接收编码 UTF-8
			request.setCharacterEncoding("UTF-8");

			// 返回编码UTF-8 和 返回参数格式参数
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			response.setHeader("Access-Control-Allow-Origin", "*");

			// 从请求中获得接收内容（xml格式的内容）
			in = request.getInputStream();
			out = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = in.read(buffer)) != -1) {
				out.write(buffer, 0, len);
			}
			out.flush();

			// 接收到的内容转 String
			String content = new String(out.toByteArray(), "utf-8");

			// 把 String（xml格式的内容）转成 json 对象
			JSONObject jsonObject = JSONObject.parseObject(Xml2JsonUtil.xml2JSON(content)).getJSONObject("xml");
			ReceiveFromWechatNotify received = JSONObject.parseObject(
					jsonObject.toString().replace("[", "").replace("]", ""), ReceiveFromWechatNotify.class);

			if (WechatConfig.RETURN_CODE_FAIL.equalsIgnoreCase(received.getReturn_code())) {

				// 失败打回信息
				writer = response.getWriter();
				writer.write(setXmlResponseString(WechatConfig.RETURN_CODE_FAIL, received.getReturn_msg()));
				writer.flush();

			} else if (WechatConfig.RETURN_CODE_SUCCESS.equalsIgnoreCase(received.getReturn_code())) {

				// **************************成功业务逻辑处理待添加********************************
				//
				//
				//
				// **************************成功业务逻辑处理待添加********************************

				// 返回微信通知接口成功信息
				writer = response.getWriter();
				writer.write(setXmlResponseString(WechatConfig.RETURN_CODE_SUCCESS, received.getReturn_msg()));
				writer.flush();
			}
		} catch (IOException e) {
			LOG.error(e.getMessage());
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				LOG.error(e.getMessage());
			}
		}
	}

	/**
	 * 返回访问者IP
	 * 
	 * @auther Wu.Liang
	 * @Date 2018年3月6日
	 * @param request
	 * @return
	 */
	public String getIpAddr(HttpServletRequest request) {
		String Xip = request.getHeader("X-Real-IP");
		String XFor = request.getHeader("X-Forwarded-For");
		if (!StringUtils.isEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)) {
			// 多次反向代理后会有多个ip值，第一个ip才是真实ip
			int index = XFor.indexOf(",");
			if (index != -1) {
				return XFor.substring(0, index);
			} else {
				return XFor;
			}
		}
		XFor = Xip;
		if (!StringUtils.isEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)) {
			return XFor;
		}
		if (!StringUtils.isEmpty(XFor) || "unknown".equalsIgnoreCase(XFor)) {
			XFor = request.getHeader("Proxy-Client-IP");
		}
		if (!StringUtils.isEmpty(XFor) || "unknown".equalsIgnoreCase(XFor)) {
			XFor = request.getHeader("WL-Proxy-Client-IP");
		}
		if (!StringUtils.isEmpty(XFor) || "unknown".equalsIgnoreCase(XFor)) {
			XFor = request.getHeader("HTTP_CLIENT_IP");
		}
		if (!StringUtils.isEmpty(XFor) || "unknown".equalsIgnoreCase(XFor)) {
			XFor = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (!StringUtils.isEmpty(XFor) || "unknown".equalsIgnoreCase(XFor)) {
			XFor = request.getRemoteAddr();
		}
		return XFor;
	}

	/**
	 * 随机生成字符串
	 * 
	 * @auther Wu.Liang
	 * @Date 2018年3月6日
	 * @param length
	 *            设定生成字符串的长度
	 * @return
	 */
	public static String getRandomString(int length) {
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * 将请求参数集拼装成如同 “<xml>...</xml>” XML格式的字符串
	 * 
	 * @auther Wu.Liang
	 * @Date 2018年3月7日
	 * @param parame
	 *            请求参数集
	 * @return
	 */
	public static String getRequestXML(SortedMap<String, Object> parame) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<xml>");
		Set<Entry<String, Object>> set = parame.entrySet();
		Iterator<Entry<String, Object>> iterator = set.iterator();
		while (iterator.hasNext()) {
			Entry<String, Object> entry = iterator.next();

			// 过滤相关字段sign
			if ("sign".equalsIgnoreCase(entry.getKey())) {
				buffer.append("<" + entry.getKey() + ">" + "<![CDATA[" + entry.getValue() + "]]>" + "</"
						+ entry.getKey() + ">");
			} else {
				buffer.append("<" + entry.getKey() + ">" + entry.getValue() + "</" + entry.getKey() + ">");
			}
		}
		buffer.append("</xml>");
		return buffer.toString();
	}

	/**
	 * 将要传给微信成成订单的参数串进行验证签名
	 * 
	 * @auther Wu.Liang
	 * @Date 2018年3月7日
	 * @param parame
	 * @return
	 */
	public static String createSign(SortedMap<String, Object> parame) {
		StringBuffer buffer = new StringBuffer();
		Set<Entry<String, Object>> set = parame.entrySet();
		Iterator<Entry<String, Object>> iterator = set.iterator();
		while (iterator.hasNext()) {
			Entry<String, Object> entry = iterator.next();
			if (null != entry.getValue() && !"".equals(entry.getValue()) && !"sign".equals(entry.getKey())
					&& !"key".equals(entry.getKey())) {
				buffer.append(entry.getKey() + "=" + entry.getValue() + "&");
			}
		}
		buffer.append("key=" + WechatConfig.PARTNER_KEY);
		String sign = WechatMd5Util.md5(buffer.toString());
		return sign;
	}

	/**
	 * 把要返回给微信通知接口的消息封装成 XML字符串
	 * 
	 * @auther Wu.Liang
	 * @Date 2018年3月7日
	 * @param return_code
	 *            返回代码："SUCCESS" or "FAIL"
	 * @param return_msg
	 *            返回消息
	 * @return
	 */
	public static String setXmlResponseString(String return_code, String return_msg) {
		return "<xml><return_code><![CDATA[" + return_code + "]]></return_code><return_msg><![CDATA[" + return_msg
				+ "]]></return_msg></xml>";
	}
}
