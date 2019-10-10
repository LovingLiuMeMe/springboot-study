package cn.lovingliu.rabbitmqproducer.producer;

import cn.lovingliu.rabbitmqproducer.domain.Order;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author：LovingLiu
 * @Description: 发送消息
 * @Date：Created in 2019-09-24
 */
@Component
public class OrderSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(Order order){
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(order.getMessageId());
        /**
         * 配置Jackson2JsonMessageConverter,使其序列化和反序列化JSON格式对象。
         * 不配置时 默认使用字节数组 SimpleMessageConverter
        */
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());

        /**
         * correlationData:消息的唯一ID
        */
        rabbitTemplate.convertAndSend("order-exchange","order.abcd",order,correlationData);
        /**
         * 还要在 rabbitmq 控制台配置exchange和queue，并绑定
         * 加绑定在控制台的exchange和queues哪一块都可以
         */
    }
}
