package com.soulballad.usage.springcloud.service;

import com.soulballad.usage.springcloud.model.Msg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : receive
 * @since ：2020/6/29 21:18
 */
@Service
public class ReceiveService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReceiveService.class);

    @StreamListener("input1")
    public void receiveInput1(String receiveMsg) {
        LOGGER.info("alb-rocketmq-consumer input1 receive : {}", receiveMsg);
    }

    @StreamListener("input2")
    public void receiveInput2(String receiveMsg) {
        LOGGER.info("alb-rocketmq-consumer input2 receive : {}", receiveMsg);
    }

    @StreamListener("input3")
    public void receiveInput3(@Payload Msg msg) {
        LOGGER.info("alb-rocketmq-consumer input3 receive : {}", msg);
    }

    @StreamListener("input4")
    public void receiveTransactionMsg(String receiveMsg) {
        LOGGER.info("alb-rocketmq-consumer input4 receive : {}", receiveMsg);
    }
}
