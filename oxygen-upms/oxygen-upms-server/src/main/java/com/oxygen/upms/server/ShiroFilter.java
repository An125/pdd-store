package com.oxygen.upms.server;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;


/**
 * shiroFilter
 * Created by yangxy on 2017/9/11.
 */
@WebFilter(
        filterName = "shiroFilter",
        urlPatterns = "/*",
        initParams = {
                @WebInitParam(name = "targetFilterLifecycle", value = "true")
        }
)
public class ShiroFilter extends org.springframework.web.filter.DelegatingFilterProxy {

}
