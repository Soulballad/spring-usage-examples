package com.soulballad.usage.springcloud;

import com.soulballad.usage.springcloud.input.MySink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;

@EnableBinding({MySink.class})
@SpringBootApplication
public class AlbRocketmqConsumerApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlbRocketmqConsumerApplication.class);

    @Bean
    public ConsumerCustomerRunner customerRunner() {
        return new ConsumerCustomerRunner();
    }

    public static void main(String[] args) {
        SpringApplication.run(AlbRocketmqConsumerApplication.class, args);
    }

    public static class ConsumerCustomerRunner implements CommandLineRunner {

        @Autowired
        private MySink mySink;

        @Override
        public void run(String... args) throws Exception {

            while (true) {
                mySink.input5().poll(m -> {
                    String payload = (String) m.getPayload();
                    LOGGER.info("alb-rocketmq-consumer input5 pull msg : {}", payload);
                }, new ParameterizedTypeReference<String>() {
                });
                Thread.sleep(2000);
            }
        }
    }
}
