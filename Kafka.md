# Kafaka

### 内部结构

* producer
* broker
    通过zookeeper阶段选举一个controller，控制partition leader选举
    * topic
        * partition
            partition只会被一个consumer消费，partition有leader和follower
            * segment
* consumer/consumer group
    Pull方式获取消息

### 可靠性
* 消息投递
    * 发送出去就成功
    * Master和Slave都接受到才成功
    * Master接受到就成功
* 消息消费
    * at most once
    * at least once
    * exactly once

### zookeepr作用
* 管理broker与consumer的动态加入与离开
* 触发负载均衡
* 维护消费关系及每个partition的消费信息


### 高效原因
* segment index file采取稀疏索引存储方式，减少索引文件大小，通过mmap可以直接内存操作
* 磁盘线性写，持久化队列构建在对一个文件的读和追加上
* 高效的数据传输，不创建单独的cache，使用系统的pagecache，使用sendfile优化网络传输，减少一次内存拷贝


    
    