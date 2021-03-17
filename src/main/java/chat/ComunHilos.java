package chat;

import java.net.Socket;
import java.util.ArrayList;
import java.io.*;

public class ComunHilos {

	private static ArrayList<Socket> conexiones = new ArrayList<>();
	
	public synchronized void anadir(Socket socket) {
		
		conexiones.add(socket);
		
	}
	
	public synchronized void anadir(String usuario, String mensaje) {
		
		for(Socket socket : conexiones) {
			
			DataOutputStream salida;
			
			try {
				
				salida = new DataOutputStream(socket.getOutputStream());
				salida.writeUTF(mensaje);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		
	}
}
