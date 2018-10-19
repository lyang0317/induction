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
        * 1.8采用synchronize+cas控制多线程同步，结构为Node数组+链表/红黑树