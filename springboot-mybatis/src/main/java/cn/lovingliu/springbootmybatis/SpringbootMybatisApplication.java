package cn.lovingliu.springbootmybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.lovingliu.springbootmybatis.dao")
//或者直接在Mapper类上面添加注解@Mapper
public class SpringbootMybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisApplication.class, args);
    }

}
