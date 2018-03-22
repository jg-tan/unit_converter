package com.example.joseph.converter;

/**
 * Created by Joseph on 16/03/2018.
 */

public class ConvertWeight extends Converter{

    public double convert(String unitFrom, String unitTo, double input){
        double output = 0;
        double baseInput = 0;
        unitFrom = unitFrom.toLowerCase();
        unitTo = unitTo.toLowerCase();

        /** Converts unit from to base unit (gram) */
        switch(unitFrom) {
            case "kilogram":
                baseInput = input * 1000;
                break;
            case "gram":
                baseInput = input;
                break;
            case "miligram":
                baseInput = input * 0.001;
                break;
            case "pound":
                baseInput = input * 453.592;
                break;
            case "ton":
                baseInput = input * 907185;
                break;
            case "ounce":
                baseInput = input * 28.3495;
                break;
        }

        /** Converts from base unit (gram) to selected unit*/
        switch(unitTo) {
            case "kilogram":
                output = baseInput * 0.001;
                break;
            case "gram":
                output = baseInput;
                break;
            case "miligram":
                output = baseInput * 1000;
                break;
            case "pound":
                output = baseInput * 0.00220462;
                break;
            case "ton":
                output = baseInput * 1.1023e-6;
                break;
            case "ounce":
                output = baseInput * 0.035274;
                break;
        }

        return output;
    }

}


