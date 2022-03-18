package proyecto.programacion3.app;


import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import proyecto.programacion3.modelo.*;
import proyecto.programacion3.controlador.*;

public class MainApp extends Application {

	private static Stage primaryStage;
	public ModelFactoryController mfc;

	@Override
	public void start(Stage primaryStage) throws Exception {

		mfc = ModelFactoryController.getInstance();
		this.primaryStage = primaryStage;
		mostrarVentanaLogin();
	}


	public static void mostrarVentanaLogin() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/proyecto/programacion3/vista/Login.FXML"));
			BorderPane bp = loader.load();
			LoginController lController = loader.getController();
			Scene scene = new Scene(bp);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Bienestar Uniquindio");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void mostrarVentanaAdministrador(Usuario usuario) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/proyecto/programacion3/vista/paginaPrincipal.FXML"));
			Parent root = loader.load();
			BienestarController bController = loader.getController();
			bController.setUsuario(usuario);
			bController.vincularUsuario();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Bienestar Uniquindio");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void mostrarVentanaEstudiante(Estudiante estudiante) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/proyecto/programacion3/vista/EstudianteView.FXML"));
			Parent root = loader.load();
			EstudianteViewController evController = loader.getController();
			evController.setEstudiante(estudiante);
			evController.vincularUsuario();
			evController.actualizarTablas();
			evController.mostrarFichaUsuario();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Bienestar Uniquindio");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void mostrarVentanaInstructor(Usuario usuario) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/proyecto/programacion3/vista/InstructorView.FXML"));
			Parent root = loader.load();
			InstructorViewController ivController = loader.getController();
//			ivController.setEstudiante(usuario);
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Bienestar Uniquindio");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		launch(args);
	}

}
