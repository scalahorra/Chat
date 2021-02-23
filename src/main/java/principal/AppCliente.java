package principal;

import java.io.*;
import java.net.*;

public class AppCliente {
//Clase encargada de establecer la conexion con el servidor, leer mensajes del terminal y enviarselos al servidor
	
	static final String IP = "localhost";
	static final int PUERTO = 4444;
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		//Conectamos con el servidor
		Socket socket = new Socket(IP,PUERTO);
		
		System.out.println("-- CLIENTE --");
	    
		//Abrimos el flujo de salida
		DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
		
		//Guardamos en variable mensaje y enviamos una a nuestra consola y otra a el servidor
		String mensajeCliente = "Hola, soy el cliente";
		System.out.println("Yo: "+mensajeCliente);
		salida.writeUTF(mensajeCliente);
		
		//
	    AtiendeServidor aServidor = new AtiendeServidor(socket);
	    aServidor.start();
	    
		
	}
}
