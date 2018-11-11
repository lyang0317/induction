# SpringBoot

## 源码过程
1. 设置SpringApplication默认参数，包括ApplicationContextInitializer和ApplicationListener
2. 开启StopWatch
3. 获取SpringApplicationRunListener并触发开始监听
4. 解析组装ApplicationArguments
5. 初始化Environment
    1. 创建Environment
    2. 配置PropertySource和Profile
    3. 触发SpringApplicationRunListener预备监听(ApplicationEnvironmentPreparedEvent)
    4. 绑定spring.man配置到容器
6. 初始化打印Banner
7. 创建ApplicationContext
8. 初始化SpringBootExceptionReporter
9. 预定义Context
    1. 设置environment、beanNameGenerator、resourceLoader
    2. 执行ApplicationContextInitializer初始化方法
    3. 打印启动日志
    4. 注册applicationArguments、printedBanner实例
    5. 执行BeanDefinitionLoader(load方法)
    6. 触发SpringApplicationRunListener预备监听(ApplicationPreparedEvent)
10. Spring正常fresh方法
11. 触发SpringApplicationRunListener监听(ApplicationStartedEvent)
12. 执行ApplicationRunner和CommandLineRunner
13. 触发SpringApplicationRunListener监听(ApplicationReadyEvent)

### POM配置
* spring-boot-parent 继承spring-boot-dependencies
* spring-boot-starters 继承spring-boot-parent，包含所有启动器，包括spring-boot-starter-parent
* spring-boot-starter-parent 继承spring-boot-dependencies，版本管理
* 其他启动器 继承spring-boot-starters