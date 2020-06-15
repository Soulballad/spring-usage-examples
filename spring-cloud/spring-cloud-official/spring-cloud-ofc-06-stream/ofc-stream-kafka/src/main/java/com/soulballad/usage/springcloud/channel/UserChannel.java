package com.soulballad.usage.springcloud.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote :
 * @since ：2020/6/15 21:49
 */
public interface UserChannel {

    /**
     * 信道名称
     */
    String USER_INPUT = "user_input";

    /**
     * 信道名称
     */
    String USER_OUTPUT = "user_output";

    /**
     * 发送消息的 channel
     */
    @Output(USER_OUTPUT)
    MessageChannel sendUserMessage();

    /**
     * 接收消息的 channel
     */
    @Input(USER_INPUT)
    SubscribableChannel receiveMessage();
}
