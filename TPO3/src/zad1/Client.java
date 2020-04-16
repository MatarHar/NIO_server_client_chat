/**
 *
 *  @author Tryfon Piotr S17787
 *
 */

package zad1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Client {
	
	
	String Name;

	public Client(String ThreadName) throws IOException, InterruptedException 
	{
		this.Name = ThreadName;
		LogInWindow log = new LogInWindow(Name);
		if(log.enter == true) {
			info("+++++++++++++++CLIENTIN+++++++++++++++");
			setClient();
		}
		else {
			info("---------------ClientNOTIn---------------");
		}
	}
	public void setClient() throws InterruptedException, IOException {
		boolean LogIn = false;
		//ClientWindow clientwindow = new ClientWindow(Name);
		InetSocketAddress socket = new InetSocketAddress("localhost", 8080);
		SocketChannel channel = SocketChannel.open();
		channel.connect(socket);
		info("Client " + Name + " is connecting");
		String message = "Hi there";
		message += "\n";
		ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
		channel.write(buffer);
		buffer.clear();
 	}
		private static void info(String str) {
			System.out.println(str);
		}

public static void main(String[] args) throws IOException, InterruptedException {
	  new Client(null);
  }}