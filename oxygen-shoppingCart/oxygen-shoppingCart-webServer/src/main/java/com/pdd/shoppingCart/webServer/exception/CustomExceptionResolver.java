package com.pdd.shoppingCart.webServer.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
/**
 * 
 * @作者： zhaoxin
 * @日期：2018年4月3日
 * @描述：自定义全局异常处理器(一个系统只有一个异常处理器)
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

	/**
	 * 前端控制器DispatcherServlet在进行HandlerMapping、调用HandlerAdapter执行Handler过程中，如果遇到异常就会执行此方法
	 * handler最终要执行的Handler，它的真实身份是HandlerMethod
	 * Exception ex就是接收到异常信息
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		
		/**
		 * 统一异常处理代码
		 */
		//针对系统自定义的CustomException异常，就可以直接从异常类中获取异常信息，将异常处理在错误页面展示
		//异常信息
		String msg = null;
		CustomException custExp = null;
		//如果ex是系统 自定义的异常，直接取出异常信息
		if(ex instanceof CustomException) {
			custExp=(CustomException) ex;
			msg = custExp.getExpMessage();
		}else {
			 // 如果是运行时异常，则取错误的堆栈信息
			ex.printStackTrace();// 向控制台上打印堆栈信息,输出异常
			
			StringWriter s = new StringWriter();
			PrintWriter printWriter = new PrintWriter(s);
			ex.printStackTrace(printWriter);
			msg = s.toString();
		}
		 
		// 写日志、发短信、发邮件
        // 在此省略这一步......
		
		
		// 返回一个友好的错误页面，并显示错误消息
		 ModelAndView modelAndView = new ModelAndView();
	     modelAndView.addObject("msg", msg);
	     modelAndView.setViewName("error");
		return modelAndView;
	}

}
