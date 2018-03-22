package com.example.joseph.converter;

/**
 * Created by Joseph on 16/03/2018.
 */

public class ConvertLength extends Converter{

    public double convert(String unitFrom, String unitTo, double input){
        double output = 0;
        double baseInput = 0;
        unitFrom = unitFrom.toLowerCase();
        unitTo = unitTo.toLowerCase();

        /** Converts unit from to base unit (meter) */
        switch(unitFrom) {
            case "kilometer":
                baseInput = input * 1000;
                break;
            case "meter":
                baseInput = input;
                break;
            case "milimeter":
                baseInput = input * 0.001;
                break;
            case "inch":
                baseInput = input * 0.0254;
                break;
            case "foot":
                baseInput = input * 0.3048;
                break;
            case "mile":
                baseInput = input * 1609.34;
                break;
        }

        /** Converts from base unit (meter) to selected unit*/
        switch(unitTo) {
            case "kilometer":
                output = baseInput * 0.001;
                break;
            case "meter":
                output = baseInput;
                break;
            case "milimeter":
                output = baseInput * 1000;
                break;
            case "inch":
                output = baseInput * 39.3701;
                break;
            case "foot":
                output = baseInput * 3.28084;
                break;
            case "mile":
                output = baseInput * 0.000621371;
                break;
        }

        return output;
    }
}


