package currency;

import java.math.BigDecimal;

/**
 *  Interface states important methods for a single currency pair.
 * @author Sebastian
 */
public interface ExchangeData {
    public String getSenderCurrency();
    public String getReceiverCurrency();
    public BigDecimal getExchangeRate();
    public String getDate();
}
