/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculations;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *  Class responsible for reading json and saving its important values.
 * @author Sebastian
 */
public class ReadJsonNBP extends ExchangeRateRecord {
//    public enum jsonAddress {
//        PLNGBP("https://api.nbp.pl/api/exchangerates/rates/a/gbp/?format=json"), //temp
//        GBPPLN("https://api.nbp.pl/api/exchangerates/rates/a/gbp/?format=json"); 
//        private final String url;
//        jsonAddress(String url) {
//            this.url = url;
//        }
//        public URL getUrl() throws MalformedURLException {
//            return new URL(url);
//        }
//    }
    private JsonNBPEnum url;
    public ReadJsonNBP(JsonNBPEnum exchangeRate) {
        url = exchangeRate;
    }
    @Override
    public boolean readData() {
        StringBuilder json;
        try (InputStream input = url.getUrl().openStream()) {
        InputStreamReader isr = new InputStreamReader(input);
        BufferedReader reader = new BufferedReader(isr);
        json = new StringBuilder();
        int c;
        while ((c = reader.read()) != -1) {
            json.append((char) c);
        }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
            alert.showAndWait();
            return false;
        }
        setCurrencyPair(json.toString()); //temporary
        //return json.toString();
        return true;
    }
}
