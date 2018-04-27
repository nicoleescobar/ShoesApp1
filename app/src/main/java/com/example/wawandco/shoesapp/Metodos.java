package com.example.wawandco.shoesapp;

import android.util.Log;

public class Metodos {
    public static double total (int cant, int marcaVal, int sexoVal, int tipoVal){ //nike adidas puma - clasico zapatilla - hombre mujer
        double total = 0;

        if( sexoVal == 0 ) { //Hombre

            if(tipoVal == 0) { // clasicos
                switch (marcaVal){
                    case 0:
                        total = 120000;
                        break;
                    case 1:
                        total = 140000;
                        break;
                    case 2:
                        total = 130000;
                        break;
                }
            } else {
                switch (marcaVal){
                    case 0:
                        total = 50000;
                        break;
                    case 1:
                        total = 80000;
                        break;
                    case 2:
                        total = 100000;
                        break;
                }
            }

        } else { //Mujer

            if(tipoVal == 0) { // clasicos
                switch (marcaVal) {
                    case 0:
                        total = 100000;
                        break;
                    case 1:
                        total = 130000;
                        break;
                    case 2:
                        total = 110000;
                        break;
                }
            } else {
                switch (marcaVal) {
                    case 0:
                        total = 60000;
                        break;
                    case 1:
                        total = 70000;
                        break;
                    case 2:
                        total = 120000;
                        break;
                }
            }
        }

        total  = total * cant;

        return total;
    }
}
