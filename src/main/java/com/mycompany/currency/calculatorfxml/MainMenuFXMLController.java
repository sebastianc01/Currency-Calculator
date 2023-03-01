/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.currency.calculatorfxml;

import static currency.SelectedExchangeRate.loadExchangeRate;
import com.mycompany.exceptions.IncorrectDataException;
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

    ObservableList<String> exchangeRateList = FXCollections.observableArrayList(
            "CHF/PLN", "GBP/PLN","USD/PLN","EUR/PLN", "CZK/PLN", "NOK/PLN");
    
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
        if(exchangeRateChoiceBox.getSelectionModel().getSelectedItem() == null) { //user did not choose anything, choice box empty
            Alert alert = new Alert(Alert.AlertType.ERROR, "Exchange rate was not selected.", ButtonType.OK);
            alert.showAndWait();
        }
        else {
            try{
            String selectedItem = (String) exchangeRateChoiceBox.getSelectionModel().getSelectedItem();
            Stage stage = (Stage) calculatorButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/com/mycompany/currency/calculatorfxml/CalculatorFXML.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            CalculatorFXMLController calcController = (CalculatorFXMLController) fxmlLoader.getController();
            calcController.setExchangeRate(loadExchangeRate((String) exchangeRateChoiceBox.getSelectionModel().getSelectedItem()));
            stage.close();
            stage.setScene(scene);
            stage.show();
            } catch(IOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to open currency calculator.", ButtonType.OK);
                alert.showAndWait();
            } catch(IncorrectDataException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
                alert.showAndWait();
            }
    }
    }
}
