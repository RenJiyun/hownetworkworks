package com.eggip.hownetworkworks.demos;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerSocketChannelDemo {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8081));

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            System.out.println("接收到一个新的请求");

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        int bytesRead = socketChannel.read(byteBuffer);
                        while (bytesRead != -1) {
                            byteBuffer.flip();
                            while (byteBuffer.hasRemaining()) {
                                System.out.print((char) byteBuffer.get());
                            }

                            byteBuffer.clear();
                            bytesRead = socketChannel.read(byteBuffer);
                        }

                        socketChannel.close();
                    } catch (IOException e) {

                    }

                }
            }).start();


        }

    }
}
