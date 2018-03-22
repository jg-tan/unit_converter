package com.example.joseph.converter;

/**
 * Created by Joseph on 16/03/2018.
 */

public class ConvertCurrency extends Converter{

    public double convert(String unitFrom, String unitTo, double input){
        double output = 0;
        double baseInput = 0;
        unitFrom = unitFrom.toLowerCase();
        unitTo = unitTo.toLowerCase();

        /** Converts unit from to base unit (USD) */
        switch(unitFrom) {
            case "philippine peso":
                baseInput = input / 52.16;
                break;
            case "us dollar":
                baseInput = input;
                break;
            case "japanese yen":
                baseInput = input / 106.27;
                break;
            case "euro":
                baseInput = input / 0.82;
                break;
            case "south korean won":
                baseInput = input / 1075.27;
                break;
            case "singapore dollar":
                baseInput = input / 1.32;
                break;
        }

        /** Converts from base unit (USD) to selected unit*/
        switch(unitTo) {
            case "philippine peso":
                output = baseInput * 52.16;
                break;
            case "us dollar":
                output = baseInput;
                break;
            case "japanese yen":
                output = baseInput * 106.27;
                break;
            case "euro":
                output = baseInput * 0.82;
                break;
            case "south korean won":
                output = baseInput * 1075.27;
                break;
            case "singapore dollar":
                output = baseInput * 1.32;
                break;
        }

        return output;
    }
}



