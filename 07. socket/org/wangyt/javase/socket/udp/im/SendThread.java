package org.wangyt.javase.socket.udp.im;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author 王永涛
 * 
 * @date 2012-8-31 下午04:25:58
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,wangyongtao. All Rights Reserved.
 */
@SuppressWarnings("all")
public class SendThread extends Thread
{
    private DatagramSocket ds;

    private int sendPort;

    public SendThread(int port, int sendPort)
    {
        this.sendPort = sendPort;
        try
        {
            this.ds = new DatagramSocket(port);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void run()
    {
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String msg = null;
            while ((msg = br.readLine()) != null)
            {
                // 构造数据报包，用来将长度为 length 的包发送到指定主机上的指定端口号。
                DatagramPacket dp = new DatagramPacket(msg.getBytes(), 0, msg.length(), InetAddress.getByName("127.0.0.1"), sendPort);
                ds.send(dp);
                System.out.println("send: " + msg);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            ds.close();
        }
    }
}