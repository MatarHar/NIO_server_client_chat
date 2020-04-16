package zad1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ChatWindow extends JFrame implements ActionListener{
	
	String UserN;
	JPanel jpanel;
	JTextArea chatfield;
	JTextField enterfield;
	JButton Send;
	JButton Exit;
	private Client c;
	
	public ChatWindow(Client client, String UserName) {
		this.UserN = UserName;
		this.c = client;
		this.jpanel = new JPanel();
		jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.Y_AXIS));
		this.chatfield = new JTextArea(15, 2);	
		JScrollPane scrollPane = new JScrollPane(chatfield);		
		this.enterfield = new JTextField(30);
		if(UserN.equals("")) {
			this.Send = new JButton("Send as Admin");
		}
		else {
			this.Send = new JButton("Send as " + UserN);

		}
		this.Exit = new JButton("Exit");
		chatfield.setPreferredSize(new Dimension (900,200));
		enterfield.setPreferredSize(new Dimension (990,50));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jpanel.add(scrollPane);
		jpanel.add(enterfield);
		jpanel.add(Send);
		jpanel.add(Exit);

		Exit.addActionListener(this);
		Send.addActionListener(this);
		enterfield.addActionListener(this);
		
        add(jpanel, BorderLayout.CENTER);
        
        chatfield.setLineWrap(true);
        chatfield.setEditable(false);
        setSize(1000,400);
        setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent a) {
		if(((a.getSource() == Send) && (((enterfield.getText()).length()) > 0)) || 
				(((enterfield.getText()).length()) > 0)) {
			this.c.writemessage(enterfield.getText());
			enterfield.setText("");
		}else if (a.getSource() == Exit) {
			System.out.println("------Exit------");
			close();
		}
	}
	private void close() {
		Window win = SwingUtilities.getWindowAncestor(Exit);
		win.dispose();
	}

	public void addmessage(String messageback) throws NullPointerException{
		//System.out.println("debug:DISPLAY MESSAGE");
		chatfield.append(messageback + "\n");
		chatfield.setCaretPosition(chatfield.getDocument().getLength());
		chatfield.update(chatfield.getGraphics());
	}
	}
	

