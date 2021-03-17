package chat;

import java.io.DataOutputStream;
import java.net.Socket;

public class AppCliente {

	private static final String IP = "localhost";
	private static final int PUERTO = 9999;
	private static String mensaje;
	
	public static void main(String[] args) {
		
		try {
			
			Socket socket = new Socket(IP, PUERTO);
			
			DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
			
			System.out.println("Usuario:");
			String usuario = Leer.pedirCadena();
			salida.writeUTF(usuario);
			
			AtiendeServidor cliente = new AtiendeServidor(socket);
			
			cliente.start();
			
			while(true) {
				
				mensaje = Leer.pedirCadena();
				
				salida.writeUTF(mensaje);
				
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
