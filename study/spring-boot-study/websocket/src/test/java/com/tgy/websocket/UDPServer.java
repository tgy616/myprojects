package com.tgy.websocket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author DragonSwimDiving
 * @program websocket.demo
 * @Date 2020-08-11 15:41
 **/

public class UDPServer{
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(8888);
        byte[] data = new byte[1024];
        DatagramPacket packet = new DatagramPacket(data,data.length);
        socket.receive(packet);
        String message = new String(data,0,packet.getLength());
        System.out.println("UDPServer 接收到了消息："+message);

        InetAddress address = packet.getAddress();
        int port = packet.getPort();
        byte[] replyContent = "我是服务端，我回复了一条消息".getBytes();
        DatagramPacket packet1 = new DatagramPacket(replyContent, replyContent.length, address, port);
        socket.send(packet1);
        socket.close();
    }

}
