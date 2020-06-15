package com.soulballad.usage.springcloud.controller;

import com.soulballad.usage.springcloud.channel.UserChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : controller
 * @since ：2020/6/15 21:53
 */
@RestController
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    @Qualifier(UserChannel.USER_OUTPUT)
    private MessageChannel userMessageChannel;

    @GetMapping(value = "/sendMessage")
    public String sendMessage(String content) {
        boolean isSuccess = userMessageChannel.send(MessageBuilder.withPayload(content).build());
        return isSuccess ? "success" : "failed";
    }

    @StreamListener(UserChannel.USER_INPUT)
    public void receive(Message<String> message) {
        LOGGER.info("ofc-stream-kafka receive message is [{}]", message.getPayload());
    }
}
