/**
 *
 *  @author Tryfon Piotr S17787
 *
 */

package zad1;

import java.io.IOException;

//Logowanie za pomoca guest - wpisz Nickname -> Enter button
//Logowanie za pomoca admina - wpisz root root lub toor toor -> Enter button
public class Main {

  public static void main(String[] args) throws InterruptedException, IOException {
	  new Thread() {
		  public void run() {
			  try {
				//System.out.println("Sever connecting");
				new Server();
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		  }
	  }.start();
	  new Thread() {
		  public void run() {
			  try {
				System.out.println("First THREAD");
				new Client("First Thread");
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		  }
	  }.start();
	  //System.out.println("Second THREAD");
	  new Client("Second Thread");
	  
  }
}
