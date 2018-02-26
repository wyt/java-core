/**
 * 《构建高性能的大型分布式Java应用》
 *  书中的示例代码
 *  版权所有   2008---2009
 */
package org.wangyt.javase.tcpip.nio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * 描述：基于java NIO实现的tcp client
 */
public class Client {

	public static void main(String[] args) throws Exception {
		int port = 9527;
		
		SocketChannel channel = SocketChannel.open();
		// 设置为非阻塞模式
		channel.configureBlocking(false);
		
		SocketAddress target = new InetSocketAddress("127.0.0.1", port);
		// 对于非阻塞模式，立刻返回false，表示连接正在建立中;后续代码不阻塞，继续执行
		channel.connect(target);
		Selector selector = Selector.open();
		
		// 想channel注册selector，以及感兴趣的连接事件
		channel.register(selector, SelectionKey.OP_CONNECT);
		
		BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			
			// 向服务端写数据
			if (channel.isConnected()) {
				String command = systemIn.readLine();
				channel.write(Charset.forName("UTF-8").encode(command));
				if (command == null || "quit".equalsIgnoreCase(command.trim())) {
					systemIn.close();
					channel.close();
					selector.close();
					System.out.println("Client quit!");
					System.exit(0);
				}
			}
			
			int nKeys = selector.select(1000);
			if (nKeys > 0) {
				for (SelectionKey key : selector.selectedKeys()) {
					if (key.isConnectable()) {
						SocketChannel sc = (SocketChannel) key.channel();
						sc.configureBlocking(false);
						sc.register(selector, SelectionKey.OP_READ);
						sc.finishConnect();
					} else if (key.isReadable()) {
						ByteBuffer buffer = ByteBuffer.allocate(1024);
						SocketChannel sc = (SocketChannel) key.channel();
						int readBytes = 0;
						try {
							int ret = 0;
							try {
								while ((ret = sc.read(buffer)) > 0) {
									readBytes += ret;
								}
							} finally {
								buffer.flip();
							}
							if (readBytes > 0) {
								System.out.println(Charset.forName("UTF-8").decode(buffer).toString());
								buffer = null;
							}
						} finally {
							if (buffer != null) {
								buffer.clear();
							}
						}
					}
				}
				selector.selectedKeys().clear();
			}
		}
	}

}
