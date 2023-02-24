/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.currency.calculatorfxml;

import com.mycompany.calculations.JsonNBPEnum;
import com.mycompany.calculations.ReadJsonNBP;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sebastian
 */
public class MainMenuFXMLController implements Initializable {

    ObservableList<String> exchangeRateList = FXCollections.observableArrayList("GBP/PLN", "PLN/GBP");
    
    @FXML
    private ChoiceBox exchangeRateChoiceBox;
    @FXML
    private Button calculatorButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        exchangeRateChoiceBox.setItems(exchangeRateList);
    }    

    @FXML
    private void calculatorAction(ActionEvent event) {
        String b = (String) exchangeRateChoiceBox.getSelectionModel().getSelectedItem();
        Alert alert1 = new Alert(Alert.AlertType.ERROR, b, ButtonType.OK);
        alert1.showAndWait();
        Stage stage = (Stage) calculatorButton.getScene().getWindow();
        stage.close();
        try{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/com/mycompany/currency/calculatorfxml/CalculatorFXML.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        ReadJsonNBP a = new ReadJsonNBP(JsonNBPEnum.GBPPLN);
        stage.setUserData(a);
        stage.setScene(scene);
        stage.show();
        } catch(IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
            alert.showAndWait();
        }
    }
    
}
