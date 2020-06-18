package com.soulballad.usage.springcloud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : resource server: 资源服务器配置
 * @since ：2020/6/18 22:05
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated().and().requestMatchers()
                // 配置需要保护的资源路径
                .antMatchers("/user/**");
    }
}
