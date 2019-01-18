# 胖嘟嘟电商二期平台


### 组织结构

``` lua
oxygen
├── oxygen-common -- SSM框架公共模块
├── oxygen-admin -- 后台管理模板
├── oxygen-config -- 配置中心[端口:1001]
├── oxygen-upms -- 用户权限管理系统
|    ├── oxygen-upms-common -- upms系统公共模块
|    ├── oxygen-upms-dao -- 代码生成模块，无需开发
|    ├── oxygen-upms-client -- 集成upms依赖包，提供单点认证、授权、统一会话管理
|    ├── oxygen-upms-rpc-api -- rpc接口包
|    ├── oxygen-upms-rpc-service -- rpc服务提供者
|    └── oxygen-upms-server -- 用户权限系统及SSO服务端[端口:1111]
├── oxygen-pay -- 支付系统
|    ├── oxygen-pay-common -- pay系统公共模块
|    ├── oxygen-pay-dao -- 代码生成模块，无需开发
|    ├── oxygen-pay-rpc-api -- rpc接口包
|    ├── oxygen-pay-rpc-service -- rpc服务提供者
|    ├── oxygen-pay-sdk -- 开发工具包
|    ├── oxygen-pay-admin -- 后台管理[端口:3331]
|    └── oxygen-pay-web -- 演示示例[端口:3332]
├── oxygen-ucenter -- 用户系统(包括第三方登录)
|    ├── oxygen-ucenter-common -- ucenter系统公共模块
|    ├── oxygen-ucenter-dao -- 代码生成模块，无需开发
|    ├── oxygen-ucenter-rpc-api -- rpc接口包
|    ├── oxygen-ucenter-rpc-service -- rpc服务提供者
|    └── oxygen-ucenter-web -- 网站前台[端口:4441]
├── oxygen-wechat -- 微信系统
|    ├── oxygen-wechat-mp -- 微信公众号管理系统
|    |    ├── oxygen-wechat-mp-dao -- 代码生成模块，无需开发
|    |    ├── oxygen-wechat-mp-service -- 业务逻辑
|    |    └── oxygen-wechat-mp-admin -- 后台管理[端口:5551]
|    └── oxygen-ucenter-app -- 微信小程序后台
├── oxygen-api -- API接口总线系统
|    ├── oxygen-api-common -- api系统公共模块
|    ├── oxygen-api-rpc-api -- rpc接口包
|    ├── oxygen-api-rpc-service -- rpc服务提供者
|    └── oxygen-api-server -- api系统服务端[端口:6666]
```

### 技术选型

#### 后端技术:
技术 | 名称 | 官网
----|------|----
Spring Framework | 容器  | [http://projects.spring.io/spring-framework/](http://projects.spring.io/spring-framework/)
SpringMVC | MVC框架  | [http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#mvc](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#mvc)
Apache Shiro | 安全框架  | [http://shiro.apache.org/](http://shiro.apache.org/)
Spring session | 分布式Session管理  | [http://projects.spring.io/spring-session/](http://projects.spring.io/spring-session/)
MyBatis | ORM框架  | [http://www.mybatis.org/mybatis-3/zh/index.html](http://www.mybatis.org/mybatis-3/zh/index.html)
MyBatis Generator | 代码生成  | [http://www.mybatis.org/generator/index.html](http://www.mybatis.org/generator/index.html)
Druid | 数据库连接池  | [https://github.com/alibaba/druid](https://github.com/alibaba/druid)
FluentValidator | 校验框架  | [https://github.com/neoremind/fluent-validator](https://github.com/neoremind/fluent-validator)
Velocity | 模板引擎  | [http://velocity.apache.org/](http://velocity.apache.org/)
ZooKeeper | 分布式协调服务  | [http://zookeeper.apache.org/](http://zookeeper.apache.org/)
Dubbo | 分布式服务框架  | [http://dubbo.io/](http://dubbo.io/)
TBSchedule & elastic-job | 分布式调度框架  | [https://github.com/dangdangdotcom/elastic-job](https://github.com/dangdangdotcom/elastic-job)
Redis | 分布式缓存数据库  | [https://redis.io/](https://redis.io/)
Quartz | 作业调度框架  | [http://www.quartz-scheduler.org/](http://www.quartz-scheduler.org/)
Ehcache | 进程内缓存框架  | [http://www.ehcache.org/](http://www.ehcache.org/)
ActiveMQ | 消息队列  | [http://activemq.apache.org/](http://activemq.apache.org/)
Log4J | 日志组件  | [http://logging.apache.org/log4j/1.2/](http://logging.apache.org/log4j/1.2/)
Swagger2 | 接口测试框架  | [http://swagger.io/](http://swagger.io/)
sequence | 分布式高效ID生产  | [http://git.oschina.net/yu120/sequence](http://git.oschina.net/yu120/sequence)
Protobuf & json | 数据序列化  | [https://github.com/google/protobuf](https://github.com/google/protobuf)
Maven | 项目构建管理  | [http://maven.apache.org/](http://maven.apache.org/)

