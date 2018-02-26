package org.wangyt.javase.socket.tcp.app.webserver;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author 王永涛
 * 
 * @since 2012-8-31 下午03:35:41
 * 
 * @version v1.0
 * 
 *          Copyright (c) 2012, WANG YONG TAO. All Rights Reserved.
 */
@SuppressWarnings("all")
public class HttpProcessThread extends Thread {
	private Socket socket;

	public HttpProcessThread() {
	}

	public HttpProcessThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);

			pw.println(
					"<html><head><title>Web Server</title></head><body><span>Hello,this is my web page.</span></body></html>");
			pw.flush();

			pw.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}