package com.soulballad.usage.springboot.config;

import com.soulballad.usage.springboot.model.UserModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : config for dev environment
 * @since ：2020/7/12 21:02
 */
@Profile("prod")
@Configuration
public class ProdConfig {

    @Bean
    public UserModel userModel() {
        UserModel userModel = new UserModel();
        userModel.setName("lisi");
        return userModel;
    }
}
