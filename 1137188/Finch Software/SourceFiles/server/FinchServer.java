package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class FinchServer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Get the id of the local machine
        //Declare an object to store your computer's name
        InetAddress computerAddr = null;
        //Now store the local computer's name
        try{
          computerAddr = InetAddress.getLocalHost();
        }
        catch(UnknownHostException e){
          System.out.println(e);
        }
       
        System.out.println("The address of this computer is... " + computerAddr.getHostName());

        // Now set up the server socket on port 4444 on the local machine
        // Change the port so that someone else does not connect to it

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4444.");
            System.exit(1);
        }
        System.out.println("Server up and waiting");
        // Wait for client connection
        // When a client connects, make the link and carry on
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
       // Connect the input and the output to and from the socket
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine, outputLine, outputline1;
        String xcoordinates,ycoordinates;
        // Make the server internal state object
        Finchstate fs = new Finchstate();
        // Get the first message
        //outputLine = fs.processInput("0");
        ycoordinates=fs.processInput2();
        // And send it to the client
        out.println(ycoordinates);
        // Repeatedly loop getting input from the client
        // check it with the state object for the response
        // and send it to the client until the client
        // says Bye.
        while ((inputLine = in.readLine()) != null) {
             outputline1=fs.processInput2();
             out.println(outputline1);
             
         }
      
         // Tidy up
         out.close();
         in.close();
         clientSocket.close();
         serverSocket.close();

	}

}
