package com.soulballad.usage.springcloud.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.soulballad.usage.springcloud.model.UserModel;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : proxy
 * @since ：2020/5/31 22:27
 */
@Service
public class UserServiceProxy implements UserService {

    // user-service-provider 的 application.properties 中 spring.application.name + prefix
    private static final String USER_PROVIDER_PREFIX = "http://netflix-eureka-client-provider" + "/provider/user";

    // 在 UserServiceConsumerApplication 进行声明
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<UserModel> findAll() {
        UserModel[] userArray = restTemplate.getForObject(USER_PROVIDER_PREFIX + "/list", UserModel[].class);
        return Arrays.asList(userArray != null ? userArray : new UserModel[0]);
    }

    @Override
    public UserModel findById(Long id) {
        return restTemplate.getForObject(USER_PROVIDER_PREFIX + "/query/{id}", UserModel.class, id);
    }

    @Override
    public UserModel add(UserModel userModel) {
        return restTemplate.postForObject(USER_PROVIDER_PREFIX + "/add", userModel, UserModel.class);
    }

    @Override
    public UserModel update(UserModel userModel) {
        restTemplate.put(USER_PROVIDER_PREFIX + "/update", userModel);
        return findById(userModel.getId());
    }

    @Override
    public UserModel deleteById(Long id) {
        UserModel userModel = findById(id);
        restTemplate.delete(USER_PROVIDER_PREFIX + "/delete/{id}", id);
        return userModel;
    }
}
