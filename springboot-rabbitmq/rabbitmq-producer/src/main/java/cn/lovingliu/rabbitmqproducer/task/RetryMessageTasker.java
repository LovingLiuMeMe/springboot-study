package cn.lovingliu.rabbitmqproducer.task;

import cn.lovingliu.rabbitmqproducer.constant.Constants;
import cn.lovingliu.rabbitmqproducer.dao.MessageLogMapper;
import cn.lovingliu.rabbitmqproducer.domain.MessageLog;
import cn.lovingliu.rabbitmqproducer.domain.Order;
import cn.lovingliu.rabbitmqproducer.producer.RabbitOrderSender;
import cn.lovingliu.rabbitmqproducer.utils.FastJsonConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author：LovingLiu
 * @Description:
 * @Date：Created in 2019-09-25
 */
@Component
public class RetryMessageTasker {


    @Autowired
    private RabbitOrderSender rabbitOrderSender;

    @Autowired
    private MessageLogMapper messageLogMapper;

    /**
     * 项目启动3s后 每个10s执行一次
    */
    @Scheduled(initialDelay = 3000, fixedDelay = 10000)
    public void reSend(){
        System.out.println("-----------定时任务开始-----------");
        //查询超过有效时间 且 状态为0的 消息
        List<MessageLog> list = messageLogMapper.query4StatusAndTimeoutMessage();
        list.forEach(messageLog -> {
            if(messageLog.getTryCount() >= 3){
                // 重新投递的次数已经是第4次了
                messageLogMapper.changeBrokerMessageLogStatus(messageLog.getMessageId(), Constants.ORDER_SEND_FAILURE);
            } else {
                // 次数还么有超过限制 再次投递
                messageLogMapper.update4ReSend(messageLog.getMessageId());
                Order reSendOrder = FastJsonConvertUtil.convertJSONToObject(messageLog.getMessage(), Order.class);
                try {
                    rabbitOrderSender.sendOrder(reSendOrder);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println("-----------异常处理-----------");
                }
            }
        });
    }
}
