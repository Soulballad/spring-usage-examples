**Q**: springboot 同时配置了多个配置文件，优先加载哪个？比如同时配置了application.properties, application.yaml, application.yml，加载顺序是怎样的？为什么？

**A**: 
 1. springboot 启动时，会触发事件调用(org.springframework.boot.SpringApplication.prepareEnvironment->org.springframework.boot.SpringApplicationRunListeners.environmentPrepared->org.springframework.context.event.SimpleApplicationEventMulticaster.doInvokeListener->listener.onApplicationEvent(event))
 2. listener中有一个ConfigFileApplicationListener，这个监听器用来解析配置文件，所以执行onApplicationEvent方法， org.springframework.boot.context.config.ConfigFileApplicationListener.onApplicationEnvironmentPreparedEvent->postProcessor.postProcessEnvironment->org.springframework.boot.context.config.ConfigFileApplicationListener.postProcessEnvironment->new Loader(environment, resourceLoader).load()
 3. Loader的构造函数中，使用SpringFactoriesLoader加载PropertySourceLoader.class，PropertySourceLoader有两个实现类：PropertiesPropertySourceLoader和YamlPropertySourceLoader，前者解析 .properties和.xml，后者解析 .yml和.yaml，在spring.factories中，PropertiesPropertySourceLoader在前，所以先解析 .properties 文件，YamlPropertySourceLoader中 .yml 在前，先解析 .yml
 4. 所以最终顺序是 .properties->.yml->.yaml
 
 **Q**: spring.profiles.active 有几种配置方式？
 **A**: 
 1. 命令行启动时配置 --spring.profiles.active=dev, java -jar spring-boot.jar --spring.profiles.active=dev
 2. java启动时配置 -Dspring.profiles.active=dev
 3. web.xml 中配置 <context-param> <param-name>spring.profiles.active</param-name> <param-value>dev</param-value> </context-param>
 
 spring.profiles 单个配置可以使用注解，xml，Properties等多种配置方式