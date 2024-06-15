# 领域驱动设计

* 模型元素
    * entity
    * value object
    * service
    * module
* 解决生命周期维护的完整性、复杂性
    * Aggregate
    * Factory
    * Repository
* 柔性设计
    * Intention-Revealing Interfaces
    * Side-Effect-Free Function
    * Assertion
    * Conceptual Contour
    * Standalone Class
    * Closure Of Operation
* 战略设计
    * Bounded Context
    * Continuous Integration
    * Context Map
    * Shared Kernel
    * Customer/Supplier Development Team
    * Conformist
    * Anticorruption Layer
    * Separate Way
    * Open Host Service
    * Published Language
    
### jdk用到的设计模式
* 单例 Runtime.getRuntime
* 抽象工厂 DocumentBuilderFactory.newInstance
* 工厂 Calendar.getInstance NumberFormat.getInstance
* 原型 Object.clone
* 适配器 InputStreamReader(InputStream)
* 装饰器 HttpServletRequestWrapper synchronizedXXX()
* 享元 Integer.valueOf
* 代理 Proxy
* 迭代器 Iterator
* 观察者 Observable/Observer
* 模板 
* 策略 ThreadPoolExecutor

### spring用到的设计模式
* 简单工厂 BeanFactory获取bean
* 工厂方法 SqlSessionFactoryBean getObject
* 单例模式 getSingleton
* 适配器模式 SpringMVC HandlerAdatper
* 装饰器模式 带Wrapper、Decorator
* 代理模式 aop
* 观察者模式 ApplicationContextEvent
* 策略模式 Resource接口
* 模板模式 JDBCTemplate

### 七大设计原则
* 开闭原则
* 里氏代换原则
* 依赖倒转原则
* 接口隔离原则
* 单一职责原则
* 迪米特法则