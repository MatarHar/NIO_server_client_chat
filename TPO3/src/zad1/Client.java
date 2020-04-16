/**
 *
 *  @author Tryfon Piotr S17787
 *
 */

package zad1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class Client {

	public String TName;
	public String UserName;
	ChatWindow cwin;
	public SocketChannel socketchannel;
	public Client(String ThreadName) throws IOException, InterruptedException 
	{
		this.TName = ThreadName;
		LogInWindow log = new LogInWindow(TName);
		this.UserName = log.guest;
		if(log.enter == true) {
			info("+++++++++++++++CLIENT IN+++++++++++++++");
			setClient();
			//info("Debugging 2");
			cwin = new ChatWindow(this, UserName);
			socketrun(cwin);
		}
		else {
			info("---------------CLIENT NOT IN---------------");
		}
	}
	
	
	private void socketrun(ChatWindow chat) {
		while(true) {
		String messageback = ServerServant.getmessage(this.socketchannel);
		//info("Debugging 3");
		chat.addmessage(messageback);	
		}
	}
	
	public void setClient() throws InterruptedException, IOException {
		//info("Debugging 1");
		int port = 8080;
		InetSocketAddress socket = new InetSocketAddress("localhost", port);
		SocketChannel channel = SocketChannel.open();
		channel.connect(socket);
		this.socketchannel = channel;
 	}
	
		private static void info(String str) {
			System.out.println(str);
		}

public static void main(String[] args) throws IOException, InterruptedException {
	  new Client(null);
  }
public void writemessage(String line) {
	try {
		ServerServant.writemessage(this.socketchannel, (this.UserName + " :" + line));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}}