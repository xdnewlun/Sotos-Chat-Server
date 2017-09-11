package server;

import java.io.*;
import java.net.*;

public class ChatServer {
	public static void main(String []args) {
		try {
			ServerSocket ss=new ServerSocket(6969);
			Socket s =ss.accept();
			DataInputStream dis = new DataInputStream(s.getInputStream());
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			while (true) {
				String str=(String)dis.readUTF();
				dos.writeUTF(str);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
