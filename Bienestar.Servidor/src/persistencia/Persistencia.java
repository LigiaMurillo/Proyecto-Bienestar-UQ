package persistencia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import proyecto.programacion3.modelo.Bienestar;
import proyecto.programacion3.modelo.Estudiante;
import proyecto.programacion3.modelo.Instructor;

public class Persistencia {


	public static final String RUTA_ARCHIVO_LOG = "src/resources/regLog.txt";
	public static final String RUTA_ARCHIVO_MODELO_PROGRAMA_XML = "src/resources/Bienestar.xml";


	/*
	 * public static void guardarRecursoProgramaXML(Programa programa) {
	 *
	 * try {
	 * ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_PROGRAMA_XML,
	 * programa); } catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 */

//	----------------------LOADS------------------------



	public static Bienestar cargarRecursoBienestarXML() {

		Bienestar bienestar = null;

		try {
			bienestar = (Bienestar)ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_PROGRAMA_XML);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bienestar;
	}



	public static void guardarRecursoBienestarXML(Bienestar bienestar) {

		try {
			ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_PROGRAMA_XML, bienestar);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	RegistroLog ------------------------------------------------------------------------------

	/**
	 * Metodo que guarda el Registro Log
	 * @param mensaje
	 * @param nivel
	 * @param accion
	 */
	public static void guardarRegLog(String mensaje, int nivel, String accion) {

		ArchivoUtil.guardarRegistroLog(RUTA_ARCHIVO_LOG, mensaje, nivel, accion);
	}
}
