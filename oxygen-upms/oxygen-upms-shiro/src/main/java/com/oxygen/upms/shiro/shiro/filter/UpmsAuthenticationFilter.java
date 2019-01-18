package com.oxygen.upms.shiro.shiro.filter;

import com.oxygen.common.util.PropertiesFileUtil;
import com.oxygen.upms.common.constant.UpmsConstant;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.net.URLEncoder;

/**
 * Created by yangxy on 2017/9/8.
 */
public class UpmsAuthenticationFilter extends AuthenticationFilter {
    private final static Logger _log = LoggerFactory.getLogger(UpmsAuthenticationFilter.class);

    /**
     * 判断用户是否已登录
     * 若未登录再判断是否请求的是登录地址，是登录地址则放行，否则返回true终止filter链。
     *
     * @param request
     * @param response
     * @param mappedValue
     * @return
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        Subject subject = getSubject(request, response);
        Session session = subject.getSession();
        // 判断请求类型
        String upmsType = PropertiesFileUtil.getInstance("oxygen-upms-shiro").get("oxygen.upms.type");
        session.setAttribute(UpmsConstant.UPMS_TYPE, upmsType);
        if ("server".equals(upmsType)) {
            return subject.isAuthenticated();
        }
        return false;
    }


    /**
     * 如果用户未登录，即AuthenticatingFilter中的isAccessAllowed判断了用户未登录
     * 若用户请求的不是登录地址，则跳转到登录地址，并且返回true直接终止filter链。
     * 若用户请求的是登录地址，若果是post请求则进行登录操作，
     * 由AuthenticatingFilter中提供的executeLogin方法执行。否则直接通过继续执行filter链，
     * 并最终跳转到登录页面（因为用户请求的就是登录地址，若不是登录地址也会重定向到登录地址）
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        StringBuffer sso_server_url = new StringBuffer(PropertiesFileUtil.getInstance("oxygen-upms-shiro").get("oxygen.upms.sso.server.url"));
        // server需要登录
        String upmsType = PropertiesFileUtil.getInstance("oxygen-upms-shiro").get("oxygen.upms.type");
        if ("server".equals(upmsType)) {
            WebUtils.toHttp(response).sendRedirect(sso_server_url.append("/sso/login").toString());
            return false;
        }
        sso_server_url.append("/sso/index").append("?").append("appid").append("=").append(PropertiesFileUtil.getInstance("oxygen-upms-shiro").get("oxygen.upms.appID"));
        // 回跳地址
        HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
        StringBuffer backurl = httpServletRequest.getRequestURL();
        String queryString = httpServletRequest.getQueryString();
        if (StringUtils.isNotBlank(queryString)) {
            backurl.append("?").append(queryString);
        }
        sso_server_url.append("&").append("backurl").append("=").append(URLEncoder.encode(backurl.toString(), "utf-8"));
        WebUtils.toHttp(response).sendRedirect(sso_server_url.toString());
        return false;
    }


    @Override
    protected void issueSuccessRedirect(ServletRequest request, ServletResponse response) throws Exception {
        WebUtils.issueRedirect(request, response, getSuccessUrl(), null, true);
    }
}
