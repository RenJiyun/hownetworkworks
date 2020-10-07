package com.eggip.hownetworkworks.demos;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketChannelDemo {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress(8081));
        InputStream in = System.in;
        int a = in.read();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (a != -1) {
            byteBuffer.put((byte) a);
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                System.out.println((char)a);
                socketChannel.write(byteBuffer);
            }
            byteBuffer.clear();
            a = in.read();

        }
    }
}
