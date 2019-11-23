/*
package com.congee.service.impl;
import com.congee.domain.User;
import com.congee.service.MailService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

*/
/**
 * @author: 小米粥
 * @description: com.itqf.service.impl
 * @date: 2019/10/25
 * @time: 11:53
 *//*

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Override
    public void send(User user) {
        rabbitTemplate.convertAndSend("topicExchange","routeKey",user);
    }
}
*/
