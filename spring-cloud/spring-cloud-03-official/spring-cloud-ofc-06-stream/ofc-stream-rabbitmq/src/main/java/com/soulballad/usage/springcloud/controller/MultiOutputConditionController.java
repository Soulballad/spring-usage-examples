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
 * @apiNote : multi output condition config
 * @since ：2020/6/15 22:24
 */
@RestController
public class MultiOutputConditionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MultiOutputController.class);

    @Autowired
    private UserRabbitChannel channel;

    @GetMapping(value = "/sendConditionOutput")
    @StreamListener(target = UserRabbitChannel.USER_INPUT, condition = "payload < 10")
    public void routeValuesOutput(Integer val) {
        channel.sendMessage().send(message(val));
    }

    @GetMapping(value = "/sendConditionOtherOutput")
    @StreamListener(target = UserRabbitChannel.USER_INPUT, condition = "payload >= 10")
    public void routeValuesOtherOutput(Integer val) {
        channel.sendOtherMessage().send(message(val));
    }

    private <T> Message<T> message(T val) {
        LOGGER.info("ofc-stream-rabbitmq MultiOutputConditionController message val is [{}]", val);
        return MessageBuilder.withPayload(val).build();
    }
}
