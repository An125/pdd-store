package com.pdd.orderMgr.webServer.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.pdd.common.core.exceptions.BizException;

/**
 * 
 * @作者： zhaoxin
 * @日期：2018年4月2日
 * @描述：处理系统异常拦截器
 */
public class ExceptionHandlerInterceptor implements HandlerInterceptor {
	private static Logger LOG = Logger.getLogger(ExceptionHandlerInterceptor.class);
	/**
	 * 在执行handler之前来执行的 用于用户认证校验、用户权限校验
	 *  false表示拦截，不向下执行；
	 *  true表示放行
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("--->异常拦截器preHandle");  
		return true;
	}

	/**
	 * 在执行handler返回modelAndView之前来执行 如果需要向页面提供一些公用 的数据或配置一些视图信息，使用此方法实现
	 * 从modelAndView入手
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		 System.out.println("--->异常拦截器postHandle");  
	}

	/**
	 * 执行handler之后执行此方法 作系统
	 * 统一异常处理，进行方法执行性能监控，在preHandle中设置一个时间点，在afterCompletion设置一个时间，两个时间点的差就是执行时长 
	 * 实现系统 统一日志记录
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		 System.out.println("--->异常拦截器afterCompletion");
		if(ex instanceof BizException) {
			LOG.error("业务异常："+ex.getMessage());
			
		}
		/*if(ex instanceof IllegalArgumentException) {
			LOG.error("参数异常："+ex.getMessage());
		}
		if(ex instanceof NullPointerException) {
			LOG.error("未知错误："+ex.getMessage());
		}*/
	}
	
}
