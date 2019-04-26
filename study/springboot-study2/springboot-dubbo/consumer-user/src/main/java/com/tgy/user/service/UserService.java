package com.tgy.user.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tgy.ticket.service.TicketService;
import org.springframework.stereotype.Service;

/**
 * @author tanggy
 * @date 2018/9/30
 */
@Service
public class UserService {
    @Reference
    TicketService ticketService;

    public void hello(){
        String ticket = ticketService.getTicket();
        System.out.println("买到票了："+ticket);
    }
}
