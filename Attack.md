### Frontend
* CSRF 攻击者盗用了身份，以客户的名义(带Cookie)发送恶意请求

### Backend
* log4j2
    * jndi利用RMI（经典的命名服务）和LDAP（典型的目录服务，目录服务是命名服务的拓展）执行远程代码
    * 高版本jdk绕过RMI限制借用本地tomcat中的BeanFactory
    * 高版本jdk绕过LDAP限制借用javaSerializedData反序列化