package com.uttec.calculadora.model;

//Recordemos que el modelo es el cerebro, , aui no debe haber codigo de interfaz, pura logica

public class CalculadoraModel {
    public double calcular(double numero1, double numero2, String operador){
        switch (operador) {
            case "+":
                return numero1 + numero2;
            case "-":
                return numero1 - numero2;
            case "*":
                return numero1 * numero2;
            case "/":
                if (numero2 == 0 || numero1 == 0) {
                    throw new IllegalArgumentException("No se puede dividir entre cero");
                }
                return numero1 / numero2;
            default:
                throw new IllegalArgumentException("Operador no valido");
            }


    }
}
