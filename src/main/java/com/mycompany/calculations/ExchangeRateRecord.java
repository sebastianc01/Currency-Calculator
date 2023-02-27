/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculations;

import com.mycompany.exceptions.IncorrectDataException;


/**
 *  Data of the single exchange rate record
 * @author Sebastian
 */
public abstract class ExchangeRateRecord implements ExchangeData {
    private String senderCurrency; // sender currency
    private String receiverCurrency; //receiver currency
    private double exchangeRate; // exchange rate
    private String date; // date

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public void setDate(String date) {
        this.date = date;
    }
    @Override
    public double getExchangeRate() {
        return exchangeRate;
    }
    @Override
    public String getDate() {
        return date;
    }
    
    public void setSenderCurrency(String senderCurrency) {
        this.senderCurrency = senderCurrency;
    }

    public void setReceiverCurrency(String receiverCurrency) {
        this.receiverCurrency = receiverCurrency;
    }
    @Override
    public String getSenderCurrency() {
        return senderCurrency;
    }
    @Override
    public String getReceiverCurrency() {
        return receiverCurrency;
    }
    /*
        Not implemented in ExchangeRateRecord class. 
        Class will be inherited by other classes to implement multiple formats of files (e.g. json, xml) and different sources (e.g. NBP).
    */
    
    public abstract void readData() throws IncorrectDataException;
    public abstract void saveData(String data) throws IncorrectDataException;
}
