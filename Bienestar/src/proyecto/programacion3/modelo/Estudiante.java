package proyecto.programacion3.modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Estudiante extends Usuario{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private int catidadCreditosInscritos;
	private int semestre;
	private ArrayList<Credito> listaCreditosInscritos;

	public Estudiante() {
		super();
	}

	public Estudiante(String nombre, String cedula, String nick, String clave) {
		super(nombre, cedula, nick, clave);
		this.catidadCreditosInscritos = 0;
		this.semestre = 1;
		this.listaCreditosInscritos = new ArrayList<>();
	}

	public int getCatidadCreditosInscritos() {
		return catidadCreditosInscritos;
	}

	public void setCatidadCreditosInscritos(int catidadCreditosInscritos) {
		this.catidadCreditosInscritos = catidadCreditosInscritos;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public ArrayList<Credito> getListaCreditosInscritos() {
		return listaCreditosInscritos;
	}

	public void setListaCreditosInscritos(ArrayList<Credito> listaCreditosInscritos) {
		this.listaCreditosInscritos = listaCreditosInscritos;
	}

	public boolean registrarCreditos (Credito credito){
		
		if (!listaCreditosInscritos.contains(credito))
			return this.listaCreditosInscritos.add(credito);
		return false;
	}

	public boolean cancelarCreditos (Credito credito){

		return this.listaCreditosInscritos.remove(credito);
	}
}
