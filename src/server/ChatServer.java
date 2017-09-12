package server;

import java.io.*;
import java.net.*;

public class ChatServer {
	public ChatServer() {
		try {
			ServerSocket ss=new ServerSocket(6969);
			Runtime.getRuntime().addShutdownHook(new Thread() {
				public void main(String []args) throws IOException {
					ss.close();
				}
			});
			Socket s =ss.accept();
			DataInputStream dis = new DataInputStream(s.getInputStream());
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			while (true) {
				String str=(String)dis.readUTF();
				String remote = ss.getInetAddress().toString();
				String newmes = remote + ": " + str;
				dos.writeUTF(newmes);
				System.out.println(newmes);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
