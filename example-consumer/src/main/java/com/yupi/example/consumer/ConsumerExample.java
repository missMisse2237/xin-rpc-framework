package com.yupi.example.consumer;

import com.yupi.example.common.model.User;
import com.yupi.example.common.service.UserService;
//import com.yupi.yurpc.bootstrap.ConsumerBootstrap;
import com.yupi.yurpc.RpcApplication;
import com.yupi.yurpc.config.RpcConfig;
import com.yupi.yurpc.proxy.ServiceProxyFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * 服务消费者示例
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @learn <a href="https://codefather.cn">编程宝典</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
public class ConsumerExample {

    public static void main(String[] args) {

        // 获取代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("我不是迪丽热巴，我12是古力娜扎"); // 如果用mock的花就没用了
        // 调用
        User newUser = userService.getUser(user);
        System.out.println(newUser);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
    }
}
