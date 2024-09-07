package com.yupi.example.provider;

import com.yupi.example.common.service.UserService;
import com.yupi.yurpc.registry.LocalRegistry;
import com.yupi.yurpc.server.HttpServer;
import com.yupi.yurpc.server.VertxHttpServer;

/**
 * 简易服务提供者示例
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @learn <a href="https://codefather.cn">编程宝典</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
public class EasyProviderExample {

    public static void main(String[] args) {
        // 注册服务  getName是获得类名！！  注册名是UserService 服务名是UserServiceImpl UserService.class 获取了 UserService 接口的 Class 对象。
        //.getName() 方法返回该类的完整类名，包括包名。例如，如果 UserService
        // 接口在 com.example.services 包中，那么 UserService.class.getName()
        // 将返回 "com.example.services.UserService"。
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8080);
    }
}
