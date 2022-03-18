package proyecto.programacion3.excepciones;

public class FaltaParametroException extends Exception {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la clase
	 *
	 * @param mensaje El mensaje a mostrar
	 */
	public FaltaParametroException(String mensaje) {
		super(mensaje);

	}
}
