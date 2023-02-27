package com.mycompany.calculations;

/**
 *  Interface states important methods for a single currency pair.
 * @author Sebastian
 */
public interface ExchangeData {
    public String getSenderCurrency();
    public String getReceiverCurrency();
    public double getExchangeRate();
    public String getDate();
}
