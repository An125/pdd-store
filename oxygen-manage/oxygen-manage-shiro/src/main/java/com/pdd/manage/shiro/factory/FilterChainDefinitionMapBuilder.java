package com.pdd.manage.shiro.factory;

import java.util.LinkedHashMap;

/**
 * 
 * @作者： zhaoxin
 * @日期：2018年6月26日
 * @描述：通过工厂设计模式来创建一个 filterChainDefinitionMap。
 * 		因为在Shiro 的源代码中 filterChainDefinition 本身是一个linkedHashMap
 * 重新封装filterChainDefinitionMap好处：
 * 1.减少配置文件冗余；
 * 2.使 filterChainDefinitionMap 变得高度可配置化并将其从预配置中独立出来，进行单独配置或者后台设置
 */
public class FilterChainDefinitionMapBuilder {

	public LinkedHashMap<String, String> buildFilterChainDefinitionMap(){
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		//此处声明关系也可是已配置在数据库中的
		
		//和配置文件一样按顺序
		map.put("/login.html", "anon");
		map.put("/manage/login", "anon");
		map.put("/manage/logout", "logout");
		//样式可匿名访问
		map.put("/css/**", "anon");
		map.put("/data/**", "anon");
		map.put("/guo_js/**", "anon");
		map.put("/images/**", "anon");
		map.put("/js/**", "anon");
		map.put("/plugins/**", "anon");
		
		map.put("/**", "authc");
		
		return map;
	}
	
}
