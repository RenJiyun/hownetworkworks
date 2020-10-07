package com.eggip.hownetworkworks.simplerpc;

public class HelloServiceConsumer {
    public static void main(String[] args) {
        HelloService helloService = RpcBuilder.build(HelloService.class);
        System.out.println(helloService.sayHello("chen"));
    }
}
