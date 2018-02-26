package org.wangyt.javase.io.file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 把文件命中的商密替换掉
 * 
 * @author wangyongtao(sdwyt@foxmail.com)
 * 
 * @date 2014-8-28 上午9:26:59
 * 
 * @version $Rev$
 * 
 * @id $Id${date}
 * 
 * @URL $URL$
 * 
 * @Copyright (c) Copyright 2014 yongtao.wang, All rights reserved.
 */

public class RenameFile
{

    public static void main(String[] args)
    {
        // String a = "Workflow-5103-工作流管理系统文件箱子系统使用说明【商密】v1.0.pdf";
        // System.out.println(a.replace("商密", ""));

        File file = new File("E:/重要/2011 - 2012【济南鲁美达软件技术有限公司】/工作日志/2012-1-6(垦利)/有生RiseNet【商密】");
        rename(file);
    }

    public static void rename(File file)
    {

        // 过滤出dir中以.exe结尾的文件。
        File[] secrets = file.listFiles(new FilenameFilter()
        {
            // dir - 被找到的文件所在的目录。name - 文件的名称
            public boolean accept(File dir, String name)
            {
                // return name.toLowerCase().endsWith(".exe");
                return name.contains("商密");
            }
        });

        for (File source : secrets)
        {
            // System.out.println(source.getAbsolutePath());
            File dest = new File(source.getParent() + File.separator + source.getName().replace("商密", ""));
            // System.out.println(dest.getAbsolutePath());
            source.renameTo(dest);
        }
    }
}
