package com.pdd.manage.shiro.test;

import com.xiaoleilu.hutool.crypto.SecureUtil;

public class SHA1Test {
	public static void main(String[] args) {
		String sha1 = SecureUtil.sha1("111111" + "e7614d7e9b9a4ba59624c06927551377");
		System.out.println(sha1);
		
	}
}
