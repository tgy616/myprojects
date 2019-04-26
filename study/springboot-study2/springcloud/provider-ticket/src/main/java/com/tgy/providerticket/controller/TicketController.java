package com.tgy.providerticket.controller;

import com.tgy.providerticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tanggy
 * @date 2018/10/8
 */
@RestController
public class TicketController{
    @Autowired
    TicketService ticketService;

    @GetMapping("/ticket")
    public String getTicket(){
        return ticketService.getTicket();
    }
}
