package com.oxygen.shop.server;

import javax.servlet.DispatcherType;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;


/**
 * 强制进行转码过滤器
 * Created by yangxy on 2017/9/11.
 */
@WebFilter(
        filterName = "CharacterEncodingFilter",
        urlPatterns = "/*",
        dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD},
        initParams = {
                @WebInitParam(name = "encoding", value = "UTF-8")
        }
)
public class CharacterEncodingFilter extends org.springframework.web.filter.CharacterEncodingFilter {

}
