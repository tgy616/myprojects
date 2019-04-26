package com.tgy.ticket.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @author tanggy
 * @date 2018/9/30
 */
@Component
@Service //将服务发布出去
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {

        return "<<厉害了我的国>>";
    }
}
