package testing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ServerTesterClient {

	private Socket socket;
	private BufferedReader in;
	private BufferedWriter out;
	
	/**
	 * Creates a new Server Tester Client.
	 */
	public ServerTesterClient() {
	}
	
	/**
	 * Connecting to server.
	 * If the connection fails, the TUI gets informed and the client resets.
	 */
	public void connect(InetAddress addr, int port) {
		//Socket and Port and IPaddress in the TUI.
		if (!(addr == null) && port >= 0 && port <= 65535) {
			//Check the IP address
			try {
				socket = new Socket(addr, port);				
				System.out.println("Socket created");
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			} catch (IOException e) {
				System.out.println("Socket failure");
			}
		}
		
	}
	
    /**
     * Reads a string from the console and sends this string over
     * the socket-connection to the Peer process.
     * On Peer.EXIT the method ends
     */
    public void write(String input) {
		try {
			out.write(input);
			out.newLine();
			out.flush();			
			if (input.equals("exit")) {
				this.shutDown();
			}
		} catch (IOException e) {
			System.out.println("Connection terminated.");
		}
    }
    
//    /**  
//     * Read a line from the default input.
//     */
//    static public String readString(String message) {
//        System.out.print(message);
//        String antw = null;
//        try {
//            BufferedReader in = new BufferedReader(new InputStreamReader(
//                    System.in));
//            antw = in.readLine();
//        } catch (IOException e) {
//        }
//
//        return (antw == null) ? "exit" : antw;
//    }
    
	/**
	 * Reads from the socket and prints it to the Terminal.
	 */
	public void read() {
		String message;
    	try {
    		boolean read = false;
    		while (!read) {
    			message = in.readLine();
    			if (message != null) {
    				System.out.println("Server sent this message: " + message);
    				read = true;
    			}    			
    		}
    	} catch (IOException e) {
    		this.shutDown();
    		
    	}
	}
	
    /**
     * Closes the connection, the sockets will be terminated.
     */
    public void shutDown() {
    	try {
    		out.close();
        	in.close();
        	socket.close();
    	} catch (IOException e) {
    		System.out.println("Problems while the shut down");
    	}
    }
}
