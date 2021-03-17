package chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class AppServidor {

	private static final int PUERTO = 9999;
	private static ServerSocket servidor;
	
	public static void main(String[] args) {
		
		try {
			
			servidor = new ServerSocket(PUERTO);
			
			System.out.println("Escuchando en el puerto " + PUERTO + " ...");
			
			ComunHilos comunHilos = new ComunHilos();
			
			while(true) {
				
				Socket socket = servidor.accept();
				
				AtiendeCliente atiendeCliente = new AtiendeCliente(socket, comunHilos);
				
				System.out.println("\\Un usuario ha iniciado sesión//");
				
				atiendeCliente.start();
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
