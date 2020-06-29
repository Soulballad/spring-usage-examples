package com.soulballad.usage.springcloud.service;

import com.soulballad.usage.springcloud.outptu.MySource;
import org.apache.rocketmq.common.message.MessageConst;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : send service
 * @since ：2020/6/29 20:36
 */
@Service
public class SendService {

    @Autowired
    private MySource source;

    public void send(String msg) {
        source.output1().send(MessageBuilder.withPayload(msg).build());
    }

    public <T> void sendWithTags(T msg, String tag) {
        Message<T> message = MessageBuilder.createMessage(msg, new MessageHeaders(Stream.of(tag)
                .collect(Collectors.toMap(str -> MessageConst.PROPERTY_TAGS, String::toString))));
        source.output1().send(message);
    }

    public <T> void sendObject(T msg, String tag) {
        Message<T> message = MessageBuilder.withPayload(msg)
                .setHeader(MessageConst.PROPERTY_TAGS, tag)
                .setHeader(MessageHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .build();
        source.output1().send(message);
    }

    public <T> void sentTransactionalMsg(T msg, int num) {
        Message<T> message = MessageBuilder.withPayload(msg)
                .setHeader(MessageHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .setHeader("test", String.valueOf(num))
                .setHeader(RocketMQHeaders.TAGS, "binder")
                .build();
        source.output2().send(message);
    }
}
