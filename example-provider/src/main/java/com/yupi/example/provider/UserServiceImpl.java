package com.yupi.example.provider;

import com.yupi.example.common.model.User;
import com.yupi.example.common.service.UserService;

/**
 * 用户服务实现类
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @learn <a href="https://codefather.cn">编程宝典</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
public class UserServiceImpl implements UserService {

    // 传进来一个user 我对这个user做了某些操作之后，我又返回这个user，这样理解。
    public User getUser(User user) {
        // 这里只是一个简单的案例，实际的逻辑可能非常复杂
        System.out.println("用户名：" + user.getName());
        return user;
    }
}
