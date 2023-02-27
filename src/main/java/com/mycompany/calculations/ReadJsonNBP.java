/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculations;

import com.mycompany.exceptions.IncorrectDataException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *  Class responsible for reading json and saving its important values.
 * @author Sebastian
 */
public final class ReadJsonNBP extends ExchangeRateRecord {
    private JsonNBPEnum url;
    public ReadJsonNBP(String choice) throws IncorrectDataException {
        if(choice.equals("PLN/GBP")) {
            url = JsonNBPEnum.PLNGBP;
        }
        else if(choice.equals("GBP/PLN")) {
            url = JsonNBPEnum.GBPPLN;
        }
        readData();
    }
    
    @Override
    public void readData() throws IncorrectDataException {
        StringBuilder json; //MalformedURLException IOException
        try (InputStream input = url.getUrl().openStream()) {
        InputStreamReader isr = new InputStreamReader(input);
        BufferedReader reader = new BufferedReader(isr);
        json = new StringBuilder();
        int c;
        while ((c = reader.read()) != -1) {
            json.append((char) c);
        }
        } catch (IOException e) {
            throw new IncorrectDataException("Failed to read data from the current selection.");
        }
        saveData(json.toString());
    }
    
    @Override
    public void saveData(String data) throws IncorrectDataException {
        int currencyIndex = data.indexOf("\"code\":\"");
        String currency = data.substring(currencyIndex + "\"code\":\"".length(), data.indexOf("\"", currencyIndex + "\"code\":\"".length()));
        setSenderCurrency(currency);
        setReceiverCurrency("PLN");
        int exchangeRateIndex = data.indexOf("\"mid\":");
        String exchange = data.substring(exchangeRateIndex + "\"mid\":".length(), data.indexOf("}", exchangeRateIndex + "\"mid\":".length()));
        try {
        setExchangeRate(Double.parseDouble(exchange));
        } catch (NumberFormatException e) {
            throw new IncorrectDataException("Cannot continue with a current choice, NBP Json data saved improperly.");
        }
        int dateIndex = data.indexOf("\"effectiveDate\":\"");
        String date = data.substring(dateIndex + "\"effectiveDate\":\"".length(), data.indexOf("\"", dateIndex + "\"effectiveDate\":\"".length()));
        setDate(date);
        if(getSenderCurrency().isBlank() || getSenderCurrency().isEmpty() ||
                getDate().isBlank() || getDate().isEmpty()) {
            
        }
    }
}
