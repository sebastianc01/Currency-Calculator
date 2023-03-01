/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package currency;

import com.mycompany.exceptions.IncorrectDataException;


/**
 *  Data of the single exchange rate record. Contains get and set methods of the attributes.
 *  It also has two abstract methods readData and saveData.
 *  Class will be inherited by other classes to implement reading multiple formats of files (e.g. json, xml) and different sources (e.g. NBP).
 * @author Sebastian
 */
public abstract class ExchangeRateRecord implements ExchangeData {
    private String senderCurrency; // sender currency
    private String receiverCurrency; // receiver currency
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

    /**
     * Not implemented in ExchangeRateRecord class. 
     * Used to read data from the specific source.
     * @throws IncorrectDataException created just to avoid throwing many others exceptions. Its message depends on the reason of throwing other exceptions, which simplify the code.
     */
    public abstract void readData() throws IncorrectDataException;
    /**
     * Not implemented in ExchangeRateRecord class. 
     * Used to save data from the specific source.
     * @param data string read from the specific source.
     * @throws IncorrectDataException created just to avoid throwing many others exceptions. Its message depends on the reason of throwing other exceptions, which simplify the code.
     */
    public abstract void saveData(String data) throws IncorrectDataException;
}
