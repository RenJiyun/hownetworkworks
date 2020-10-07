package com.eggip.hownetworkworks.simplerpc;

public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }
}
