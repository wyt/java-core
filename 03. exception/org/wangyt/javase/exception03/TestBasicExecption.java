package org.wangyt.javase.exception03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@SuppressWarnings("all")
public class TestBasicExecption {
   public String getFis() {
      String str = null;
      try {
         FileInputStream fis = new FileInputStream("E:/号码.txt");
         byte[] b = new byte[1024];
         fis.read(b, 0, b.length);
         str = new String(b, "ISO-8859-1");
      } catch (FileNotFoundException e) {
         e.printStackTrace();
         throw new BusinessExecption("File Not Found." + e.getMessage());
      } catch (IOException e) {
         throw new BusinessExecption("流异常" + e.getMessage());
      } catch (NullPointerException e) {
         throw new BusinessExecption("空指针错误:" + e.getMessage());
      }
      return str;
   }
}
