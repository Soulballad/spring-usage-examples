package com.soulballad.usage.springcloud.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : channel
 * @since ：2020/6/15 22:16
 */
public interface UserRabbitChannel {

    String USER_INPUT = "user_input";
    String USER_OUTPUT = "user_output";

    @Input(USER_INPUT)
    SubscribableChannel receiveMessage();

    @Output(USER_OUTPUT)
    MessageChannel sendMessage();

    @Output
    MessageChannel sendOtherMessage();
}
