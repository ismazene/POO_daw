package org.example.demofx_estudiantes;

import javafx.beans.property.ReadOnlyListWrapper;
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
    public TableView<Estudiante> TablaGeneral;
    public TableColumn<Estudiante,Integer> ColumnaNIA;
    public TableColumn<Estudiante, String> ColumnaNombre;
    public TableColumn<Estudiante, LocalDate> ColumnaFecha;
    public TextField NIATextField;
    public TextField NombreTextField;
    public DatePicker FechaDatePicker;
    public Button BotonInsertar;
    public Button BotonGuardar;

    @FXML
    public void initialize(){

         db = DatosEstudiantes.conexion();

        ColumnaNIA.setCellValueFactory(datos -> new SimpleIntegerProperty(datos.getValue().getNIA()).asObject());
        ColumnaNombre.setCellValueFactory(datos -> new SimpleStringProperty(datos.getValue().getNombre()));
        ColumnaFecha.setCellValueFactory(datos -> new ReadOnlyObjectWrapper<>(datos.getValue().getFecha_nacimiento()));

        TablaGeneral.setItems(DatosEstudiantes.consulta(db));
    }

    public void EditarButton(ActionEvent actionEvent) {

        
    }

    public void EliminarButton(ActionEvent actionEvent) {
    }

    public void InsertarButton(ActionEvent actionEvent) {
    }

    public void GuardarButton(ActionEvent actionEvent) {
    }
}
