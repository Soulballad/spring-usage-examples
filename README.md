# spring-usage-examples

spring 组件的使用方法，主要包含 Spring Boot 和 Spring Cloud。

1. Spring Boot：基于 **2.2.0.RELEASE**；
2. Spring Cloud：基于 **Hoxton.RELEASE**。包含四种实现：
   - **spring-cloud-netflix**: Netflix 实现的 spring cloud 组件；
   - **spring-cloud-alibaba**: Alibaba 实现的 spring cloud 组件；
   - **spring-cloud-official**: Spring 官方实现的组件；
   - **spring-cloud-consul**: Consul 实现的 spring cloud 组件；
3. [码云](https://gitee.com/soulballad/spring-usage-examples)

*springboot和springcloud版本对应关系* 
https://start.spring.io/actuator/info



## [Spring Boot](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-boot)

- [spring-boot-demo](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-boot/spring-boot-01-demo): 第一个 Spring Boot 的应用
- [spring-boot-config](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-boot/spring-boot-02-config): Spring Boot ConfigurationProperties 的使用
- [spring-boot-webmvc](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-boot/spring-boot-03-webmvc): 基于 Spring Boot 的 webmvc 实现
- [spring-boot-bean-validate](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-boot/spring-boot-04-bean-validate): Spring Boot 的输入参数校验，支持国际化和自定义校验规则
- [spring-boot-banner](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-boot/spring-boot-05-basis/spring-boot-banner): Spring Boot 自定义 Banner
- [spring-boot-actuator](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-boot/spring-boot-05-basis/spring-boot-actuator): Spring Boot Actuator 监控
- [spring-boot-admin](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-boot/spring-boot-05-basis/spring-boot-admin): Spring Boot Admin
- [spring-boot-email](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-boot/spring-boot-05-basis/spring-boot-email): Spring Boot Email 邮件发送
- [spring-boot-profile](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-boot/spring-boot-05-basis/spring-boot-profile): Spring Boot Profile 环境隔离
- [spring-boot-data-jpa](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-boot/spring-boot-06-jdbc/spring-boot-data-jpa): Spring Boot Jpa 操作数据库
- [spring-boot-multi-datasource](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-boot/spring-boot-06-jdbc/spring-boot-multi-datasource): Spring Boot Jpa 配置多数据源
- [spring-boot-jdbc-template](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-boot/spring-boot-06-jdbc/spring-boot-jdbc-template): Spring Boot  JdbcTemplate 操作数据库
- [spring-boot-mybatis](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-boot/spring-boot-06-jdbc/spring-boot-mybatis): Spring Boot 整合 Mybatis 操作数据库
- [spring-boot-webflux-demo](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-boot/spring-boot-07-webflux/spring-boot-webflux-demo): Spring Boot Web 响应式编程，使用 Controller
- [spring-boot-webflux-router](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-boot/spring-boot-07-webflux/spring-boot-webflux-router): Spring Boot Web 响应式编程，使用 Router 路由
- [spring-boot-template-freemarker](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-boot/spring-boot-08-template/spring-boot-template-freemarker): Spring Boot 视图技术，使用 Freemarker 
- [spring-boot-template-thymeleaf](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-boot/spring-boot-08-template/spring-boot-template-thymeleaf): Spring Boot 视图技术，使用 Thymeleaf
- [spring-boot-template-groovy](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-boot/spring-boot-08-template/spring-boot-template-groovy): Spring Boot 视图技术，使用 groovy
- [spring-boot-template-beetl](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-boot/spring-boot-08-template/spring-boot-template-beetl): Spring Boot 视图技术，使用 beetl
- [spring-boot-ui-swagger](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-boot/spring-boot-09-ui/spring-boot-ui-swagger): Spring Boot 集成 Swagger 
- [spring-boot-ui-knife4j](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-boot/spring-boot-09-ui/spring-boot-ui-knife4j): Spring Boot 集成 knife4j 
- [spring-boot-message-converter](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-boot/spring-boot-10-message-converter): 自定义 Spring Boot 消息转换器
- [spring-boot-custom-starter](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-boot/spring-boot-11-custom-starter): 自定义 Spring Boot Starter
- ...





## [Spring Cloud](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-cloud)

### [spring-cloud-netflix](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-cloud/spring-cloud-netflix)

- [spring-cloud-nfx-01-archaius](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-cloud/spring-cloud-netflix/spring-cloud-nfx-01-archaius): Spring Cloud 整合 Archaius 实现的分布式配置中心方案
- [spring-cloud-nfx-02-eureka](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-cloud/spring-cloud-netflix/spring-cloud-nfx-02-eureka): Spring Cloud 整合 Eureka 实现的分布式注册中心方案
- [spring-cloud-nfx-03-hystrix](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-cloud/spring-cloud-netflix/spring-cloud-nfx-03-hystrix): Spring Cloud 整合 Hystrix 实现的分布式限流、熔断方案
- [spring-cloud-nfx-04-ribbon](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-cloud/spring-cloud-netflix/spring-cloud-nfx-04-ribbon): Spring Cloud 整合 Ribbon实现的分布式负载均衡方案
- [spring-cloud-nfx-05-zuul](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-cloud/spring-cloud-netflix/spring-cloud-nfx-05-zuul): Spring Cloud 整合 Zuul 实现的分布式网关方案
- [spring-cloud-nfx-06-assemble](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-cloud/spring-cloud-netflix/spring-cloud-nfx-06-assemble): Spring Cloud Netflix 组件组合运用
- ...



### [spring-cloud-alibaba](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-cloud/spring-cloud-alibaba)

- [spring-cloud-alb-01-nacos](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-cloud/spring-cloud-alibaba/spring-cloud-alb-01-nacos): Spring Cloud 整合 Nacos 实现分布式注册中心和配置中心
- [spring-cloud-alb-02-dubbo](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-cloud/spring-cloud-alibaba/spring-cloud-alb-02-dubbo): Spring Cloud 整合 Dubbo 的分布式服务调用方案
- [spring-cloud-alb-03-sentinel](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-cloud/spring-cloud-alibaba/spring-cloud-alb-03-sentinel): Spring Cloud 整合 Sentinel 实现的分布式限流、熔断方案
- [spring-cloud-alb-04-rocketmq](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-cloud/spring-cloud-alibaba/spring-cloud-alb-04-rocketmq): Spring Cloud 整合 RocketMQ 实现的分布式消息方案
- [spring-cloud-alb-05-seata](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-cloud/spring-cloud-alibaba/spring-cloud-alb-05-seata): Spring Cloud 整合 Seata 实现的分布式事务方案
- ...



### [spring-cloud-official](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-cloud/spring-cloud-official)

- [spring-cloud-ofc-01-config](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-cloud/spring-cloud-official/spring-cloud-ofc-01-config): Spring Cloud 官方提供的分布式配置中心方案
- [spring-cloud-ofc-02-zookeeper](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-cloud/spring-cloud-official/spring-cloud-ofc-02-zookeeper): Spring Cloud 官方提供的基于 Zookeeper 的分布式注册中心方案
- [spring-cloud-ofc-03-circuit-breaker](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-cloud/spring-cloud-official/spring-cloud-ofc-03-circuit-breaker): Spring Cloud 官方提供的分布式限流熔断器抽象
- [spring-cloud-ofc-04-feign](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-cloud/spring-cloud-official/spring-cloud-ofc-04-feign): Spring Cloud 官方提供的分布式服务调用方案
- [spring-cloud-ofc-05-gateway](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-cloud/spring-cloud-official/spring-cloud-ofc-05-gateway): Spring Cloud 官方提供的分布式网关方案
- [spring-cloud-ofc-06-stream](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-cloud/spring-cloud-official/spring-cloud-ofc-06-stream): Spring Cloud 官方提供的 Steam 分布式消息方案
- [spring-cloud-ofc-07-bus](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-cloud/spring-cloud-official/spring-cloud-ofc-07-bus): Spring Cloud 官方提供的消息总线方案
- [spring-cloud-ofc-08-loadbalancer](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-cloud/spring-cloud-official/spring-cloud-ofc-08-loadbalancer): Spring Cloud 官方提供的负载均衡方案
- [spring-cloud-ofc-09-sleuth](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-cloud/spring-cloud-official/spring-cloud-ofc-09-sleuth): Spring Cloud 官方提供的分布式链路跟踪方案
- [spring-cloud-ofc-10-security](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-cloud/spring-cloud-official/spring-cloud-ofc-10-security): Spring Cloud 官方提供的安全方案
- ...



### [spring-cloud-consul](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-cloud/spring-cloud-consul)

- [spring-cloud-csl-01-config](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-cloud/spring-cloud-netflix/spring-cloud-csl-01-config): Spring Cloud 整合 Consule 实现的配置中心方案
- [spring-cloud-csl-02-registry](https://github.com/Soulballad/spring-usage-examples/tree/master/spring-cloud/spring-cloud-netflix/spring-cloud-csl-02-registry): Spring Cloud 整合 Consule 实现的注册中心方案
- ...

## 持续更新中......