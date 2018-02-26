package org.wangyt.javase.socket.udp.im;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author 王永涛
 * 
 * @date 2012-8-31 下午04:25:46
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,wangyongtao. All Rights Reserved.
 */
@SuppressWarnings("all")
public class ReceiveThread extends Thread
{
    // 数据报包的套接字
    private DatagramSocket ds;

    public ReceiveThread(int port)
    {
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
            byte[] buf = new byte[1024];
            // 构造 数据报包(DatagramPacket) ，用来接收长度为 length 的数据包(packets)。
            DatagramPacket dp = new DatagramPacket(buf, 1024);
            while (true)
            {
                ds.receive(dp);
                String msg = new String(dp.getData(), 0, dp.getLength());
                System.out.println("receive: " + msg);
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