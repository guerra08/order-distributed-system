package com.example.demo.service;

import com.example.demo.domain.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private RabbitTemplate template;

    public void dispatchToQueues(Order order){
        template.convertAndSend("NotificationQueue", order);
        template.convertAndSend("ReceiptQueue", order);
    }

}
