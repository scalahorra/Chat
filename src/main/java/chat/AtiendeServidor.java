package chat;

import java.io.DataInputStream;
import java.net.Socket;

public class AtiendeServidor extends Thread{

	private Socket socket;
	
	public AtiendeServidor(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		super.run();
		
		try {
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
