package cn.lovingliu.springbootmybatis.service;

import cn.lovingliu.springbootmybatis.domain.User;
import com.github.pagehelper.PageInfo;

/**
 * @Author：LovingLiu
 * @Description:
 * @Date：Created in 2019-09-23
 */
public interface UserService {
    int save(User user);
    PageInfo<User> list(Integer pageNum, Integer pageSize);
}
