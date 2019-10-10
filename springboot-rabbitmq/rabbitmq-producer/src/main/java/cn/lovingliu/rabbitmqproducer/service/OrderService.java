package cn.lovingliu.rabbitmqproducer.service;

import cn.lovingliu.rabbitmqproducer.domain.Order;

/**
 * @Author：LovingLiu
 * @Description:
 * @Date：Created in 2019-09-24
 */
public interface OrderService {
    void createOrder(Order order) throws Exception;
}
