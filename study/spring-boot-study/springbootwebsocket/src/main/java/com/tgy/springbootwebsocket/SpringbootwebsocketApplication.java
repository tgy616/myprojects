package com.tgy.springbootwebsocket;

import com.tgy.springbootwebsocket.websocket.ChatRomServerEndpoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@SpringBootApplication
public class SpringbootwebsocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootwebsocketApplication.class, args);
    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
    @Bean
    public ChatRomServerEndpoint chatRoomServerEndpoint() {
        return new ChatRomServerEndpoint();
    }
}
