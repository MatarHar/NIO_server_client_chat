/**
 *
 *  @author Tryfon Piotr S17787
 *
 */

package zad1;

import java.io.IOException;

public class Main {

  public static void main(String[] args) throws InterruptedException, IOException {
	  new Thread() {
		  public void run() {
			  try {
				System.out.println("Sever connecting");
				new Server();
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
	  }.start();
	  try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  new Thread() {
		  public void run() {
			  try {
				System.out.println("First THREAD");
				new Client("First Thread");
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
	  }.start();
	  Thread.sleep(100000);
	  System.out.println("Second THREAD");
	  //new Client("Second Thread");
	  
  }
}
