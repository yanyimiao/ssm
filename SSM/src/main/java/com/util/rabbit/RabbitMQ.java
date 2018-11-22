package com.util.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

@Component
public class RabbitMQ {
    @Resource
    private RabbitTemplate rabbitTemplate;

    @Value("${exchage}")
    private String exchange;
    @Value("${routeKey}")
    private String routeKey;

    public  void  pushMessageToMq(String className, String methodName, Map<String,Object> param) {
        RabbitMessage msg = new RabbitMessage(exchange, routeKey, className, methodName, param);
        try {
            rabbitTemplate.convertAndSend(msg.getExchange(), msg.getRouteKey(), msg);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
