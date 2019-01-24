code introduction:
this is a projects which submit by me.



1、dubbo和SpringCloud的区别:
dubbo采用的是RPC协议进行通信，SpringCloud采用的是基于http的restful api进行通信。
（在性能上来说，由于Dubbo底层是使用Netty这样的NIO框架，是基于TCP协议传输的，配合以Hession序列化完成RPC。
而SpringCloud是基于Http协议+rest接口调用远程过程的，相对来说，Http请求会有更大的报文，占的带宽也会更多。）
2、微服务的优缺点
    优点：
    每个服务足够内聚，足够小，代码容易理解，这样能聚焦一个指定的业务功能或者业务需求；
    开发简单、开发效率提高，一个服务可能就是专一的只干一件事；
    微服务能够被小团队单独开发，这个小团队是2到5人的开发人员组成
    微服务是松耦合的，是有功能意义的服务，无论是在开发阶段或者部署阶段都是独立的
    微服务能使用不同的语言开发
    易于和第三方集成，微服务允许容易且灵活的方式集成自动部署，通过持续集成工具，如Jenkins,Hudson,bamboo.
    微服务易于被一个开发人员理解，修改和维护，这样小团队能够更关注自己的工作成果。无需通过合作才能体现价值。
    微服务允许你利用融合最新技术。
    微服务只是业务逻辑的代码，不会和HTML，CSS或者其他界面组件混合。
    每个微服务都有自己的存储能力，可以有自己的数据库。也可以有统一数据库。
    --------------------------
    缺点：
    开发人员要处理分布式系统的复杂性；
    多服务运维难度，随着服务的增加，运维的压力也在增大；
    系统部署依赖；
    服务间通讯成本
    数据一致性
    系统集成测试
    性能监控。。。

3、微服务面试题汇总
 1)什么是微服务
 2)微服务之间是如何独立通讯的
 3)SpringCloud和Dubbo有哪些区别



 4)SpringBoot和SpringCloud，请你谈谈对他们的理解
   SpringBoot专注于快速方便的开发单个个体微服务。
   SpringCloud是专注全局的微服务协调治理框架，它将SpringBoot开发的一个个简单微服务整合并管理起来，为各个微服务之间提供配置管理、
   服务发现、断路器、路由、微代理、时间总线、全局锁、决策竞选、分布式会话等等集成服务
   SpringBoot可以离开SpringCloud独立使用开发项目，但是SpringCloud离不开SpringBoot，属于依赖的关系。
   SpringBoot专注于快速、方便的开发单个微服务个体，SpringCloud关注全局的服务治理框架。
 5)什么是服务熔断？什么是服务降级
 6)微服务的优缺点分别是什么？说下你在项目开发中碰到的坑
 7)你所知道的微服务技术栈有哪些？请列举一二
    微服务技术栈是指多种技术的集合体
    ----------------------------------------------------------------------------------
    -------  微服务条目                            落地技术
    服务开发                                  --SpringBoot、spring、springMVC
    服务配置与管理                            --Netflix公司的Archaius、阿里的Diamond等
    服务注册与发现                            --Eureka、 Consul、Zookeeper等
    服务调用                                  --Rest、RPC、gRPC
    服务熔断器                                --Hystix、Envoy等
    负载均衡                                  --Ribbon、Nginx等
    服务接口调用（客服端调用服务的简化工具）  --Feign等
    消息队列                                  --Kafka、RabbitMQ、ActiveMQ等
    服务配置中心管理                          --SpringCloudConfig、Chef等
    服务路由（API网关）                       --Zuul等
    服务监控                                  --Zabbix、Nagios、Metrics、Spectator等
    全链路追踪                                --Zipkin、Brave、Dapper等
    服务部署                                  --Docker、OpenStack、Kubernetes等
    数据流操作开发包                          --SpringCloud Stream(封装与Redis,Rabbit、Kafka等发送接收消息)
    事件消息总线                              --Spring Cloud Bus
    。。。

 8)eureka和zookeeper都可以提供注册服务与发现功能，请说说两者的区别？

------------------------------------------------------------------------------------------------------------------------

