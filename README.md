
	File Upload and Download Service (Multiple Clients)

	01.	Program Details:

		(i)	Date: 26th September, 2019
		(ii)	Language: Java

	02.	Problem Statement:

		(i)	Simple file upload and download service based on
			a)	message-oriented,
			b)	client-server communication, and
			c)	computation service
			using remote procedure call (RPC) based communication.

		(ii)	The file server supports multiple clients and four basic operations:
			a)	UPLOAD,
			b)	DOWNLOAD,
			c)	DELETE, and
			d)	RENAME.

		(iii)	File service is implemented using a connection-oriented protocol,
			in which the client and server
			a)	first establish a network connection,
			b)	negotiate the operation to be performed, and
			c)	carry out the file transfer through the same connection.

	03.	Code Execution:

		(i)	Before compiling and running these files,
			you have to set the path of 'Client Database' sub-folder and 'Server Database' subfolder inside these files.

		(ii)	To compile the above programs,
			change the directory of the Terminal or Command Prompt to the folder containing these files.

		(iii)	Then, enter 'javac Server.java', 'javac Client.java' and 'javac ServerThread' to compile these files.
			You can only run these files after compiling them.

		(iv)	Finally, to run these files correctly,
			first, run 'Server.class' by entering 'java Server' then run 'Client.class' by entering 'java Client'.

		(v)	Do not run 'ServerThread.class' file.
			As it will be called by 'Server.class'.

	04.	Note:

		(i)	'Test.txt' is a sample file hardcoded in the program.

		(ii)	'Server Database' and 'Client Database' folders represent the server's and client's database respectively
			for storing files used for this program.

		(iii)	File locking techniques can also be used for this program to prevent multiple file access errors.
