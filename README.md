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

# SpringAOP
AOP:【动态代理】指在程序运行期间动态的将某段代码切入到指定方法指定位置进行运行的编程方式。
 
     1、导入aop模块：Spring AOP：（spring-aspects）
     2、定义一个业务逻辑类（MathCalculator）；在业务逻辑运行的时候讲日志进行打印（方法之前、方法运行结束、方法出现异常等)
     3、定义一个日志切面类（LOgAspects）；切面类里面的方法需要动态感知MathCalculator.div运行到哪里然后执行对应的切面方法；
 		通知方法：
 		    前置通知(@Before)：logStart:在目标方法div()运行之前运行
                后置通知(@After)：logEnd：在目标方法div()运行结束之后运行
                返回通知(@AfterReturning)：logReturn：在目标方法div()正常返回之后运行
                异常通知(@AfterThrowing)：logException：在目标方法div()出现异常之后运行
                环绕通知：动态代理，手动推进目标方法运行（joinPoint.procced()）		
    4、给切面类的目标方法标注何时何地运行（通知注解）
    5、将切面类和业务逻辑类（目标方法所在类）都加入到容器中；
    6、必须告诉Spring哪个类是切面类（给切面类上加一个注解：@Aspect）
    7※给配置类中加@EnableAspectJAutoProxy 开启基于注解的AOP模式
 		在Spring中很多的@EnableXXX都是表示要开启XXX功能

 主要三步：
   * 将业务逻辑组件和切面类都加入到容器中；告诉Spring哪个类是切面类（@Aspect）
   * 在切面类上的每一个通知方法上标注通知注解，告诉Spring何时何地运行（切入点表达式）
   * 开启基于注解的AOP模式；@EnableAspectJAutoProxy

原文链接：https://blog.csdn.net/ysl19910806/java/article/details/91898875
