package com.missmisse.rpc.shinrpcspringbootprovider;

import com.missmisse.rpc.shinrpcspringbootstarter.annocation.EnableRpc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRpc
public class ShinRpcSpringbootProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShinRpcSpringbootProviderApplication.class, args);
    }

}
