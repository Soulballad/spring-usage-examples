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

    public HelloCommand() {
        super(HystrixCommandGroupKey.Factory.asKey("hello"), 100);
    }

    @Override
    protected String run() throws Exception {

        int time = new Random().nextInt(200);
        Thread.sleep(time);
        return "hello hystrix command!";
    }

    @Override
    protected String getFallback() {
        return "hystrix command request timeout";
    }
}
