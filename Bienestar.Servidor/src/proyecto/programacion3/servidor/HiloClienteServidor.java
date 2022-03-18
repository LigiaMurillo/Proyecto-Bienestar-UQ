package proyecto.programacion3.servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import persistencia.Persistencia;
import proyecto.programacion3.modelo.Bienestar;

public class HiloClienteServidor extends Thread{

	private DataInputStream flujoEntradaComunicacion;
	private DataOutputStream flujoSalidaComunicacion;

	private ObjectInputStream flujoEntradaObjeto;
	private ObjectOutputStream flujoSalidaObjeto;
	private Servidor servidor;
	private int tipoServicio;
	private Bienestar bienestar;


	/**
	 * Metodo run del hilo que pregunta al cliente el tipo de servicio que necesita
	 * @author Juan Carlos Celis Romero
	 */
	@Override
	public void run() {

		try {
			tipoServicio = flujoEntradaComunicacion.readInt();
			switch(tipoServicio){
			case 1:
				enviarInformacionPersistencia();
				break;

			case 2:
				guardarInformacionPersistencia();
				break;

				default:

					break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	/**
	 * Metodo que guarda la informacion de persistencia en el servidor
	 * @author Juan Carlos Celis
	 */
	private void guardarInformacionPersistencia() {

		try{
			bienestar = (Bienestar) flujoEntradaObjeto.readObject();
			Persistencia.guardarRecursoBienestarXML(bienestar);
		}
		catch(ClassNotFoundException | IOException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}



	/**
	 * Metodo que envia la informacion de persistencia al el servidor
	 * @author Juan Carlos Celis
	 */
	private void enviarInformacionPersistencia() {

		try {
			bienestar = Persistencia.cargarRecursoBienestarXML();
			flujoSalidaObjeto.writeObject(bienestar);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * Constructor del hilo
	 * @param flujoEntradaComunicacion
	 * @param flujoSalidaComunicacion
	 * @param flujoSalidaObjeto
	 * @param flujoEntradaObjeto
	 * @param servidor
	 * @author Juan Carlos Celis Romero
	 */
	public void inicializar(DataInputStream flujoEntradaComunicacion, DataOutputStream flujoSalidaComunicacion,
			ObjectOutputStream flujoSalidaObjeto, ObjectInputStream flujoEntradaObjeto, Servidor servidor) {

		this.flujoEntradaComunicacion = flujoEntradaComunicacion;
		this.flujoSalidaComunicacion = flujoSalidaComunicacion;
		this.flujoEntradaObjeto = flujoEntradaObjeto;
		this.flujoSalidaObjeto = flujoSalidaObjeto;
		this.servidor = servidor;
	}
}
