package server;

import java.io.*;
import java.net.*;

public class ChatServer {
	protected Socket s;
	protected Socket ss;
	public ChatServer() {
		try {
			ServerSocket ss=new ServerSocket(6969);
			Runtime.getRuntime().addShutdownHook(new Thread() {
				public void main(String []args) throws IOException {
					ss.close();
				}
			});
			while (true) {
				Socket s =ss.accept();
				new ThreadedServer(s).start();
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		new ThreadedServer(s).start();
	}
}
