# springboot-log
> 日志管理
```
日志基本：
trace：微量，级别最低
debug：需要调试时候的关键信息打印
info ：普通的打印信息（默认）
warn ：警告，不影响使用，但需要注意的问题
error：错误信息，级别较高的错误日志信息
fatal：致命的，因为代码异常导致程序退出执行的事件（不需要我们自己打印）
```
## Logback
> Logback 是log4j 框架的作者开发的新一代日志框架，它效率更高、能够适应诸多的运行环境，同时天然支持SLF4J Logback的定制性更加灵活，同时也是spring boot的内置日志框架
### 参考文档
* https://blog.csdn.net/m0_71777195/article/details/126743783
* https://blog.csdn.net/Biteht/article/details/128015006

### 使用
1. maven依赖
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-logging</artifactId>
</dependency>
```
> 实际开发中我们不需要直接添加该依赖，spring-boot-starter其中包含了 spring-boot-starter-logging，该依赖内容就是 Spring Boot 默认的日志框架 Logback+SLF4J。而 spring-boot-starter-web 包含了spring-boot-starte，所以我们只需要引入web组件即可
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
2. 配置文件
> 默认情况下Spring Boot将日志输出到控制台，不会写到日志文件。如果要编写除控制台输出之外的日志文件，则需在application.properties或者application.yml中设置logging.file或logging.path属性
* 注：二者不能同时使用，如若同时使用，则只有logging.file生效
* logging.file，设置文件，可以是绝对路径，也可以是相对路径。如：logging.file=my.log
* logging.path，设置目录，会在该目录下创建spring.log文件，并写入日志内容，如：logging.path=/var/log
* logging.level.root，全局日志打印级别, 只打印当前以及更高级别的日志
* 如果想要更复杂的需求，就需要定制化配置

3. 使用
* 获取日志对象 (通过 LoggerFactory中的方法去获取该类的日志)
```java
protected final Logger logger = LoggerFactory.getLogger(this.getClass());
logger.info("测试日志 -> {}", true);
```
* lombok 注解注入
```java
@Slf4j
public class LogServiceImpl {
    public String lombokTest(){
        log.warn("lombok ->{} ", true);
        return "lombok";
    }
}
```
