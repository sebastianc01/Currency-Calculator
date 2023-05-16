/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculations;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * CalculateValues class. It has one attribute - TextFieldNumber enum. 
 * Depending on the chosen enum's value different calculations will be performed.
 * Methods of this class are preparing value of the string, round out it and check its correctness.
 * @author Sebastian
 */
final public class CalculateValues {
    /**
     * Depending on the chosen enum's value different calculations will be performed.
     */
    private TextFieldNumber textFieldNumber;
    
    /**
     * Constructor, sets enum's value.
     * @param textFieldNumber enum type
     */
    public CalculateValues(TextFieldNumber textFieldNumber) {
        this.textFieldNumber = textFieldNumber;
    }
    
    /**
     * Method checks the correctness of the input string and then call method, which calculates the output string.
     * In case of errors or inappropriate input returns empty string.
     * @param value input string, converted to double
     * @param exchangeRate exchange rate, used in calculations
     * @return output string (converted from double). When input is incorrect then just empty string.
     */
    public String calculateValue(String value, BigDecimal exchangeRate) {
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.CEILING);
        String result;
        try {
            if(value.length() <= 16 && df.format(textFieldNumber.calculate(new BigDecimal(value), exchangeRate)).length() < 16) {
                result = df.format(textFieldNumber.calculate(new BigDecimal(value), exchangeRate));
            }
            else {
                result = "";
            }
            } catch(Exception e) {
                result = "";
            }
        return result;
    }
    
    /**
     * Static method, in fact independent from the rest of the class. Used to change all points (',') to dots ('.').
     * @param string input string
     * @return output string
     */
    static public String transformPointsToDots(String string) {
        if(string == null || string.isEmpty() || string.isBlank()) return ""; //when passed string is empty or blank, then return an empty string 
        int index = string.indexOf(",");
        while(index != -1) {
            string = string.substring(0, index) + "." + string.substring(index + 1, string.length());
            index = string.indexOf(",");
        }
        return string;
    }
}
