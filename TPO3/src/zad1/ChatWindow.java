package zad1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatWindow extends JFrame implements ActionListener{
	
	boolean decision;
	JPanel jpanel;
	JTextArea chatfield;
	JTextField enterfield;
	JButton Send;
	JButton Exit;
	
	public ChatWindow(String name) {
		
		this.decision = false;
		this.jpanel = new JPanel(new GridLayout(10,0));
		this.chatfield = new JTextArea(5, 5);
		this.enterfield = new JTextField(25);
		this.Send = new JButton("Send");
		this.Exit = new JButton("Exit");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jpanel.add(chatfield);
		jpanel.add(enterfield);
		jpanel.add(Send);
		jpanel.add(Exit);

		Exit.addActionListener(this);
		Send.addActionListener(this);
		enterfield.addActionListener(this);
		
        add(jpanel, BorderLayout.CENTER);
		
        setSize(1000,300);
        setVisible(true);
        waitformessage();
	}
	
	private void waitformessage() {
		while (decision == false) {
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		
		
	}
	}
	

