package com.oxygen.common.util;

import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @描述：String 工具类 
 * @作者： yangxy on 2016/12/07.
 * @日期：Feb 11, 2018
 * modify by Wu.Liang
 */
public class StringUtil {

	private static Pattern LINE_PATTERN = Pattern.compile("_(\\w)");
	private static Pattern HUMP_PATTERN = Pattern.compile("[A-Z]");

	/**
	 * 
	 * @描述：下划线转驼峰
	 * @作者： yangxy
	 * @param str
	 * @return
	 */
	public static String lineToHump(String str) {
		if (null == str || "".equals(str)) {
			return str;
		}
		str = str.toLowerCase();
		Matcher matcher = LINE_PATTERN.matcher(str);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
		}
		matcher.appendTail(sb);

		str = sb.toString();
		str = str.substring(0, 1).toUpperCase() + str.substring(1);

		return str;
	}

	/**
	 * 驼峰转下划线(简单写法，效率低于{@link #humpToLine2(String)})
	 * 
	 * @param str
	 * @return
	 */
	public static String humpToLine(String str) {
		return str.replaceAll("[A-Z]", "_$0").toLowerCase();
	}

	/**
	 * 驼峰转下划线,效率比上面高
	 * 
	 * @param str
	 * @return
	 */
	public static String humpToLine2(String str) {
		Matcher matcher = HUMP_PATTERN.matcher(str);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
		}
		matcher.appendTail(sb);
		return sb.toString();
	}

	/**
	 * 首字母转小写
	 * 
	 * @param s
	 * @return
	 */
	public static String toLowerCaseFirstOne(String s) {
		if (StringUtils.isBlank(s)) {
			return s;
		}
		if (Character.isLowerCase(s.charAt(0))) {
			return s;
		} else {
			return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
		}
	}

	/**
	 * 首字母转大写
	 * 
	 * @param s
	 * @return
	 */
	public static String toUpperCaseFirstOne(String s) {
		if (StringUtils.isBlank(s)) {
			return s;
		}
		if (Character.isUpperCase(s.charAt(0))) {
			return s;
		} else {
			return (new StringBuffer()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
		}
	}

	/**
	 * object转String
	 * 
	 * @param object
	 * @return
	 */
	public static String getString(Object object) {
		return getString(object, "");
	}

	public static String getString(Object object, String defaultValue) {
		if (null == object) {
			return defaultValue;
		}
		return object.toString();
	}

	/**
	 * object转Integer
	 * 
	 * @param object
	 * @return
	 */
	public static int getInt(Object object) {
		return getInt(object, -1);
	}

	public static int getInt(Object object, Integer defaultValue) {
		if (null == object) {
			return defaultValue;
		}
		return Integer.parseInt(object.toString());
	}

	/**
	 * object转Boolean
	 * 
	 * @param object
	 * @return
	 */
	public static boolean getBoolean(Object object) {
		return getBoolean(object, false);
	}

	public static boolean getBoolean(Object object, Boolean defaultValue) {
		if (null == object) {
			return defaultValue;
		}
		return Boolean.parseBoolean(object.toString());
	}

	/**
	 * 验证指定的字符串是否包含在包含逗号分隔符的字符串序列内
	 * 
	 * @param parentStr
	 *            包含逗号分隔符的字符串序列
	 * @param childStr
	 *            指定的字符串
	 * @return
	 */
	public static boolean containString(String parentStr, String childStr) {
		List<String> listStr = Arrays.asList(parentStr.split(","));
		listStr = trimList(listStr);
		return listStr.contains(childStr);
	}

	/**
	 * 验证指定的字符串是否包含在包含逗号分隔符的字符串序列内，忽略字符串大小写
	 * 
	 * @param parentStr
	 *            包含逗号分隔符的字符串序列
	 * @param childStr
	 *            指定的字符串
	 * @return
	 */
	public static boolean containStringIgnoreCase(String parentStr, String childStr) {
		List<String> listStr = Arrays.asList(parentStr.split(","));// StringTokenizer
		listStr = trimList(listStr);
		listStr = toCaseList(listStr, true);
		return listStr.contains(childStr.toUpperCase());
	}

	/**
	 * 将目标字符串列表内的字符串忽略前导空白和尾部空白
	 * 
	 * @param listStr
	 *            待处理的字符串列表
	 * @return 经处理的字符串列表
	 */
	public static List<String> trimList(List<String> listStr) {
		List<String> tgtList = new ArrayList<String>();
		for (String s : listStr) {
			if (StringUtils.isNotBlank(s))
				tgtList.add(s.trim());
		}
		return tgtList;
	}

	/**
	 * 将目标字符串数组内的字符串忽略前导空白和尾部空白
	 * 
	 * @param strArr
	 *            待处理的字符串数组
	 * @return 经处理的字符串数组
	 */
	public static String[] trimArray(String[] strArr) {
		List<String> tarList = new ArrayList<String>();
		for (String s : strArr) {
			if (StringUtils.isNotBlank(s))
				tarList.add(s.trim());
		}
		return tarList.toArray(new String[0]);
	}

	/**
	 * 将目标字符串数组内的字符串忽略前导空白和尾部空白并在前后增加sequ标识符
	 * 
	 * @param strArr
	 * @param sequ
	 * @return
	 */
	public static String[] trimArray(String[] strArr, CharSequence sequ) {
		List<String> tarList = new ArrayList<String>();
		for (String s : strArr) {
			if (StringUtils.isNotBlank(s))
				tarList.add(sequ + s.trim() + sequ);
		}
		return tarList.toArray(new String[0]);
	}

	/**
	 * @param listStr
	 *            待转换的字符串列表
	 * @param toUpperCase
	 *            true将listStr内字符串全部转换为大写，否则全部小写
	 * @return 经转换的字符串列表
	 */
	public static List<String> toCaseList(List<String> listStr, boolean toUpperCase) {
		List<String> target = new ArrayList<String>();
		for (String s : listStr) {
			if (toUpperCase) {
				target.add(s.toUpperCase());
			} else {
				target.add(s.toLowerCase());
			}
		}
		return target;
	}

	/**
	 * 将指定字符串 "iso-8859-1" 转换为 "UTF-8" 编码格式的字符串
	 * 
	 * @param codeStr
	 *            待转换的字符串
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String transcode(String codeStr) throws UnsupportedEncodingException {
		return transCode(codeStr, "iso-8859-1", "utf-8");
	}

	/**
	 * @param codeStr
	 *            目标字符串
	 * @param decodeCharset
	 *            原来的Charset
	 * @param encodeCharset
	 *            新转的Charset
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String transCode(String codeStr, String decodeCharset, String encodeCharset)
			throws UnsupportedEncodingException {
		return new String(codeStr.getBytes(decodeCharset), encodeCharset);
	}

	/**
	 * 从Map中提取键值对拼装URL参数
	 * 
	 * @param urlMap
	 * @return
	 */
	public static String assembleyURLParam(Map<String, String> urlMap) {
		String urlParamStr = "";
		if (urlMap != null && urlMap.size() > 0) {
			StringBuilder builder = new StringBuilder("?");
			for (Map.Entry<String, String> map : urlMap.entrySet()) {
				builder.append(map.getKey()).append("=").append(map.getValue()).append("&");
			}
			urlParamStr = builder.toString().substring(0, builder.lastIndexOf("&"));
		}
		return urlParamStr;
	}

	/**
	 * 将字符串中某些字符替换成其他字符
	 * 
	 * @param str
	 *            目标字符串
	 * @param target
	 *            替换的目标
	 * @param replacement
	 *            想要替换成的
	 * @return
	 * @author: Wu.Liang
	 */
	public static String replaceSomeChar(String str, String target, String replacement) {
		return str.replace(target, replacement);
	}

	/**
	 * 将list字符串数组集合，根据tag拼成一串，比如tag=‘，’，结果串为“'string1'，'string2'，'string3'”,
	 * 此方法适用于sql中：“select * from xxx where x in (适用于此处);”
	 * 
	 * @param list
	 * @param tag
	 *            做分隔符的字符
	 * @return
	 * @author: Wu.Liang
	 */
	public static String parseListToStringForSQL(Collection<String> collection) {
		StringBuffer sb = new StringBuffer("");
		if (collection != null && collection.size() > 0) {
			Iterator<String> it = collection.iterator();
			int count = 0;
			// 循环取出容器中的字符串
			while (it.hasNext()) {
				String str = it.next();
				count++;
				if (count >= collection.size()) {
					sb.append(str);
				} else {
					sb.append(str);
					sb.append(",");
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 将List<String>数组直接转成 “str01,str02,str03...” 这样带逗号的字符串 格式
	 * 
	 * @param list
	 * @return
	 * @author Wu.Liang
	 */
	public static String listToString(List<String> list) {
		if (list == null || list.size() == 0) {
			return null;
		}
		StringBuffer buffer = new StringBuffer("");
		for (int i = 0; i < list.size(); i++) {
			if (i == list.size() - 1) {
				buffer.append(list.get(i));
			} else {
				buffer.append(list.get(i)).append(",");
			}
		}
		return buffer.toString();
	}

	/**
	 * 
	 * @描述：生成32位的UUID字符串，去掉“-”符号
	 * @作者：Wu.Liang
	 * @return
	 */
	public static String generateUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	/**
	 * 
	 * @描述：生成32位的UUID字符串，去掉“-”符号，前面 + 前缀
	 * @作者：Wu.Liang
	 * @param prefix	前缀
	 * @return
	 */
	public static String generateUUIDByPrefix(String prefix) {
		return prefix + generateUUID();
	}
	
}
