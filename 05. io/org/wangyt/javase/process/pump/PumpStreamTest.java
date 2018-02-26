package org.wangyt.javase.process.pump;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@SuppressWarnings("all")
public class PumpStreamTest {

  public static void main(String[] args) throws IOException {
    // exec("ping /t 127.0.0.1");
    pumpExec("ping /t 127.0.0.1");
  }

  /**
   * 调用外部命令，刷新缓冲区.
   * 
   * @param cmd
   * @return
   * @throws IOException
   */
  public static int pumpExec(String cmd) throws IOException {
    Process process = null;
    PumpStreamHandler streams = null;
    try {
      process = Runtime.getRuntime().exec(cmd);
      streams = new PumpStreamHandler();
      streams.setProcessOutputStream(process.getInputStream());
      streams.setProcessErrorStream(process.getErrorStream());
      streams.setProcessInputStream(process.getOutputStream());
      streams.start();
      return process.waitFor();
    } catch (InterruptedException e) {
      e.printStackTrace();
      if (process != null) {
        process.destroy();
        process = null;
      }
      return 0;
    } finally {
      Thread.interrupted();
      if (streams != null) {
        streams.stop();
      }
    }
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
