/**
 *
 *  @author Tryfon Piotr S17787
 *
 */

package zad1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class Server {
	
	
	public Server() throws IOException, InterruptedException {
		Selector selector = Selector.open();
		int port = 8080;
		ServerSocketChannel bigchannel = ServerSocketChannel.open();
		InetSocketAddress socket = new InetSocketAddress("localhost", 8080);
		bigchannel.bind(socket);
		bigchannel.configureBlocking(false);
		bigchannel.register(selector, SelectionKey.OP_ACCEPT);

		while(true) {
			info("running all day long");
			selector.select();
			
			Set SKey = selector.selectedKeys();
			Iterator SIterator = SKey.iterator();
			
			while (SIterator.hasNext()) {
				Thread.sleep(1000);
				info("**********HAS NEXT************");
				SelectionKey Key = (SelectionKey) SIterator.next();
				info(Boolean.toString(Key.isAcceptable()));
				info(Boolean.toString(Key.isReadable()));
				if (Key.isAcceptable()) {
					SocketChannel Client = bigchannel.accept();
					if (Client != null) {
					Client.configureBlocking(false);
					Client.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
					info("Connection is being Accepted" + Client.getLocalAddress() + "\n");
				}
					}
				else if (Key.isReadable()) {
					info("Thread is readable");
					SocketChannel Client = (SocketChannel) Key.channel();
					ByteBuffer Buffer = ByteBuffer.allocate(1024);
					Client.read(Buffer);
					String response = new String(Buffer.array()).trim();
					
					info("Message is: " + response);
					
					if (response.equals("LogMeOut")) {
						Client.close();
						info("Client is being disconnected");
					}
				}
			}
		}
	}

	private void info(String string) {
		System.out.println(string);
	}


  public static void main(String[] args) throws IOException, InterruptedException {
	  new Server();
	  }}