package com.soulballad.usage.springboot.hello;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote :
 * @since ：2020/5/28 22:04
 */
public class HelloGirl implements Hello {
    @Override
    public String hello() {
        return "hello girl";
    }
}
