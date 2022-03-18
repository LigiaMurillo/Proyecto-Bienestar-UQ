package proyecto.programacion3.modelo;

import java.io.Serializable;

public class Instructor extends Usuario{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public Instructor() {
		super();
	}

	public Instructor(String nombre, String cedula, String nick, String clave) {
		super(nombre, cedula, nick, clave);

	}


}
