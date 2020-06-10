package com.soulballad.usage.springboot.autoconfiguration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.soulballad.usage.springboot.hello.Hello;
import com.soulballad.usage.springboot.hello.HelloGirl;
import com.soulballad.usage.springboot.hello.HelloJava;
import com.soulballad.usage.springboot.hello.HelloWorld;
import com.soulballad.usage.springboot.properties.HelloProperties;
import com.soulballad.usage.springboot.template.HelloTemplate;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : AutoConfiguration
 * @since ：2020/5/28 22:13
 */
@Configuration
@EnableConfigurationProperties(HelloProperties.class)
public class HelloAutoConfiguration {

    @Bean
    public HelloTemplate helloTemplate(Hello hello, HelloProperties helloProperties) {
        return new HelloTemplate(hello, helloProperties);
    }

    @Bean
    @Primary
    @ConditionalOnProperty(prefix = HelloProperties.HELLO_PREFIX + ".world", name = "enable", havingValue = "true")
    public Hello helloWorld() {
        return new HelloWorld();
    }

    @Bean
    @ConditionalOnProperty(prefix = HelloProperties.HELLO_PREFIX + ".java", name = "enable", havingValue = "true")
    public Hello helloJava() {
        return new HelloJava();
    }

    @Bean
    @ConditionalOnProperty(prefix = HelloProperties.HELLO_PREFIX + ".girl", name = "enable", havingValue = "true")
    public Hello helloGirl() {
        return new HelloGirl();
    }
}
