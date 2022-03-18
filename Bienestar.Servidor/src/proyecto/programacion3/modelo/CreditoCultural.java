package proyecto.programacion3.modelo;

import proyecto.programacion3.utilidades.TipoCredito;

public class CreditoCultural extends Credito{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private double costo;

	public CreditoCultural() {
		super();
	}

	public CreditoCultural(String codigo, String nombre, int duracionHoras, int cupoMaximo, String horario,
			Instructor instructor, Lugar lugar, TipoCredito tipoCredito, double costo) {
		super(codigo, nombre, duracionHoras, cupoMaximo, horario, instructor, lugar, tipoCredito);
		this.costo = costo;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	@Override
	public String toString() {
		return "Cultural [costo=" + costo + "]";
	}
}
