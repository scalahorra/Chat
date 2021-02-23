package principal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class AtiendeServidor extends Thread{
//Clase encargada de recibir los mensajes del servidor y escribirlos en el terminal
	
	private Socket socket;
	
	public AtiendeServidor(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		
		try {
			
			//Abrimos los flujos de entrada y salida
			DataInputStream entrada = new DataInputStream(socket.getInputStream());
			DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
			
			//Recibimos el mensaje del servidor
			String mensajeDelServidor = entrada.readUTF();
			System.out.println("Servidor: "+mensajeDelServidor);
			
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		
	}
}
