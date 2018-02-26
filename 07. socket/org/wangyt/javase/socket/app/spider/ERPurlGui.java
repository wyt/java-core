package org.wangyt.javase.socket.app.spider;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author wangyongtao(sdwyt@foxmail.com)
 * 
 * @date 2014-7-29 上午10:39:28
 * 
 * @version $Rev$
 * 
 * @id $Id${date}
 * 
 * @URL $URL$
 * 
 * @Copyright (c) Copyright 2014 yongtao.wang, All rights reserved.
 */
@SuppressWarnings("all")
public class ERPurlGui
{
    public static JFrame jf;
    public static JTextArea jta;

    public static void main(String[] args) throws Exception
    {
        jf = new JFrame("内部商城Web页面测试");
        jf.setLayout(new java.awt.BorderLayout());
        // jta = new JTextArea(statUrltims());

        jta = new JTextArea();

        // 设置文本域滚动条自动出现
        JScrollPane scroll = new JScrollPane(jta);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        /** 滚动条强制出现 **/
        // scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        // scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        jf.add(scroll, java.awt.BorderLayout.CENTER);

        showWindow(jf);
        statUrltimsVoid();
    }

    /**
     * 显示窗体的方法
     * 
     * @param jf
     */
    public static void showWindow(JFrame jf)
    {
        jf.setSize(400, 380);
        jf.getContentPane().setBackground(new Color(236, 233, 216));

        // 屏幕大小
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = jf.getSize();
        // 设置窗口在屏幕中的位置
        jf.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        // 窗口尺寸是否可变
        jf.setResizable(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    public static String statUrltims() throws IOException
    {
        StringBuilder urlInfo = new StringBuilder();

        BufferedReader br = new BufferedReader(new FileReader("io/org/xiaotao/javase/io/stream/urls.txt"));
        String line = null;

        URL url = null;

        while ((line = br.readLine()) != null)
        {
            long t_before = new java.util.Date().getTime();

            try
            {
                // System.out.println(line.trim());
                url = new URL(line.trim());
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.connect();

                // 202
                if (conn.getResponseCode() == HttpURLConnection.HTTP_OK)
                {
                    // print header
                    Map<String, List<String>> header = conn.getHeaderFields();
                    for (String key : header.keySet())
                    {
                        // System.out.println(key + ":" + header.get(key));
                    }

                    // print content
                    BufferedReader br2 = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
                    String content = null;
                    while ((content = br2.readLine()) != null)
                    {
                        // System.out.println(content);
                    }

                    long t_after = new java.util.Date().getTime();

                    float t_result = (float) (t_after - t_before) / 1000;
                    // System.out.println(t_result + "秒");

                    urlInfo.append(t_result + "秒\n");

                    // break connection
                    conn.disconnect();
                } else
                {
                    urlInfo.append("N/A: " + url + "\n");
                }
            } catch (Exception e)
            {
                urlInfo.append("执行url发生异常，请手动执行：" + url + "\n");
            }

        }

        return urlInfo.toString();
    }

    public static void statUrltimsVoid() throws IOException
    {
        StringBuilder urlInfo = new StringBuilder("->>>程序开始执行<<<-\n");

        BufferedReader br = new BufferedReader(new FileReader("io/org/xiaotao/javase/io/stream/urls.txt"));
        String line = null;

        URL url = null;

        /**
         * 注意不加这一行会报java.net.ProtocolException: Server redirected too many times (20)错误.
         * 
         * It's apparently redirecting in an infinite loop because you don't maintain the user
         * session.
         * 
         * The session is usually backed by a cookie. You need to create a CookieManager before you
         * 
         * use URLConnection.
         */
        CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));

        while ((line = br.readLine()) != null)
        {
            long t_before = new java.util.Date().getTime();

            try
            {
                // System.out.println(line.trim());
                url = new URL(line.trim());
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.connect();

                // 202
                if (conn.getResponseCode() == HttpURLConnection.HTTP_OK)
                {
                    // print header
                    Map<String, List<String>> header = conn.getHeaderFields();
                    for (String key : header.keySet())
                    {
                        // System.out.println(key + ":" + header.get(key));
                    }

                    // print content
                    BufferedReader br2 = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
                    String content = null;
                    while ((content = br2.readLine()) != null)
                    {
                        // System.out.println(content);
                    }

                    long t_after = new java.util.Date().getTime();

                    float t_result = (float) (t_after - t_before) / 1000;
                    // System.out.println(t_result + "秒");

                    urlInfo.append(t_result + "秒\n");

                    // break connection
                    conn.disconnect();
                } else
                {
                    urlInfo.append("N/A: " + url + "\n");
                }
            } catch (Exception e)
            {
                urlInfo.append("执行url发生异常，请手动执行：" + url + "\n");
                e.printStackTrace();
            }

            jta.setText(urlInfo.toString());
            jta.paintImmediately(jta.getBounds());
        }

        jta.setText(urlInfo.append("->>>程序执行完毕<<<-").toString());
        jta.paintImmediately(jta.getBounds());
    }
}
