package proyecto.programacion3.modelo;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import persistencia.Persistencia;
import proyecto.programacion3.utilidades.TipoCredito;
import proyecto.programacion3.excepciones.*;

public class Bienestar implements Serializable, Validaciones{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Credito> listaCreditos;
	private ArrayList<Instructor> listaInstructores;
	private ArrayList<Estudiante> listaEstudiantes;
	private ArrayList<Administrador> listaAdministradores;
	private ArrayList<Lugar> listaLugares;
	private ArrayList<RegistroCredito> listaRegistros;

	public Bienestar() {
		super();
	}



	public ArrayList<Credito> getListaCreditos() {
		return listaCreditos;
	}

	public void setListaCreditos(ArrayList<Credito> listaCreditos) {
		this.listaCreditos = listaCreditos;
	}

	public ArrayList<Instructor> getListaInstructores() {
		return listaInstructores;
	}

	public void setListaInstructores(ArrayList<Instructor> listaInstructores) {
		this.listaInstructores = listaInstructores;
	}

	public ArrayList<Estudiante> getListaEstudiantes() {
		return listaEstudiantes;
	}

	public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
		this.listaEstudiantes = listaEstudiantes;
	}

	public ArrayList<Lugar> getListaLugares() {
		return listaLugares;
	}

	public void setListaLugares(ArrayList<Lugar> listaLugares) {
		this.listaLugares = listaLugares;
	}

	public ArrayList<RegistroCredito> getListaRegistros() {
		return listaRegistros;
	}

	public void setListaRegistros(ArrayList<RegistroCredito> listaRegistros) {
		this.listaRegistros = listaRegistros;
	}

	public ArrayList<Administrador> getListaAdministradores() {
		return listaAdministradores;
	}



	public void setListaAdministradores(ArrayList<Administrador> listaAdministradores) {
		this.listaAdministradores = listaAdministradores;
	}

	// -----------------------METODOS AGREGAR-------------------------



	public boolean agregarEstudiante(String nombre, String ccEstudiante,
			String usuario, String clave) throws FaltaParametroException, NombreNoEmpiezaConMayusculaException, NoEsNumeroException, CantidadDeCaracteresIncorrecta, ContieneNumerosException{

		comprobarParametro(nombre);
		comprobarParametro(ccEstudiante);
		comprobarParametro(usuario);
		comprobarParametro(clave);
		comprobarMayuscula(nombre);
		comprobarEsNumerico(ccEstudiante);
		comprobarTieneNumeros(nombre);
		comprobarCantidadCaracteres(clave);

		Estudiante estudiante = obtenerEstudiante(ccEstudiante);

		if (estudiante == null) {
				estudiante = new Estudiante(nombre, ccEstudiante, usuario, clave);
				return this.listaEstudiantes.add(estudiante);
		}
		return false;
	}

	public boolean agregarInstructor(String codigo, String nombre, String usuario, String clave) throws FaltaParametroException, NombreNoEmpiezaConMayusculaException, NoEsNumeroException, CantidadDeCaracteresIncorrecta, ContieneNumerosException{

		comprobarParametro(nombre);
		comprobarParametro(codigo);
		comprobarParametro(usuario);
		comprobarParametro(clave);
		comprobarMayuscula(nombre);
		comprobarEsNumerico(codigo);
		comprobarTieneNumeros(nombre);
		comprobarCantidadCaracteres(clave);

		Instructor instructor = obtenerInstructor(codigo);

		if(instructor==null) {
			instructor = new Instructor(codigo, nombre, usuario, clave);
			return this.listaInstructores.add(instructor);
		}
		return false;
	}

	public boolean agregarLugar(String nombre, String direccion) throws FaltaParametroException {

		comprobarParametro(nombre);
		comprobarParametro(direccion);

		Lugar nuevoLugar = new Lugar(nombre, direccion);

		if (!listaLugares.contains(nuevoLugar))
			return listaLugares.add(nuevoLugar);
		return false;
	}

	private void agregarRegistroCredito(int codigo, Estudiante estudiante, Credito credito, int nota1, int nota2,
			int nota3, int nota4, int promedio, int horasAsistencia, boolean aprovado) {

		RegistroCredito registroCredito = new RegistroCredito(codigo, null, credito, nota1, nota2, nota3, nota4,
				promedio, horasAsistencia, aprovado);
		/*
		 * registroCredito.setCodigo(codigo); registroCredito.setCredito(credito);
		 * registroCredito.setNota1(nota1); registroCredito.setNota2(nota2);
		 * registroCredito.setNota3(nota3); registroCredito.setNota4(nota4);
		 * registroCredito.setPromedio(promedio);
		 * registroCredito.setHorasAsistencia(horasAsistencia);
		 * registroCredito.setAprovado(aprovado);
		 */

		getListaRegistros().add(registroCredito);

	}

	// --------------- METODOS OBTENER -------------------------------

	public Instructor obtenerInstructor(String codigo) {

		for (Instructor instructor : listaInstructores) {
			if (instructor.getCedula().equals(codigo)) {
				return instructor;
			}
		}
		return null;
	}

	public Credito obtenerCredito(String nombre) {

		for (Credito credito : listaCreditos) {
			if (credito.getNombre().equalsIgnoreCase(nombre))
				return credito;
		}
		return null;
	}

	public Credito obtenerCreditoCodigo (String codigo){

		for (Credito credito : listaCreditos) {
			if (credito.getCodigo().equalsIgnoreCase(codigo))
				return credito;
		}
		return null;
	}

	public Estudiante obtenerEstudiante(String codigo) {

		Estudiante estudianteEncontrado = null;

		for (Estudiante estudiante : listaEstudiantes) {
			if (estudiante.getCedula().equals(codigo)) {

				estudianteEncontrado = estudiante;
				return estudianteEncontrado;
			}
		}
		return null;
	}

	public Lugar obtenerLugar(String nombre) {

		for (Lugar lugar : listaLugares) {
			if (lugar.getNombre().equalsIgnoreCase(nombre))
				return lugar;
		}
		return null;
	}

	public RegistroCredito obtenerRegistroCredito(int codigo) {
		RegistroCredito registroCreditoEncontrado = null;

		for (RegistroCredito registroCredito : listaRegistros) {
			if (registroCredito.getCodigo() == codigo) {
				registroCreditoEncontrado = registroCredito;
				break;
			}
		}

		return registroCreditoEncontrado;
	}

