package refresh_W4;
import java.net.*;
import java.io.*;

public class check_port {


	   public static void main(String[] args) {
		   Socket Skt;
	      String host = "localhost";
	      if (args.length > 0) {
	         host = args[0];
	      }
	      
	      try {
	            System.out.println("Looking for vnc" );
	            Skt = new Socket(host, 5900);
	            System.out.println("There is a server on port 5900 of " + host);
	         }
	         catch (UnknownHostException e) {
	            System.out.println("Exception occured"+ e);
	            //break;
	         }
	         catch (IOException e) {
	        	 
	         }
	      /*
	      for (int i = 0; i < 1024; i++) {
	         try {
	            System.out.println("Looking for "+ i);
	            Skt = new Socket(host, i);
	            System.out.println("There is a server on port " + i + " of " + host);
	         }
	         catch (UnknownHostException e) {
	            System.out.println("Exception occurred"+ e);
	            break;
	         }
	         catch (IOException e) {
	         }
	      }
	      */
	   }
	}

