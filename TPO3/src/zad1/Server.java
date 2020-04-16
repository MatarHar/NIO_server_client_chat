/**
 *
 *  @author Tryfon Piotr S17787
 *
 */

package zad1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class Server {
	public Selector selector;
	public ServerSocketChannel bigchannel;
	
	public Server() throws IOException, InterruptedException {
		selector = Selector.open();
		int port = 8080;
		bigchannel = ServerSocketChannel.open();
		InetSocketAddress socket = new InetSocketAddress("localhost", port);
		bigchannel.bind(socket);
		bigchannel.configureBlocking(false);
		bigchannel.register(selector, SelectionKey.OP_ACCEPT);
		serverrun();
	}

	private void serverrun() {
		info("First iteration");
		while(true) {
			try {
			//info("**********running all day long, next iteration**********");
			selector.select();
			
			Set SKey = selector.selectedKeys();
			Iterator SIterator = SKey.iterator();
			
			while (SIterator.hasNext()) {
				SelectionKey Key = (SelectionKey) SIterator.next();
				//info(Boolean.toString(Key.isAcceptable()));
				//info(Boolean.toString(Key.isReadable()));
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
					String response = ServerServant.getmessage(Client);
					info("Message is: " + response);
					if(response.length() > 0) {
						try {
							selector.select();
							Set SSKey = selector.selectedKeys();
							Iterator SSIterator = SSKey.iterator();
							while(SSIterator.hasNext()) {
								SelectionKey KKey = (SelectionKey) SSIterator.next();
								if (KKey.isWritable()) {
									info("Thread is writable");
									SocketChannel socketc = (SocketChannel) KKey.channel();
									String str = (new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss").format(new Date()))
											+ " " + response;
									ServerServant.writemessage(socketc, str);;
								}
							}
						} catch(Exception exc) {
							exc.printStackTrace();
						}
					}	
					}
				}
			
		} catch(Exception e) {
			e.printStackTrace();		
		}}
			}

	private void info(String string) {
		System.out.println(string);
	}


  public static void main(String[] args) throws IOException, InterruptedException {
	  new Server();
	  }}