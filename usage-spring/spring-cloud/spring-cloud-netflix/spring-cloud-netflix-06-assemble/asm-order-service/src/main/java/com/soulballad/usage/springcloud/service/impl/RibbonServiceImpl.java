package com.soulballad.usage.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.soulballad.usage.springcloud.service.RibbonService;
import com.soulballad.usage.springcloud.vo.UserVo;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote :
 * @since ：2020/6/6 22:21
 */
@Service
public class RibbonServiceImpl implements RibbonService {

    private static final String USER_SERVICE_PREFIX = "http://asm-user-service" + "/user";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public UserVo queryUserInfo(Long userId) {
        return restTemplate.getForObject(USER_SERVICE_PREFIX + "/query/{id}", UserVo.class, userId);
    }

    @Override
    public UserVo updateUserPoint(UserVo userVo) {
        restTemplate.put(USER_SERVICE_PREFIX + "/update", UserVo.class);
        return queryUserInfo(userVo.getId());
    }
}
