package com.oxygen.common.plugin;

import com.oxygen.common.util.AESUtil;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 支持加密配置文件插件
 * Created by yangxy on 2017/9/4.
 */
public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
	private Logger LOG = Logger.getLogger(EncryptPropertyPlaceholderConfigurer.class);
	
	private String[] propertyNames = {
		"master.jdbc.password","generator.jdbc.password"
	};

	/**
	 * 解密指定propertyName的加密属性值
	 * @param propertyName
	 * @param propertyValue
	 * @return
	 */
	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		for (String p : propertyNames) {
			if (p.equalsIgnoreCase(propertyName)) {
				try {
					return AESUtil.AESDecode(propertyValue);
				} catch (Exception e) {
					LOG.error(e.getMessage());
				}
			}
		}
		return super.convertProperty(propertyName, propertyValue);
	}

}
