package com.uttec.calculadora.controller;

import java.awt.event.ActionEvent;

import com.uttec.calculadora.model.CalculadoraModel;
import com.uttec.calculadora.view.CalculadoraView;

//Aqui, el controlador, se encarga de escuchar a la vista y pasar accones al modelo y actualizar la vista

public class CalculadoraController {
    private final CalculadoraModel model;
    private final CalculadoraView view;
    
    //variables para manejar el estado de la calculadora
    private double currentNumber = 0;
    private String currentOperator = "";
    private boolean isNewNumber = true;

    public CalculadoraController(CalculadoraModel model, CalculadoraView view) {
        this.model = model;
        this.view = view;
        addListeners();
    
    }
    private void addListeners(){
        //en esta sección añadimos todos los listeners para todos los bottones numericos
        view.addNumberButtonListener(e -> handleNumber(e));

        //escuchador para los operadores
        view.addOperatorButtonListener(e -> handleOperator(e));

        //escuchador para el boton igual
        view.addEqualsButtonListener(e -> handleEquals());

        //Escuchador para el boton igual
        view.addClearButtonListener(e -> handleClear());

    }
    private void handleNumber (ActionEvent e){
        String digit = e.getActionCommand();
        if (isNewNumber) {
            view.setDisplayText(digit);
            isNewNumber = false;
        } else {
            view.setDisplayText(view.getDisplayText() + digit);
        }
    }
    private void handleOperator(ActionEvent e){
        if (!isNewNumber) {
            // Si ya hay un operador, calcula el resultado parcial
            if (!currentOperator.isEmpty()) {
                handleEquals();
            }
            currentNumber = Double.parseDouble(view.getDisplayText());
            currentOperator = e.getActionCommand();
            isNewNumber = true;
        }
    }
    private void handleEquals(){
        if (!currentOperator.isEmpty()){
            double secondNumber = Double.parseDouble(view.getDisplayText());
            try {
                double result = model.calcular(currentNumber, secondNumber, currentOperator);
                view.setDisplayText(String.valueOf(result));

        }catch (IllegalArgumentException ex) {
            view.setDisplayText("Error: " + ex.getMessage());
        }
            currentOperator = "";
            isNewNumber = true;
        }
    }
        private void handleClear() {
        currentNumber = 0;
        currentOperator = "";
        isNewNumber = true;
        view.setDisplayText("");
    }
}
