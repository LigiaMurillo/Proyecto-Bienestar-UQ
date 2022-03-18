package proyecto.programacion3.controlador;

import java.net.URL;
import java.util.ResourceBundle;

import org.omg.CORBA.portable.ValueOutputStream;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import proyecto.programacion3.modelo.Credito;
import proyecto.programacion3.modelo.Estudiante;
import proyecto.programacion3.modelo.Lugar;
import proyecto.programacion3.modelo.Usuario;

public class EstudianteViewController implements Initializable{

	private Estudiante estudiante;
	private Credito creditoSeleccionado;
	private Credito creditoRegistradoSeleccionado;

	ModelFactoryController mfc = ModelFactoryController.getInstance();
	ObservableList<Credito> listaCreditos = FXCollections.observableArrayList();
	ObservableList<Credito> listaCreditosRegistrados = FXCollections.observableArrayList();


    @FXML
    private Label lblSemestre;

    @FXML
    private TableView<Credito> tablaCreditos;

    @FXML
    private Label lblUsuario;

    @FXML
    private TableColumn<Credito, Lugar> colLugarRegistrado;

    @FXML
    private Label lblNombre;

    @FXML
    private TableColumn<Credito, String> colCod;

    @FXML
    private Button btnCancelarCredito;

    @FXML
    private TableColumn<Credito, String> colNombre;

    @FXML
    private TableColumn<Credito, String> colNombreRegistrado;

    @FXML
    private TableColumn<Credito, String> colHora;

    @FXML
    private Button btnRegistrarCredito;

    @FXML
    private TableColumn<Credito, String> colHoraRegistrado;

    @FXML
    private TableColumn<Credito, Lugar> colLugar;

    @FXML
    private Label lblCedula;

    @FXML
    private TableView<Credito> tablaCreditosRegistrados;

    @FXML
    void registrarCredito(ActionEvent event) {

    	try {
    		if (creditoSeleccionado != null){
    			if (mfc.registrarCredito(creditoSeleccionado, estudiante)){
    				mostrarMensaje("Bienestar Institucional.", "Informe de registro",
    						"Credito registrado correctamente.", AlertType.INFORMATION);
    			}else{
    				mostrarMensaje("Bienestar Institucional.", "Informe de registro",
    						"No se pudo registrar el credito.", AlertType.INFORMATION);
    			}
    		}else
    			mostrarMensaje("Bienestar Institucional.", "Informe de registro",
    					"Asegurese de seleccionar un credito primero.", AlertType.WARNING);
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		actualizarTablas();
    	}
    }

    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
    	this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	this.colCod.setCellValueFactory(new PropertyValueFactory<>("codigo"));
    	this.colHora.setCellValueFactory(new PropertyValueFactory<>("horario"));
    	this.colLugar.setCellValueFactory(new PropertyValueFactory<>("lugar"));

    	this.colNombreRegistrado.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	this.colHoraRegistrado.setCellValueFactory(new PropertyValueFactory<>("horario"));
    	this.colLugarRegistrado.setCellValueFactory(new PropertyValueFactory<>("lugar"));

    	tablaCreditos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			creditoSeleccionado = newSelection;
		});

    	tablaCreditosRegistrados.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			creditoRegistradoSeleccionado = newSelection;
		});
	}

    @FXML
    void cancelarCredito(ActionEvent event) {

    	try {
    		if (creditoRegistradoSeleccionado != null){
    			if (mfc.cancelarCredito(creditoRegistradoSeleccionado, estudiante)){
    				mostrarMensaje("Bienestar Institucional.", "Informe de cancelacion",
    						"Credito cancelado correctamente.", AlertType.INFORMATION);
    			}else
    				mostrarMensaje("Bienestar Institucional.", "Informe de cancelacion",
    						"No se pudo cancelar el credito.", AlertType.INFORMATION);
    		}else
    			mostrarMensaje("Bienestar Institucional.", "Informe de cancelacion",
						"Asegurese de seleccionar un credito primero.", AlertType.WARNING);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			actualizarTablas();
		}
    }

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public void mostrarFichaUsuario (){

		this.lblNombre.setText(estudiante.getNombre());
		this.lblCedula.setText(estudiante.getCedula());
		this.lblUsuario.setText(estudiante.getNick());
		this.lblSemestre.setText(String.valueOf(estudiante.getSemestre()));
	}

	public void actualizarTablas(){

		tablaCreditos.getItems().clear();
		listaCreditos.addAll(mfc.obtenerListaCreditos());
		tablaCreditos.setItems(listaCreditos);

		tablaCreditosRegistrados.getItems().clear();
		listaCreditosRegistrados.addAll(estudiante.getListaCreditosInscritos());
		tablaCreditosRegistrados.setItems(listaCreditosRegistrados);

	}

	private void mostrarMensaje(String titulo, String head, String content, AlertType tipo) {
		Alert alerta = new Alert(null);
		alerta.setTitle(titulo);
		alerta.setHeaderText(head);
		alerta.setContentText(content);
		alerta.setAlertType(tipo);
		alerta.show();
	}

	public void vincularUsuario(){

		this.mfc.setUsuario(estudiante);
	}
}
