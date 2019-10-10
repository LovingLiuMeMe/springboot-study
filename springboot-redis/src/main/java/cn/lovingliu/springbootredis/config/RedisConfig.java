package cn.lovingliu.springbootredis.config;

import cn.lovingliu.springbootredis.util.RedisConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Author：LovingLiu
 * @Description: 覆盖 redisTemplate,加入自己的序列化器。
 * public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory)
 * @Date：Created in 2019-09-18
 */

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());//设置key的序列化器
        redisTemplate.setValueSerializer(new RedisConverter());//设置值的序列化器
        return redisTemplate;
    }
}
