/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.calculations;

/**
 *  TextFieldNumber enum, allows to perform different operation depending on the enum type.
 * @author Sebastian
 */
public enum TextFieldNumber {
        firstTextField {
            @Override
            public double calculate(double value, double exchangeRate) throws ArithmeticException {
                if(exchangeRate == 0) 
                    throw new ArithmeticException();
                return value / exchangeRate;
            }
        },
        secondTextField {
            @Override
            public double calculate(double value, double exchangeRate) throws ArithmeticException {
                return value * exchangeRate;
            }
        };
        /**
         * Abstract method, its implementation depends on the selected enum type.
         * @param value double value
         * @param exchangeRate double value
         * @return double result
         * @throws ArithmeticException exception thrown, for example, when dividing by zero
         */
        public abstract double calculate(double value, double exchangeRate) throws ArithmeticException;
}
