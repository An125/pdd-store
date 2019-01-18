package com.oxygen.common.util;

import org.apache.log4j.Logger;

/**
 * 
 * @作者： zhaoxin
 * @日期：2018年7月31日
 * @描述：对字符串数组进行排序
 * 字符串用ASCII码比较大小，规则是：

	1、比较首字母的ASCII码大小

	2、若是前面的字母相同，则比较之后的字母的ASCII码值

	3、若是一个字符串从首字母开始包含另一个字符串，则认为字符串长度较长的大；例 ：abc > ab
 */
public class StringSortUtil {
	private static final Logger LOG = Logger.getLogger(StringSortUtil.class);

	/**
	 * 对字符串数组进行排序
	 * 
	 * @param keys     String[] 需要排序的字符串数组
	 * @return
	 */
	public static String[] getUrlParam(String[] keys) {

		for (int i = 0; i < keys.length - 1; i++) {
			for (int j = 0; j < keys.length - i - 1; j++) {
				String pre = keys[j];
				String next = keys[j + 1];
				if (isMoreThan(pre, next)) {
					String temp = pre;
					keys[j] = next;
					keys[j + 1] = temp;
				}
			}
		}
		return keys;
	}

	/**
	 * 比较两个字符串的大小，按字母的ASCII码比较
	 * 
	 * @param pre
	 * @param next
	 * @return
	 */
	private static boolean isMoreThan(String pre, String next) {
		if (null == pre || null == next || "".equals(pre) || "".equals(next)) {
			LOG.error("字符串比较数据不能为空！");
			return false;
		}

		char[] c_pre = pre.toCharArray();
		char[] c_next = next.toCharArray();

		int minSize = Math.min(c_pre.length, c_next.length);

		for (int i = 0; i < minSize; i++) {
			if ((int) c_pre[i] > (int) c_next[i]) {
				return true;
			} else if ((int) c_pre[i] < (int) c_next[i]) {
				return false;
			}
		}
		if (c_pre.length > c_next.length) {
			return true;
		}

		return false;
	}
	
	/**
	 * 
	 * @作者： zhaoxin
	 * @日期：2018年7月31日
	 * @描述：测试
	 */
	public static void main(String[] args) {

		String[] keys = getUrlParam(new String[] { "shidema", "DGLPVN", "bushi", "了红枫湖基地回家", "23435435" });
		//把字符数组转换成字符串
		StringBuffer  sb = new StringBuffer();
		for(int i = 0; i < keys.length; i++){
			 sb.append(keys[i]);
			}
		String result = sb.toString();
		System.out.println(result);
	}
}
