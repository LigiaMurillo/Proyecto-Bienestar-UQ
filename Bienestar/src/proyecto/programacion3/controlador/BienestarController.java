package proyecto.programacion3.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import proyecto.programacion3.app.MainApp;
import proyecto.programacion3.modelo.Credito;
import proyecto.programacion3.modelo.Estudiante;
import proyecto.programacion3.modelo.Instructor;
import proyecto.programacion3.modelo.Lugar;
import proyecto.programacion3.modelo.Usuario;
import proyecto.programacion3.utilidades.TipoCredito;

public class BienestarController implements Initializable {

	Usuario usuario;
	ObservableList<String> listaHorariosData = FXCollections.observableArrayList("14:00", "16:00", "18:00", "20:00");
	ObservableList<String> listaHomologableData = FXCollections.observableArrayList("Si", "No");
	ObservableList<Estudiante> listaEstudiantesData = FXCollections.observableArrayList();
	ObservableList<Instructor> listaInstructoresData = FXCollections.observableArrayList();
	ObservableList<Lugar> listaLugaresData = FXCollections.observableArrayList();
	ObservableList<Credito> listaCreditoData = FXCollections.observableArrayList();
	ObservableList<TipoCredito> listaTipoCreditoData = FXCollections.observableArrayList(
			TipoCredito.ACADEMICO, TipoCredito.CULTURAL, TipoCredito.DEPORTIVO);

	Estudiante estudianteSeleccionado;
	Instructor instructorSeleccionado;
	Lugar lugarSeleccionado;
	Credito creditoSeleccionado;

//	Singleton --------------------------------------------------------------------------------
	ModelFactoryController mfc = ModelFactoryController.getInstance();
//	------------------------------------------------------------------------------------------

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button botonActualizarInstructor;

	@FXML
	private TableColumn<Estudiante, String> columnaSemestreEstudiante;

	@FXML
	private Button botonBuscarCredito;

	@FXML
	private TextField textNombreEstudiante;

	@FXML
	private TextField textUsuarioInstructor;

	@FXML
	private TableColumn<Estudiante, String> columnaDocumetoEstudiante;

	@FXML
	private TableColumn<Lugar, String> columnaNombreLugar;

	@FXML
	private TableColumn<Instructor, String> columnaNombreInstructor;

	@FXML
	private TableColumn<Instructor, String> columnaUsuarioInstructor;

	@FXML
	private TextField textDracionHorasCredito;

	@FXML
	private Button botonLimpiarInstructor;

	@FXML
	private TextField textCostoCredito;

	@FXML
	private Button botonEliminarLugar;

	@FXML
	private TextField textClaveEstudiante;

	@FXML
	private Button botonGuardarEstudiante;

	@FXML
	private TableColumn<Instructor, String> columnaInstructorCredito;

	@FXML
	private TextField textBuscarLugar;

	@FXML
	private TableColumn<Credito, String> columnaHorarioCredito;

	@FXML
	private TableColumn<Estudiante, String> columnaCreditosRegistradosEstudiante;

	@FXML
	private TableView<Instructor> tablaInstructores;

	@FXML
	private TextField textNombreLugares;

	@FXML
	private TableColumn<Lugar, String> columnaDireccionLugar;

	@FXML
	private Button botonBuscarEstudiante;

	@FXML
	private TableColumn<Credito, String> columnaDuracionCredito;

	@FXML
	private Tab pestanaEstudiantes;

	@FXML
	private ChoiceBox<String> choiceBoxHomologableCredito;

	@FXML
	private ChoiceBox<String> choiceBoxHorarioCredito;

	@FXML
	private TableColumn<Instructor, String> columnaClaveInstructor;

	@FXML
	private Tab pestanaLugares;

	@FXML
	private Button botonLimpiarLugar;

	@FXML
	private TextField textDireccionLugares;

	@FXML
	private TextField textBuscarCredito;

	@FXML
	private TableColumn<Estudiante, String> columnaNombreEstudiante;

	@FXML
	private TableColumn<Instructor, String> columnaDocumetoInstructor;

	@FXML
	private Tab pestanaCreditos;

