# SpringCloud(Dalston)

## 组件
* Config
    分布式系统外部配置管理
* Eureka
    服务发现，和zookeeper相比保证AP，由于没有leader选举概念一致性保证没有
* Hystrix
    断路器
* Ribbon
    负载平衡器，侧重于客户端的负载平衡，服务端的负载平衡可采用nginx控制
* Feign
    Rest客户端，绑定地址端口
* Zuul
    路由
* Stream
    对接消息中间件
* Bus
    总线，用于分布式节点间的通信
* Sleuth
    监控
* Consul
    服务发现，保证CA
* Zookeeper
* Security
* Contract
    消费段保证测试统一可用