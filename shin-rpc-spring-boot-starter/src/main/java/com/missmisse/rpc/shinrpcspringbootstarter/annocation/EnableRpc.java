package com.missmisse.rpc.shinrpcspringbootstarter.annocation;

import com.missmisse.rpc.shinrpcspringbootstarter.bootstrap.RpcConsumerBootstrap;
import com.missmisse.rpc.shinrpcspringbootstarter.bootstrap.RpcInitBootstrap;
import com.missmisse.rpc.shinrpcspringbootstarter.bootstrap.RpcProviderBootstrap;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 启用 Rpc 注解
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @learn <a href="https://codefather.cn">程序员鱼皮的编程宝典</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({RpcInitBootstrap.class, RpcProviderBootstrap.class, RpcConsumerBootstrap.class})
public @interface EnableRpc {

    /**
     * 需要启动 server ————》因为消费端不用开启server
     *
     * @return
     */
    boolean needServer() default true;
}
