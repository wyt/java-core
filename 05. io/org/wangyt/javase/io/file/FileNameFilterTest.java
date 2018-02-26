package org.wangyt.javase.io.file;

/**
 * 遍历c盘中的exe文件,看API就能明白。
 * 
 * 注意windows中有些目录进不去，会报空指针异常
 * 
 * @author 王永涛
 *
 * @date 2012-6-28 下午10:28:28
 *
 * @version v1.0
 *
 * @Copyright (c) 2012,Jinan Lumeida Software Technology Co.,LTD. All Rights Reserved.
 */
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class FileNameFilterTest
{
	public static void main(String[] args)
	{
		FilterPrintExe(new File("E:\\wangyt\\传智播客_张孝祥_Java多线程与并发库高级应用视频教程下载"));
	}

	public static void FilterPrintExe(File dir)
	{
		// 过滤出dir中的目录(即文件夹)
		File[] dirs = dir.listFiles(new FileFilter()
		{
			public boolean accept(File pathname)
			{
				return pathname.isDirectory();
			}
		});

		// 过滤出dir中以.exe结尾的文件。
		File[] exes = dir.listFiles(new FilenameFilter()
		{
			// dir - 被找到的文件所在的目录。name - 文件的名称,接口方法，参数的用途都事先定义好的
			public boolean accept(File dir, String name)
			{
				return name.toLowerCase().endsWith(".avi");
			}
		});

		for (File d : dirs)
		{
			// System.out.println(d);
			FilterPrintExe(d);
		}

		for (File e : exes)
		{
			System.out.println(e);
		}
	}
}