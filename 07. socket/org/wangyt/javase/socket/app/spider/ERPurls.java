package org.wangyt.javase.socket.app.spider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author wangyongtao(sdwyt@foxmail.com)
 * 
 * @date 2014-3-12 上午8:56:57
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
public class ERPurls
{
    public static void main(String[] args) throws IOException
    {
    	List resultList = new ArrayList();
    	List resultListErr = new ArrayList();
    	
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
                    resultList.add(t_result + "秒");
                    System.out.println(t_result + "秒");

                    // break connection
                    conn.disconnect();
                } else
                {
                    System.out.println("N/A: " + url);
                    resultList.add("N/A");
                    resultListErr.add(url);
                }
            } catch (Exception e)
            {
                System.out.println("执行url发生异常，请手动执行：" + url);
                resultList.add("N/A");
                resultListErr.add(url);
            }
        }
        
        System.out.println(resultList.size());
        System.out.println(resultListErr.size());
    }
}
