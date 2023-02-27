/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.currency.calculatorfxml;

import com.mycompany.calculations.ExchangeRate;
import java.io.IOException;
import java.math.RoundingMode;
import java.net.URL;
import java.text.DecimalFormat;
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.CEILING);
//        textField1.textProperty().addListener((observable, oldValue, newValue) -> {
//            if((Double.parseDouble(textField2.getText()) / exchangeRate.getExchangeRate()) != Double.parseDouble(oldValue)) {
//                try {
//                    textField2.setText(String.valueOf(df.format(Double.parseDouble(newValue) * exchangeRate.getExchangeRate())));
//                } catch (Exception e) {}
//            }
//        });
//        textField2.textProperty().addListener((observable, oldValue, newValue) -> {
//            if((Double.parseDouble(textField1.getText()) * exchangeRate.getExchangeRate()) != Double.parseDouble(oldValue)) {
//                try {
//                    textField1.setText(String.valueOf(df.format(Double.parseDouble(newValue) / exchangeRate.getExchangeRate())));
//                } catch (Exception e) {}
//            }
//        });
        final StringProperty text1 = new SimpleStringProperty(textField1.getText());
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
            // perform whatever action you need...

            // update the text property so the two remain equal:
            try {
            text1.set(df.format(Double.parseDouble(newValue)));
            //textField2.setText(Double.parseDouble(newValue));
            } catch(Exception e) {
                
            }
        }
    }
    });
        final StringProperty text2 = new SimpleStringProperty(textField2.getText());
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
            text2.set(newValue);
        }
    }
    });
    }
    
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
    
    public void setExchangeRate(ExchangeRate exchangeRate) {
        this.exchangeRate = exchangeRate;
        exchangeRateValue.setText("1 " + exchangeRate.getReceiverCurrency() + " = " + exchangeRate.getExchangeRate() + " " + exchangeRate.getSenderCurrency());
        dateLabel.setText("Date: " + exchangeRate.getDate());
    }
}
