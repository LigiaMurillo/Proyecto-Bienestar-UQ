package proyecto.programacion3.servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	/**
	 * Sockets del servidor
	 */
	ServerSocket serverComunicacion;
	ServerSocket serverTransferenciaObjeto;

	/**
	 * Flujos de comunicacion
	 */

	private DataInputStream flujoEntradaComunicacion;
	private DataOutputStream flujoSalidaComunicacion;

	/**
	 * Flujos de transporte para objetos
	 */
	private ObjectInputStream flujoEntradaObjeto;
	private ObjectOutputStream flujoSalidaObjeto;

	/**
	 * Metodo que pone a correr el servidor
	 * @author Anggy
	 * @throws IOException
	 */
	public void runServer() throws IOException{

		serverComunicacion = new ServerSocket(8888);
		serverTransferenciaObjeto = new ServerSocket(8889);

		while (true){

			System.out.println("Servidor iniciado...");
			Socket socketComunicacion =  null;
			Socket socketTransferenciaObjeto =  null;

			socketComunicacion = serverComunicacion.accept();
			socketTransferenciaObjeto = serverTransferenciaObjeto.accept();

			System.out.println("Conexión establecida");

			flujoEntradaComunicacion = new DataInputStream(socketComunicacion.getInputStream());
			flujoSalidaComunicacion = new DataOutputStream(socketComunicacion.getOutputStream());

			flujoSalidaObjeto = new ObjectOutputStream(socketTransferenciaObjeto.getOutputStream());
			flujoEntradaObjeto = new ObjectInputStream(socketTransferenciaObjeto.getInputStream());

			iniciarHiloClienteServidor();

		}
	}


	private void iniciarHiloClienteServidor() {

		HiloClienteServidor hiloClienteServidor = new HiloClienteServidor();

		hiloClienteServidor.inicializar(flujoEntradaComunicacion, flujoSalidaComunicacion, flujoSalidaObjeto, flujoEntradaObjeto, this);

		hiloClienteServidor.start();
	}
}
