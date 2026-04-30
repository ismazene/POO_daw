package org.example.demofx_estudiantes;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.time.LocalDate;

public class EstudiantesController {

    static Connection db;

    public TableView<Estudiante> estudianteTableView;
    public TableColumn<Estudiante,Integer> niaTableColumn;
    public TableColumn<Estudiante,String> nombreTableColumn;
    public TableColumn<Estudiante, LocalDate> fechaTableColumn;
    public Label mensajeLabel;
    public TextField niaTextField;
    public TextField nombreTextField;
    public DatePicker fechaDatePicker;
    public Button insertarButton;
    public Button guardarButton;

    @FXML
    public void initialize(){

        db = DatosEstudiantes.conexion();

        niaTableColumn.setCellValueFactory(datos -> new SimpleIntegerProperty(datos.getValue().getNia()).asObject());
        nombreTableColumn.setCellValueFactory(datos -> new SimpleStringProperty(datos.getValue().getNombre()));
        fechaTableColumn.setCellValueFactory(datos -> new ReadOnlyObjectWrapper<>(datos.getValue().getFecha_nacimiento()));

        estudianteTableView.setItems(DatosEstudiantes.consulta(db));

    }

    public void modificarClickButton() {
       Estudiante estudiante = estudianteTableView.getSelectionModel().getSelectedItem();
       if (estudiante == null){
           mensajeLabel.setText("No hay nadie seleccionado...");
       }else {
           insertarButton.setDisable(true);
           guardarButton.setDisable(false);
           niaTextField.setText(estudiante.getNia().toString());
           niaTextField.setDisable(true);
           nombreTextField.setText(estudiante.getNombre());
           fechaDatePicker.setValue(estudiante.getFecha_nacimiento());
       }
    }

    public void eliminarClickButton() {
        Estudiante estudiante = estudianteTableView.getSelectionModel().getSelectedItem();

        if (estudiante == null){
            mensajeLabel.setText("No hay nadie seleccionado...");
        }else {
            DatosEstudiantes.borrar(db,estudiante);
            System.out.println("Estudiante borrado.");
            estudianteTableView.setItems(DatosEstudiantes.consulta(db));
        }
    }

    public void insertarClickButton() {
        String nombre = nombreTextField.getText();
        Integer nia;
        try {
            nia = Integer.parseInt(niaTextField.getText());

        }catch (Exception e){
            mensajeLabel.setText("Formato NIA incorrecto...");
            return;
        }
        LocalDate fecha = fechaDatePicker.getValue();
        Estudiante estudiante = new Estudiante(nia,nombre,fecha);

        if (estudiante.getFecha_nacimiento().getYear()>LocalDate.now().getYear()){
            mensajeLabel.setText("Año no válido...");
        }else {
            if (DatosEstudiantes.insertar(db,estudiante)){
                estudianteTableView.setItems(DatosEstudiantes.consulta(db));
                nombreTextField.clear();
                niaTextField.clear();
                fechaDatePicker.setValue(null);
                mensajeLabel.setText("Estudiante insertado!");
            }else {
                mensajeLabel.setText("Formato no válido...");
            }


        }
    }

    public void guardarClickButton() {
        Integer nia = Integer.parseInt(niaTextField.getText());
        String nombre = nombreTextField.getText();
        LocalDate fecha = fechaDatePicker.getValue();
        DatosEstudiantes.guardar(db,new Estudiante(nia,nombre,fecha));
        insertarButton.setDisable(false);
        guardarButton.setDisable(true);
        mensajeLabel.setText("Estudiante modificado!");
        niaTextField.clear();
        nombreTextField.clear();
        fechaDatePicker.setValue(null);
        estudianteTableView.setItems(DatosEstudiantes.consulta(db));

    }
}
