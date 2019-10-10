package cn.lovingliu.rabbitmqproducer.service.impl;

import cn.lovingliu.rabbitmqproducer.constant.Constants;
import cn.lovingliu.rabbitmqproducer.dao.MessageLogMapper;
import cn.lovingliu.rabbitmqproducer.dao.OrderMapper;
import cn.lovingliu.rabbitmqproducer.domain.MessageLog;
import cn.lovingliu.rabbitmqproducer.domain.Order;
import cn.lovingliu.rabbitmqproducer.producer.RabbitOrderSender;
import cn.lovingliu.rabbitmqproducer.service.OrderService;
import cn.lovingliu.rabbitmqproducer.utils.DateUtils;
import cn.lovingliu.rabbitmqproducer.utils.FastJsonConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author：LovingLiu
 * @Description:
 * @Date：Created in 2019-09-24
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private MessageLogMapper messageLogMapper;

    @Autowired
    private RabbitOrderSender rabbitOrderSender;

    public void createOrder(Order order) throws Exception {
        // 插入消息记录表数据
        MessageLog messageLog = new MessageLog();
        // 消息唯一ID
        messageLog.setMessageId(order.getMessageId());
        // 保存消息整体 转为JSON 格式存储入库
        messageLog.setMessage(FastJsonConvertUtil.convertObjectToJSON(order));
        // 设置消息状态为0 表示发送中
        messageLog.setStatus("0");
        // 设置消息未确认超时时间窗口为 一分钟
        Date orderTime = new Date();
        messageLog.setNextRetry(DateUtils.addMinutes(orderTime, Constants.ORDER_TIMEOUT));
        messageLogMapper.insertSelective(messageLog);
        // 发送消息
        rabbitOrderSender.sendOrder(order);
    }
}
