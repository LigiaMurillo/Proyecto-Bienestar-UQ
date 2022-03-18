package proyecto.programacion3.excepciones;

public class NombreNoEmpiezaConMayusculaException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param mensaje
	 */
	public NombreNoEmpiezaConMayusculaException(String mensaje) {
		super(mensaje);
	}
}
