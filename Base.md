# 基础

### 变量

    String s1 = "Hello";
    String s2 = "Hello";
    String s3 = "Hel" + "lo";
    String s4 = "Hel" + new String("lo");
    String s5 = new String("Hello");
    String s6 = s5.intern();
    String s7 = "H";
    String s8 = "ello";
    String s9 = s7 + s8;
    
    System.out.println(s1 == s2);  // true
    System.out.println(s1 == s3);  // true
    System.out.println(s1 == s4);  // false
    System.out.println(s1 == s9);  // false
    System.out.println(s4 == s5);  // false
    System.out.println(s1 == s6);  // true

* 字符串常量拼接编译后会查找常量池
* 字符串变量拼接由于编译无法确定内存分配不会找常量池
* intern会查找常量池，相同则指向常量池
* new String在堆中创建新对象，不会查找常量池

### 框架
* 工具请求对象添加@RequestBody标准化
* 页面ajax请求对象不加@RequestBody
* 同一事务重复能检测

###软件版本
* RC（Release Candidate
    
    发行候选版本，和Beta版最大的差别在于Beta阶段会一直加入新的功能，但是到了RC版本，几乎就不会加入新的功能了，而主要着重于除错!
    是最终发放给用户的最接近正式版的版本，发行后改正bug就是正式版了，就是正式版之前的最后一个测试版

* GA（General availability）
    
    首次发行稳定的版本，GA意味着General Availability，也就是官方开始推荐广泛使用了。

* 有关软件测试中的alpha、beta、gamma版本
    * alpha 
        是指内测，即现在说的 CB，指开发团队内部测试的版本或者有限用户体验测试版本。
    * beta 
        是指公测，即针对所有用户公开的测试版本2。