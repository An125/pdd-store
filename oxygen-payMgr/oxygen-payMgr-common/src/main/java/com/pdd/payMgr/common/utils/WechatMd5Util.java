package com.pdd.payMgr.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

/**
 * 微信专用的 md5 加密工具
 * @author Wu.Liang
 * @Date 2018年3月6日
 */
public class WechatMd5Util {
	private static Logger LOG = Logger.getLogger(WechatMd5Util.class);
	
	private static MessageDigest sMd5MessageDigest;
	private static StringBuilder sStringBuilder;

	/**
	 * 本工具类不允许 new 对象
	 * @auther Wu.Liang
	 * @Date 2018年3月6日
	 */
	private WechatMd5Util() {
	}

	/**
	 * 加密
	 * @auther Wu.Liang
	 * @Date 2018年3月6日
	 * @param content 要加密的内容
	 * @return 加密后的密文（全部为大写）
	 */
	public static String md5(String content) {
		sMd5MessageDigest.reset();
		sMd5MessageDigest.update(content.getBytes());
		byte[] digest = sMd5MessageDigest.digest();
		sStringBuilder.setLength(0);

		for (int i = 0; i < digest.length; ++i) {
			int b = digest[i] & 255;
			if (b < 16) {
				sStringBuilder.append('0');
			}
			sStringBuilder.append(Integer.toHexString(b));
		}
		return sStringBuilder.toString().toUpperCase();
	}

	static {
		try {
			sMd5MessageDigest = MessageDigest.getInstance("MD5");
			sStringBuilder = new StringBuilder();
		} catch (NoSuchAlgorithmException var1) {
			LOG.error("找不到加密算法“MD5”：" + var1.getMessage());
		}
	}
	
}
