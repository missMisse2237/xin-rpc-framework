package com.yupi.example.provider;

import com.yupi.example.common.service.UserService;
import com.yupi.yurpc.RpcApplication;
import com.yupi.yurpc.config.RegistryConfig;
import com.yupi.yurpc.config.RpcConfig;
import com.yupi.yurpc.model.ServiceMetaInfo;
import com.yupi.yurpc.registry.LocalRegistry;
import com.yupi.yurpc.registry.Registry;
import com.yupi.yurpc.registry.RegistryFactory;
import com.yupi.yurpc.server.HttpServer;
import com.yupi.yurpc.server.VertxHttpServer;

public class ProviderExample {
    public static void main(String[] args) {
        // 注意服务者是RpcApplication.init();  消费者是注意服务者是RpcApplication.getRpcConfig();
        // 为什么呢？
        /*
        当RPC框架中的某个服务作为提供者启动时，
        它需要进行一系列的初始化操作来准备接收来自客户端的调用请求。这些初始化操作可能包括：端口号、序列化方式、线程池大小
        消费者：-> 去使用和服务者一样的配置
         */
        // RPC框架初始化
        RpcApplication.init();

        // 注册服务
        String serviceName = UserService.class.getName();
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        // 注册服务到注册中心
        RpcConfig rpcConfig = RpcApplication.getRpcConfig();
        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
        ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
        serviceMetaInfo.setServiceName(serviceName);
        serviceMetaInfo.setServiceAddress(rpcConfig.getServerHost() + ":" + rpcConfig.getServerPort());
        try {
            registry.register(serviceMetaInfo);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 启动web服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());



    }
}
