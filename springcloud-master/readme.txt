code introduction:
this is a projects which submit by me.



1、dubbo和springcloud的区别:
dubbo采用的是RPC协议进行通信，springcloud采用的是基于http的restful api进行通信。
（在性能上来说，由于Dubbo底层是使用Netty这样的NIO框架，是基于TCP协议传输的，配合以Hession序列化完成RPC。
而SpringCloud是基于Http协议+rest接口调用远程过程的，相对来说，Http请求会有更大的报文，占的带宽也会更多。）
2、微服务的优缺点

3、微服务面试题汇总
 1)什么是微服务
 2)微服务之间是如何独立通讯的
 3)springCloud和Dubbo有哪些区别
 4)Springboot和springcloud，请你谈谈对他们的理解
 5)什么是服务熔断？什么是服务降级
 6)微服务的优缺点分别是什么？说下你在项目开发中碰到的坑
 7)你所知道的微服务技术栈有哪些？请列举一二
 8)eureka和zookeeper都可以提供注册服务与发现功能，请说说两者的区别？