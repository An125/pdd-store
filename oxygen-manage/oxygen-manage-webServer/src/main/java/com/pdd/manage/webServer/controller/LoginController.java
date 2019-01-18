package com.pdd.manage.webServer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdd.manage.api.service.UpmsUserService;
import com.pdd.manage.common.params.UserParams;
import com.pdd.manage.webServer.exception.CustomException;

/**
 * 
 * @作者： zhaoxin
 * @日期：2018年3月21日
 * @描述：登录和退出
 * 通过@RequestMapping注解可以定义不同的处理器映射规则：
 * 1.URL路径映射；
 * 2.窄化请求映射：在class上添加@RequestMapping(url)指定通用请求前缀， 限制此类下的所有方法请求url必须以请求前缀开头，通过此方法对url进行分类管理
 */
@RestController
//定义url的根路径，访问时根路径+方法的url
@RequestMapping("/manage")
public class LoginController {

	private static Logger LOG = Logger.getLogger(LoginController.class);
	@Autowired
	private UpmsUserService upmsUserService;
	
	/**
	 * 
	 * @作者： zhaoxin
	 * @日期：2018年3月20日
	 * @描述：登录
	 */
	//登录提交地址，和spring-shiro.xml中配置的loginUrl一致
	@RequestMapping("/login")
	public String login(UserParams userParams,HttpServletRequest request,HttpServletResponse response) throws Exception{
		if(StringUtils.isBlank(userParams.getUsername())) {
			throw new CustomException("帐号不能为空！");
		}
		if(StringUtils.isBlank(userParams.getPassword())) {
			throw new CustomException("密码不能为空！");
		}
		//得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
		Subject currentUser  = SecurityUtils.getSubject();
		
		// 把用户名和密码封装为 UsernamePasswordToken 对象
		UsernamePasswordToken token = new UsernamePasswordToken(userParams.getUsername(), userParams.getPassword());
			
		try {
			if(!currentUser.isAuthenticated()) {
				token.setRememberMe(true);
			}else {
				token.setRememberMe(false);
			}
			// 执行登录
			currentUser.login(token);
		} catch (UnknownAccountException e) {
			throw new CustomException("帐号不存在！");
		}catch (IncorrectCredentialsException e) {
			throw new CustomException("密码错误！");
		}catch (LockedAccountException e) {
			throw new CustomException("帐号已锁定！");
		// 所有认证时异常的父类
		}catch (AuthenticationException e) {
			LOG.info(e.getMessage());
		}
		
		return "index.html";
		
		
	}
	
}
