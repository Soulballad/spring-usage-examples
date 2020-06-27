package com.soulballad.usage.springcloud;

import com.alibaba.cloud.dubbo.annotation.DubboTransported;
import com.soulballad.usage.springcloud.model.UserModel;
import com.soulballad.usage.springcloud.service.RestService;
import com.soulballad.usage.springcloud.service.UserService;
import com.soulballad.usage.springcloud.service.feign.DubboFeignService;
import com.soulballad.usage.springcloud.service.feign.FeignService;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EnableCaching
@EnableScheduling
@EnableFeignClients
@EnableDiscoveryClient
@EnableAutoConfiguration
public class AlbDubboConsumerApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlbDubboConsumerApplication.class);

    public static void main(String[] args) {
        new SpringApplicationBuilder(AlbDubboConsumerApplication.class)
                .properties("spring.profiles.active=nacos").run(args);
    }

    @LoadBalanced
    @DubboTransported
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Value("${provider.application.name}")
    private String providerAppName;

    @Reference
    private UserService userService;

    @Reference(version = "1.0.0", protocol = "dubbo")
    private RestService restService;

    @Autowired
    @Lazy
    private FeignService feignService;

    @Autowired
    @Lazy
    private DubboFeignService dubboFeignService;

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public ApplicationRunner userRunner() {
        return args -> {
            UserModel user = new UserModel();
            user.setId(1L);
            user.setName("soulballad");
            user.setAge(26);

            boolean save = userService.save(user);
            List<UserModel> list = userService.findAll();
            boolean delete = userService.delete(user.getId());

            LOGGER.info("alb-dubbo-consumer userRunner save result: {}", save);
            LOGGER.info("alb-dubbo-consumer userRunner list result: {}", Arrays.toString(list.toArray()));
            LOGGER.info("alb-dubbo-consumer userRunner delete result: {}", delete);
        };
    }

    @Bean
    public ApplicationRunner callerRunner() {
        return args -> {
            callParam();
            callParams();
            callHeaders();
            callPathVariables();
            callRequestBodyMap();
        };
    }

    private void callParam() {
        LOGGER.info("alb-dubbo-consumer callParam restService result: {}", restService.param("a"));
        LOGGER.info("alb-dubbo-consumer callParam feignService result: {}", feignService.param("a"));
        LOGGER.info("alb-dubbo-consumer callParam dubboFeignService result: {}", dubboFeignService.param("a"));
        LOGGER.info("alb-dubbo-consumer callParam restTemplate result: {}", restTemplate.getForObject("http://" + providerAppName + "/param?param=a", String.class));
    }

    private void callParams() {
        LOGGER.info("alb-dubbo-consumer callParams restService result: {}", restService.params(1, "a"));
        LOGGER.info("alb-dubbo-consumer callParams feignService result: {}", feignService.params(1, "a"));
        LOGGER.info("alb-dubbo-consumer callParams dubboFeignService result: {}", dubboFeignService.params(1, "a"));
    }

    private void callHeaders() {
        LOGGER.info("alb-dubbo-consumer callHeaders restService result: {}", restService.headers("a", "b", 10));
        LOGGER.info("alb-dubbo-consumer callHeaders feignService result: {}", feignService.headers("a", "b", 10));
        LOGGER.info("alb-dubbo-consumer callHeaders dubboFeignService result: {}", dubboFeignService.headers("a", "b", 10));
    }

    private void callPathVariables() {
        LOGGER.info("alb-dubbo-consumer callPathVariables restService result: {}", restService.pathVariables("a", "b", "10"));
        LOGGER.info("alb-dubbo-consumer callPathVariables feignService result: {}", feignService.pathVariables("a", "b", "10"));
        LOGGER.info("alb-dubbo-consumer callPathVariables dubboFeignService result: {}", dubboFeignService.pathVariables("a", "b", "10"));
        LOGGER.info("alb-dubbo-consumer callPathVariables restTemplate result: {}", restTemplate.getForObject("http://" + providerAppName + "/pathVariables/{p1}/{p2}?val=10", String.class, "a", "b"));
    }

    private void callRequestBodyMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("name", "soulballad");
        map.put("age", 26);

        LOGGER.info("alb-dubbo-consumer callRequestBodyMap restService result: {}", restService.requestBodyMap(map, "helloRest"));
        LOGGER.info("alb-dubbo-consumer callRequestBodyMap feignService result: {}", feignService.requestBodyMap(map, "helloFeign"));
        LOGGER.info("alb-dubbo-consumer callRequestBodyMap dubboFeignService result: {}", dubboFeignService.requestBodyMap(map, "helloDubbo"));
        LOGGER.info("alb-dubbo-consumer callRequestBodyMap restTemplate result: {}", restTemplate.postForObject("http://" + providerAppName + "/request/body/map?param=hello", map, UserModel.class));
    }
}
