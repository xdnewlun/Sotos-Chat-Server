package client;

import java.io.*;
import java.net.*;

public class ChatClient {
	
	public static void main(String []args) {
		try {
			Socket s = new Socket("localhost",6969);
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			DataInputStream dis = new DataInputStream(s.getInputStream());
			while (true) {
				String message = System.console().readLine();
				dos.writeUTF(message);
				System.out.println(dis.readUTF());
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		Runtime.getRuntime().addShutdownHook(new Thread(public static void main()
				s.close();
			}
		}));	 
	}
}
//https://stackoverflow.com/questions/8051863/how-can-i-close-the-socket-in-a-proper-way