1. 配置 spring-boot-starter-actuator
    - 1.1 配置 spring-boot-starter-actuator 和 spring-cloud-starter-netflix-hystrix 依赖
    - 1.2 配置文件打开 endpoint 监控
    - 1.3 http://localhost:9090/actuator/hystrix.stream 一直打印 ping
    - 1.4 访问 http://localhost:9090/dashboard 后，再访问 /actuator/hystrix.stream， 打印请求信息
2. 配置 spring-cloud-starter-netflix-hystrix-dashboard
    - 2.1 激活 EnableHystrixDashboard 注解
    - 2.2 访问 http://localhost:9090/hystrix
    - 2.3 配置 stream， http://localhost:9090/actuator/hystrix.stream
    - 2.4 点击 monitor stream 可以看到集群健康状况