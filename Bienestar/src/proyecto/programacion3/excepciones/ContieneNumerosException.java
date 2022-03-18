package proyecto.programacion3.excepciones;

public class ContieneNumerosException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param mensaje
	 */
	public ContieneNumerosException (String mensaje){
		super(mensaje);
	}
}
