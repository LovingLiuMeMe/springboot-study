package cn.lovingliu.springbootmybatis.service.impl;

import cn.lovingliu.springbootmybatis.domain.User;
import cn.lovingliu.springbootmybatis.service.UserService;
import com.github.pagehelper.PageInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author：LovingLiu
 * @Description:
 * @Date：Created in 2019-09-23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    public void save() {
        User user = new User();
        user.setUsername("lovingliu");
        user.setPassword("12345");
        user.setEmail("lovingliu@126.com");
        user.setPhone("19828304479");
        user.setQuestion("question?");
        user.setAnswer("answer");
        user.setRole(0);
        Integer resultCount = userService.save(user);
        Assert.assertEquals(new Integer(1),resultCount);
    }

    @Test
    public void findUserList(){
        Integer pageNum = 1;
        Integer pageSize = 10;
        PageInfo pageInfo = userService.list(pageNum, pageSize);
        System.out.println(pageInfo);

    }
}