package zad1;

import javax.swing.JFrame;

public class ClientWindow extends JFrame{
	public ClientWindow(String ClientName) throws InterruptedException {
		super("Client: " + ClientName);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
