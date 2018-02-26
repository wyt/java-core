package org.wangyt.javase.atm.server;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 王永涛
 * 
 * @since 2010-12-7
 * 
 */
@SuppressWarnings("all")
public class ATMServer {

	public static void main(String[] args) throws Exception {
		System.out.println("ATMServer");
		ServerSocket ss = new ServerSocket(8888);
		while (true) {
			Socket sersoc = ss.accept();
			new ClientATMThread(sersoc).start();
		}
	}

}