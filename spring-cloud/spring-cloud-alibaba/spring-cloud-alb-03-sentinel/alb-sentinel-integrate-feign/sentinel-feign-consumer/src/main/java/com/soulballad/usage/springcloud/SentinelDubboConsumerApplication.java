package com.soulballad.usage.springcloud;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.SentinelRpcException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.soulballad.usage.springcloud.service.FooServiceConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

@SpringBootApplication
public class SentinelDubboConsumerApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SentinelDubboConsumerApplication.class);

    @Bean
    public FooServiceConsumer serviceConsumer() {
        return new FooServiceConsumer();
    }

    public static void main(String[] args) {

        FlowRule flowRule = new FlowRule();
        flowRule.setResource("com.soulballad.usage.springcloud.service.FooService:hello(java.lang.String)");
        flowRule.setCount(10);
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        flowRule.setLimitApp("default");
        FlowRuleManager.loadRules(Collections.singletonList(flowRule));

        ApplicationContext applicationContext = SpringApplication.run(SentinelDubboConsumerApplication.class, args);
        FooServiceConsumer serviceConsumer = applicationContext.getBean(FooServiceConsumer.class);

        for (int i = 0; i < 15; i++) {
            try {
                String message = serviceConsumer.hello("sentinel times : " + i);
                LOGGER.info("sentinel-feign-consumer main result : " + message);
            } catch (SentinelRpcException e) {
                LOGGER.error("sentinel-feign-consumer main error times: " + i, e);
            }
        }
    }
}
