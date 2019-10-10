package cn.lovingliu.springbootmybatis.service.impl;

import cn.lovingliu.springbootmybatis.dao.UserMapper;
import cn.lovingliu.springbootmybatis.domain.User;
import cn.lovingliu.springbootmybatis.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author：LovingLiu
 * @Description:
 * @Date：Created in 2019-09-23
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public int save(User user){
        int resultCount = userMapper.insert(user);
        return resultCount;
    }
    public PageInfo<User> list(Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userMapper.findProductList();
        PageInfo<User> pageInfo =  new PageInfo<>(userList);
        return pageInfo;
    }
}
