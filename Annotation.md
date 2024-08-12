# 插入式注解 JSR 269

## lombok
## mapstruct
1. 引入依赖
```
<dependency>
    <groupId>org.mapstruct</groupId>
    <artifactId>mapstruct</artifactId>
    <version>1.3.1.Final</version>
</dependency>
<dependency>
    <groupId>org.mapstruct</groupId>
    <artifactId>mapstruct-processor</artifactId>
    <version>1.3.1.Final</version>
</dependency>
<plugin>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.2</version>
    <configuration>
        <source>1.8</source>
        <target>1.8</target>
        <encoding>UTF-8</encoding>
        <!--<annotationProcessorPaths>
            <path>
                <groupId>org.mapstruct</groupId>
                <artifactId>mapstruct-processor</artifactId>
                <version>1.3.1.Final</version>
            </path>
            &lt;!&ndash; other annotation processors &ndash;&gt;
        </annotationProcessorPaths>-->
    </configuration>
</plugin>
```

2. 定义接口
3. 定义转换接口
    ```
    package com.lenovo.ofp.purchase.web.dao.mapper;

    import com.lenovo.ofp.purchase.web.common.domain.quote.QuoteItemResult;
    import com.lenovo.ofp.purchase.web.common.domain.quote.QuoteItemVO;
    import org.mapstruct.Mapper;
        
    @Mapper(componentModel = "spring")
    public interface QuoteConvertMapper {
        
        QuoteItemVO convert(QuoteItemResult quoteItemResult);

    }
   ```
4. 注意事项
    * swagger考虑需要排除内部mapstruct
    * 建议maven引入放在lombok后面
    * 第一次引入mapstruct可能找不到注解，多试几次
    * 可以安装idea mapstruct插件