	@FXML
	private ChoiceBox<Instructor> choiceBoxInstructorCredito;

	@FXML
	private Button botonLimpiarEstudiante;

	@FXML
	private TextField textDocumentoEstudinate;

	@FXML
	private TextField textUsuarioEstudiante;

	@FXML
	private TextField textCupoMaximoCredito;

	@FXML
	private Button botonBuscarLugar;

	@FXML
	private Button botonGuardarCredito;

	@FXML
	private Button botonEliminarCredito;

	@FXML
	private TableView<Estudiante> tablaEstudiantes;

	@FXML
	private TableView<Lugar> tablaLugares;

	@FXML
	private TableColumn<Credito, String> columnaNombreCredito;

	@FXML
	private Button botonGuardarLugar;

	@FXML
	private Button botonLimpiarCredito;

	@FXML
	private TextField textBuscarDocumentoInstructor;

	@FXML
	private Tab pestanaEstudiantes1;

	@FXML
	private TextField textClaveInstructor;

	@FXML
	private TableColumn<Lugar, String> columnaCodigoLugar;

	@FXML
	private Button botonActualizarLugar;

	@FXML
	private Button botonEliminarInstructor;

	@FXML
	private Button botonBuscarInstructor;

	@FXML
	private Button botonGuardarInstructor;

	@FXML
	private TextField textBuscarDocumentoEstudinate1;

	@FXML
	private Button botonEliminarEstudiante;

	@FXML
	private Button botonActualizarEstudiante;

	@FXML
	private Button botonActuializarCredito;

	@FXML
	private TextField textNombreInstructor;

	@FXML
	private TextField textNmbreCredito;

	@FXML
	private TextField textDocumentoInstructor;

	@FXML
	private ChoiceBox<Lugar> choiceBoxLugarCredito;

	@FXML
    private ChoiceBox<TipoCredito> choiceBoxTipoCredito;

	@FXML
    private TableView<Credito> tablaCreditos;

