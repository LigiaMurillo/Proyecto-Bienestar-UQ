package proyecto.programacion3.modelo;

import java.io.Serializable;
import java.util.ArrayList;

import proyecto.programacion3.utilidades.TipoCredito;

public class Credito implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
	private String nombre;
	private int duracionHoras;
	private int cupoMaximo;
	private int contadorEstudiantes;
	private String horario;
	private Instructor instructor;
	private Lugar lugar;
	private TipoCredito tipoCredito;
	private ArrayList<Estudiante> listaEstudiantes;

	public Credito() {

	}

	public Credito(String codigo, String nombre, int duracionHoras, int cupoMaximo, String horario,
			Instructor instructor, Lugar lugar, TipoCredito tipoCredito) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.duracionHoras = duracionHoras;
		this.cupoMaximo = cupoMaximo;
		this.horario = horario;
		this.instructor = instructor;
		this.lugar = lugar;
		this.tipoCredito = tipoCredito;
		this.contadorEstudiantes = 0;
		this.listaEstudiantes = new ArrayList<>();
	}

	public TipoCredito getTipoCredito() {
		return tipoCredito;
	}

	public void setTipoCredito(TipoCredito tipoCredito) {
		this.tipoCredito = tipoCredito;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDuracionHoras() {
		return duracionHoras;
	}

	public void setDuracionHoras(int duracionHoras) {
		this.duracionHoras = duracionHoras;
	}

	public int getCupoMaximo() {
		return cupoMaximo;
	}

	public void setCupoMaximo(int cupoMaximo) {
		this.cupoMaximo = cupoMaximo;
	}

	public int getContardorEstudiantes() {
		return contadorEstudiantes;
	}

	public void setContardorEstudiantes(int contardorEstudiantes) {
		this.contadorEstudiantes = contardorEstudiantes;
	}


	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}


	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public int getContadorEstudiantes() {
		return contadorEstudiantes;
	}

	public void setContadorEstudiantes(int contadorEstudiantes) {
		this.contadorEstudiantes = contadorEstudiantes;
	}

	public ArrayList<Estudiante> getListaEstudiantes() {
		return listaEstudiantes;
	}

	public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
		this.listaEstudiantes = listaEstudiantes;
	}

	public boolean registrarEstudiante(Estudiante estudiante){

		if (!this.listaEstudiantes.contains(estudiante) && contadorEstudiantes+1 <= cupoMaximo){
			contadorEstudiantes++;
			return this.listaEstudiantes.add(estudiante);
		}
		return false;
	}

	@Override
	public String toString() {
		return "Credito [codigo=" + codigo + ", nombre=" + nombre + ", duracionHoras=" + duracionHoras + ", cupoMaximo="
				+ cupoMaximo + ", contardorEstudiantes=" + contadorEstudiantes + ", horario=" + horario
				+ ", instructor=" + instructor + ", lugar=" + lugar + "]";
	}

	public boolean eliminarEstudiante(Estudiante estudiante) {

		if (this.listaEstudiantes.contains(estudiante))
			return this.listaEstudiantes.remove(estudiante);
		return false;
	}
}
