/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.calculations;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Sebastian
 */
public enum JsonNBPEnum {
    PLNGBP("https://api.nbp.pl/api/exchangerates/rates/a/gbp/?format=json"), //temp
    GBPPLN("https://api.nbp.pl/api/exchangerates/rates/a/gbp/?format=json"); 
    private final String url;
    JsonNBPEnum(String url) {
        this.url = url;
    }
    public URL getUrl() throws MalformedURLException {
        return new URL(url);
    }
}
