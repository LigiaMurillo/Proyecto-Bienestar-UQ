package proyecto.programacion3.controlador;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import proyecto.programacion3.modelo.*;
import proyecto.programacion3.utilidades.TipoCredito;
import persistencia.*;
import javafx.util.converter.LocalDateStringConverter;

public class ModelFactoryController implements Runnable{

	private Bienestar bienestar;
	private Usuario usuario;
	private Thread hiloGuardar;
	private Thread hiloCargar;
	Socket socketComunicacion;
	Socket socketObjeto;
	DataOutputStream flujoSalida;
	DataInputStream flujoEntrada;
	ObjectOutputStream flujoSalidaObjeto;
	ObjectInputStream flujoEntradaObjeto;
	private final int CANTIDADCARACTERESCODIGOCREDITO;

	private static class SingletonHolder {
		private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
	}

	public static ModelFactoryController getInstance(){
		return SingletonHolder.eINSTANCE;
	}

	public ModelFactoryController() {
		super();

		this.CANTIDADCARACTERESCODIGOCREDITO = 5;
		this.usuario = null;
		try {
			cargarXML();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Bienestar getBienestar() {
		return bienestar;
	}

	public void setBienestar(Bienestar bienestar) {
		this.bienestar = bienestar;
	}

//	Metodos de persistencia y servidor -------------------------------------------------------

	/**
	 * Crea la conexion.
	 * @author Michael Aguirre
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	private void crearConexion() throws UnknownHostException, IOException {

		socketComunicacion = new Socket("localhost", 8888);
		socketObjeto = new Socket("localhost", 8889);

		flujoEntrada = new DataInputStream(socketComunicacion.getInputStream());
		flujoSalida = new DataOutputStream(socketComunicacion.getOutputStream());

		flujoEntradaObjeto = new ObjectInputStream(socketObjeto.getInputStream());
		flujoSalidaObjeto = new ObjectOutputStream(socketObjeto.getOutputStream());
	}

	/**
	 * Metodo para guardar datos del servidor
	 * @author Juan Carlos Celis Romero
	 */
	private void enviarInstruccion(int i) {
		try {
			flujoSalida.writeInt(i);
			flujoSalida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que envia el objeto a guardar en el servidor.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	private void enviarObjetoPersistencia() throws ClassNotFoundException, IOException {
		flujoSalidaObjeto.writeObject(bienestar);
		System.out.println("Objeto bienestar enviado");
		flujoSalidaObjeto.close();
	}

	/**
	 * Metodo para encapsular el objeto proveniente del servidor
	 * @author Michael Aguirre
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	private void leerObjetoPersistencia() throws ClassNotFoundException, IOException {

		bienestar = (Bienestar) flujoEntradaObjeto.readObject();
		flujoEntradaObjeto.close();
	}

	public void guardarXML() throws Exception {

		hiloGuardar = new Thread(this);
		hiloGuardar.start();
	}

	public void cargarXML() {

		hiloCargar = new Thread(this);
		hiloCargar.start();
	}

//	Utilidades -------------------------------------------------------------------------------

	public String generarCodigoAleatorio() {

        String theAlphaNumericS;
        StringBuilder builder = new StringBuilder(CANTIDADCARACTERESCODIGOCREDITO);
        theAlphaNumericS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789";

        for (int m = 0; m <= CANTIDADCARACTERESCODIGOCREDITO; m++) {
        	int myindex = (int)(theAlphaNumericS.length() * Math.random());
        	builder.append(theAlphaNumericS.charAt(myindex));
        }
        return builder.toString();
	}

	public Usuario validarAcceso(String nick, String clave) {
		// TODO Auto-generated method stub
		return this.bienestar.validarInicioSesion(nick, clave);
	}
//	Obtener listas ----------------------------------------------------------------------------

	public ArrayList<Estudiante> obtenerListaEstudiantes(){

		return this.bienestar.getListaEstudiantes();
	}

	public ArrayList<Instructor> obtenerListaInstructores() {

		return this.bienestar.getListaInstructores();
	}

	public ArrayList<Lugar> obtenerListaLugares() {
		// TODO Auto-generated method stub
		return this.bienestar.getListaLugares();
	}

	public ArrayList<Credito> obtenerListaCreditos() {
		// TODO Auto-generated method stub
		return this.bienestar.getListaCreditos();
	}

//	CRUD Estudiantes --------------------------------------------------------------------------

	public boolean agregarEstudiante(String nombreEstudiante, String codigoEstudiante, String usuarioEstudiante, String claveEstudiante) throws Exception {

		if (this.bienestar.agregarEstudiante(nombreEstudiante, codigoEstudiante, usuarioEstudiante, claveEstudiante)){
			guardarXML();
			Persistencia.guardarRegLog(usuario.getNombre() + ": Estudiante agregado.", 1, "Guardar estudiante");
			return true;
		}
		Persistencia.guardarRegLog(usuario.getNombre() + ": Estudiante no agregado.", 2, "Guardar estudiante");
		return false;
	}

	public Estudiante buscarEstudiante(String busqueda) {

		Persistencia.guardarRegLog(usuario.getNombre() + ": Estudiante buscado.", 1, "Buscar estudiante");
		return this.bienestar.obtenerEstudiante(busqueda);
	}

	public boolean actualizarEstudiante(String nombreEstudiante, String usuarioEstudiante, String claveEstudiante,
			String cedula) throws Exception {

		if (this.bienestar.actualizarEstudiante(nombreEstudiante, usuarioEstudiante, claveEstudiante, cedula)){
			guardarXML();
			Persistencia.guardarRegLog(usuario.getNombre() + ": Estudiante actualizado.", 1, "Actualizar estudiante");
			return true;
		}
		Persistencia.guardarRegLog(usuario.getNombre() + ": Estudiante no actualizado.", 2, "Actualizar estudiante");
		return false;
	}

	public boolean eliminarEstudiante(String cedula) throws Exception {

		if (this.bienestar.eliminarEstudiante(cedula)){
			guardarXML();
			Persistencia.guardarRegLog(usuario.getNombre() + ": Estudiante eliminado.", 1, "Eliminar estudiante");
			return true;
		}
		Persistencia.guardarRegLog(usuario.getNombre() + ": Estudiante eliminado.", 2, "Eliminar estudiante");
		return false;
	}

//	Crud Instructor -------------------------------------------------------------------------

	public boolean agregarInstructor(String nombreInstructor, String codigoInstructor, String usuarioInstructor,
			String claveInstructor) throws Exception {

		if (this.bienestar.agregarInstructor(nombreInstructor, codigoInstructor, usuarioInstructor, claveInstructor)){
			guardarXML();
			Persistencia.guardarRegLog(usuario.getNombre() + ": Instructor agregado.", 1, "Guardar instructor");
			return true;
		}
		Persistencia.guardarRegLog(usuario.getNombre() + ": Instructor no agregado.", 2, "Guardar instructor");
		return false;
	}

	public Instructor buscarInstructor(String busqueda) {

		Persistencia.guardarRegLog(usuario.getNombre() + ": Instructor buscado.", 1, "Buscar instructor");
		return this.bienestar.obtenerInstructor(busqueda);
	}

	public boolean actualizarInstructor(String nombreInstructor, String usuarioInstructor, String claveInstructor,
			String cedulaInstructor) throws Exception {

		if (this.bienestar.actualizarInstructor(cedulaInstructor, nombreInstructor, usuarioInstructor, claveInstructor)){
			guardarXML();
			Persistencia.guardarRegLog(usuario.getNombre() + ": Instructor actualizado.", 1, "Actualizar instructor");
			return true;
		}
		Persistencia.guardarRegLog(usuario.getNombre() + ": Instructor no actualizado.", 2, "Actualizar instructor");
		return false;
	}

	public boolean eliminarInstructor(String cedula) throws Exception {

		if (this.bienestar.eliminarInstrctor(cedula)){
			guardarXML();
			Persistencia.guardarRegLog(usuario.getNombre() + ": Instructor eliminado.", 1, "Eliminar instructor");
			return true;
		}
		Persistencia.guardarRegLog(usuario.getNombre() + ": Instructor no eliminado.", 2, "Eliminar instructor");
		return false;
	}

//	Crud lugar -------------------------------------------------------------------------------

	public boolean agregarLugar(String nombre, String direccion) throws Exception {
		// TODO Auto-generated method stub
		if (this.bienestar.agregarLugar(nombre, direccion)){
			guardarXML();
			Persistencia.guardarRegLog(usuario.getNombre() + ": Lugar creado.", 1, "Agregar lugar");
			return true;
		}
		Persistencia.guardarRegLog(usuario.getNombre() + ": lugar no creado.", 2, "Agregar lugar");
		return false;
	}

	public Lugar buscarLugar(String busqueda) {

		Persistencia.guardarRegLog(usuario.getNombre() + ": Lugar buscado.", 1, "Buscar lugar");
		return this.bienestar.obtenerLugar(busqueda);
	}

	public boolean actualizarLugar(String nombreActualizar, String nombre, String dir) throws Exception {
		// TODO Auto-generated method stub
		if (this.bienestar.actualizarLugar(nombreActualizar, nombre, dir)){
			guardarXML();
			Persistencia.guardarRegLog(usuario.getNombre() + ": Lugar actualizado.", 1, "Actualizar lugar");
			return true;
		}
		Persistencia.guardarRegLog(usuario.getNombre() + ": Lugar no actualizado.", 2, "Actualizar lugar");
		return false;
	}

	public boolean eliminarLugar(Lugar lugar) throws Exception {

		if (this.bienestar.eliminarLugar(lugar)){
			guardarXML();
			Persistencia.guardarRegLog(usuario.getNombre() + ": Lugar eliminado.", 1, "Eliminar lugar");
			return true;
		}
		Persistencia.guardarRegLog(usuario.getNombre() + ": Lugar no eliminado.", 2, "Eliminar lugar");
		return false;
	}

//	Crud creditos ----------------------------------------------------------------------------

	public boolean agregarCredito(String nombre, int duracion, int cupo, Instructor instructor, String horario,
			Lugar lugar, String homologable, TipoCredito tipoCredito, int costo) throws Exception {

		String codigo = generarCodigoAleatorio();
		if (this.bienestar.agregarCredito(nombre, codigo, duracion, cupo, instructor, horario, lugar,
				homologable, tipoCredito, costo)){
			guardarXML();
			Persistencia.guardarRegLog(usuario.getNombre() + ": Credito agregado.", 1, "Agregar credito");
			return true;
		}
		Persistencia.guardarRegLog(usuario.getNombre() + ": Credito no agregado.", 2, "Agregar credito");
		return false;
	}

	public Credito buscarCredito(String busqueda) {

		Persistencia.guardarRegLog(usuario.getNombre() + ": Credito buscado.", 1, "Buscar credito");
		return this.bienestar.obtenerCredito(busqueda);
	}

	public boolean actualizarCredito(String codigo, String nombre, int duracion, int cupo, Instructor instructor,
			String horario, Lugar lugar) throws Exception {

		if (this.bienestar.actualizarCredito(codigo, nombre, duracion, cupo, instructor, horario, lugar)){
			guardarXML();
			Persistencia.guardarRegLog(usuario.getNombre() + ": Credito actualizado.", 1, "Actualizar credito");
			return true;
		}
		Persistencia.guardarRegLog(usuario.getNombre() + ": Credito no actualizado.", 2, "Actualizar credito");
		return false;
	}

	public boolean eliminarCredito(Credito creditoSeleccionado) throws Exception {

		if (this.bienestar.eliminarCredito(creditoSeleccionado)){
			guardarXML();
			Persistencia.guardarRegLog(usuario.getNombre() + ": Credito eliminado.", 1, "Eliminar credito");
			return true;
		}
		Persistencia.guardarRegLog(usuario.getNombre() + ": Credito no eliminado.", 2, "Eliminar credito");
		return false;
	}

//	Transaccional ----------------------------------------------------------------------------

	public boolean registrarCredito(Credito creditoSeleccionado, Estudiante estudiante) throws Exception {

		if (this.bienestar.registrarCreditoEstudiante(creditoSeleccionado, estudiante)){
			guardarXML();
			Persistencia.guardarRegLog(usuario.getNombre() + ": Credito registrado.", 1, "Registrar credito");
			return true;
		}
		Persistencia.guardarRegLog(usuario.getNombre() + ": Credito no registrado.", 2, "Registrar credito");
		return false;
	}

	public boolean cancelarCredito(Credito creditoRegistradoSeleccionado, Estudiante estudiante) throws Exception {

		if (this.bienestar.cancelarCreditoEstudiante(creditoRegistradoSeleccionado, estudiante)){
			guardarXML();
			Persistencia.guardarRegLog(usuario.getNombre() + ": Credito cancelado.", 1, "Cancelar credito");
			return true;
		}
		Persistencia.guardarRegLog(usuario.getNombre() + ": Credito no cancelado.", 2, "Cancelar credito");
		return false;
	}

	@Override
	public void run() {

		Thread hilo = Thread.currentThread();

		if (hilo.equals(hiloGuardar)){
			try {
				crearConexion();
				enviarInstruccion(2);
				enviarObjetoPersistencia();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		else if (hilo.equals(hiloCargar)){
			try {
				crearConexion();
				enviarInstruccion(1);
				leerObjetoPersistencia();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}