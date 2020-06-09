package com.soulballad.usage.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @Value("asm.archaius.address")
    private String ASM_ARCHAIUS_PREFIX;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public UserVo queryUserInfo(Long userId) {
        return restTemplate.getForObject(USER_SERVICE_PREFIX + "/query/{id}", UserVo.class, userId);
    }

    @Override
    public UserVo updateUserPoint(UserVo userVo) {
        try {
            String jsonStr = new ObjectMapper().writeValueAsString(userVo);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
            HttpEntity httpEntity = new HttpEntity(jsonStr, headers);
            restTemplate.put(USER_SERVICE_PREFIX + "/update", httpEntity);
            return queryUserInfo(userVo.getId());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getOrderPoint() {
        return restTemplate.getForObject(ASM_ARCHAIUS_PREFIX + "/orderPoint", String.class);
    }
}
