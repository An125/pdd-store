package com.oxygen.common.util;

import com.xiaoleilu.hutool.io.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.io.File;

/**
 * 启动解压oxygenAdmin-x.x.x.jar到resources目录
 * Created by yangxy on 2016/12/18.
 */
public class OxygenAdminUtil implements InitializingBean, ServletContextAware {

    private static Logger _log = LoggerFactory.getLogger(OxygenAdminUtil.class);

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        _log.info("===== 开始解压oxygen-admin =====");
        String version = PropertiesFileUtil.getInstance("oxygen-admin").get("oxygen.admin.version");
        _log.info("oxygen-admin.jar 版本: {}", version);
        String jarPath = servletContext.getRealPath("/WEB-INF/lib/oxygen-admin-" + version + ".jar");
        _log.info("oxygen-admin.jar 包路径: {}", jarPath);
        String resources = servletContext.getRealPath("/") + "/resources/oxygen-admin";
        if(!FileUtil.exist(resources)){
            _log.info("oxygen-admin.jar 解压到: {}", resources);
            JarUtil.decompress(jarPath, resources);
            _log.info("===== 解压oxygen-admin完成 =====");
        }else{
            _log.info("===== oxygen-admin已存在 =========");
        }
    }

}
