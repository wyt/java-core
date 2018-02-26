package org.wangyt.javase.socket.udp.im;

/**
 * 即时聊天，使用时需要在命令行中提供3个参数，即接收端口号/发送端口号/和对方的端口号。
 * 
 * 当演示该程序的时候，需要开启两个cmd。
 * 
 * 例如：一个命令行参数为 1111 2222 3333
 *              另一个为 3333 4444 1111
 * 
 * @author 王永涛
 * 
 * @date 2012-8-31 下午04:24:36
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,wangyongtao. All Rights Reserved.
 */
public class Chat
{
    public static void main(String[] args)
    {
        /**
         * args format: 接收端口，发送端口，对方接收端口。
         */
        // 启动接受线程
        new ReceiveThread(Integer.parseInt(args[0])).start();

        // 启动发送线程
        new SendThread(Integer.parseInt(args[1]), Integer.parseInt(args[2])).start();
    }
}