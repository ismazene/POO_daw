package org.example.demofx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {

    static int cont;

    @FXML
    private Label welcomeText;

    @FXML
    private Button contador;

    @FXML
    private Label contando;

    @FXML
    public void initialize() {
        contador.setOnAction(e -> contando.setText(Integer.toString(++cont)));
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}