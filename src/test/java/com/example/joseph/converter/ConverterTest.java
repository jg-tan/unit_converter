package com.example.joseph.converter;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Joseph on 17/03/2018.
 */
public class ConverterTest {
    @Test   //Km to Km
    public void convert() throws Exception {
        double input = 0;
        double output = 0;
        String selUnit1 = "kilometer";
        String selUnit2 = "kilometer";
        double delta = 0.1;
        double expected = 0;
        Converter converter = new Converter();

        for(int i = 0; i < 98; i++){
            switch(i){
                case 0:
                    selUnit1 =  "kilometer";
                    selUnit2 = "kilometer";
                    input = 10000;
                    expected = 10000;
                    break;
                case 1:
                    selUnit1 = "kilometer";
                    selUnit2 = "meter";
                    input = 10000;
                    expected = 10000000;
                    break;
                case 2:
                    selUnit1 = "kilometer";
                    selUnit2 = "milimeter";
                    input = 10;
                    expected = 10000000;
                    break;
                case 3:
                    selUnit1 = "kilometer";
                    selUnit2 = "inch";
                    input = 10;
                    expected = 393701;
                    break;
                case 4:
                    selUnit1 = "kilometer";
                    selUnit2 = "foot";
                    input = 10;
                    expected = 32808.4;
                    break;
                case 5:
                    selUnit1 = "kilometer";
                    selUnit2 = "mile";
                    input = 10;
                    expected = 6.2137;
                    break;
                case 6:
                    selUnit1 = "meter";
                    selUnit2 = "kilometer";
                    input = 10000;
                    expected = 10;
                    break;
                case 7:
                    selUnit1 = "meter";
                    selUnit2 = "meter";
                    input = 10000;
                    expected = 10000;
                    break;
                case 8:
                    selUnit1 = "meter";
                    selUnit2 = "milimeter";
                    input = 10000;
                    expected = 10000000;
                    break;
                case 9:
                    selUnit1 = "meter";
                    selUnit2 = "inch";
                    input = 10;
                    expected = 393.701;
                    break;
                case 10:
                    selUnit1 = "meter";
                    selUnit2 = "foot";
                    input = 10;
                    expected = 32.8084;
                    break;
                case 11:
                    selUnit1 = "meter";
                    selUnit2 = "mile";
                    input = 10000;
                    expected = 6.2137;
                    break;
                case 12:
                    selUnit1 = "milimeter";
                    selUnit2 = "kilometer";
                    input = 10000000;
                    expected = 10;
                    break;
                case 13:
                    selUnit1 = "milimeter";
                    selUnit2 = "meter";
                    input = 10000000;
                    expected = 10000;
                    break;
                case 14:
                    selUnit1 = "milimeter";
                    selUnit2 = "milimeter";
                    input = 10000;
                    expected = 10000;
                    break;
                case 15:
                    selUnit1 = "milimeter";
                    selUnit2 = "inch";
                    input = 10000;
                    expected = 393.701;
                    break;
                case 16:
                    selUnit1 = "milimeter";
                    selUnit2 = "foot";
                    input = 10000;
                    expected = 32.8084;
                    break;
                case 17:
                    selUnit1 = "milimeter";
                    selUnit2 = "mile";
                    input = 10000000;
                    expected = 6.2137;
                    break;
                case 18:
                    selUnit1 =  "inch";
                    selUnit2 = "kilometer";
                    input = 100000;
                    expected = 2.54;
                    break;
                case 19:
                    selUnit1 = "inch";
                    selUnit2 = "meter";
                    input = 100000;
                    expected = 2540;
                    break;
                case 20:
                    selUnit1 = "inch";
                    selUnit2 = "milimeter";
                    input = 100000;
                    expected = 2540000;
                    break;
                case 21:
                    selUnit1 = "inch";
                    selUnit2 = "inch";
                    input = 10;
                    expected = 10;
                    break;
                case 22:
                    selUnit1 = "inch";
                    selUnit2 = "foot";
                    input = 1000000;
                    expected = 83333.3333;
                    break;
                case 23:
                    selUnit1 = "inch";
                    selUnit2 = "mile";
                    input = 100000;
                    expected = 1.578;
                    break;
                case 24:
                    selUnit1 =  "foot";
                    selUnit2 = "kilometer";
                    input = 10000;
                    expected = 3.048;
                    break;
                case 25:
                    selUnit1 = "foot";
                    selUnit2 = "meter";
                    input = 100;
                    expected = 30.48;
                    break;
                case 26:
                    selUnit1 = "foot";
                    selUnit2 = "milimeter";
                    input = 100;
                    expected = 30480;
                    break;
                case 27:
                    selUnit1 = "foot";
                    selUnit2 = "inch";
                    input = 100;
                    expected = 1200;
                    break;
                case 28:
                    selUnit1 = "foot";
                    selUnit2 = "foot";
                    input = 1000;
                    expected = 1000;
                    break;
                case 29:
                    selUnit1 = "foot";
                    selUnit2 = "mile";
                    input = 100000;
                    expected = 18.9393;
                    break;
                case 30:
                    selUnit1 =  "mile";
                    selUnit2 = "kilometer";
                    input = 100;
                    expected = 160.934;
                    break;
                case 31:
                    selUnit1 = "mile";
                    selUnit2 = "meter";
                    input = 10;
                    expected = 16093.4;
                    break;
                case 32:
                    selUnit1 = "mile";
                    selUnit2 = "milimeter";
                    input = 0.1;
                    expected = 160934;
                    break;
                case 33:
                    selUnit1 = "mile";
                    selUnit2 = "inch";
                    input = 0.1;
                    expected = 6336;
                    break;
                case 34:
                    selUnit1 = "mile";
                    selUnit2 = "foot";
                    input = 0.1;
                    expected = 528;
                    break;
                case 35:
                    selUnit1 = "mile";
                    selUnit2 = "mile";
                    input = 10;
                    expected = 10;
                    break;
                case 36:
                    selUnit1 =  "kilogram";
                    selUnit2 = "kilogram";
                    input = 1;
                    expected = 1;
                    break;
                case 37:
                    selUnit1 = "kilogram";
                    selUnit2 = "gram";
                    input = 1;
                    expected = 1000;
                    break;
                case 38:
                    selUnit1 = "kilogram";
                    selUnit2 = "miligram";
                    input = 1;
                    expected = 1000000;
                    break;
                case 39:
                    selUnit1 = "kilogram";
                    selUnit2 = "pound";
                    input = 1;
                    expected = 2.20462;
                    break;
                case 40:
                    selUnit1 = "kilogram";
                    selUnit2 = "ton";
                    input = 10000;
                    expected = 11.0231;
                    break;
                case 41:
                    selUnit1 = "kilogram";
                    selUnit2 = "ounce";
                    input = 1;
                    expected = 35.274;
                    break;
                case 42:
                    selUnit1 =  "gram";
                    selUnit2 = "kilogram";
                    input = 1000;
                    expected = 1;
                    break;
                case 43:
                    selUnit1 = "gram";
                    selUnit2 = "gram";
                    input = 1;
                    expected = 1;
                    break;
                case 44:
                    selUnit1 = "gram";
                    selUnit2 = "miligram";
                    input = 1;
                    expected = 1000;
                    break;
                case 45:
                    selUnit1 = "gram";
                    selUnit2 = "pound";
                    input = 1000;
                    expected = 2.20462;
                    break;
                case 46:
                    selUnit1 = "gram";
                    selUnit2 = "ton";
                    input = 10000000;
                    expected = 11.0231;
                    break;
                case 47:
                    selUnit1 = "gram";
                    selUnit2 = "ounce";
                    input = 1000;
                    expected = 35.274;
                    break;
                case 48:
                    selUnit1 =  "miligram";
                    selUnit2 = "kilogram";
                    input = 1000000;
                    expected = 1;
                    break;
                case 49:
                    selUnit1 = "miligram";
                    selUnit2 = "gram";
                    input = 1000;
                    expected = 1;
                    break;
                case 50:
                    selUnit1 = "miligram";
                    selUnit2 = "miligram";
                    input = 1;
                    expected = 1;
                    break;
                case 51:
                    selUnit1 = "miligram";
                    selUnit2 = "pound";
                    input = 1000000;
                    expected = 2.20462;
                    break;
                case 52:
                    selUnit1 = "miligram";
                    selUnit2 = "ton";
                    input = 100000000;
                    expected = 0.110231;
                    break;
                case 53:
                    selUnit1 = "miligram";
                    selUnit2 = "ounce";
                    input = 1000000;
                    expected = 35.274;
                    break;
                case 54:
                    selUnit1 =  "pound";
                    selUnit2 = "kilogram";
                    input = 1000;
                    expected = 453.592;
                    break;
                case 55:
                    selUnit1 = "pound";
                    selUnit2 = "gram";
                    input = 1;
                    expected = 453.592;
                    break;
                case 56:
                    selUnit1 = "pound";
                    selUnit2 = "miligram";
                    input = 0.1;
                    expected = 45359.2;
                    break;
                case 57:
                    selUnit1 = "pound";
                    selUnit2 = "pound";
                    input = 1;
                    expected = 1;
                    break;
                case 58:
                    selUnit1 = "pound";
                    selUnit2 = "ton";
                    input = 1000;
                    expected = 0.5;
                    break;
                case 59:
                    selUnit1 = "pound";
                    selUnit2 = "ounce";
                    input = 1000;
                    expected = 16000;
                    break;
                case 60:
                    selUnit1 =  "ton";
                    selUnit2 = "kilogram";
                    input = 1;
                    expected = 907.185;
                    break;
                case 61:
                    selUnit1 = "ton";
                    selUnit2 = "gram";
                    input = 1;
                    expected = 907185;
                    break;
                case 62:
                    selUnit1 = "ton";
                    selUnit2 = "miligram";
                    input = 0.001;
                    expected = 907185;
                    break;
                case 63:
                    selUnit1 = "ton";
                    selUnit2 = "pound";
                    input = 1;
                    expected = 2000;
                    break;
                case 64:
                    selUnit1 = "ton";
                    selUnit2 = "ton";
                    input = 1;
                    expected = 1;
                    break;
                case 65:
                    selUnit1 = "ton";
                    selUnit2 = "ounce";
                    input = 1;
                    expected = 32000;
                    break;
                case 67:
                    selUnit1 =  "ounce";
                    selUnit2 = "kilogram";
                    input = 1000;
                    expected = 28.3495;
                    break;
                case 68:
                    selUnit1 = "ounce";
                    selUnit2 = "gram";
                    input = 1;
                    expected = 28.3495;
                    break;
                case 69:
                    selUnit1 = "ounce";
                    selUnit2 = "miligram";
                    input = 1;
                    expected = 28349.5;
                    break;
                case 70:
                    selUnit1 = "ounce";
                    selUnit2 = "pound";
                    input = 100000;
                    expected = 6250;
                    break;
                case 71:
                    selUnit1 = "ounce";
                    selUnit2 = "ton";
                    input = 100000;
                    expected = 3.125;
                    break;
                case 72:
                    selUnit1 = "ounce";
                    selUnit2 = "ounce";
                    input = 1;
                    expected = 1;
                    break;
                case 73:
                    selUnit1 =  "philippine peso";
                    selUnit2 = "philippine peso";
                    input = 1000;
                    expected = 1000;
                    break;
                case 74:
                    selUnit1 = "philippine peso";
                    selUnit2 = "us dollar";
                    input = 1000;
                    expected = 19.23;
                    break;
                case 75:
                    selUnit1 = "philippine peso";
                    selUnit2 = "japanese yen";
                    input = 1000;
                    expected = 2037.385;
                    break;
                case 76:
                    selUnit1 = "philippine peso";
                    selUnit2 = "euro";
                    input = 1000;
                    expected = 15.7208;
                    break;
                case 77:
                    selUnit1 = "philippine peso";
                    selUnit2 = "south korean won";
                    input = 1000;
                    expected = 20614.839;
                    break;
                case 78:
                    selUnit1 =  "us dollar";
                    selUnit2 = "philippine peso";
                    input = 1000;
                    expected = 52160;
                    break;
                case 79:
                    selUnit1 = "us dollar";
                    selUnit2 = "us dollar";
                    input = 1000;
                    expected = 1000;
                    break;
                case 80:
                    selUnit1 = "us dollar";
                    selUnit2 = "japanese yen";
                    input = 1000;
                    expected = 106270;
                    break;
                case 81:
                    selUnit1 = "us dollar";
                    selUnit2 = "euro";
                    input = 1000;
                    expected = 820;
                    break;
                case 82:
                    selUnit1 = "us dollar";
                    selUnit2 = "south korean won";
                    input = 1000;
                    expected = 1075270;
                    break;
                case 83:
                    selUnit1 =  "japanese yen";
                    selUnit2 = "philippine peso";
                    input = 1000;
                    expected = 490.8252;
                    break;
                case 84:
                    selUnit1 = "japanese yen";
                    selUnit2 = "us dollar";
                    input = 1000;
                    expected = 9.44;
                    break;
                case 85:
                    selUnit1 = "japanese yen";
                    selUnit2 = "japanese yen";
                    input = 1000;
                    expected = 1000;
                    break;
                case 86:
                    selUnit1 = "japanese yen";
                    selUnit2 = "euro";
                    input = 1000;
                    expected = 7.6681;
                    break;
                case 87:
                    selUnit1 = "japanese yen";
                    selUnit2 = "south korean won";
                    input = 1000;
                    expected = 10118.2836;
                    break;
                case 88:
                    selUnit1 =  "euro";
                    selUnit2 = "philippine peso";
                    input = 1000;
                    expected = 63609.756;
                    break;
                case 89:
                    selUnit1 = "euro";
                    selUnit2 = "us dollar";
                    input = 1000;
                    expected = 1219.5122;
                    break;
                case 90:
                    selUnit1 = "euro";
                    selUnit2 = "japanese yen";
                    input = 1000;
                    expected = 129597.5609;
                    break;
                case 91:
                    selUnit1 = "euro";
                    selUnit2 = "euro";
                    input = 1000;
                    expected = 1000;
                    break;
                case 92:
                    selUnit1 = "euro";
                    selUnit2 = "south korean won";
                    input = 1000;
                    expected = 1311304.87804;
                    break;
                case 93:
                    selUnit1 =  "south korean won";
                    selUnit2 = "philippine peso";
                    input = 1000;
                    expected = 48.5087;
                    break;
                case 94:
                    selUnit1 = "south korean won";
                    selUnit2 = "us dollar";
                    input = 1000;
                    expected = 0.94;
                    break;
                case 95:
                    selUnit1 = "south korean won";
                    selUnit2 = "japanese yen";
                    input = 1000;
                    expected = 98.83099;
                    break;
                case 96:
                    selUnit1 = "south korean won";
                    selUnit2 = "euro";
                    input = 1000;
                    expected = 0.7605;
                    break;
                case 97:
                    selUnit1 = "south korean won";
                    selUnit2 = "south korean won";
                    input = 1000;
                    expected = 1000;
                    break;
            }
            output = converter.convert(selUnit1, selUnit2, input);

            if(output <= expected - delta || output >= expected + delta){
                System.out.println(i + " " + selUnit1 + " " + selUnit2);
            }

            assertEquals(expected, output, delta);

        }

    }
}