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
import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Client {
	
	public Client(String ThreadName) throws IOException, InterruptedException 
	{
		ClientWindow clientwindow = new ClientWindow(ThreadName);
		InetSocketAddress socket = new InetSocketAddress("localhost", 8080);
		SocketChannel channel = SocketChannel.open(socket);
		info("Client " + ThreadName + " is connecting");
		String message = "Hi there";
		ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
		channel.write(buffer);
		buffer.clear();
 	}/*
	//{	  
			InetSocketAddress crunchifyAddr = new InetSocketAddress("localhost", 8080);
			SocketChannel crunchifyClient = SocketChannel.open(crunchifyAddr);
	 
			info("Connecting to Server on port 8080...");
	 
			ArrayList<String> companyDetails = new ArrayList<String>();
	 
			// create a ArrayList with companyName list
			companyDetails.add("Facebook");
			companyDetails.add("Twitter");
			companyDetails.add("IBM");
			companyDetails.add("Google");
			companyDetails.add("Crunchify");
	 
			for (String companyName : companyDetails) {
	 
				byte[] message = new String(companyName).getBytes();
				ByteBuffer buffer = ByteBuffer.wrap(message);
				crunchifyClient.write(buffer);
	 
				info("sending: " + companyName);
				buffer.clear();
	 
				// wait for 2 seconds before sending next message
				Thread.sleep(500);
			}
			crunchifyClient.close();
		}*/
	 
		private static void info(String str) {
			System.out.println(str);
		}

public static void main(String[] args) throws IOException, InterruptedException {
	  new Client(null);
  }}
  
  /*@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Select Your country");
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(5);
		grid.setHgap(5);
		Label label = new Label("Please enter Countries and Cities in English");
		GridPane.setConstraints(label, 0, 0);
		grid.getChildren().add(label);
		
		//Defining the CountryName text field
		CountryName.setPromptText("Enter Country name.");
		CountryName.setPrefColumnCount(10);
		CountryName.getText();
		GridPane.setConstraints(CountryName, 0, 1);
		grid.getChildren().add(CountryName);
		
		//Defining the CityName text field
		CityName.setPromptText("Enter City name.");
		GridPane.setConstraints(CityName, 0, 2);
		grid.getChildren().add(CityName);
		
		//Defining the LFCurrency text field
		LFCurrency.setPromptText("Enter Curency name");
		GridPane.setConstraints(LFCurrency, 0, 3);
		grid.getChildren().add(LFCurrency);
		
		//Defining the Submit button
		Button submit = new Button("Submit");
		GridPane.setConstraints(submit, 0, 4);
		grid.getChildren().add(submit);

		submit.setOnAction(this);
		
		primaryStage.setScene(new Scene(grid, 300, 250));
		primaryStage.show();

	}
}*/
