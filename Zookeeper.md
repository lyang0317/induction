# Zookeeper

### 概要

    分布式应用程序协调服务，提供了文件系统和通知机制。
    
### 原理
    原子广播保证了各个server的同步，实现这个机制的是ZAB协议，协议分为恢复模式和广播模式。
    
### 数据模型
    * ZNode节点树
        持久化目录节点
        持久化顺序目录节点
        临时目录节点
        临时顺序编号目录节点
        
### 功能
    * 数据发布与订阅
        客户端向服务端注册自己需要关注的节点，一旦该节点的数据发生变更，那么服务端就会向相应的客户端发送Watcher事件通知，
        客户端接收到这个消息通知后，需要主动到服务端获取最新的数据
    * 命名服务
    * 配置管理
    * 集群管理
    * 分布式锁
        * 排它锁
            1. 一个机器定义一个锁
            2. 通过创建临时节点来获取锁，没有获取到锁的到/exclusive_lock节点注册子节点变更的watcher监听
            3. 释放锁
        * 共享锁
            1. 创建EPHEMERAL_SEQUENTIAL目录节点
            2. 调用getChildren获取当前目录列表中最小节点判断是不是自己创建的
            3. 如果是就获取锁，不是则调用exist监控目录列表变化
            4. 当创建目录节点是最小编号的目录节点，获取锁。
    * 队列管理
    
### 角色

    * Leader
        只有一个，提供读写服务，负责投票的发起和决议，更新系统状态
    * Learner
        * Follower
            提供读服务，参与选举，参与过半写成功策略
        * Observer  
            需要特殊配置，提供读服务，不参与选举，也不参与过半写成功策略，因此在不影响写性能情况下提升集群的读性能
    
    树形结构，leader是其中的根节点，其他节点为follow节点，每个节点存储数据和状态信息。
    
    数据操作流程（二阶段提交）：
        1. 在Client向Follwer发出一个写的请求
        2. Follwer把请求发送给Leader
        3. Leader接收到以后开始发起投票并通知Follwer进行投票
        4. Follwer把投票结果发送给Leader
        5. Leader将结果汇总后如果需要写入，则开始写入同时把写入操作通知给Leader，然后commit;
        6. Follwer把请求结果返回给Client
        
    Server状态
        * LOOKING
        * LEADING
        * FOLLOWING
    群首选举算法流程：
        1. 第一次投票 
            发送自己的投票信息，sid和zxid
        2. 变更投票
            接受其他机器的投票，选择zxid大的（如果zxid相等，选择sid大的）投票发出去
        3. 确定Leader
            经过两轮投票，统计如果有超过半数相同投票，则定位leader
        
### 事务操作
    
    改变zookeeper服务器状态操作称为事务操作，包括数据节点的创建删除、数据内容更新、客户端会话创建和失效，对应每一个事物
    请求，分配一个全局唯一的zxid，间接标识请求的顺序。
    
### watcher事件监听器

    允许用户在节点注册watcher，并在特定时间触发，zookeeper服务端将时间通知到感兴趣的客户端。
    
### 2pc 3pc
    * 区别
        3pc增加是否提交CanCommit阶段，解决同步阻塞和单点问题
        3pc等待超时会中断事务
        
### zab和paxos
    * 区别
        zab协议增加了同步阶段
        zab引入leader角色，避免了竞争能够快速收敛趋于一致
        zab构建高可用分布式数据主备系统，paxos构建一个分布式的一致性状态机系统
        paxos无法保证因果顺序
        
### 流程
    ZAB 选举 -> 发现 -> 同步 -> 广播
    JAVA实现  Fast Leader Election(epoch -> zxid -> server id) -> 恢复 -> 广播

### 源码
#### 群首选举
![](zookeeper_class.png)
#### 消息广播
* ZooKeeperServer
    1. ZooKeeperServer PrepRequestProcessor -> SyncRequestProcessor -> FinalRequestProcessor
    2. LeaderZooKeeperServer 
![](leaderzookeeper_processor.png)
    3. FollowerZookeeperServer
![](followerzookeeper_processor.png)
* LearnerHandler