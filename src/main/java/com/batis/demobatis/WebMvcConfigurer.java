package com.batis.demobatis;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
/**
 * @projectName: demebatis1.0
 * @author: Administrator
 * @date: 2020年05月24日 11:36
 * @version: 1.0
 */

/**
 * 图片映射虚拟路径，
 * 第一种重写addResourceHandlers
 * 第二种在配置文件里映射yml
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurationSupport {

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        /* 访问路径的前缀. */
        registry.addResourceHandler("/images/**")
                /* 绝对路径 .*/
                .addResourceLocations("file:D://checkimage/");
        super.addResourceHandlers(registry);
    }
}
