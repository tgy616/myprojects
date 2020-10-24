package com.tgy.websocket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author DragonSwimDiving
 * @program websocket.demo
 * @Date 2020-08-11 15:39
 **/

public class UDPClient  {
    public static void main(String[] args) throws Exception {
        byte[] data = "我是客户端，我发送了一条消息".getBytes();
        InetAddress address = InetAddress.getByName("localhost");
        DatagramPacket packet = new DatagramPacket(data,data.length,address,8888);
        DatagramSocket socket = new DatagramSocket();
        socket.send(packet);

        byte[] message = new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(message,message.length);
        socket.receive(packet1);
        String replyContent = new String(message,0,message.length);
        System.out.println("UDPClient 接收到了消息："+replyContent);
        socket.close();
    }
}
