package org.wangyt.javase.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

@SuppressWarnings("all")
public class FileChannelTest {

  public static void main(String[] args) {

    File f = new File("05. io/org/wangyt/javase/nio/FileChannelTest.java");
    try {
      /** 创建FileInputStream，以该文件输入流创建FileChannel */
      FileChannel inChannel = new FileInputStream(f).getChannel();

      /** 以文件输出流创建FileChannel，用以控制输出 */
      FileChannel outChannel =
          new FileOutputStream("05. io/org/wangyt/javase/nio/out.txt").getChannel();

      /** 将FileChannel里的全部数据映射成ByteBuffer */
      MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, f.length()); // ①

      /** 直接将buffer里的数据全部输出 */
      outChannel.write(buffer); // ②

      // -----------上面的代码已经完成内容的复制-----------//

      /** 再次调用buffer的clear()方法，复原limit、position的位置 */
      buffer.clear();

      /** 创建解码器(CharsetDecoder)对象,注意当前文件是UTF-8的，所以解码器也应该是UTF-8 */
      CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();

      /** 使用解码器将ByteBuffer转换成CharBuffer */
      CharBuffer charBuffer = decoder.decode(buffer);

      /** CharBuffer的toString方法可以获取对应的字符串 */
      System.out.println(charBuffer);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

}
