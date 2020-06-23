package com.soulballad.usage.springcloud.service;

import com.soulballad.usage.springcloud.model.UserModel;

import java.util.Map;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : rest
 * @since ：2020/6/23 21:26
 */
public interface RestService {

    String param(String param);

    String params(Integer a, String b);

    String headers(String header1, String header2, Integer param);

    String pathVariables(String path1, String path2, String param);

    String from(String from);

    UserModel requestBodyMap(Map<String, Object> data, String param);

    Map<String, Object> requestBodyUser(UserModel userModel);
}
