package principal;

import java.io.IOException;
import java.net.*;

public class AppServidor {
//Clase encargada de recibir y aceptar todas las conexiones de los clientes y lanzar los hilos que atienden a cada cliente
	
	static final int PUERTO = 4444;
	
	public static void main(String[] args) throws IOException {
		
		//Iniciamos servidor
		ServerSocket servidor = new ServerSocket(PUERTO); 
		
		System.out.println("-- SERVIDOR --");
		System.out.println("Servidor activo y escuchando en el puerto "+PUERTO+" ...");
		
		//Bucle infinito para que el servidor esté constantemente escuchando
		while(true) {
			
			Socket socket = servidor.accept();
			AtiendeCliente aCliente = new AtiendeCliente(socket); 
			aCliente.start();
		}
		
	}
}
