/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.calculations;

import java.math.BigDecimal;

/**
 *  TextFieldNumber enum, allows to perform different operation depending on the enum type.
 * @author Sebastian
 */
public enum TextFieldNumber {
        firstTextField {
            @Override
            public BigDecimal calculate(BigDecimal value, BigDecimal exchangeRate) throws ArithmeticException {
                if(exchangeRate == BigDecimal.ZERO) 
                    throw new ArithmeticException();
                return value.divide(exchangeRate);
            }
        },
        secondTextField {
            @Override
            public BigDecimal calculate(BigDecimal value, BigDecimal exchangeRate) throws ArithmeticException {
                return value.multiply(exchangeRate);
            }
        };
        /**
         * Abstract method, its implementation depends on the selected enum type.
         * @param value BigDecimal value
         * @param exchangeRate BigDecimal value
         * @return BigDecimal result
         * @throws ArithmeticException exception thrown, for example, when dividing by zero
         */
        public abstract BigDecimal calculate(BigDecimal value, BigDecimal exchangeRate) throws ArithmeticException;
}
