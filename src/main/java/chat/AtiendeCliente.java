package chat;

import java.io.DataInputStream;
import java.net.Socket;

public class AtiendeCliente extends Thread{

	private Socket socket;
	private ComunHilos comunHilos;
	private String usuario;
	
	public AtiendeCliente(Socket socket, ComunHilos comunHilos) {
		this.socket = socket;
		this.comunHilos = comunHilos;
	}
	
	@Override
	public void run() {
		super.run();
		
		try {
			
			comunHilos.anadir(socket);
			
			DataInputStream entrada = new DataInputStream(socket.getInputStream());
			
			usuario = entrada.readUTF();
			
			System.out.println(usuario + ": " + entrada.readUTF());
			
			while(true) {
				
				String mensajeCliente = entrada.readUTF();
			
				System.out.println(usuario + ": " + mensajeCliente);
				
				comunHilos.anadir(mensajeCliente, usuario);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
