/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculations;

/**
 *
 * @author Sebastian
 */
public class ExchangeRate {
    private ExchangeRateRecord exchangeRateRecord;
    public ExchangeRate(ExchangeRateRecord exchangeRateRecord) {
        this.exchangeRateRecord = exchangeRateRecord;
    }
    public ExchangeRateRecord getExchangeRateRecord() {
        return exchangeRateRecord;
    }
    public String getSenderCurrency() {
        return exchangeRateRecord.getSenderCurrency();
    }
    public String getReceiverCurrency() {
        return exchangeRateRecord.getReceiverCurrency();
    }
    public double getExchangeRate() {
        return exchangeRateRecord.getExchangeRate();
    }
    public String getDate() {
        return exchangeRateRecord.getDate();
    }
}
