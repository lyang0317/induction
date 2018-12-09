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
* 请求对象添加@RequestBody标准化