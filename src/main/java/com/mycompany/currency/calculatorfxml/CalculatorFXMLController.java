/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.currency.calculatorfxml;

import com.mycompany.calculations.ExchangeRateRecord;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Sebastian
 */
public class CalculatorFXMLController implements Initializable {

    @FXML
    private AnchorPane calcAnchorPane;
    protected ExchangeRateRecord exchangeRate;
    @FXML
    private Button returnButton;
    @FXML
    private TextField textField1;
    @FXML
    private TextField textField2;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    private void returnAction(ActionEvent event) {
        Stage stage = (Stage) returnButton.getScene().getWindow();
        ExchangeRateRecord temp = (ExchangeRateRecord) stage.getUserData();
        temp.readData();
        Alert alert1 = new Alert(Alert.AlertType.ERROR, temp.getCurrencyPair(), ButtonType.OK);
        alert1.showAndWait();
        stage.close();
        try{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/com/mycompany/currency/calculatorfxml/MainMenuFXML.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
        //main.getScene().setRoot(fxmlLoader.load());
        } catch(IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
            alert.showAndWait();
        }
    }

}
