package com.uttec.calculadora.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

//Recordar qe aqui, en la vista, va todo la interfaz gráfica, nada de calulos
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculadoraView extends JFrame{
        private JTextField display = new JTextField();
        private JButton[] numberButtons = new JButton[10];
        private JButton addButton = new JButton("+");
        private JButton subtractButton = new JButton("-");
        private JButton multiplyButton = new JButton("*");
        private JButton divideButton = new JButton("/");
        private JButton equalsButton = new JButton("=");
        private JButton clearButton = new JButton("C");

    public CalculadoraView() {
        // --- Configuración de la Ventana Principal (JFrame) ---
        this.setTitle("Calculadora MVC");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 500);
        this.setLayout(new BorderLayout());

        // --- Configuración de la Pantalla de Resultados ---
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 40));
        display.setHorizontalAlignment(JTextField.RIGHT);
        this.add(display, BorderLayout.NORTH);

        // --- Panel para los Botones ---
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10)); // 4x4 grid con espaciado

        // --- Creación de los Botones Numéricos ---
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
        }

        // --- Añadir Botones al Panel en Orden ---
        // Fila 1
        buttonPanel.add(numberButtons[7]);
        buttonPanel.add(numberButtons[8]);
        buttonPanel.add(numberButtons[9]);
        buttonPanel.add(divideButton);
        // Fila 2
        buttonPanel.add(numberButtons[4]);
        buttonPanel.add(numberButtons[5]);
        buttonPanel.add(numberButtons[6]);
        buttonPanel.add(multiplyButton);
        // Fila 3
        buttonPanel.add(numberButtons[1]);
        buttonPanel.add(numberButtons[2]);
        buttonPanel.add(numberButtons[3]);
        buttonPanel.add(subtractButton);
        // Fila 4
        buttonPanel.add(clearButton);
        buttonPanel.add(numberButtons[0]);
        buttonPanel.add(equalsButton);
        buttonPanel.add(addButton);
        
        this.add(buttonPanel, BorderLayout.CENTER);
    }
    
    // --- Métodos para que el Controlador interactúe con la Vista ---

    public String getDisplayText() {
        return display.getText();
    }

    public void setDisplayText(String text) {
        display.setText(text);
    }

    // El controlador usará estos métodos para "escuchar" los clics.
    public void addNumberButtonListener(ActionListener listener) {
        for (int i = 0; i < 10; i++) {
            numberButtons[i].addActionListener(listener);
        }
    }

    public void addOperatorButtonListener(ActionListener listener) {
        addButton.addActionListener(listener);
        subtractButton.addActionListener(listener);
        multiplyButton.addActionListener(listener);
        divideButton.addActionListener(listener);
    }

    public void addEqualsButtonListener(ActionListener listener) {
        equalsButton.addActionListener(listener);
    }

    public void addClearButtonListener(ActionListener listener) {
        clearButton.addActionListener(listener);
    }
}
