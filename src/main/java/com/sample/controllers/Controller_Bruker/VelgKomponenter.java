package com.sample.controllers.Controller_Bruker;

import com.sample.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VelgKomponenter implements Initializable {

    @FXML
    private CheckBox musvelg;

    @FXML
    private CheckBox tastaturvelg;

    @FXML
    private Button leggtil;

    @FXML
    void handlekurvaction(ActionEvent event) throws IOException {
        App.changeView("fullforkjop.fxml");

    }

    @FXML
    void leggtilaction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
