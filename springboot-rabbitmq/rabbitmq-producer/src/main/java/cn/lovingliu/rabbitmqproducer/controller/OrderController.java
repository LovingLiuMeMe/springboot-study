package cn.lovingliu.rabbitmqproducer.controller;

import cn.lovingliu.rabbitmqproducer.domain.Order;
import cn.lovingliu.rabbitmqproducer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author：LovingLiu
 * @Description: 订单order
 * @Date：Created in 2019-09-25
 */
@RestController
@RequestMapping("/order/")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("save")
    public Map<String,Object> save(Order order){
        Map<String,Object> map = new HashMap<>();

        order.setMessageId(order.getId()+"$"+UUID.randomUUID().toString());
        try {
            orderService.createOrder(order);
        }catch (Exception e){
            e.printStackTrace();
            map.put("code",1);
            map.put("msg","保存失败");
            return map;
        }

        map.put("code",0);
        map.put("msg","保存成功");
        return map;
    }
}
