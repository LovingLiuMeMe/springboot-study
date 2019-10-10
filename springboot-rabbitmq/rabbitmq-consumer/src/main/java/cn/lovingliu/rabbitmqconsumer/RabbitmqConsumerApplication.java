package cn.lovingliu.rabbitmqconsumer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.lovingliu.rabbitmqconsumer.dao")
public class RabbitmqConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqConsumerApplication.class, args);
    }

}
