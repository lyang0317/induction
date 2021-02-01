### 概览
* 四变体，六版本
* jdk用到变体2 版本3、4

### 实现
* 符合一定格式 16个8比特数字
* 代码数据结构分高64比特和低64比特
* 随机数版本（依赖操作系统随机数实现）
    1. 通过 SecureRandom依赖提供的安全随机数接口获取种子，生成一个 16字节的随机数（字节数组）
    2. 对于生成的随机数，清空和重新设置 version和 variant对应的位
    3. 把重置完 version和 variant的随机数的所有位转移到 mostSigBits和 leastSigBits中
* MD5版本
    1. 通过输入的命名字节数组基于 MD5算法生成一个 16字节长度的随机数
    2. 对于生成的随机数，清空和重新设置 version和 variant对应的位
    3. 把重置完 version和 variant的随机数的所有位转移到 mostSigBits和 leastSigBits中
