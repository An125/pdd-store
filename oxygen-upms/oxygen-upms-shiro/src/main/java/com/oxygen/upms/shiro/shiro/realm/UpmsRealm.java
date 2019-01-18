package com.oxygen.upms.shiro.shiro.realm;

import com.oxygen.common.util.PropertiesFileUtil;
import com.oxygen.upms.dao.model.UpmsPermission;
import com.oxygen.upms.dao.model.UpmsRole;
import com.oxygen.upms.dao.model.UpmsUser;
import com.oxygen.upms.rpc.api.UpmsApiService;
import com.xiaoleilu.hutool.util.StrUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.oxygen.common.util.OxySecureUtil.encryptPassword;

/**
 * 用户认证和授权
 * Created by yangxy on 2017/1/20.
 */
public class UpmsRealm extends AuthorizingRealm {

    private static Logger _log = LoggerFactory.getLogger(UpmsRealm.class);

    @Autowired
    private UpmsApiService upmsApiService;

    /**
     * 授权：验证权限时调用
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        UpmsUser upmsUser = upmsApiService.selectUpmsUserByUsername(username);
        // 当前用户所有角色
        List<UpmsRole> upmsRoles = upmsApiService.selectUpmsRoleByUpmsUserId(upmsUser.getUserId());
        Set<String> roles = new HashSet<String>();
        for (UpmsRole upmsRole : upmsRoles) {
            if (StrUtil.isNotBlank(upmsRole.getName())) {
                roles.add(upmsRole.getName());
            }
        }
        // 当前用户所有权限
        List<UpmsPermission> upmsPermissions = upmsApiService.selectUpmsPermissionByUpmsUserId(upmsUser.getUserId());
        Set<String> permissions = new HashSet<String>();
        for (UpmsPermission upmsPermission : upmsPermissions) {
            if (StrUtil.isNotBlank(upmsPermission.getPermissionValue())) {
                permissions.add(upmsPermission.getPermissionValue());
            }
        }

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permissions);
        simpleAuthorizationInfo.setRoles(roles);
        return simpleAuthorizationInfo;
    }

    /**
     * 认证：登录时调用
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        // client无密认证
        String upmsType = PropertiesFileUtil.getInstance("oxygen-upms-shiro").get("oxygen.upms.type");
        if ("client".equals(upmsType)) {
            return new SimpleAuthenticationInfo(username, password, getName());
        }

        // 查询用户信息
        UpmsUser upmsUser = upmsApiService.selectUpmsUserByUsername(username);

        if (null == upmsUser) {
            throw new UnknownAccountException();
        }
        if (!upmsUser.getPassword().equals(encryptPassword(password, upmsUser.getSalt()))) {
            throw new IncorrectCredentialsException();
        }
        if (upmsUser.getLocked() == 1) {
            throw new LockedAccountException();
        }

        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
