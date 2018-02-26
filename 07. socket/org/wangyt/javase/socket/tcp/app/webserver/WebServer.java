package org.wangyt.javase.socket.tcp.app.webserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模仿web容器
 * 
 * @author 王永涛
 * 
 * @since 2012-8-31 下午03:33:03
 * 
 * @version v1.0
 * 
 *          Copyright (c) 2012,WANG YONG TAO. All Rights Reserved.
 */
class WebServer {
	public static void main(String[] args) throws IOException {
		ServerSocket s_socket = new ServerSocket(8080);
		Socket socket = null;
		while ((socket = s_socket.accept()) != null) {
			new HttpProcessThread(socket).start();
		}
		s_socket.close();
	}
}