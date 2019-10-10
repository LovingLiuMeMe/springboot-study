package cn.lovingliu.rabbitmqproducer.utils;

import java.util.Date;

/**
 * @Author：LovingLiu
 * @Description: 时间工具类
 * @Date：Created in 2019-09-24
 */
public class DateUtils {
    public static Date addMinutes(Date orderTime, int orderTimeout) {
        Date afterDate = new Date(orderTime.getTime() + 60000*orderTimeout);
        return afterDate;
    }
}
