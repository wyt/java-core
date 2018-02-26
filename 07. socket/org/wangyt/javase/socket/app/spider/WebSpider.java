package org.wangyt.javase.socket.app.spider;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * 网络爬虫(爬取网页内容)
 * 
 * @author 王永涛
 * 
 * @date 2012-8-31 下午03:59:20
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,wangyongtao. All Rights Reserved.
 */
@SuppressWarnings("all")
public class WebSpider
{
    public static void main(String[] args) throws Exception
    {
        // java.util.Date date = new java.util.Date();
        // System.out.println(new Timestamp(date.getTime()));

        long t_before = new java.util.Date().getTime();

        URL url = new URL("http://www.portal.unicom.local/default/home");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.connect();

        System.out.println(conn.getResponseCode());

        // print header
        Map<String, List<String>> header = conn.getHeaderFields();
        for (String key : header.keySet())
        {
            // System.out.println(key + ":" + header.get(key));
        }

        // print content
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
        String content = null;
        while ((content = br.readLine()) != null)
        {
            // System.out.println(content);
        }

        long t_after = new java.util.Date().getTime();

        float t_result = (float) (t_after - t_before) / 1000;
        System.out.println("t_result: " + t_result);

        // break connection
        conn.disconnect();

        // 调用本地浏览器打开一个网页
        // java.net.URI uri = new java.net.URI("http://geminiyoung.iteye.com/");
        // java.awt.Desktop.getDesktop().browse(uri);

    }
}