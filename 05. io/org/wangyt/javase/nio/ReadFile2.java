package org.wangyt.javase.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import org.apache.commons.lang3.ArrayUtils;

public class ReadFile2 {

  public static void main(String[] args) throws IOException {
    try (FileInputStream fis = new FileInputStream("05. io/org/wangyt/javase/nio/ReadFile2.java");
        FileChannel fcin = fis.getChannel()) {

      ByteBuffer bbuff = ByteBuffer.allocateDirect(32);

      byte[] previous = new byte[0];
      while (fcin.read(bbuff) != -1) {
        bbuff.flip();
        byte[] now = new byte[bbuff.remaining()];
        bbuff.get(now);
        previous = ArrayUtils.addAll(previous, now);
        bbuff.clear();
      }

      System.out.println(new String(previous));
    }
  }
}
