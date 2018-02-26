package org.wangyt.javase.io.stream;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

/**
 * 获得系统的信息，通过System.getProperties()得到的属性值中，其中user.dir表示虚拟机启动的路径，
 * 
 * java 程序中的相对路径就是相对于此。
 * 
 * @author 王永涛
 * 
 * @date 2012-7-4 下午04:34:59
 * 
 * @version v1.0
 * 
 * @Copyright (c) 2012,Jinan Lumeida Software Technology Co.,LTD. All Rights Reserved.
 */
@SuppressWarnings("all")
public class getUserDir
{
    public static void main(String[] args)
    {
        Properties properties = System.getProperties();
        Set set = properties.entrySet();
        Iterator it = set.iterator();

        while (it.hasNext())
        {
            Map.Entry entry = (Entry) it.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println(key + "=" + value);
        }
    }
}