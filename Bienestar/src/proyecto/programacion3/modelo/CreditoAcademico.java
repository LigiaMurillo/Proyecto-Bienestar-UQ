package proyecto.programacion3.modelo;

import proyecto.programacion3.utilidades.TipoCredito;

public class CreditoAcademico extends Credito {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private boolean homologable;

	public CreditoAcademico() {
		super();
	}
	
	public CreditoAcademico(String codigo, String nombre, int duracionHoras, int cupoMaximo, String horario,
			Instructor instructor, Lugar lugar, TipoCredito tipoCredito, boolean homologable) {
		super(codigo, nombre, duracionHoras, cupoMaximo, horario, instructor, lugar, tipoCredito);
		this.homologable = homologable;
	}

	public boolean isHomologable() {
		return homologable;
	}

	public void setHomologable(boolean homologable) {
		this.homologable = homologable;
	}

	@Override
	public String toString() {
		return "Academico [homologable=" + homologable + "]";
	}
}
