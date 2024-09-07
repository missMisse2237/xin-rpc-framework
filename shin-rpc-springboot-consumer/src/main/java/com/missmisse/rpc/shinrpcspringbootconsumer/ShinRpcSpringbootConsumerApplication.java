package com.missmisse.rpc.shinrpcspringbootconsumer;

import com.missmisse.rpc.shinrpcspringbootstarter.annocation.EnableRpc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRpc
public class ShinRpcSpringbootConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShinRpcSpringbootConsumerApplication.class, args);
    }

}
