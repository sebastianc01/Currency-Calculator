/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package currency;

import com.mycompany.exceptions.IncorrectDataException;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 *  SelectedExchangeRate class has only one static method. 
 *  Method used only to separate a bit class chosen to read data and save it, from the controller.
 * @author Sebastian
 */
final public class SelectedExchangeRate {
    /**
     * 
     * @param choice input string, depending on it specific exchange rate will be selected.
     * @throws IncorrectDataException threw when data was improperly saved
     * @throws NumberFormatException exchange rate saved improperly
     * @throws IOException threw when connection failed
     */
    public static ExchangeRate loadExchangeRate(String choice) throws IncorrectDataException, IOException, NumberFormatException {
        return new ExchangeRate(new ReadJsonNBP(choice));
    }
}
