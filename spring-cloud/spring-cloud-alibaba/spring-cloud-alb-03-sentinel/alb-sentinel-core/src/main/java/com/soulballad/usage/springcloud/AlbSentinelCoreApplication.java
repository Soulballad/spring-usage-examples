package com.soulballad.usage.springcloud;

import com.alibaba.cloud.circuitbreaker.sentinel.SentinelCircuitBreakerFactory;
import com.alibaba.cloud.circuitbreaker.sentinel.SentinelConfigBuilder;
import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.soulballad.usage.springcloud.converter.JsonFlowRuleConverter;
import com.soulballad.usage.springcloud.exception.ExceptionUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;


@SpringBootApplication
public class AlbSentinelCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlbSentinelCoreApplication.class, args);
    }

    @Bean
    @SentinelRestTemplate(blockHandler = "handleException", blockHandlerClass = ExceptionUtils.class)
    public RestTemplate sentinelRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Converter myConverter() {
        return new JsonFlowRuleConverter();
    }

    @Bean
    public Customizer<SentinelCircuitBreakerFactory> defaultConfig() {
        return factory -> {
            factory.configureDefault(id -> new SentinelConfigBuilder().resourceName(id)
                    .rules(Collections.singletonList(new DegradeRule(id)
                            .setGrade(RuleConstant.DEGRADE_GRADE_RT).setTimeWindow(10)))
                    .build());
        };
    }
}
