package org.example.demofx_estudiantes;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.time.LocalDate;

public class HelloController {

    static Connection db;

    @FXML
    public TableView<Estudiante> TablaGeneral;

    @FXML
    public TableColumn<Estudiante, Integer> ColumnaNIA;

    @FXML
    public TableColumn<Estudiante, String> ColumnaNombre;

    @FXML
    public TableColumn<Estudiante, LocalDate> ColumnaFecha;

    @FXML
    public TextField NIATextField;

    @FXML
    public TextField NombreTextField;

    @FXML
    public DatePicker FechaDatePicker;

    @FXML
    public Button BotonInsertar;

    @FXML
    public Button BotonGuardar;

    @FXML
    public Label IDlabel;

    @FXML
    public void initialize() {

        db = DatosEstudiantes.conexion();

        ColumnaNIA.setCellValueFactory(datos ->
                new SimpleIntegerProperty(datos.getValue().getNIA()).asObject());

        ColumnaNombre.setCellValueFactory(datos ->
                new SimpleStringProperty(datos.getValue().getNombre()));

        ColumnaFecha.setCellValueFactory(datos ->
                new ReadOnlyObjectWrapper<>(datos.getValue().getFecha_nacimiento()));

        TablaGeneral.setItems(DatosEstudiantes.consulta(db));
    }

    public void EditarButton(ActionEvent actionEvent) {

        Estudiante estudiante = TablaGeneral.getSelectionModel().getSelectedItem();

        if (estudiante == null) {
            IDlabel.setText("Selecciona un estudiante");
            return;
        }

        BotonInsertar.setDisable(true);
        BotonGuardar.setDisable(false);

        NIATextField.setText(String.valueOf(estudiante.getNIA()));
        NombreTextField.setText(estudiante.getNombre());
        FechaDatePicker.setValue(estudiante.getFecha_nacimiento());
    }

    public void EliminarButton(ActionEvent actionEvent) {
        Estudiante estudiante = TablaGeneral.getSelectionModel().getSelectedItem();

        if (estudiante != null) {
            DatosEstudiantes.eliminar(db, estudiante.getNIA());
            TablaGeneral.setItems(DatosEstudiantes.consulta(db));
        }
    }

    public void InsertarButton(ActionEvent actionEvent) {

        int nia = Integer.parseInt(NIATextField.getText());
        String nombre = NombreTextField.getText();
        LocalDate fecha = FechaDatePicker.getValue();

        Estudiante estudiante = new Estudiante(nia, nombre, fecha);

        DatosEstudiantes.insertar(db, estudiante);

        TablaGeneral.setItems(DatosEstudiantes.consulta(db));
    }

    public void GuardarButton(ActionEvent actionEvent) {

        int nia = Integer.parseInt(NIATextField.getText());
        String nombre = NombreTextField.getText();
        LocalDate fecha = FechaDatePicker.getValue();

        Estudiante estudiante = new Estudiante(nia, nombre, fecha);

        DatosEstudiantes.guardar(db, estudiante);

        TablaGeneral.setItems(DatosEstudiantes.consulta(db));

        BotonInsertar.setDisable(false);
        BotonGuardar.setDisable(true);
    }
}