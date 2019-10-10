package cn.lovingliu.rabbitmqproducer.producer;

import cn.lovingliu.rabbitmqproducer.domain.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * @Author：LovingLiu
 * @Description:
 * @Date：Created in 2019-09-24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderSenderTest {
    @Autowired
    private OrderSender orderSender;
    @Test
    public void send() {
        Order order = new Order();
        order.setId(2);
        order.setName("lovingliu2");
        order.setMessageId(UUID.randomUUID().toString());
        orderSender.send(order);
    }
}