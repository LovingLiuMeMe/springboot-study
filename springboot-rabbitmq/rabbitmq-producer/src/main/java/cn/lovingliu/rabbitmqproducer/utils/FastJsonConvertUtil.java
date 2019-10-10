package cn.lovingliu.rabbitmqproducer.utils;

import cn.lovingliu.rabbitmqproducer.domain.Order;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

/**
 * @Author：LovingLiu
 * @Description: json转换工具类
 * @Date：Created in 2019-09-24
 */
public class FastJsonConvertUtil {
    public static Order convertJSONToObject(String message, Object obj){
        Order order = JSON.parseObject(message, new TypeReference<Order>() {});
        return order;
    }

    public static String convertObjectToJSON(Object obj){
        String text = JSON.toJSONString(obj);
        return text;
    }
}
