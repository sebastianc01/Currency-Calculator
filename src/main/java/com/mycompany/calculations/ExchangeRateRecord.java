/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculations;

/**
 *  Class responsible for reading online json and saving its important values.
 * @author Sebastian
 */
public class ExchangeRateRecord implements ExchangeData {
    String currencyPair; // about which currency pair is current record
    double exchangeRate; // exchange rate
    String date; // date
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
    
    
    
}
