/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculations;

import java.net.URL;

/**
 *  Data of the single exchange rate record
 * @author Sebastian
 */
public abstract class ExchangeRateRecord implements ExchangeData {
    private String currencyPair; // about which currency pair is current record
    private double exchangeRate; // exchange rate
    private String date; // date
    public void setCurrencyPair(String currencyPair) {
        this.currencyPair = currencyPair;
    }
    @Override
    public String getCurrencyPair() {
        return currencyPair;
    }

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
    
    /*
        Not implemented in ExchangeRateRecord class. 
        Class will be inherited by other classes to implement multiple formats of files (e.g. json, xml) and different sources (e.g. NBP).
    */
    
    public abstract boolean readData();
}
