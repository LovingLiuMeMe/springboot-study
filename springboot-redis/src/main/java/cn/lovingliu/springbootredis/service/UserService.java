package cn.lovingliu.springbootredis.service;

import cn.lovingliu.springbootredis.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author：LovingLiu
 * @Description:
 * @Date：Created in 2019-09-18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserService {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final String userKey="lovingliu";
    private static final String stringKey = "string";

    @Test
    public void setObject(){
        stringRedisTemplate.opsForValue().set(stringKey,"www.loingliu.cn");

        User user = new User();
        user.setName("lovingliu");
        user.setAge(22);
        redisTemplate.opsForValue().set(userKey,user);
        System.out.println("保存成功");
    }

    @Test
    public void vertifyObject(){
        String string = stringRedisTemplate.opsForValue().get(stringKey);
        User user = (User)redisTemplate.opsForValue().get(userKey);
        System.out.println("string:"+string);
        System.out.println(user);
    }
}
