package client;

import java.io.*;
import java.net.*;

public class ChatClient {
	
	public ChatClient() {
		try {
			Socket s = new Socket("10.4.27.29",6969);
			Runtime.getRuntime().addShutdownHook(new Thread() {
				public void main(String []args) throws IOException {
					s.close();
				}
			});
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
	}
}
//https://stackoverflow.com/questions/8051863/how-can-i-close-the-socket-in-a-proper-way