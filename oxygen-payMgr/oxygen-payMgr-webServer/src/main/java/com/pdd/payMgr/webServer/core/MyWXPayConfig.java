package com.pdd.payMgr.webServer.core;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.github.wxpay.sdk.WXPayConfig;

/**
 * 公司微信服务端支付接口配置 @作者： wu.liang
 * 
 * @日期：Mar 15, 2018
 */
public class MyWXPayConfig implements WXPayConfig{
	private byte[] certData;

	public MyWXPayConfig(String certPathFromWebRoot) throws Exception {
		String certPath = certPathFromWebRoot; //"/path/to/apiclient_cert.p12";
		File file = new File(certPath);
		InputStream certStream = new FileInputStream(file);
		this.certData = new byte[(int) file.length()];
		certStream.read(this.certData);
		certStream.close();
	}

	public String getAppID() {
		return "wx7a4478b2180fa338";
	}

	public String getMchID() {
		return "1487814122";
	}

	public String getKey() {
		return "wxmypddjunlang888efb666znd6abc66";
	}

	public InputStream getCertStream() {
		ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
		return certBis;
	}

	public int getHttpConnectTimeoutMs() {
		return 8000;
	}

	public int getHttpReadTimeoutMs() {
		return 10000;
	}
}
