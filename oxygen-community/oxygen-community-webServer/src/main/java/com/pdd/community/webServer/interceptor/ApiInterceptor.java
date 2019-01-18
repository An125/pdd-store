package com.pdd.community.webServer.interceptor;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.oxygen.common.util.StringSortUtil;
/**
 * @作者： zhaoxin
 * @日期：2018年7月25日
 * @描述：校验用户请求拦截器
 * token生成规则：请求参数字符串的值按规定排完序后拼接（除token 外）+“pddwangluoyonghutoken2018”生成32位md5码
 */                      
public class ApiInterceptor extends HandlerInterceptorAdapter{
	
	private static Logger LOG = Logger.getLogger(ApiInterceptor.class);
	
	private String constant = "pddwangluoyonghutoken2018";
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		LOG.info("--->preHandle:" + request);
		String token = request.getParameter("token");

		// token is not needed when debug
		if (token == null) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println("token为空");
			response.setStatus(401);
			return false; // !! remember to comment this when deploy on server !!
		}

		// 1.将发送请求页面中form表单里所有具有name属性的表单对象获取(包括button).返回一个Enumeration类型的枚举
		Enumeration paraKeys = request.getParameterNames();
		String encodeStr = "";
		
		List<String> list = new ArrayList<String>();
		
		// 2.通过 Enumeration 的hasMoreElements()方法遍历
		while (paraKeys.hasMoreElements()) {
			// 3.再由nextElement()方法获得枚举的值.此时的值是form表单中所有控件的name属性的值
			String paraKey = (String) paraKeys.nextElement();
			if (paraKey.equals("token"))
				//不要使用break，当遍历到token时会跳出循环其他属性就遍历不出来
				continue;
			
			/*//判断是否为图片上传  data：二进制数，是前端把图片转成二进制传过来
			if(paraKey.equals("data")) {
				MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
				//解析request，将结果放置在map中
				Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
				Iterator<Entry<String, MultipartFile>> entrySetIterator = fileMap.entrySet().iterator();
				Entry<String, MultipartFile> entry;
				while (entrySetIterator.hasNext()) {
					entry = entrySetIterator.next();
					long size = entry.getValue().getSize();
					encodeStr =size+" "+"bytes";
					
				}
				
			
			//非图片上传情况下
			}else {*/
			
				// 4.最后通过request.getParameter()方法获取表单控件的value值
				String paraValue = request.getParameter(paraKey);
				LOG.info("表单控件的值===>"+paraKey+":"+paraValue);
			/* 把value值循环写入list集合 。
			  	注意：把List<String> list = new ArrayList<String>();放到循环外，否则最后List里面得到的都是最后一个值
			  	每次new一个对象就是一个新对象，在循环里new，就是每一次循环都创建一个全新的对象。
			  	而在循环外只new了一次，你每次循环只是改变外面new的对象属性值而已
			 */
			//List<String> list = new ArrayList<String>();
			list.add(paraValue);
			//list转换成带逗号的字符串
			String str = StringUtils.join(list.toArray(),",");
//			LOG.info("===>list转化成带逗号字符串："+str);
			
			//字符串转成字符串数组
			String[] arr = str.split(",");
			//调用工具类进行排序
			String[] keys = StringSortUtil.getUrlParam(arr);
			//把字符串数组转换成字符串
			StringBuffer  sb = new StringBuffer();
			for(int i = 0; i < keys.length; i++){
				sb.append(keys[i]);
			}
			String result = sb.toString();
//			LOG.info("===>排序后的字符串："+result);
			
			encodeStr = result;
//			}
		}
		// 相当于encodeStr=encodeStr+constant
		encodeStr += constant;
		LOG.info("===>排序后的未加密字符串：" + encodeStr);
		LOG.info("===>加密后（token）：" + DigestUtils.md5Hex(encodeStr));
		if (!token.equals(DigestUtils.md5Hex(encodeStr))) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println("token不匹配");
			response.setStatus(500);
			return false;
		}

		return true;
		}
	

		@Override
		public void postHandle(HttpServletRequest request,
				HttpServletResponse response, Object handler,
				ModelAndView modelAndView) throws Exception {
			LOG.info("--->postHandle:"+request);
		}
	 
		@Override
		public void afterCompletion(HttpServletRequest request,
				HttpServletResponse response, Object handler, Exception ex)
				throws Exception {
			
		}
		
		public static void main(String[] args) {
			
			System.out.println(DigestUtils.md5Hex("113pddwangluoyonghutoken2018"));
		}
	}

