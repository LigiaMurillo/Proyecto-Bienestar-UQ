package proyecto.programacion3.modelo;

import java.io.Serializable;

public class RegistroCredito implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigo;
	private Estudiante estudiante;
	private Credito credito;
	private int nota1, nota2, nota3,nota4;
	private int promedio =(nota1+ nota2+ nota3+ nota4)/4;
	private int horasAsistencia;
	private boolean aprovado;
	
	public RegistroCredito() {
		super();
	}

	public RegistroCredito(int codigo, Estudiante estudiante, Credito credito, int nota1, int nota2, int nota3,
			int nota4, int promedio, int horasAsistencia, boolean aprovado) {
		super();
		this.codigo = codigo;
		this.estudiante = estudiante;
		this.credito = credito;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
		this.nota4 = nota4;
		this.promedio = promedio;
		this.horasAsistencia = horasAsistencia;
		this.aprovado = aprovado;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public Estudiante getEstudiante() {
		return estudiante;
	}


	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}


	public Credito getCredito() {
		return credito;
	}


	public void setCredito(Credito credito) {
		this.credito = credito;
	}


	public int getNota1() {
		return nota1;
	}


	public void setNota1(int nota1) {
		this.nota1 = nota1;
	}


	public int getNota2() {
		return nota2;
	}


	public void setNota2(int nota2) {
		this.nota2 = nota2;
	}


	public int getNota3() {
		return nota3;
	}


	public void setNota3(int nota3) {
		this.nota3 = nota3;
	}


	public int getNota4() {
		return nota4;
	}


	public void setNota4(int nota4) {
		this.nota4 = nota4;
	}


	public int getPromedio() {
		return promedio;
	}


	public void setPromedio(int promedio) {
		this.promedio = promedio;
	}


	public int getHorasAsistencia() {
		return horasAsistencia;
	}


	public void setHorasAsistencia(int horasAsistencia) {
		this.horasAsistencia = horasAsistencia;
	}


	public boolean isAprovado() {
		return aprovado;
	}


	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}

	@Override
	public String toString() {
		return "RegistroCredito [codigo=" + codigo + ", estudiante=" + estudiante + ", credito=" + credito + ", nota1="
				+ nota1 + ", nota2=" + nota2 + ", nota3=" + nota3 + ", nota4=" + nota4 + ", promedio=" + promedio
				+ ", horasAsistencia=" + horasAsistencia + ", aprovado=" + aprovado + "]";
	}
}
