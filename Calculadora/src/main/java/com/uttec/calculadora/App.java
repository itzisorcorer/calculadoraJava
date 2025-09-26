package com.uttec.calculadora;

import javax.swing.SwingUtilities;

import com.uttec.calculadora.controller.CalculadoraController;
import com.uttec.calculadora.model.CalculadoraModel;
import com.uttec.calculadora.view.CalculadoraView;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> {
            //crear el modelo:
            CalculadoraModel model = new CalculadoraModel();
            
            //crear la vista
            CalculadoraView view = new CalculadoraView();

            // crear el controlador y pasarle el modelo y la vistaa
            new CalculadoraController(model, view);

            //hacer viisible la ventana
            view.setVisible(true);
        });
    }
}
