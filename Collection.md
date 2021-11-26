# 数据结构

### 常见结构
* Collection
    * Queue
        ![](queue_oper.png)
        * ArrayDeque
            1.数组实现双端队列
            2.扩容增加两倍
            3.可以作为栈使用
        * LinkedTransferQueue
    * List 有序重复
    * Set 无序不重复
* Map
    * HashMap 
        * 键和值允许空，底层数组的长度总是2的n次方，保证速度上的优化，数据在数组上分布比较均匀
            1. size 存放的KV树
            2. capacity 桶的数量
            3. loadFactor 衡量满的程度，size/capacity
            4. threshold size大于threshold会执行resize，capacity*loadFactor 
        * put操作
            1. 索引计算 : ((key.hashCode() ^ (key.hashCode() >>> 16)) & (table.length - 1))
            2. 在链表中查找，并记录链表长度，若链表长度达到了 TREEIFY_THRESHOLD(8)，则将该链转成红黑树
               * 1.8 操作红黑树同样可能导致死循环
            3. 若在链表中找到了，则替换旧值，若未找到则继续
            4. 当总元素个数超过容量*加载因子时，扩容为原来 2 倍并重新散列，元素的下标要么不变，要么变为原下标+原容量
               * 1.7 头插入方式，在resize时候出现循环链表，导致后续死循环
            5. 将新元素加到链表尾部
    * TreeMap
        基于红黑树，损耗在插入删除，键值都不能为空，效率低，但总是根据指定的规则保持有序状态
    * HashTable 
        键和值不允许空