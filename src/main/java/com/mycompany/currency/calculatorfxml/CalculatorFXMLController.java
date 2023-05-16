/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.currency.calculatorfxml;

import currency.ExchangeRate;
import com.mycompany.calculations.CalculateValues;
import com.mycompany.calculations.TextFieldNumber;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 * FXML Controller class, shows two text fields, allowing user to convert chosen currencies and displaying current exchange rate.
 *
 * @author Sebastian
 */
public class CalculatorFXMLController implements Initializable {

    public ExchangeRate exchangeRate;
    @FXML
    private Button returnButton;
    @FXML
    private TextField textField1;
    @FXML
    private TextField textField2;
    @FXML
    private Label exchangeRateValue;
    @FXML
    private Label dateLabel;
    @FXML
    private Label currency1Label;
    @FXML
    private Label currency2Label;
    /**
     * Initializes the controller class. Setting the listeners of the text fields up.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        final StringProperty text1 = new SimpleStringProperty(textField1.getText());
        final StringProperty text2 = new SimpleStringProperty(textField2.getText());
        text1.addListener(new ChangeListener<String>() {
       @Override
         public void changed(ObservableValue<? extends String> obs, String oldValue, String newValue) {
         textField1.setText(newValue);
     }
    });
        textField1.textProperty().addListener(new ChangeListener<String>() {
    @Override
    public void changed(ObservableValue<? extends String> obs, String oldValue, String newValue) {
        if (! newValue.equals(text1.get())) { // textField's text was changed directly (i.e. by user)
            text1.set(CalculateValues.transformPointsToDots(newValue));
            CalculateValues calc = new CalculateValues(TextFieldNumber.secondTextField);
            text2.set(calc.calculateValue(newValue, exchangeRate.getExchangeRate()));
        }
    }
    });
        
        text2.addListener(new ChangeListener<String>() {
       @Override
         public void changed(ObservableValue<? extends String> obs, String oldValue, String newValue) {
         textField2.setText(newValue);
     }
    });
        textField2.textProperty().addListener(new ChangeListener<String>() {
    @Override
    public void changed(ObservableValue<? extends String> obs, String oldValue, String newValue) {
        if (! newValue.equals(text2.get())) { // textField's text was changed directly (i.e. by user)
            text2.set(CalculateValues.transformPointsToDots(newValue));
            CalculateValues calc = new CalculateValues(TextFieldNumber.firstTextField);
            text1.set(calc.calculateValue(newValue, exchangeRate.getExchangeRate()));
        }
    }
    });
    }
    
    /**
     * Used when a user clicks the return button to come back to the main menu.
     * @param event action event
     */
    @FXML
    private void returnAction(ActionEvent event) {
        Stage stage = (Stage) returnButton.getScene().getWindow();
        stage.close();
        try{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/com/mycompany/currency/calculatorfxml/MainMenuFXML.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //scene.
        stage.setScene(scene);
        stage.show();
        //main.getScene().setRoot(fxmlLoader.load());
        } catch(IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
            alert.showAndWait();
        }
    }
    
    /**
     * Sets ExchangeRate and a few values displayed on the screen (e.g. date, exchange rate value, currency codes).
     * @param exchangeRate way of reading data (from different sources) and types of currencies depends on it
     */
    public void setExchangeRate(ExchangeRate exchangeRate) {
        this.exchangeRate = exchangeRate;
        exchangeRateValue.setText("1 " + exchangeRate.getSenderCurrency() + " = " + exchangeRate.getExchangeRate() + " " + exchangeRate.getReceiverCurrency());
        dateLabel.setText("Date: " + exchangeRate.getDate());
        currency1Label.setText(exchangeRate.getSenderCurrency());
        currency1Label.setStyle("-fx-font-weight: bold");
        currency2Label.setText(exchangeRate.getReceiverCurrency());
        currency2Label.setStyle("-fx-font-weight: bold");
    }
}
