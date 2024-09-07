package com.yupi.example.consumer;

import com.yupi.example.common.model.User;
import com.yupi.example.common.service.UserService;
import com.yupi.yurpc.proxy.ServiceProxyFactory;

public class Consumer {
    public static void main(String[] args) {
        // 初始化
        com.yupi.yurpc.bootstrap.ConsumerBootstrap.init();

        // 获取代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("我是一只粉刷匠");
        // 调用rpc
        User newUser = userService.getUser(user);
        if (user != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("newUser is null");
        }
    }
}
