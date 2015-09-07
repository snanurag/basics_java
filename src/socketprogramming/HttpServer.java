package socketprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class HttpServer {

    public static void main(String[] args) throws IOException {

	List<Socket> clientSocketList = new ArrayList<Socket>();
	
	while (true) {
	    ServerSocket serverSocket = null;
	    try {
		serverSocket = new ServerSocket(8080);
	    } catch (IOException e) {
		System.err.println("Could not listen on port: 8080." + e);
		System.exit(1);
	    }

	    Socket clientSocket = null;
	    try {
		System.out.println("anurag before accept");
		clientSocket = serverSocket.accept();
		clientSocketList.add(clientSocket);
		System.out.println("anurag after accept");
	    } catch (IOException e) {
		System.err.println("Accept failed.");
		System.exit(1);
	    }

	    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),
		    true);
	    BufferedReader in = new BufferedReader(new InputStreamReader(
		    clientSocket.getInputStream()));

	    System.out.println("anurag after creating Buffered Reader");
	    String inputLine;

	    while ((inputLine = in.readLine()) != null) {
		
		System.out
			.println("Server got input from client: " + inputLine);
		if (inputLine.equals("")){
		    String output = "HTTP/1.1 200 OK\n"+
		    "Date: Mon, 29 Nov 2004 01:45:35 GMT\n"+
		    "Server: Apache\n"+
		    "Last-Modified: Thu, 25 Nov 2004 02:32:28 GMT\n"+
		    "Content-Length: 16291\n"+
		    "Content-Type: text/html\n"+

		    "<html>\n"+
		    "<!-- Actual content snipped -->\n"+
		    "</html>";		    
		    out.print(output);
		    out.flush();
		    System.out.println("output send");
		    out.close();
		}
		
	    }


	}
    }
}
