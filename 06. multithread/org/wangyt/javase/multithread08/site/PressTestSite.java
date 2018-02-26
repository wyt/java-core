package org.wangyt.javase.multithread08.site;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 压测网站,linux上用 netstat -apn | grep 8080 | wc -l 统计并发数,top查看资源利用率
 * 
 * @author WANG YONG TAO
 *
 */
@SuppressWarnings("all")
public class PressTestSite {
	public static void main(String[] args) {
		pressTesting();
	}

	public static void pressTesting() {
		try {
			// final URL url = new URL("http://192.168.186.4:8080/");
			final URL url = new URL(
					"http://idp.dms.net:8085/dms_idp/retrievePass.do?method=sendEmail2&rand=0.3971972016103298");
			final int concurrentNum = 200;

			ExecutorService threadPool = Executors.newCachedThreadPool();

			for (int i = 0; i < concurrentNum; i++) {
				threadPool.execute(new Runnable() {
					@Override
					public void run() {
						while (true) {
							URLConnection urlConn;
							try {
								urlConn = url.openConnection();
								InputStream in = urlConn.getInputStream();
								byte[] buff = new byte[1024];
								int len = -1;
								while ((len = in.read(buff)) != -1) {
									Thread.sleep(10);
									// TODO 这段代码有问题
									System.out.println(new String(buff));
								}
							} catch (IOException e) {
								e.printStackTrace();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
