package com.eggip.hownetworkworks.simplerpc;

public class HelloServiceProvider {
    public static void main(String[] args) {
        HelloServiceImpl helloService = new HelloServiceImpl();
        Rpc.<HelloService>provide(HelloService.class, HelloServiceImpl.class);
    }
}
