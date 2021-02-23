package principal;

import java.io.*;
import java.net.*;

public class AtiendeCliente extends Thread{
//Clase encargada de interaccionar con el cliente que le han asignado a través de su socket.
	
	private Socket socket;
	
	public AtiendeCliente(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		
		try {
			
			DataInputStream entrada = new DataInputStream(socket.getInputStream());
			DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
			
			String mensajeDelCliente = entrada.readUTF();
			System.out.println("Cliente: "+mensajeDelCliente);
			
			String mensajeServidor = "Hola, yo soy el servidor";
			System.out.println("Yo: "+mensajeServidor);
			salida.writeUTF(mensajeServidor);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
