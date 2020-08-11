package com.soulballad.usage.springcloud.controller;

import com.soulballad.usage.springcloud.channel.UserRabbitChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : multi output config
 * @since ：2020/6/15 22:20
 */
@RestController
public class MultiOutputController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MultiOutputController.class);

    @Autowired
    private UserRabbitChannel channel;

    @GetMapping(value = "/sendMultiOutput")
    @StreamListener(UserRabbitChannel.USER_INPUT)
    public void routeValues(Integer val) {
        LOGGER.info("ofc-stream-rabbitmq MultiOutputController routeValues val is [{}]", val);
        if (val < 10) {
            channel.sendMessage().send(message(val));
        } else {
            channel.sendOtherMessage().send(message(val));
        }
    }

    private <T> Message<T> message(T val) {
        LOGGER.info("ofc-stream-rabbitmq MultiOutputController message val is [{}]", val);
        return MessageBuilder.withPayload(val).build();
    }
}
