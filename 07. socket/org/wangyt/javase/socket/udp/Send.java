package org.wangyt.javase.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 发送端
 * 
 * @author 王永涛
 * 
 * @date 2012-8-31 下午02:09:16
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,wangyongtao. All Rights Reserved.
 */
public class Send
{
    public static void main(String[] args) throws IOException
    {
        /**
         * 创建 DatagramSocket(数据报套接字)，指定端口
         */
        DatagramSocket s_socket = new DatagramSocket(9998);

        String msg = "hello,world!";

        /**
         * 创建数据包对象
         */
        DatagramPacket dp = new DatagramPacket(msg.getBytes(), 0, msg.length(), InetAddress.getByName("127.0.0.1"), 9999);

        s_socket.send(dp);
        s_socket.close();
    }
}