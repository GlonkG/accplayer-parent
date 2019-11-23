/*
package com.congee.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


*/
/**
 * @author: 小米粥
 * @description: com.itqf.utils
 * @date: 2019/10/25
 * @time: 11:44
 *//*

@Configuration
public class RabbitConfig {
    //创建队列
    @Bean
    public Queue mailqueue(){
        return new Queue("mailqueue");
    }
    //创建交换机
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topicExchange");
    }
    //绑定交换机和队列
    @Bean
    public Binding binding(Queue mailqueue,TopicExchange topicExchange){
        return BindingBuilder.bind(mailqueue).to(topicExchange).with("routeKey");
    }
    //从配置文件中获得配置
    @Value("${spring.rabbitmq.host}")
    private String host;
    @Value("${spring.rabbitmq.port}")
    private String port;
    @Value("${spring.rabbitmq.username}")
    private String username;
    @Value("${spring.rabbitmq.password}")
    private String password;
    @Value("${spring.rabbitmq.publisher-confirms}")
    private boolean confirms;
    @Value("${spring.rabbitmq.virtual-host}")
    private String virtual;
    //设置连接工厂
    @Bean
    public ConnectionFactory getConnectionFactory(){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses(host+":"+port);//设置 RabbitMq 连接IP
        connectionFactory.setUsername(username);//设置 RabbitMq 连接名称
        connectionFactory.setPassword(password);//设置 RabbitMq 连接密码
        connectionFactory.setPublisherConfirms(confirms);//设置 RabbitMq 是否开启发布确认机制
        connectionFactory.setVirtualHost(virtual);//设置 RabbitMq 连接虚拟主机
        return connectionFactory;
    }
    //自定义 RabbitTemplate
    @Bean
    public RabbitTemplate myRabbitTemplate(@Qualifier("getConnectionFactory")ConnectionFactory getConnectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(getConnectionFactory);
        return rabbitTemplate;
    }
}
*/
