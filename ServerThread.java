import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread
{
	Socket s;
	int clientNo;

	ServerThread(Socket insocket, int counter)
	{
		s = insocket;
		clientNo = counter;
	}

	public void run()
	{
		try
		{
			// Create text output and input streams
			DataInputStream dis = new DataInputStream(s.getInputStream());
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());

			// 01. Send text message
			dos.writeUTF("\nConnection Established");
			dos.flush();

			String c, nold = "C:\\Server Database\\Test.txt", nnew;
			byte []b = new byte[2007];

			while(true)
			{
				// 02. Send text message
				dos.writeUTF("\nTo enter your request:\n\n01.\tEnter 1 to UPLOAD a file,\n02.\tEnter 2 to DOWNLOAD your file,\n03.\tEnter 3 to DELETE your file,\n04.\tEnter 4 to RENAME your file and\n05.\tEnter 0 to EXIT\n\nSelect your choice:");
				dos.flush();
				// 03. Receive choice
				c = dis.readUTF();

				if(c.equals("1"))
				{
					// UPLOAD

					// 04. Receive file
					InputStream is = s.getInputStream();

					// Read and write file at specified location
					is.read(b, 0, b.length);
					FileOutputStream fos = new FileOutputStream("C:\\Server Database\\Test.txt");
					fos.write(b, 0, b.length);
					fos.close();
				}

				if(c.equals("2"))
				{
					// DOWNLOAD

					// Get file
					FileInputStream fis = new FileInputStream(nold);
					fis.read(b, 0, b.length);

					// 05. Send file
					OutputStream os = s.getOutputStream();
					os.write(b, 0, b.length);
					fis.close();
				}

				if(c.equals("3"))
				{
					// DELETE file form the 'Server Database' folder

					File file2 = new File(nold);
					file2.delete();

					// 06. Send text message
					dos.writeUTF("\nFile successfully deleted");
					dos.flush();
				}

				if(c.equals("4"))
				{
					// RENAME

					// 07. Send text message
					dos.writeUTF("\nEnter a new file name:");
					dos.flush();

					// 08. Receive new file name
					nnew = dis.readUTF();

					// Read old file
					FileInputStream fis2 = new FileInputStream(nold);
					fis2.read(b, 0, b.length);

					// Write to new file
					nnew = "C:\\Server Database\\"+nnew;
					FileOutputStream fos2 = new FileOutputStream(nnew);
					fos2.write(b, 0, b.length);
					fis2.close();
					fos2.close();

					// Delete old file
					File file1 = new File(nold);
					file1.delete();

					nold=nnew;

					// 09. Send text message
					dos.writeUTF("\nFile successfully renamed");
					dos.flush();
				}

				if(c.equals("0"))
				{
					// EXIT

					// 10. Send text message
					dos.writeUTF("\nConnection closed");
					dos.flush();

					break;
				}
			}
		}

		catch (Exception ex)
		{
			System.out.println(ex);
		}

		finally
		{
			System.out.println("Client: "+clientNo+" Exit");
		}
	}
}
