/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package currency;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *  JsonNBPEnum, contains a few exchange rates and links to them from the NBP website.
 * @author Sebastian
 */
public enum JsonNBPEnum {
    CHFPLN("https://api.nbp.pl/api/exchangerates/rates/a/chf/?format=json"),
    GBPPLN("https://api.nbp.pl/api/exchangerates/rates/a/gbp/?format=json"),
    USDPLN("https://api.nbp.pl/api/exchangerates/rates/a/usd/?format=json"),
    EURPLN("https://api.nbp.pl/api/exchangerates/rates/a/eur/?format=json"),
    CZKPLN("https://api.nbp.pl/api/exchangerates/rates/a/czk/?format=json"),
    NOKPLN("https://api.nbp.pl/api/exchangerates/rates/a/nok/?format=json"); 
    private final String url;
    /**
     * Constructor
     * @param url input string, depending on its value type of enum is chosen.
     */
    JsonNBPEnum(String url) {
        this.url = url;
    }
    
    /**
     * Get method.
     * @return link to wanted exchange rate
     * @throws MalformedURLException an error is thrown in case of no legal protocol found or when string could not be parsed.
     */
    public URL getUrl() throws MalformedURLException {
        return new URL(url);
    }
}
