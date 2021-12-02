# ThreadPool

### 线程池状态
    * Running 创建线程初始时
    * Shutdown 不能接受新任务，等待所有任务完毕
    * Stop 不能接受新任务，尝试终止正在执行的任务
    * Terminated 处于Shutdown和Stop，并且工作线程销毁，缓存队列已经清空时

### 配置
    * corePoolSize 核心线程数
    * maxPoolSize 最大线程数
    * keepAliveSecondes 允许的空闲时间
    * queueCapacity 缓存队列
        * ArrayBlockingQueue
        * LinkedBlockingQueue
        * SynchronousQueue
    * rejectedExecutionHandler 拒绝策略
        * AbortPolicy 默认为阻塞策略，不执行任务，抛异常
        * DiscardPolicy 不执行任务
        * DiscardOldestPolicy 从队列里抛弃head的一个任务，重新执行此任务
        * CallerRunsPolicy 调用execute的线程执行此动作，阻塞入口
        * 自定义策略
    
### 执行过程
    1.线程池中数量小于corePoolSize，创建新线程处理任务
    2.线程池中数量等于corePoolSize，但是缓冲队列未满，任务放入缓冲队列
    3.线程池中数量大于corePoolSize，缓冲队列满，小于maxPoolSize，建立新线程处理任务
    4.线程池中数量大于corePoolSize，缓冲队列满，等于maxPoolSize，通过策略处理任务
    5.线程池中数量大于corePoolSize，如果某空闲线程超过keepAliveSecondes，则线程终止

### 分类
    * newFixedThreadPool corePoolSize==maxPoolSize LinkedBlockingQueue
        执行长期的任务，性能好很多
    * newSingleThreadExecutor corePoolSize==maxPoolSize==1 LinkedBlockingQueue
        一个任务一个任务执行的场景
    * newCachedThreadPool corePoolSize==0 maxPoolSize==Integer.MAX_VALUE SynchronousQueue
        执行很多短期异步的小程序或者负载较轻的服务器
    * newScheduledThreadPool 唯一一个有延迟执行和周期重复执行的线程池
        周期性执行任务的场景

### 设计
    * 考虑因素
        1. tasks 每秒任务数
        2. taskcost 每个任务花费时间
        3. responsetime 系统容忍最大响应时间
    * 计算
        corePoolSize tasks/(1/taskcost)（二八原则确定具体数值）
        queueCapacity (coreSizePool/taskcost)*responsetime
        maxPoolSize (max(tasks)- queueCapacity)/(1/taskcost)
        keepAliveTime 默认值
        
### 源码
* runStateOf(int c) 是通过与的方式，在clt字段中获取到clt的前三位，也就是线程池的状态标识。 
  workerCountOf(int c)是通过与的方式，在clt字段中获取到clt的后29位，也就是线程池中的线程数量。 
  ctlOf(int rs, int wc) 是通过或的方式，将修改后的线程池状态rs和线程池中线程数量打包成clt。 
  isRunning(int c) SHUTDOWN的状态是0左移29为得到的，比他大的均是线程池停止或销毁状态
* addWorker 参数core控制是核心线程数还是最大线程数，线程数目增加，workers添加
* Worker run方法调用ThreadPoolExecutor的runWorker方法不断获取自己和队列中任务执行