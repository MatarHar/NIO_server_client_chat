package zad1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;

public class ServerThread extends Thread{
	public Socket SocketThread; 
	
	public ServerThread (Socket SocketThread) {
		this.SocketThread = SocketThread;
	}

	@Override
	public void run() {
		try {
			streamservice();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}
	private void streamservice() throws IOException, InterruptedException {
		InputStream inputstream = SocketThread.getInputStream();
		OutputStream outputStream = SocketThread.getOutputStream();
	
		SocketThread.close();
		 System.out.println("Socket Closed");
	}
	}
	