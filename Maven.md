# Maven

## 配置
* scope
1. compile
    缺省值，适用于所有阶段，会随着项目一起发布
2. provided
    类似compile，期望JDK、容器或使用者会提供这个依赖。如servlet.jar
3. runtime
    只在运行时使用，如JDBC驱动，适用运行和测试阶段
4. test
    只在测试时使用，用于编译和运行测试代码。不会随项目发布
5. system
    和provided相同，不过被依赖项不会从maven仓库下载，而是从本地文件系统拿。需要添加systemPath的属性来定义路径
6. import
    只能用在dependencyManagement里面，实现多继承maven parent
    
### 标签
* dependencies
    子模块继承依赖
* dependencyManagement
    声明依赖，可以被子模块引用

## 插件
* maven-compiler-plugin
    编译Java源码，一般只需设置编译的jdk版本
* maven-dependency-plugin
    用于复制依赖的jar包到指定的文件夹里
* maven-jar-plugin
    打成jar时，设定manifest的参数，比如指定运行的Main class，还有依赖的jar包，加入classpath中
* maven-assembly-plugin
    包含了自己项目中的代码和资源，还包含了所有依赖包的内容。所以可以直接通过java -jar来运行
* maven-shade-plugin
    用于把多个jar包，打成1个jar包
* spring-boot-maven-plugin
    所做的工作是在默认的maven-jar-plugin插件打包结束后，将项目依赖的jar包中的.class文件重新进行打包
  
### 命令
    * mvn dependency:tree -DoutputType=graphml -DoutputFile=dependency.graphml
    * mvn dependency:list
    * mvn dependency:tree -Dincludes=*log4j*:*log4j*