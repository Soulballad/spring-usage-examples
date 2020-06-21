hystrix 统一熔断<br/>
archaius 配置底量数据，积分比例；会员等级信息


- nfx-asm-eureka
    http://localhost:8011/eureka/, http://localhost:8012/eureka/
    1. --server.port=8011
- nfx-asm-user-service
    http://localhost:[11021-11030]/user
    1. --spring.profiles.active=11021
- nfx-asm-order-service
    http://localhost:[11011-11020]/user
    1. --spring.profiles.active=11011
- nfx-asm-zuul  
    http://localhost:9090
- nfx-asm-archaius
    http://localhost:7010/config