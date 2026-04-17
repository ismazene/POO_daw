package org.example.demofx;

import javafx.beans.Observable;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;


public class Pantalla2controller {

    @FXML
    private TextField nombreTextField;

    @FXML
    private TextField edadTextField;

    @FXML
    private TableView<Persona> personasTableView;

    @FXML
    private TableColumn<Persona,String> nombreTableColumn;

    @FXML
    private TableColumn<Persona,Integer> edadTableColumn;

    @FXML
    public void initialize(){
        nombreTableColumn.setCellValueFactory(datos -> new SimpleStringProperty(datos.getValue().getNombre()));
        edadTableColumn.setCellValueFactory(datos -> new SimpleIntegerProperty(datos.getValue().getEdad()).asObject());

        personasTableView.setItems(PersonasCreadas.getListaPersonas());

    }


    public void volverButton() throws IOException {

        HelloApplication.setRoot("hello-view");
    }

    public void guardarButton() {
        String nombre = nombreTextField.getText();
        Integer edad = Integer.parseInt(edadTextField.getText() );

        Persona persona = new Persona(nombre,edad);
        PersonasCreadas.insertarPersona(persona);
        System.out.println("Persona creada: " + nombre + " - " + edad);
        System.out.println(PersonasCreadas.getListaPersonas());

        nombreTextField.clear();
        edadTextField.clear();

    }
}
