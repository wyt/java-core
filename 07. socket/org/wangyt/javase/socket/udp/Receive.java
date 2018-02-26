package org.wangyt.javase.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 接收端
 * 
 * @author 王永涛
 * 
 * @date 2012-8-31 下午02:09:10
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,wangyongtao. All Rights Reserved.
 */
public class Receive
{
    public static void main(String[] args) throws IOException
    {
        /**
         * 创建 DatagramSocket(数据报套接字)，指定端口
         */
        DatagramSocket s_socket = new DatagramSocket(9999);

        byte[] buf = new byte[1024];
        /**
         * 创建一个数据包对象
         */
        DatagramPacket dp = new DatagramPacket(buf, 1024);
        /**
         * 接受消息
         */
        s_socket.receive(dp);

        String msg = new String(dp.getData(), 0, dp.getLength());

        System.out.println(msg);

        s_socket.close();
    }
}