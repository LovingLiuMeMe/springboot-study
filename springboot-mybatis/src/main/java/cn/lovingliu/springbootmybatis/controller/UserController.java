package cn.lovingliu.springbootmybatis.controller;

import cn.lovingliu.springbootmybatis.domain.User;
import cn.lovingliu.springbootmybatis.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author：LovingLiu
 * @Description:
 * @Date：Created in 2019-09-23
 */
@RestController
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("save")
    public Map<String,String> save(User user){
        Integer resultCount = userService.save(user);
        Map<String,String> resultMap = new HashMap<>();
        if(resultCount > 0){
            resultMap.put("code","0");
            resultMap.put("msg","保存成功");
            return resultMap;
        }
        resultMap.put("code","1");
        resultMap.put("msg","保存失败");
        return resultMap;
    }

    @PostMapping("list")
    public Map<String,Object> list(User user){
        PageInfo<User> pageInfo = userService.list(1, 5);
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("code","0");
        resultMap.put("msg","查询成功");
        resultMap.put("data",pageInfo);
        return resultMap;
    }
}
