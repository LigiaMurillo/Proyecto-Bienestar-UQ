package proyecto.programacion3.modelo;

import java.io.Serializable;

public abstract class Usuario implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String cedula;
	private String nick;
	private String clave;

	public Usuario() {
		super();
	}

	public Usuario(String nombre, String cedula, String nick, String clave) {
		super();
		this.nombre = nombre;
		this.cedula = cedula;
		this.nick = nick;
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public String toString() {
		return nombre;
	}
}
