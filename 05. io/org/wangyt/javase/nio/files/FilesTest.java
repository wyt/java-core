package org.wangyt.javase.nio.files;

import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilesTest {

  public static String filePath = "05. io/org/wangyt/javase/nio/files/FilesTest.java";
  public static String outPath = "05. io/org/wangyt/javase/nio/out.txt";

  public static void main(String[] args) throws Exception {

    // 复制文件
    Files.copy(Paths.get(filePath), new FileOutputStream(outPath));

    // 判断FilesTest.java文件是否为隐藏文件
    System.out.println("FilesTest.java是否为隐藏文件：" + Files.isHidden(Paths.get(filePath)));

    // 一次性读取FilesTest.java文件的所有行
    List<String> lines = Files.readAllLines(Paths.get(filePath), Charset.forName("UTF-8"));
    System.out.println(lines);

    // 判断指定文件的大小
    System.out.println("FilesTest.java的大小为：" + Files.size(Paths.get(filePath)));

    List<String> poem = new ArrayList<>();
    poem.add("水晶潭底银鱼跃");
    poem.add("清徐风中碧竿横");

    // 直接将多个字符串内容写入指定文件中
    Files.write(Paths.get(outPath), poem, Charset.forName("UTF-8"));

    // 使用Java 8新增的Stream API列出当前目录下所有文件和子目录
    Files.list(Paths.get(".")).forEach(path -> System.out.println(path));

    // 使用Java 8新增的Stream API读取文件内容
    Files.lines(Paths.get(filePath), Charset.forName("UTF-8"))
        .forEach(line -> System.out.println(line));

    // 判断C盘的总空间，可用空间
    FileStore cStore = Files.getFileStore(Paths.get("C:"));
    System.out.println("C:共有空间：" + cStore.getTotalSpace());
    System.out.println("C:可用空间：" + cStore.getUsableSpace());
  }
}
