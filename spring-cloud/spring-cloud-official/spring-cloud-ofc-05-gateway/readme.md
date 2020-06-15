1. 服务说明：
    1. ofc-gateway-eureka(11050)：eureka server 服务
    2. ofc-gateway-router(11055)：gateway 服务器，注册到 eureka
    3. ofc-gateway-service-a(11051)：服务 a，注册到 eureka
    4. ofc-gateway-service-b(11052)：服务 b，注册到 eureka
    5. ofc-gateway-target(11056)：测试转发的目标服务（转发到该服务）
2. 测试：
    1. 简单转发： active=route_simple，启动 1245
        1. 请求 http://localhost:11055/index， 被转发到 http://localhost:11056/index， 输出 [this is ofc-gateway-target service index!]
        2. 请求转发，匹配 /index 路径，然后转发到另一个服务
    2. 路径截取： active=route_stripPrefix，启动 1245
        1. 请求 http://localhost:11055/test/access， 被转发到 http://localhost:11056/access， 输出 [this is ofc-gateway-target service access!]
        2. 路径截取，截取掉 /test，转发到目标服务地址 
    3. 转发并传参： active=route_uri，启动 124
        1. 请求 http://localhost:11055/name， 被转发到 http://localhost:11052/name， 输出 [service-b current name is : lisi]
        2. 转发到目标服务地址，并添加参数
    4. 转发并传参： active=route_addRequestParameter，启动 1234
        1. 请求 http://localhost:11055/age， 被转发到 http://localhost:11051/age 和http://localhost:11052/age， 分别输出 [service-a current age is :eighteen]|[service-b current age is :eighteen]
        2. 配置了 uri： lb://ofc-gateway-service， ofc-gateway-service 有两个实例，分别是 service-a， service-b，转发的时候会在两个实例之间切换；实现了一种类似负载均衡的效果。 
    5. 熔断： active=route_hystrix，启动 1234
        1. 请求 http://localhost:11055/age， 被转发到 http://localhost:11051/age 和http://localhost:11052/age， 分别输出 [service-a current age is :eighteen]|[service-b current age is :eighteen]
        2. 请求 http://localhost:11055/name， 被转发到 http://localhost:11051/name 和http://localhost:11052/name， 分别输出 [service-a current name is : null]|[service-b current name is : null]
        3. 请求 http://localhost:11055/fallback 手动触发熔断，输出 [spring cloud gateway is now fallback!]
    6. 限流： active=route_requestRateLimiter，启动 1234 + redis
        1. 请求 http://localhost:11055/age， 被转发到 http://localhost:11051/age 和http://localhost:11052/age， 分别输出 [service-a current age is :eighteen]|[service-b current age is :eighteen]
        2. 请求 http://localhost:11055/name， 被转发到 http://localhost:11051/name 和http://localhost:11052/name， 分别输出 [service-a current name is : null]|[service-b current name is : null]
        3. 如果访问太过频繁，就会被限流，无法访问；返回响应码 429；
        4. X-RateLimit-Burst-Capacity: 3 表示 redis 中只有 3 个令牌，每次访问消耗一个令牌，当令牌消耗完，就会被限流
    7. 综合： active=route_all，启动 1234 + redis
        1. 请求 http://localhost:11055/all/routeAll， 被转发到 http://ofc-gateway-service/routeAll， 但是会返回 [{ "msg": "the token is needed!", "code": "-1" }]，因为配置了 TokenFilter 全局过滤器
        2. 连续访问一定次数后，会被限流，响应码 429
        3. 如果出现熔断，会输出 [spring cloud gateway is now fallback!]
        4. 请求 http://localhost:11055/all/routeAll?token=123， 会被转发到 http://localhost:11051/routeAll 和http://localhost:11052/routeAll， 分别输出 [service-a can pass?yes! port: 10051]|[service-b can pass?yes! port: 11052]
        5. 访问 http://localhost:11055/all/routeAll?token=123 时， /all 会被截取掉，同时在请求中增加参数 pass=yes
        6. 观察日志，会打印：[响应码：200 OK，请求路径：/routeAll
                     filter -> before
                     响应码：200 OK，请求路径：/routeAll
                     filter -> after]
            
3. 123

