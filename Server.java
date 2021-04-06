import java.net.*;

public class Server02
{
	public static void main(String args[]) throws Exception
	{
		// Create server socket
		ServerSocket ss = new ServerSocket(1404);

		// Add clients
		int counter = 0;
		while(true)
		{
			counter++;

			// Accept client's connection
			Socket s = ss.accept();

			// Call thread
			ServerThread st = new ServerThread(s,counter);
			st.start();
		}
	}
}
