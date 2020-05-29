# springBean
>Spring 初始化  
>Spring JdbcTemplate配置   
>spring配置applicationContext.xml学习

## JdbcTemplate主要提供以下五类方法：
    execute方法：可以用于执行任何SQL语句，一般用于执行DDL语句；
    update方法：update方法用于执行新增、修改、删除等语句；
    batchUpdate方法：batchUpdate方法用于执行批处理相关语句；
    query方法及queryForXXX方法：用于执行查询相关语句；
    call方法：用于执行存储过程、函数相关语句。

### 数据库：
> CREATE TABLE xwj_user (
     id VARCHAR(32) NOT NULL,
     last_name VARCHAR(32),
     age INT(2),
     email VARCHAR(32)
  ) ENGINE=INNODB DEFAULT CHARSET=utf8

### pom.xml
> 
    <dependencies>
          <dependency>
              <groupId>org.springframework</groupId>
              <artifactId>spring-jdbc</artifactId>
              <version>4.2.5.RELEASE</version>
              <scope>compile</scope>
          </dependency>
          <dependency>
              <groupId>org.springframework</groupId>
              <artifactId>spring-tx</artifactId>
              <version>4.2.5.RELEASE</version>
              <scope>compile</scope>
          </dependency>
          <!-- 获取上下文 -->
          <dependency>
              <groupId>org.springframework</groupId>
              <artifactId>spring-context</artifactId>
              <version>4.2.5.RELEASE</version>
          </dependency>
          <dependency>
              <groupId>com.mchange</groupId>
              <artifactId>c3p0</artifactId>
              <version>0.9.5.2</version>
          </dependency>
          <!-- 连接到mysql -->
          <dependency>
              <groupId>mysql</groupId>
              <artifactId>mysql-connector-java</artifactId>
              <version>5.1.35</version>
          </dependency>
          <!-- 单元测试 -->
          <dependency>
              <groupId>junit</groupId>
              <artifactId>junit</artifactId>
              <version>4.10</version>
              <scope>test</scope>
          </dependency>
      </dependencies>
      
### 在resource下面增加两个配置文件db.properties、applicationContext.xml
 #### db.propertiees
>jdbc.user=root
 jdbc.password=root
 jdbc.driverClass=com.mysql.jdbc.Driver
 jdbc.jdbcUrl=jdbc:mysql://dev.yonyouccs.com:3001/icop-construct-busisubpack
 initPoolSize=5
 maxPoolSize=10
#### applicationContext.xml
>  
      <!-- 读取配置文件 -->
      <context:property-placeholder location="classpath:db.properties" />
      
      <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
          <property name="user" value="${jdbc.user}"></property>
          <property name="password" value="${jdbc.password}"></property>
          <property name="driverClass" value="${jdbc.driverClass}"></property>
          <property name="jdbcUrl" value="${jdbc.jdbcUrl}"></property>
  
          <property name="initialPoolSize" value="${initPoolSize}"></property>
          <property name="maxPoolSize" value="${maxPoolSize}"></property>
      </bean>
  
      <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
          <property name="dataSource" ref="dataSource"></property>
      </bean>
      
参考：https://www.cnblogs.com/xuwenjin/p/8822354.html

