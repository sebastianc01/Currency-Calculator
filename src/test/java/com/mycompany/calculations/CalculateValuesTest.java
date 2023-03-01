/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.calculations;

import static com.mycompany.calculations.CalculateValues.transformPointsToDots;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author Sebastian
 */
public class CalculateValuesTest {
    
    
    @ParameterizedTest
    @CsvSource(value={":1:", " :1:", "2.0:2.0:1", "12.5:0.5:25", "0:1.0:0", "2.0:0:"}, delimiter=':')
    public void testCalculateValueFirstTextField(String input, double exchangeRate, String expected) {
        String string = "asd";
        try {
        CalculateValues calc = new CalculateValues(TextFieldNumber.firstTextField);
        string = calc.calculateValue(input, exchangeRate);
        } catch (Exception e) {
            fail(e.getMessage());
        }
        if(expected == null) 
            expected = "";
        assertEquals(expected, string);
    }

    @ParameterizedTest
    @CsvSource(value={":1:", " :1:", "2.0:2.0:4", "12.5:0.5:6.25", "0:1.0:0", "2.0:0:0"}, delimiter=':')
    public void testCalculateValueSecondTextField(String input, double exchangeRate, String expected) {
        String string = "asd";
        try {
        CalculateValues calc = new CalculateValues(TextFieldNumber.secondTextField);
        string = calc.calculateValue(input, exchangeRate);
        } catch (Exception e) {
            fail(e.getMessage());
        }
        if(expected == null) 
            expected = "";
        assertEquals(expected, string);
    }
    
    /**
     * Test of transformPointsToDots method, of class CalculateValues.
     * @param input input data
     * @param expected expected data
     */
    @ParameterizedTest
    @CsvSource(value={":", ".:.", ",:.", ",,a,,gghj,,,:..a..gghj...", " asd, a: asd. a", " : "}, delimiter=':')
    public void testTransformPointsToDots(String input, String expected) {
        String a = transformPointsToDots(input);
        if(expected == null) 
            expected = "";
        assertEquals(expected, a);
    }
    
}
