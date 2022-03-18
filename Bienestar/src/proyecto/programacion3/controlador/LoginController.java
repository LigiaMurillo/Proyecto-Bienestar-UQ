package proyecto.programacion3.controlador;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import proyecto.programacion3.app.MainApp;
import proyecto.programacion3.modelo.Administrador;
import proyecto.programacion3.modelo.Estudiante;
import proyecto.programacion3.modelo.Instructor;
import proyecto.programacion3.modelo.Usuario;

public class LoginController implements Initializable{

	ModelFactoryController mfc = ModelFactoryController.getInstance();

    @FXML
    private Button btnIngresar;

    @FXML
    private PasswordField txtClave;

    @FXML
    private TextField txtUsuario;

    @FXML
    void ingresar(ActionEvent event) {

    	String nick = txtUsuario.getText();
    	String clave = txtClave.getText();
    	Usuario usuario = mfc.validarAcceso(nick, clave);

    	if (usuario!= null)
    		if (usuario instanceof Administrador)
    			MainApp.mostrarVentanaAdministrador(usuario);
    		else if (usuario instanceof Estudiante)
    			MainApp.mostrarVentanaEstudiante((Estudiante)usuario);
    		else if(usuario instanceof Instructor)
    			MainApp.mostrarVentanaInstructor(usuario);
    	else
    		mostrarMensaje("Bienestar institucional", "Login", "No se ha podido ingresar a la aplicacion. Puede que el usuario o la clave sean incorrectos.", AlertType.INFORMATION);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	private void mostrarMensaje(String titulo, String head, String content, AlertType tipo) {
		Alert alerta = new Alert(null);
		alerta.setTitle(titulo);
		alerta.setHeaderText(head);
		alerta.setContentText(content);
		alerta.setAlertType(tipo);
		alerta.show();
	}

}