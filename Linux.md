### 管道

* grep cut split...
  * grep 'http-apr-8080-exec-91' catalina.2022-08-24.log |grep '14:00:07.001'

### 正则

* 配合支持正则表达式的工具(grep sed)
* 与通配符区别(* 通配符代表任意字符 正则代表一个字符出现多次)
* grep -E/egrep 扩展正则(+ ? |)

### shell
* source执行 在父进程设置环境变量不需要重启生效

### 权限
* su 输入要操作用户的密码
* sudo 输入自己密码，需要配置

### 磁盘配额
* 磁盘配额相关命令（针对用户、用户组、project）
* Raid，即为磁盘阵列，根据工作方式的不同分为（0-6），性能效果也有差异
* 软件磁盘阵列和硬件磁盘阵列在设备名称有所差别
* LVM
    * 自顶向下 LV -> VG -> PV -> PE
    * 实现虚拟存储池（实际没有申请那么大，百分比按虚拟来算）
  
### 定时任务
* crontab
* anacrontab

### 任务管理
* &
* nohup

### 程序管理
* SUID/SGID命令运行方式
* SELinux
  ![](selinux_process.png)