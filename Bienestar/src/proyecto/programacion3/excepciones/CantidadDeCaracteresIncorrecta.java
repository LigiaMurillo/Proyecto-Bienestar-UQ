package proyecto.programacion3.excepciones;

public class CantidadDeCaracteresIncorrecta extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param mensaje
	 */
	public CantidadDeCaracteresIncorrecta (String mensaje){
		super(mensaje);
	}
}