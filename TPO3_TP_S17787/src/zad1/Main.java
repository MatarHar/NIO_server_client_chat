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
				new Server();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
	  }.start();
	  try {
		Thread.sleep(500);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  new Thread() {
		  public void run() {
			  try {
				new Client("First Thread");
			} catch (InterruptedException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
	  }.start();
	  new Client("Second Thread");
	  
  }
}
