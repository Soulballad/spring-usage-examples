package com.soulballad.usage.springcloud;

import com.soulballad.usage.springcloud.channel.UserRabbitChannel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(UserRabbitChannel.class)
public class OfcStreamRabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(OfcStreamRabbitmqApplication.class, args);
    }
}
