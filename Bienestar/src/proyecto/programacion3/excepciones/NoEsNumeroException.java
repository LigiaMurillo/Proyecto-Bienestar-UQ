package proyecto.programacion3.excepciones;

public class NoEsNumeroException extends Exception{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param mensaje
	 */
	public NoEsNumeroException (String mensaje){
		super(mensaje);
	}

}
