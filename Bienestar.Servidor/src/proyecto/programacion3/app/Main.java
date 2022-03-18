package proyecto.programacion3.app;

import java.io.IOException;

import proyecto.programacion3.servidor.Servidor;

public class Main {

	public static void main(String[] args) {
		
		Servidor servidor = new Servidor();
		
		try {
			servidor.runServer();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
