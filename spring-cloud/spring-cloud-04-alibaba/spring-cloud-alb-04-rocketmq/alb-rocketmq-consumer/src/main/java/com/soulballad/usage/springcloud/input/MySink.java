package com.soulballad.usage.springcloud.input;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.binder.PollableMessageSource;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : input
 * @since ：2020/6/29 21:17
 */
public interface MySink {

    @Input("input1")
    SubscribableChannel input1();

    @Input("input2")
    SubscribableChannel input2();

    @Input("input3")
    SubscribableChannel input3();

    @Input("input4")
    SubscribableChannel input4();

    @Input("input5")
    PollableMessageSource input5();
}
