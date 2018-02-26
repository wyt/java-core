package org.wangyt.javase.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@SuppressWarnings("all")
public class CallCmd {

  public static void main(String[] args) {
    exec("ping /t 127.0.0.1");
  }

  /**
   * 外部命令.
   * 
   * @param cmd
   * @throws IOException
   * @throws InterruptedException
   */
  public static void exec(String cmd) {

    String normal = "", error = "";
    InputStream normalIn = null;
    InputStream errorIn = null;

    try {
      Process process = Runtime.getRuntime().exec(cmd);

      // 子线程正常输出
      normalIn = process.getInputStream();
      // 子线程错误输出
      errorIn = process.getErrorStream();

      BufferedReader normalReader =
          new BufferedReader(new InputStreamReader(normalIn, getCharset()));
      BufferedReader errorReader = new BufferedReader(new InputStreamReader(errorIn, getCharset()));

      while ((normal = normalReader.readLine()) != null) {
        System.out.println(normal);
      }

      while ((error = errorReader.readLine()) != null) {
        System.out.println(error);
      }

      int exitCdoe = process.waitFor();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException ie) {
      ie.printStackTrace();
    } finally {
      try {
        if (normalIn != null) {
          normalIn.close();
        }
        if (errorIn != null) {
          errorIn.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * 获取虚拟机默认字符集.
   * 
   * @return
   */
  public static String getCharset() {

    String charset = System.getProperty("sun.jnu.encoding");
    if (charset == null) {
      charset = System.getProperty("file.encoding");
    }
    return charset;
  }

}
