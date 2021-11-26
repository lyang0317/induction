# 并发类

    * CountDownLatch
        允许一个或多个线程，等待其他一组线程完成操作，再继续执行
    * CyclicBarrier
        允许一组线程相互之间等待，达到一个共同点，再继续执行
    * ThreadLocal
        * ThreadLocal只是操作Thread中的ThreadLocalMap对象的集合
        * ThreadLocalMap变量属于线程的内部属性，不同的线程拥有完全不同的ThreadLocalMap变量
        * 线程中的ThreadLocalMap变量的值是在ThreadLocal对象进行set或者get操作时创建的
        * 使用当前线程的ThreadLocalMap的关键在于使用当前的ThreadLocal的实例作为key来存储value值
        * ThreadLocal模式至少从两个方面完成了数据访问隔离，即纵向隔离(线程与线程之间的ThreadLocalMap不同)和横向隔离(不同
        的ThreadLocal实例之间的互相隔离)
        * 一个线程中的所有的局部变量其实存储在该线程自己的同一个map属性中
        * 线程死亡时，线程局部变量会自动回收内存
        * 线程局部变量时通过一个Entry保存在map中，该Entry的key是一个WeakReference包装的ThreadLocal, value为线程局部变量，
        key到value的映射是通过ThreadLocal.threadLocalHashCode & (INITIAL_CAPACITY - 1)来完成的
        * 当线程拥有的局部变量超过了容量的2/3(没有扩大容量时是10个)，会涉及到ThreadLocalMap中Entry的回收
    * ArrayBlockingQueue
        ReentrantLock实现
    * ConcurrentHashMap
        * 1.7采用分段加Segment锁，结构为Segment+数组+链表
            * put
                1. 计算Segment索引值
                2. 尝试获取Segment对应锁
                3. 进行更新操作
        * 1.8采用synchronize+cas控制多线程同步，结构为Node数组+链表/红黑树
            * put
                1. 计算hash值
                2. for循环内条件判断进行相应处理
                    ① 数组未初始化
                        * 初始化数组
                        * 只允许一个完成操作
                        * 初始化sizeCtl
                    ② 数组内容为空（借用Unsafe原子方法获取数据）
                        * CAS设置元素（借用Unsafe原子方法更新数据）
                    ③ 数组内容正在扩容（helpTransfer()）
                        * 协助当前扩容
                        * ForwardingNode作为空标识节点
                    ④ 数组内容有值且没有在扩容
                        * synchronize同步设置元素
                        * 如果大于8转化为红黑树
                3. 更新KV数量并且判断是否扩容
                    * baseCount + counterCells[]
                    * fullAddCount()创建counterCells[]
                    * sizeCtl 
                        * 0代表数组还未初始化
                        * -1代表数组正在初始化
                        * 正常情况下代表扩容阈值
                        * 扩容过程中，高16位代表数组长度信息，低16位代表扩容总线程数
                    * rs
                        * 高16位全为0，第16位是1保证左移16位赋值sizeCtl为负数，低15位数组长度信息（int范围2^31-1 ~ -2^31）