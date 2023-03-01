/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package currency;

import com.mycompany.exceptions.IncorrectDataException;

/**
 *  SelectedExchangeRate class has only one static method. 
 *  Method used only to separate a bit class chosen to read data and save it, from the controller.
 * @author Sebastian
 */
final public class SelectedExchangeRate {
    /**
     * 
     * @param choice input string, depending on it specific exchange rate will be selected.
     * @return ExchangeRate object
     * @throws IncorrectDataException created just to avoid throwing many others exceptions. Its message depends on the reason of throwing other exceptions, which simplify the code.
     */
    public static ExchangeRate loadExchangeRate(String choice) throws IncorrectDataException {
        return new ExchangeRate(new ReadJsonNBP(choice));
    }
}
