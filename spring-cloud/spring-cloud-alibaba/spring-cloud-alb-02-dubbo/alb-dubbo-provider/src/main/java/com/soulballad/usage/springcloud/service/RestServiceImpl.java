package com.soulballad.usage.springcloud.service;

import com.soulballad.usage.springcloud.model.UserModel;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : rest service
 * @since ：2020/6/23 21:51
 */
@Service(version = "1.0.0")
@RestController
public class RestServiceImpl implements RestService {

    @Override
    @GetMapping(value = "/param")
    public String param(@RequestParam String param) {
        return "alb-dubbo-provider param : " + param;
    }

    @Override
    @PostMapping(value = "/params")
    public String params(@RequestParam Integer a, @RequestParam String b) {
        return "alb-dubbo-provider params : " + a + ";" + b;
    }

    @Override
    @GetMapping(value = "/headers")
    public String headers(@RequestHeader("h1") String header1, @RequestHeader("h2") String header2, @RequestParam("val") Integer param) {
        return "alb-dubbo-provider headers : " + header1 + ";" + header2 + ";" + param;
    }

    @Override
    @GetMapping(value = "/pathVariables/{p1}/{p2}")
    public String pathVariables(@PathVariable("p1") String path1, @PathVariable("p2") String path2, @RequestParam("val") String param) {
        return "alb-dubbo-provider pathVariables : " + path1 + ";" + path2 + ";" + param;
    }

    @Override
    @PostMapping(value = "/form")
    public String form(@RequestParam("form") String form) {
        return "alb-dubbo-provider form : " + form;
    }

    @Override
    @PostMapping(value = "/requestBodyMap", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserModel requestBodyMap(@RequestBody Map<String, Object> data, @RequestParam("param") String param) {
        UserModel user = new UserModel();
        user.setId(((Integer) data.get("id")).longValue());
        user.setName((String) data.get("name"));
        user.setAge((Integer) data.get("age"));
        return user;
    }

    @Override
    @PostMapping(value = "/requestBodyUser", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<String, Object> requestBodyUser(@RequestBody UserModel userModel) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", userModel.getId());
        map.put("name", userModel.getName());
        map.put("age", userModel.getAge());
        return map;
    }
}
