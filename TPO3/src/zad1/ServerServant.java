package zad1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class ServerServant {

	public static String getmessage(SocketChannel socketchannel) {
		boolean temp = true;
		if(socketchannel.isOpen() != true) {
			return "";
		}	
		StringBuffer response = new StringBuffer();
		try {
		response.setLength(0);
		ByteBuffer bytebuffer = ByteBuffer.allocate(1024);
		bytebuffer.clear();
		int iterator = 0;
		while(temp) {
			int iter = socketchannel.read(bytebuffer);
			if(iter > 0) {
					bytebuffer.flip();
					//SCENARIUSZ 1
					CharBuffer charbuffer = Charset.forName("ISO-8859-2").decode(bytebuffer);
					while(charbuffer.hasRemaining()) {
						char cha = charbuffer.get();
						if ((cha == '\r') || (cha == '\n')) {
							temp = false;
							break;
						}else {
							response.append(cha);
						}
					
					}
			}else {
				iterator++;
				temp = false;
				break;
		}
		}} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		String respons = response.toString();
		return respons;
	}
	
	public static void writemessage(SocketChannel socketChannel, String message) throws IOException {
		message += "\n";
		ByteBuffer bytebuffer = Charset.forName("ISO-8859-2").encode(message);
		while(bytebuffer.hasRemaining()) {
			socketChannel.write(bytebuffer);
		}
	}
	
}