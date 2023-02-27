/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculations;

import com.mycompany.exceptions.IncorrectDataException;

/**
 *
 * @author Sebastian
 */
public class SelectedExchangeRate {
    public static ExchangeRate loadExchangeRate(String choice) throws IncorrectDataException {
        return new ExchangeRate(new ReadJsonNBP(choice));
    }
}