//--------------------METODOS ACTUALIZAR------------------------------

	public boolean actualizarInstructor(String codigo, String nombre, String usuario, String clave) throws FaltaParametroException, NombreNoEmpiezaConMayusculaException, CantidadDeCaracteresIncorrecta, NoEsNumeroException, ContieneNumerosException{

		comprobarParametro(nombre);
		comprobarParametro(codigo);
		comprobarParametro(usuario);
		comprobarParametro(clave);
		comprobarMayuscula(nombre);
		comprobarEsNumerico(codigo);
		comprobarTieneNumeros(nombre);
		comprobarCantidadCaracteres(clave);

		Instructor instructor = obtenerInstructor(codigo);

		if (instructor != null) {
			instructor.setCedula(codigo);
			instructor.setNombre(nombre);
			instructor.setNick(usuario);
			instructor.setClave(clave);

			return true;
		}
		return false;
	}

	public boolean actualizarLugar(String nombreActualizar, String nombre, String direccion) throws FaltaParametroException {

		comprobarParametro(nombreActualizar);
		comprobarParametro(direccion);

		Lugar lugar = obtenerLugar(nombreActualizar);

		if (lugar != null) {
			lugar.setNombre(nombre);
			lugar.setDireccion(direccion);
			return true;
		}
		return false;
	}

	private void actualizarRegistroCredito(final int codigo, final Estudiante estudiante, final Credito credito,
			final int nota1, final int nota2, final int nota3, final int nota4, final int promedio,
			final int horasAsistencia, boolean aprovado) {

		RegistroCredito registroCredito = obtenerRegistroCredito(codigo);

		if (registroCredito != null) {
			registroCredito.setCodigo(codigo);
			registroCredito.setCredito(credito);
			registroCredito.setNota1(nota1);
			registroCredito.setNota2(nota2);
			registroCredito.setNota3(nota3);
			registroCredito.setNota4(nota4);
			registroCredito.setPromedio(promedio);
			registroCredito.setHorasAsistencia(horasAsistencia);
			registroCredito.setAprovado(aprovado);
		}
	}

	// ------------------------METODOS ELIMINAR------------------------------------

	public boolean eliminarInstrctor(String codigo) {

		for (Instructor instructor : listaInstructores) {
			if (instructor.getCedula().equalsIgnoreCase(codigo))
				return listaInstructores.remove(instructor);
		}
		return false;
	}

	public boolean eliminarCredito(String codigo) {

		boolean creditoEliminado = false;
		Credito credito = obtenerCredito(codigo);

		if (credito != null) {
			getListaCreditos().remove(credito);
			creditoEliminado = true;
		}
		return creditoEliminado;
	}

	public boolean eliminarEstudiante(String codigo){

		Estudiante estudiante = obtenerEstudiante(codigo);

		if (estudiante != null) {
			return listaEstudiantes.remove(estudiante);
		}
		return false;
	}

	public boolean registroCreditoEliminado(int codigo) {
		boolean registroCreditoEliminado = false;
		RegistroCredito registroCredito = obtenerRegistroCredito(codigo);

		if (registroCredito != null) {
			getListaRegistros().remove(registroCredito);
			registroCreditoEliminado = true;

		}
		return registroCreditoEliminado;
	}

	private boolean comprobarDatoVacio(String dato) {

		if (dato == null || dato.equals("")) {
			return false;
		}
		return true;
	}

	public boolean actualizarEstudiante(String nombreEstudiante, String usuarioEstudiante, String claveEstudiante,
			String cedula) throws FaltaParametroException, NombreNoEmpiezaConMayusculaException, NoEsNumeroException, CantidadDeCaracteresIncorrecta, ContieneNumerosException {

		comprobarParametro(nombreEstudiante);
		comprobarParametro(usuarioEstudiante);
		comprobarParametro(claveEstudiante);
		comprobarMayuscula(nombreEstudiante);
		comprobarTieneNumeros(nombreEstudiante);
		comprobarCantidadCaracteres(claveEstudiante);

		for (Estudiante estudiante : listaEstudiantes) {
			if (estudiante.getCedula().equalsIgnoreCase(cedula)){
				listaEstudiantes.get(listaEstudiantes.indexOf(estudiante)).setNombre(nombreEstudiante);
				listaEstudiantes.get(listaEstudiantes.indexOf(estudiante)).setNick(usuarioEstudiante);
				listaEstudiantes.get(listaEstudiantes.indexOf(estudiante)).setClave(claveEstudiante);
				return true;
			}
		}
		return false;
	}

	public boolean eliminarLugar(Lugar lugar) {

		return listaLugares.remove(lugar);
	}

	public boolean agregarCredito(String nombre, String codigo, int duracion, int cupo, Instructor instructor,
			String horario, Lugar lugar, String homologable, TipoCredito tipoCredito, int costo) {

		Credito credito = null;

		if (tipoCredito.equals(TipoCredito.ACADEMICO)){
			boolean esHomologable;
			if (homologable.equalsIgnoreCase("Si"))
				esHomologable = true;
			else
				esHomologable = false;
			credito = new CreditoAcademico(codigo, nombre, duracion, cupo, horario, instructor, lugar, tipoCredito, esHomologable);
		} else if (tipoCredito.equals(TipoCredito.CULTURAL)){
			credito = new CreditoCultural(codigo, nombre, duracion, cupo, horario, instructor, lugar, tipoCredito, costo);
		} else if (tipoCredito.equals(TipoCredito.DEPORTIVO)){
			credito = new CreditoDeportivo(codigo, nombre, duracion, cupo, horario, instructor, lugar, tipoCredito);
		}
		if (credito != null)
			return this.listaCreditos.add(credito);
		return false;
	}

	public boolean actualizarCredito(String codigo, String nombre, int duracion, int cupo, Instructor instructor,
			String horario, Lugar lugar) {

		Credito credito = obtenerCreditoCodigo(codigo);

		if (credito != null){
			credito.setNombre(nombre);
			credito.setDuracionHoras(duracion);
			credito.setCupoMaximo(cupo);
			credito.setInstructor(instructor);
			credito.setHorario(horario);
			credito.setLugar(lugar);
			return true;
		}
		return false;
	}

	public boolean eliminarCredito(Credito creditoSeleccionado) {

		return this.listaCreditos.remove(creditoSeleccionado);
	}

	@Override
	public Usuario validarInicioSesion(String usuario, String clave) {

		for (Instructor instructor : listaInstructores) {
			if (instructor.getNick().equalsIgnoreCase(usuario) && instructor.getClave().equalsIgnoreCase(clave))
				return instructor;
		}
		for (Estudiante estudiante : listaEstudiantes) {
			if (estudiante.getNick().equalsIgnoreCase(usuario) && estudiante.getClave().equalsIgnoreCase(clave))
				return estudiante;
		}
		for (Administrador administrador : listaAdministradores) {
			if (administrador.getNick().equalsIgnoreCase(usuario) && administrador.getClave().equalsIgnoreCase(clave))
				return administrador;
		}
		return null;
	}

	public boolean agregarAdministrador(String nombre, String cedula, String nick, String clave) {

		return this.listaAdministradores.add(new Administrador(nombre, cedula, nick, clave));
	}


	/**
	 * @author Ligia
	 * Este metodo registra un credito al estudiante que viene como parametro.
	 * @param creditoSeleccionado
	 * @param estudiante
	 * @return true/false
	 */
	public boolean registrarCreditoEstudiante(Credito creditoSeleccionado, Estudiante estudiante) {

		if (this.listaCreditos.contains(creditoSeleccionado) && this.listaEstudiantes.contains(estudiante)){
			for (Credito credito : listaCreditos) {
				if (credito.equals(creditoSeleccionado))
					if (credito.registrarEstudiante(estudiante))
						for (Estudiante estudianteAux : listaEstudiantes) {
							if (estudianteAux.equals(estudiante))
								return estudianteAux.registrarCreditos(credito);
						}
			}
		}
		return false;
	}

	public boolean cancelarCreditoEstudiante(Credito creditoRegistradoSeleccionado, Estudiante estudiante) {

		for (Credito credito : listaCreditos) {
			if (creditoRegistradoSeleccionado.equals(credito)){
				credito.eliminarEstudiante(estudiante);
				for (Estudiante estudianteAux : listaEstudiantes) {
					if (estudianteAux.equals(estudiante))
						return estudianteAux.cancelarCreditos(creditoRegistradoSeleccionado);
				}
			}
		}
		return false;
	}

