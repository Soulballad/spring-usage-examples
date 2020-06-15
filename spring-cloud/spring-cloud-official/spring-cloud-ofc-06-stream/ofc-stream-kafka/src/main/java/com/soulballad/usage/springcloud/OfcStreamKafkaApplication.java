package com.soulballad.usage.springcloud;

import com.soulballad.usage.springcloud.channel.UserChannel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(UserChannel.class)
public class OfcStreamKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(OfcStreamKafkaApplication.class, args);
    }
}
