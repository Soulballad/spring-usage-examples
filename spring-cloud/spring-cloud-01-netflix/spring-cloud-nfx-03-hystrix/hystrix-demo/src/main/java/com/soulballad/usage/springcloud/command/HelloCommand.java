package com.soulballad.usage.springcloud.command;

import java.util.Random;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : hystrix command
 * @since ：2020/6/1 21:20
 */
public class HelloCommand extends HystrixCommand<String> {

    /**
     * 继承自 HystrixCommand，定义要支持降级的方法
     */
    public HelloCommand() {
        super(HystrixCommandGroupKey.Factory.asKey("hello"), 100);
    }

    /**
     * 正常情况下执行
     */
    @Override
    protected String run() throws Exception {

        int time = new Random().nextInt(200);
        Thread.sleep(time);
        return "hello hystrix command!";
    }

    /**
     * 被降级后的执行
     */
    @Override
    protected String getFallback() {
        return "hystrix command request timeout";
    }
}
