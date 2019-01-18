package com.pdd.manage.shiro.test;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

public class MD5Test {
	public static void main(String[] args) {
		/**
		 * 构造方法中：第一个参数：明文，即原始密码
		 * 第二个参数：盐，通过使用随机数
		 * 第三个参数：散列次数，比如散列两次：md5(md5(''))
		 */
		String source="111111";
		
		String salt="abcdefg";
		//散列次数，散列一次结果是06da291aa533abb73e9ffade880d9432
		//散列2次结果是4aa33a194258077db0745da10d628db2
		int hashIterations=1;
		
		Md5Hash md5Hash = new Md5Hash(source, salt, hashIterations);
		
		String pwd_md5=md5Hash.toString();
		System.err.println(pwd_md5);
		
		//方法二：第一个参数是散列算法
		//结果：06da291aa533abb73e9ffade880d9432
		SimpleHash simpleHash = new SimpleHash("md5", source, salt);
		System.out.println(simpleHash);
	}
}
