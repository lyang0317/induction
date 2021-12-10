# Book
### 大型互联网架构
> 小型架构慢慢演化，从简设计，保证维护成本低
* 反向代理
* CDN加速
* 机械硬盘转为固态硬盘
* B+树 LSM树
* RAID HDFS
* Memcache分布式缓存（一致性Hash，虚拟节点保证负载均衡）
  * 一直hash变动节点只需变动其中一段的数据
* XSS 注入 CSRF
* 单向散列（salt） 对称 非对称

### Speak
* 重复谈话，降调语气
* 标注情感（注重消极）
* 谨慎是回答，控制否回答，拥抱否回答
* 重视"你说得对"
* 谈判时限的掌控，公平的重要性，预设低起点，利用规避损失心理
* 制造对方控制的幻觉，提出开放性问题，"如何"替代"为什么"

### Tomcat
* Bootstrap(启动器) Connector(Coyote) Processor(处理池，创建请求响应，解析请求，处理逻辑) Request Response
* Context（web） Wrapper（servlet）

    baseValue(servlet) + value
    
    tomcat5 pipeline（invoke） -> valuecontext(invoke(this) 内部维护value数组迭代) -> value(invokeNext)
    
    tomcat7 pipeline（getNext().invoke 内部维护value单向链表） -> value（invoke）
    
* Lifecycle（生命周期接口，实现从父容器到各组件层层启动关闭的动作管理执行）

    LifecycleEvent LifecycleListener LifecycleSupport
    
* Logger

    LoggerBase SystemOutLogger SystemErrLogger FileLogger
    
* Loader Reloader
    
    WebappLoader WebappClassLoader（缓存、安全）
    
* Session

    * Manager ManagerBase（管理session）
        1. StandardManager
        2. PersistentManager
        3. DistributedManager
    * StoreBase
        1. FileStore
        2. JDBCStore
       
* 安全性

    * Realm 身份验证领域类，重载四个验证方法
    * GenericPrincipal 验证信息类
    * LoginConfig 包含领域对象名字和所用的验证方法
    * Authenticator 验证器

* StandardWrapper

    * SingleThreadModel 并不保证线程安全
    * StandardWrapperFacade隐藏内部实现
    * FilterChain执行过滤器
    
* StandardContext

    * StandardContextMapper查找映射
    * backgroundProcess新开线程定时处理业务
    
* Host Engine
    
    * StandardHostMapper查找映射
    * Engine在需要支持多个虚拟机时使用
    
* Server Service
    
    
### 企业应用架构模式
    * 分层
    * 事务脚本 表模块 领域模型 59
    * 活动记录 工作单元 结构映射 表数据入口 行数据入口