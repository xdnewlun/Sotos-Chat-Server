package server;

import java.io.*;
import java.net.*;

public class ThreadedServer extends Thread{
	protected Socket socket;
	
	public ThreadedServer(Socket clientSocket) {
		this.socket = clientSocket;
	}
	
	public void run() {
		try {
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			while (true) {
				String str=(String)dis.readUTF();
				String remote = socket.getInetAddress().toString();
				String newmes = remote + ": " + str;
				dos.writeUTF(newmes);
				System.out.println(newmes);
				if (str.toUpperCase() == "QUIT") {
					socket.close();
					break;
				}else if (str.toUpperCase() == "EXIT") {
					socket.close();
					break;
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
