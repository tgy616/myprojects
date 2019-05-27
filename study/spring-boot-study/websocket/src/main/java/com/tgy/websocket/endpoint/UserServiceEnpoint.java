package com.tgy.websocket.endpoint;

import com.tgy.websocket.domain.User;
import com.tgy.websocket.domain.UserIdRequest;
import com.tgy.websocket.domain.UserResponse;
import com.tgy.websocket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * 用户服务Endpoint
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see
 * @since 2017.08.19
 */
@Endpoint
public class UserServiceEnpoint {


    @Autowired
    private UserRepository userRepository;

    @PayloadRoot(namespace = "http://segmentfault.com/schemas", localPart = "UserIdRequest")
    @ResponsePayload
    public UserResponse getUser(@RequestPayload UserIdRequest userIdRequest) {

        long userId = userIdRequest.getUserId();

        Instant instant = Instant.ofEpochMilli(userIdRequest.getTimestamp());
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        System.out.println("Web Services 用户 ID :" + userId + " , 请求的时间 : " + zonedDateTime);

        User user = userRepository.findById(userId);

        UserResponse userResponse = new UserResponse();

        userResponse.setUser(user);
        userResponse.setTimestamp(Instant.now().toEpochMilli());

        return userResponse;
    }


}
