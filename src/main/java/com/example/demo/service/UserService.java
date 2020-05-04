package com.example.demo.service;

import com.example.demo.bean.Result;
import com.example.demo.bean.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 注册
     * @Param user参数封装
     * @Return Result结果封装
     */
    public Result register(User user){
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        User existUser = userMapper.findUserByName(user.getUsername());
        if (existUser != null){
            result.setMsg("用户名已存在");
        }else {
            userMapper.regiser(user);
            //System.out.println(user.getId());
            result.setMsg("注册成功");
            result.setSuccess(true);
            result.setDetail(user);
        }
        return result;
    }

    /**
     * 登录
     * @Param user 用户名和密码
     * @return result
     */
    public Result login(User user){
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        Long useID = userMapper.longin(user);
        if (useID == null) {
            result.setMsg("用户名或密码错误");
        }else {
            result.setMsg("登陆成功");
            result.setSuccess(true);
            user.setId(useID);
            result.setDetail(user);
        }
        return result;
    }
}
