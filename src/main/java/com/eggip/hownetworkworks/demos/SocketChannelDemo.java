package com.eggip.hownetworkworks.demos;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketChannelDemo {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress(8081));
        String s="hello world!!!!";
        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
        byteBuffer.clear();
        byteBuffer.put(s.getBytes());
        byteBuffer.flip();
        System.out.println("byteBuffer.get()");
        while (byteBuffer.hasRemaining()){
            socketChannel.write(byteBuffer);
            System.out.print((char) byteBuffer.get());
        }


    }
}
