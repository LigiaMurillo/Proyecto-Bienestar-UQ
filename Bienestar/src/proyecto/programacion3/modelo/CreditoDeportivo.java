package proyecto.programacion3.modelo;

import proyecto.programacion3.utilidades.TipoCredito;

public class CreditoDeportivo extends Credito {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private final double PORCENTAJEMINIMO = 0.8;
	private double asistenciaminima;

	public CreditoDeportivo() {
		super();
	}

	public CreditoDeportivo(String codigo, String nombre, int duracionHoras, int cupoMaximo, String horario,
			Instructor instructor, Lugar lugar, TipoCredito tipoCredito) {
		super(codigo, nombre, duracionHoras, cupoMaximo, horario, instructor, lugar, tipoCredito);
		asistenciaminima = cupoMaximo * PORCENTAJEMINIMO;
	}

	public double getAsistenciaminima() {
		return asistenciaminima;
	}

	public void setAsistenciaminima(double asistenciaminima) {
		this.asistenciaminima = asistenciaminima;
	}

	@Override
	public String toString() {
		return "CreditoDeportivo [asistenciaminima=" + asistenciaminima + "]";
	}
}
