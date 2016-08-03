package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class FinchClient {
	 public static String getValues="";
	public static void main(String[] args) throws IOException {

        // Set up the socket, in and out variables

        Socket medSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

       // Change XXXX to the name of the computer that your kkserver is running
       // Change port 4444 to another number so you dont run into someone elses!
       // The code then connects the input and output

   
        try {
            medSocket = new Socket("localhost", 4444);
            out = new PrintWriter(medSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(medSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: localhost ");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: 4444.");
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String fromServer;
        //String fromUser;

        System.out.println("Initialised client and IO connections");
        
        /* Print out what the server says 
         * Take the client's response and send it to the server */

        while ((fromServer = in.readLine()) != null) {
            System.out.println("Server: " + fromServer);
            getValues+=fromServer;
            try {
            	
    	        BufferedWriter out1 = new BufferedWriter(new FileWriter("/Users/nikhilkishore/Documents/Clientfile1.txt"));
    	           
    	                out1.write(getValues + " ");
    	              //  out1.write(getValues + " ");
    	            
    	            out1.close();
    	        } catch (IOException e) {}
            
            if (fromServer.equals("Bye."))
            {break;}
        }
       
        
       // Tidy up
        out.close();
        in.close();
        stdIn.close();
        medSocket.close();
    }
	public String getString(){
		return getValues;
	}


}
