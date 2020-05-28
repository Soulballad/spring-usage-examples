package com.soulballad.usage.springboot.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.soulballad.usage.springboot.http.messsage.PropertiesHttpMessageConverter;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : config
 * @since ：2020/5/28 20:15
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 扩展 MessageConverter，将 PropertiesHttpMessageConverter 放在第一位
        converters.add(0, new PropertiesHttpMessageConverter());
    }
}
