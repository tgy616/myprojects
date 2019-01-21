code introduction:
this is a projects which submit by me.



dubbo和springcloud的区别:
1、dubbo采用的是RPC协议进行通信，springcloud采用的是基于http的restful api进行通信。
（在性能上来说，由于Dubbo底层是使用Netty这样的NIO框架，是基于TCP协议传输的，配合以Hession序列化完成RPC。
而SpringCloud是基于Http协议+rest接口调用远程过程的，相对来说，Http请求会有更大的报文，占的带宽也会更多。）
2、