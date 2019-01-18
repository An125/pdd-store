package com.pdd.manage.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.oxygen.common.util.OxySecureUtil;
import com.pdd.manage.api.service.UpmsUserService;
import com.pdd.manage.common.vo.UserVo;

/**
 * 
 * @作者： zhaoxin
 * @日期：2018年6月21日
 * @描述：自定义realm
 */
public class CustomRealm extends AuthorizingRealm {

	private static Logger LOG = LoggerFactory.getLogger(CustomRealm.class);

	// 注入service
	@Autowired
	private UpmsUserService upmsUserService;


	/**
	 * 认证 realm的认证方法，从数据库查询用户信息：登录时调用
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		//1. 把 AuthenticationToken 转换为 UsernamePasswordToken
		UsernamePasswordToken upToken = (UsernamePasswordToken)token;
		//2. 从 UsernamePasswordToken 中来获取 username和password
		String username = upToken.getUsername();
		String password = new String((char[])upToken.getPassword());
		
		UserVo userVo;
		try {
			//3. 调用数据库的方法, 从数据库中查询 username 对应的用户记录
			userVo = upmsUserService.findUpmsUserByUsername(username);
			//4. 若用户不存在, 则可以抛出 UnknownAccountException 异常
			if(userVo==null) {
				LOG.info("--->用户不存在!");
				throw new UnknownAccountException("用户不存在!");
			}
			//5.若密码不正确，则抛出IncorrectCredentialsException异常
			if(!userVo.getPassword().equals(OxySecureUtil.encryptPassword(password, userVo.getSalt()))) {
				LOG.info("--->密码错误！");
				System.out.println("------>盐值："+userVo.getSalt());
				System.out.println("------>密码："+OxySecureUtil.encryptPassword(password, userVo.getSalt()));
				throw new IncorrectCredentialsException("密码错误！");
			}
			if(userVo.getLocked()==1) {
				LOG.info("--->用户被锁定！");
				throw new LockedAccountException("用户被锁定！");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//6. 根据用户的情况, 来构建 AuthenticationInfo 对象并返回. 通常使用的实现类为: SimpleAuthenticationInfo
		//realmName: 当前 realm 对象的 name. 调用父类的 getName() 方法即可
		String realmName = getName();
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, realmName);
		return info;
		
		
	}
	
	
	/**
	 * 授权：验证权限时调用
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		return null;
	}

}
