import java.io.*;
import java.net.*;
import java.util.*;

public class Client
{
	public static void main(String args[]) throws Exception
	{
		// Request connection to server
		Socket s = new Socket("127.0.0.1", 1404);

		// Create text output and input streams
		DataInputStream dis = new DataInputStream(s.getInputStream());
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());

		String msgin, n = "Test.txt", c, nnew="C:\\Client Database\\Test.txt";
		// 01. Receive text message
		msgin = dis.readUTF();
		System.out.println(msgin);

		Scanner t = new Scanner(System.in);
		byte b[] = new byte[2007];

		while(true)
		{
			// 02. Receive text message
			msgin = dis.readUTF();

			System.out.println(msgin);
			c = t.nextLine();

			// 03. Send choice
			dos.writeUTF(c);
			dos.flush();

			if(c.equals("1"))
			{
				// UPLOAD

				// Get file
				FileInputStream fis = new FileInputStream("C:\\Client Database\\Test.txt");
				fis.read(b, 0, b.length);

				// 04. Send file
				OutputStream os = s.getOutputStream();
				os.write(b, 0, b.length);
				fis.close();
			}

			if(c.equals("2"))
			{
				// DOWNLOAD

				// 05. Receive file
				InputStream is = s.getInputStream();

				// Read and write file at specified location
				is.read(b, 0, b.length);
				FileOutputStream fos = new FileOutputStream(nnew);
				fos.write(b, 0, b.length);
				fos.close();
			}

			if(c.equals("3"))
			{
				// DELETE file from the 'Server Database' folder

				// 06. Receive text message
				msgin = dis.readUTF();

				System.out.println(msgin);
			}

			if(c.equals("4"))
			{
				// RENAME

				// 07. Receive text message
				msgin = dis.readUTF();

				System.out.println(msgin);
				n = t.nextLine();
				nnew="C:\\Client Database\\"+n;


				// 08. Send new file name
				dos.writeUTF(n);
				dos.flush();

				// 09. Receive text message
				msgin = dis.readUTF();

				System.out.println(msgin);
			}

			if(c.equals("0"))
			{
				// EXIT

				// 10. Receive text message
				msgin = dis.readUTF();

				System.out.println(msgin);

				break;
			}
		}

		t.close();
		s.close();
	}
}
