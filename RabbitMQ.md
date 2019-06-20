# RabbitMQ

### 结构
    * virtualHost
    * exchange
        * direct
        * topic
        * fanout
        * headers
    * queue
    * routingKey
    
### 特性
    * 特征队列
        * 死信
        * 延迟
        * 优先级
     * 队列镜像

### 原理
    * AMQP协议（流转过程）
    * 队列
        1. 四状态（alpha beta gamma delta）
        2. 五子队列
    * 流控（flow状态）
 
### 集群
    * 管理
    * 迁移
    * 监控
    * 跨集群处理
        * Federation
        * Shovel  
    * 负载均衡接入  
        
### 网络分区
    * 分区处理模式
    