//	Metodos de excepciones -------------------------------------------------------------------

	/**
	 * Metodo que comprueba si una cadena esta formada por numeros.
	 * @author Ligia
	 * @param dato
	 * @return true/false
	 * @throws NoEsNumeroException
	 */
	private void comprobarEsNumerico(String dato) throws NoEsNumeroException {

		char[] arregloDato = dato.toCharArray();

		for (char c : arregloDato) {
			if (!Character.isDigit(c)){
				throw new NoEsNumeroException("Algunas casillas como cedula o telefono, "
						+ "esperan solo numeros.");
			}
		}
	}

	/**
	 * Metodo que comprueba si una cadena contiene algun numero.
	 * @author Ligia
	 * @param dato
	 * @return true/false
	 * @throws NoEsNumeroException
	 * @throws ContieneNumerosException
	 */
	private void comprobarTieneNumeros(String dato) throws ContieneNumerosException {

		char[] arregloDato = dato.toCharArray();

		for (char c : arregloDato) {
			if (Character.isDigit(c)){
				throw new ContieneNumerosException("Algunas casillas como nombre, "
						+ "no pueden contener numeros.");
			}
		}
	}

	/**
	 * Metodo que comprueba si un dato empieza con mayuscula.
	 * @author Ligia
	 * @param dato
	 * @throws NombreNoEmpiezaConMayusculaException
	 */
	private void comprobarMayuscula(String dato) throws NombreNoEmpiezaConMayusculaException {

		char[] arregloDato = dato.toCharArray();
		if (!Character.isUpperCase(arregloDato[0]))
			throw new NombreNoEmpiezaConMayusculaException("El nombre no empieza con mayuscula.");
	}

	/**
	 * Metodo que comprueba si una cadena viene vacia.
	 * @param dato
	 * @throws FaltaParametroException
	 */
	private void comprobarParametro(String dato) throws FaltaParametroException {

		if (dato == null || dato.equalsIgnoreCase("")){
			throw new FaltaParametroException("No se pudo ejecutar la "
					+ "accion porque falta algun dato requerido.");
		}
	}

	/**
	 * Metodo que comprueba si una clave tiene 4 caracteres exactos.
	 * @author Ligia
	 * @param dato
	 * @throws CantidadDeCaracteresIncorrecta
	 */
	private void comprobarCantidadCaracteres (String dato) throws CantidadDeCaracteresIncorrecta{

		char[] arregloDato = dato.toCharArray();

		if (arregloDato.length > 4 || arregloDato.length < 4){
			throw new CantidadDeCaracteresIncorrecta("La clave debe ser de 4 caracteres exactos.");
		}
	}
}