package proyecto.programacion3.utilidades;

public enum TipoCredito {

	ACADEMICO("Academico"), CULTURAL("Cultural"), DEPORTIVO("Deportivo");

	private String tipoCredito;

	private TipoCredito(String tipoCredito) {
		this.tipoCredito = tipoCredito;
	}

	public String getTipoCredito() {
		return tipoCredito;
	}

	public void setTipoCredito(String tipoCredito) {
		this.tipoCredito = tipoCredito;
	}
}
