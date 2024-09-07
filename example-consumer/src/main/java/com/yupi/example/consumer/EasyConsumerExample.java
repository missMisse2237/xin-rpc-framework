package com.yupi.example.consumer;

import com.yupi.example.common.model.User;
import com.yupi.example.common.service.UserService;
import com.yupi.yurpc.proxy.ServiceProxyFactory;

/**
 * 简易服务消费者示例
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @learn <a href="https://codefather.cn">编程宝典</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
public class EasyConsumerExample {

    public static void main(String[] args) {
        // 静态代理
//        UserService userService = new UserServiceProxy();
        // 动态代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        // 定义一个user？ 设置他的名字
        User user = new User();
        user.setName("我不是迪丽热巴");
        // 调用-- >这里调用是什么意思？
        // 是在这一步 怎么理解？ --》 我提前创建好代理对象，等你调用服务端的功能的时候代理对象就自动发送请求，并且获得返回值
        // 是userService 调用，不是user 嘿嘿
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
    }
}
