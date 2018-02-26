package org.wangyt.javase.nio.filelock;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * 文件锁.
 * 
 * @author WANG YONG TAO
 *
 */
@SuppressWarnings("all")
public class FileLockTest {
	
	public static String FILEPATH = "05. io/org/wangyt/javase/nio/out.txt";

	public static void main(String[] args) throws IOException, InterruptedException {
		
		FileChannel outchann = new FileOutputStream(FILEPATH).getChannel();

		FileLock lock = outchann.tryLock();

		Thread.sleep(5000);

		lock.release();
	}

}