	@FXML
	void GuardarEstudiante(ActionEvent event) {

		try {

			String nombreEstudiante = textNombreEstudiante.getText();
			String codigoEstudiante = textDocumentoEstudinate.getText();
			String usuarioEstudiante = textUsuarioEstudiante.getText();
			String claveEstudiante = textClaveEstudiante.getText();
			int semestre = 1;
			int cantidadCreditos = 0;

			if (mfc.agregarEstudiante(nombreEstudiante, codigoEstudiante,
					usuarioEstudiante, claveEstudiante)){

				mostrarMensaje("Bienestar Institucional", null, "Estudiante creado con exito", AlertType.INFORMATION);
				limpiarFormularioEstudiante();
			}else{
				mostrarMensaje("Bienestar Institucional", null, "No se pudo crear al estudiante.", AlertType.ERROR);
				limpiarFormularioEstudiante();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			actualizarTablas();
		}
	}

	@FXML
	void buscarEstudiante(ActionEvent event) {

		String busqueda = textBuscarDocumentoEstudinate1.getText();
		busqueda.trim();
		Estudiante estudiante = mfc.buscarEstudiante(busqueda);
		if (estudiante != null)
			mostrarMensaje("Bienestar Institucional", "Informe de busqueda:", estudiante.toString(), AlertType.INFORMATION);
		else
			mostrarMensaje("Bienestar Institucional", "Informe de busqueda:", "El estudiante no existe.", AlertType.INFORMATION);
	}

	@FXML
	void actualizarEstudiante(ActionEvent event) {

		try {
			if (estudianteSeleccionado != null) {
				String nombreEstudiante = textNombreEstudiante.getText();
				String usuarioEstudiante = textUsuarioEstudiante.getText();
				String claveEstudiante = textClaveEstudiante.getText();
				String cedula = estudianteSeleccionado.getCedula();

				if (mfc.actualizarEstudiante(nombreEstudiante, usuarioEstudiante,
						claveEstudiante, cedula)){
					limpiarFormularioEstudiante();
					mostrarMensaje("Bienestar Institucional", "Informe de actualizacion", "Estudiante actualizado con exito", AlertType.INFORMATION);
				}else{
					mostrarMensaje("Bienestar Institucional", "Informe de actualizacion", "No se pudo actualizar al estudiante.", AlertType.INFORMATION);
				}

			} else {
				mostrarMensaje("Bienestar Institucional", null, "Asegúrese de buscar un estudiante primero.",
						AlertType.WARNING);
			}

			estudianteSeleccionado = null;

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			actualizarTablas();
		}
	}

	@FXML
	void eliminarEstudiante(ActionEvent event) {

		try {
			if (estudianteSeleccionado != null) {
				String cedula = estudianteSeleccionado.getCedula();
				if (mfc.eliminarEstudiante(cedula)){
					limpiarFormularioEstudiante();
					mostrarMensaje("Bienestar Institucional", "Informe de eliminacion", "Estudiante eliminado con éxito",
							AlertType.INFORMATION);
				}else{
					mostrarMensaje("Bienestar Institucional", "Informe de eliminacion", "No se pudo eliminar al estudiante.",
							AlertType.INFORMATION);
				}

			} else {
				mostrarMensaje("Bienestar Institucional", null, "Asegúrese de selecionar un estudiante.",
						AlertType.WARNING);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			actualizarTablas();
			limpiarFormularioEstudiante();
		}
	}

	@FXML
	void LimpiarEstudiante(ActionEvent event) {
		limpiarFormularioEstudiante();
	}

//	Crud Instructor --------------------------------------------------------------------------

	@FXML
	void GuardarInstructor(ActionEvent event) {

		try {
			String nombreInstructor = textNombreInstructor.getText();
			String codigoInstructor = textDocumentoInstructor.getText();
			String usuarioInstructor = textUsuarioInstructor.getText();
			String claveInstructor = textClaveInstructor.getText();

			if (mfc.agregarInstructor(nombreInstructor, codigoInstructor,
					usuarioInstructor, claveInstructor)){
				limpiarFormularioInstructor();
				mostrarMensaje("Bienestar Institucional", null, "Instructor creado con exito", AlertType.INFORMATION);
			}else{
				mostrarMensaje("Bienestar Institucional", null, "No se pudo crear al instructor.", AlertType.INFORMATION);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			actualizarTablas();
			actualizarChoiceBox();
		}
	}

	@FXML
	void buscarIndtructor(ActionEvent event) {

		try {
			String busqueda = textBuscarDocumentoInstructor.getText();
			Instructor instructor = mfc.buscarInstructor(busqueda);
			if (instructor!= null)
				mostrarMensaje("Bienestar Institucional", "Informe de busqueda:", instructor.toString(), AlertType.INFORMATION);
			else
				mostrarMensaje("Bienestar Institucional", "Informe de busqueda:", "No se encuentra el instructor.", AlertType.INFORMATION);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void actualizarInstructor(ActionEvent event) {

		try {
			if (instructorSeleccionado != null) {
				String nombreInstructor = textNombreInstructor.getText();
				String usuarioInstructor = textUsuarioInstructor.getText();
				String claveInstructor = textClaveInstructor.getText();
				String cedulaInstructor = instructorSeleccionado.getCedula();

				if (mfc.actualizarInstructor(nombreInstructor, usuarioInstructor,
						claveInstructor, cedulaInstructor)){
					limpiarFormularioInstructor();
					mostrarMensaje("Bienestar Institucional", "Informe de actualizacion", "Instructor actualizado con exito", AlertType.INFORMATION);
				}else{
					mostrarMensaje("Bienestar Institucional", "Informe de actualizacion", "No se pudo actualizar al instructor.", AlertType.INFORMATION);
				}
			} else {
				mostrarMensaje("Bienestar Institucional", null, "Asegúrese de seleccionar un instructor primero.",
						AlertType.WARNING);
			}
			instructorSeleccionado = null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			actualizarTablas();
			actualizarChoiceBox();
		}
	}

	@FXML
	void eliminarInstructor(ActionEvent event) {

		try {
			if (instructorSeleccionado != null) {
				String cedula = instructorSeleccionado.getCedula();
				if (mfc.eliminarInstructor(cedula)){
					mostrarMensaje("Bienestar Institucional", "Informe de eliminacion", "Instructor eliminado con éxito",
							AlertType.INFORMATION);
				}else{
					mostrarMensaje("Bienestar Institucional", "Informe de eliminacion", "No se pudo eliminar al instructor.",
							AlertType.INFORMATION);
				}
			} else {
				mostrarMensaje("Bienestar Institucional", null, "Asegúrese de selecionar un instructor.",
						AlertType.WARNING);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			actualizarTablas();
			actualizarChoiceBox();
			limpiarFormularioEstudiante();
		}
	}

	@FXML
	void LimpiarInstructor(ActionEvent event) {
		limpiarFormularioInstructor();
	}

//	Crud lugar -------------------------------------------------------------------------------

	@FXML
	void GuardarLugar(ActionEvent event) {

		try {
			String nombre = textNombreLugares.getText();
			String direccion = textDireccionLugares.getText();

			if (mfc.agregarLugar(nombre, direccion))
				mostrarMensaje("Bienestar Institucional", null, "Lugar creado con exito.", AlertType.INFORMATION);
			else
				mostrarMensaje("Bienestar Institucional", null, "No se pudo crear el lugar.", AlertType.INFORMATION);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			actualizarTablas();
			actualizarChoiceBox();
			limpiarFormularioLugar();
		}
	}

	@FXML
	void buscarLugar(ActionEvent event) {

		try {
			String busqueda = textBuscarLugar.getText();
			Lugar lugar = mfc.buscarLugar(busqueda);
			if (lugar!= null)
				mostrarMensaje("Bienestar Institucional", "Informe de busqueda:", lugar.toString(), AlertType.INFORMATION);
			else
				mostrarMensaje("Bienestar Institucional", "Informe de busqueda:", "No se encuentra el instructor.", AlertType.INFORMATION);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void actualizarLugar(ActionEvent event) {

		try {
			if (lugarSeleccionado != null){
				String nombreActualizar = lugarSeleccionado.getNombre();
				String nombre = textNombreLugares.getText();
				String dir = textDireccionLugares.getText();

				if (mfc.actualizarLugar(nombreActualizar, nombre, dir))
					mostrarMensaje("Bienestar Institucional", "Informe de actualizacion", "Lugar actualizado con exito", AlertType.INFORMATION);
				else
					mostrarMensaje("Bienestar Institucional", "Informe de actualizacion", "No se pudo actualizar el lugar.", AlertType.INFORMATION);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			actualizarTablas();
			actualizarChoiceBox();
			limpiarFormularioLugar();
		}
	}

	@FXML
	void eliminarLugar(ActionEvent event) {

		try {
			if (lugarSeleccionado != null)
				if (mfc.eliminarLugar(lugarSeleccionado))
					mostrarMensaje("Bienestar Institucional", "Informe de eliminacion", "Lugar eliminado con éxito.",
							AlertType.INFORMATION);
				else
					mostrarMensaje("Bienestar Institucional", "Informe de eliminacion", "No se pudo eliminar el lugar.",
							AlertType.INFORMATION);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			actualizarTablas();
			actualizarChoiceBox();
			limpiarFormularioLugar();
		}
	}

	@FXML
	void limpiarLugar(ActionEvent event) {
		limpiarFormularioLugar();
	}

	@FXML
	void guardarCredito(ActionEvent event) {

		try {
			String nombre = textNmbreCredito.getText();
			int duracion = Integer.parseInt(textDracionHorasCredito.getText());
			int cupo = Integer.parseInt(textCupoMaximoCredito.getText());
			int costo = 0;
			Instructor instructor = choiceBoxInstructorCredito.getValue();
			String horario = choiceBoxHorarioCredito.getValue();
			Lugar lugar = choiceBoxLugarCredito.getValue();
			String homologable = "";
			TipoCredito tipoCredito = choiceBoxTipoCredito.getValue();
			if (tipoCredito.equals(TipoCredito.ACADEMICO))
				homologable = choiceBoxHomologableCredito.getValue();
			else if(tipoCredito.equals(TipoCredito.CULTURAL))
				costo = Integer.parseInt(textCostoCredito.getText());
			if (mfc.agregarCredito(nombre, duracion, cupo, instructor, horario, lugar,
					homologable, tipoCredito, costo))
				mostrarMensaje("Bienestar Institucional", null, "Credito creado con exito.", AlertType.INFORMATION);
			else
				mostrarMensaje("Bienestar Institucional", null, "No se pudo agregar el credito.", AlertType.INFORMATION);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			actualizarTablas();
			limpiarFormularioCredito();
		}
	}

	@FXML
	void buscarCredito(ActionEvent event) {

		try {
			String busqueda = textBuscarCredito.getText();
			Credito credito = mfc.buscarCredito(busqueda);

			if (credito != null)
				mostrarMensaje("Bienestar Institucional", "Informe de busqueda",
						credito.getNombre() + "\n" + credito.getLugar() + "\n" + credito.getHorario(), AlertType.INFORMATION);
			else
				mostrarMensaje("Bienestar Institucional", "Informe de busqueda",
						"No se encuentra el credito.", AlertType.INFORMATION);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			limpiarFormularioCredito();
		}
	}

	@FXML
	void actuializarCredito(ActionEvent event) {

		if (creditoSeleccionado != null){
			try {
				String codigo = creditoSeleccionado.getCodigo();
				String nombre = textNmbreCredito.getText();
				int duracion = Integer.parseInt(textDracionHorasCredito.getText());
				int cupo = Integer.parseInt(textCupoMaximoCredito.getText());
				Instructor instructor = choiceBoxInstructorCredito.getValue();
				String horario = choiceBoxHorarioCredito.getValue();
				Lugar lugar = choiceBoxLugarCredito.getValue();
				if (mfc.actualizarCredito(codigo, nombre, duracion, cupo, instructor,
						horario, lugar))
					mostrarMensaje("Bienestar Institucional", null, "Credito actualizado con exito.", AlertType.INFORMATION);
				else
					mostrarMensaje("Bienestar Institucional", null, "No se pudo actualizar el credito.", AlertType.INFORMATION);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				actualizarTablas();
				limpiarFormularioCredito();
			}
		}
	}

	@FXML
	void eliminarCredito(ActionEvent event) {

		try {
			if (creditoSeleccionado != null)
				if (mfc.eliminarCredito(creditoSeleccionado))
					mostrarMensaje("Bienestar Institucional", "Informe de eliminacion", "Credito eliminado con éxito.",
							AlertType.INFORMATION);
				else
					mostrarMensaje("Bienestar Institucional", "Informe de eliminacion", "No se pudo eliminar el credito.",
							AlertType.INFORMATION);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			actualizarTablas();
			limpiarFormularioCredito();
		}
	}

	@FXML
	void limpiarCredito(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		this.columnaDocumetoEstudiante.setCellValueFactory(new PropertyValueFactory<>("cedula"));
		this.columnaNombreEstudiante.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columnaSemestreEstudiante.setCellValueFactory(new PropertyValueFactory<>("semestre"));
		this.columnaCreditosRegistradosEstudiante.setCellValueFactory(new PropertyValueFactory<>("catidadCreditosInscritos"));

		this.columnaNombreInstructor.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columnaDocumetoInstructor.setCellValueFactory(new PropertyValueFactory<>("cedula"));
		this.columnaUsuarioInstructor.setCellValueFactory(new PropertyValueFactory<>("nick"));
		this.columnaClaveInstructor.setCellValueFactory(new PropertyValueFactory<>("clave"));

		this.columnaNombreLugar.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columnaDireccionLugar.setCellValueFactory(new PropertyValueFactory<>("direccion"));

		this.columnaNombreCredito.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columnaDuracionCredito.setCellValueFactory(new PropertyValueFactory<>("duracionHoras"));
		this.columnaInstructorCredito.setCellValueFactory(new PropertyValueFactory<>("instructor"));
		this.columnaHorarioCredito.setCellValueFactory(new PropertyValueFactory<>("horario"));

		actualizarTablas();
		actualizarChoiceBox();

		tablaEstudiantes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			estudianteSeleccionado = newSelection;
			mostrarEstudiante(estudianteSeleccionado );
		});


		tablaInstructores.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			instructorSeleccionado = newSelection;
			mostrarInstructor(instructorSeleccionado);
		});

		tablaLugares.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			lugarSeleccionado = newSelection;
			mostrarLugar(lugarSeleccionado);
		});

		tablaCreditos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			creditoSeleccionado = newSelection;
		});

		choiceBoxHorarioCredito.setItems(listaHorariosData);
		choiceBoxHomologableCredito.setItems(listaHomologableData);
		choiceBoxTipoCredito.setItems(listaTipoCreditoData);
	}

	private void mostrarEstudiante(Estudiante estudianteSeleccionado) {
		if (estudianteSeleccionado != null) {
			textDocumentoEstudinate.setText(estudianteSeleccionado.getCedula());
			textNombreEstudiante.setText(estudianteSeleccionado.getNombre());
			textUsuarioEstudiante.setText(estudianteSeleccionado.getNick());
			textClaveEstudiante.setText(estudianteSeleccionado.getClave());

		}
	}

	private void mostrarInstructor(Instructor instructorSeleccionado2) {
		if (instructorSeleccionado2 != null) {
			textDocumentoInstructor.setText(instructorSeleccionado2.getCedula());
			textNombreInstructor.setText(instructorSeleccionado2.getNombre());
			textUsuarioInstructor.setText(instructorSeleccionado2.getNick());
			textClaveInstructor.setText(instructorSeleccionado2.getClave());

		}
	}

	private void mostrarLugar(Lugar lugarSeleccionado) {
		if (lugarSeleccionado != null) {
			textNombreLugares.setText(lugarSeleccionado.getNombre());
			textDireccionLugares.setText(lugarSeleccionado.getDireccion());

		}
	}

	private void limpiarFormularioEstudiante() {
		textNombreEstudiante.clear();
		textDocumentoEstudinate.clear();
		textUsuarioEstudiante.clear();
		textClaveEstudiante.clear();
	}

	private void limpiarFormularioInstructor() {
		textNombreInstructor.clear();
		textDocumentoInstructor.clear();
		textUsuarioInstructor.clear();
		textClaveInstructor.clear();
	}

	private void limpiarFormularioLugar() {
		textNombreLugares.clear();
		textDireccionLugares.clear();
	}

	private void limpiarFormularioCredito() {

		textNmbreCredito.setText("");
		textDracionHorasCredito.setText("");
		textCupoMaximoCredito.setText("");
		choiceBoxInstructorCredito.setValue(null);
		choiceBoxHorarioCredito.setValue("");
		choiceBoxLugarCredito.setValue(null);
		textCostoCredito.setText("");
		choiceBoxHomologableCredito.setValue("");
	}

//	Utilidades -------------------------------------------------------------------------------

	private void mostrarMensaje(String titulo, String head, String content, AlertType tipo) {
		Alert alerta = new Alert(null);
		alerta.setTitle(titulo);
		alerta.setHeaderText(head);
		alerta.setContentText(content);
		alerta.setAlertType(tipo);
		alerta.show();
	}

	private void actualizarTablas() {

		tablaEstudiantes.getItems().clear();
		listaEstudiantesData.addAll(mfc.obtenerListaEstudiantes());
		tablaEstudiantes.setItems(listaEstudiantesData);
		tablaInstructores.getItems().clear();
		listaInstructoresData.addAll(mfc.obtenerListaInstructores());
		tablaInstructores.setItems(listaInstructoresData);
		tablaLugares.getItems().clear();
		listaLugaresData.addAll(mfc.obtenerListaLugares());
		tablaLugares.setItems(listaLugaresData);
		tablaCreditos.getItems().clear();
		listaCreditoData.addAll(mfc.obtenerListaCreditos());
		tablaCreditos.setItems(listaCreditoData);
	}

	private void actualizarChoiceBox() {

		choiceBoxInstructorCredito.setItems(listaInstructoresData);
		choiceBoxLugarCredito.setItems(listaLugaresData);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void vincularUsuario(){
		mfc.setUsuario(usuario);
	}
}
