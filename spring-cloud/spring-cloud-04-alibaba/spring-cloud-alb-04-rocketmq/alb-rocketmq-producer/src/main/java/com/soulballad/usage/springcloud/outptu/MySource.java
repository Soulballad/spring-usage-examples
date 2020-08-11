package com.soulballad.usage.springcloud.outptu;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : source
 * @since ：2020/6/29 20:35
 */
public interface MySource {

    @Output("output1")
    MessageChannel output1();

    @Output("output2")
    MessageChannel output2();

    @Output("output3")
    MessageChannel output3();
}
