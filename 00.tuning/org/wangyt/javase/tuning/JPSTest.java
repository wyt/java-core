package org.wangyt.javase.tuning;

import java.io.IOException;
import java.io.InputStream;

/**
 * 
 * 查看java进程有哪些
 * 
 * c:\> jps -l
 * 
 * @author wangyt
 *
 */
public class JPSTest {
	public static void main(String[] args) {
		try {
			InputStream in = Runtime.getRuntime().exec("jps -l")
					.getInputStream();

			byte[] buff = new byte[1024];
			int len = -1;
			while ((len = in.read(buff)) != -1) {
				System.out.print(new String(buff, 0, len));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
