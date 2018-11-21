# Book
### 大型互联网架构
> 小型架构慢慢演化，从简设计，保证维护成本低
* 反向代理
* CDN加速
* 机械硬盘转为固态硬盘
* B+树 LSM树
* RAID HDFS
* Memcache分布式缓存（一致性H按时，虚拟节点保证负载均衡）
* XSS 注入 CSRF
* 单向散列（salt） 对称 非对称

### Speak
* 重复谈话，降调语气
* 标注情感（注重消极）
* 谨慎是回答，控制否回答，拥抱否回答

### Tomcat
* Bootstrap(启动器) Connector(Coyote) Processor(处理池，创建请求响应，解析请求，处理逻辑) Request Response
* Context（web） Wrapper（servlet）

    baseValue(servlet) + value
    
    tomcat5 pipeline（invoke） -> valuecontext(invoke(this) 内部维护value数组迭代) -> value(invokeNext)
    
    tomcat7 pipeline（getNext().invoke 内部维护value单向链表） -> value（invoke）