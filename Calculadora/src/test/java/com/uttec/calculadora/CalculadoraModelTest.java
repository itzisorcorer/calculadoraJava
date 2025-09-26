package com.uttec.calculadora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.uttec.calculadora.model.CalculadoraModel;

//Pruebas unitarias para la clase CalculadoraModel si k si

public class CalculadoraModelTest {

    private CalculadoraModel model;

    // Esta anotación hace que este método se ejecute ANTES de cada prueba.
    // Así nos aseguramos de tener un modelo "limpio" para cada caso.

    @BeforeEach
    void setUp() {
        model = new CalculadoraModel();
    }

    @Test
    @DisplayName("Prueba de suma 5 + 3 = 8")
    void testSuma() {
        //Arranque: Preparar los datos a sumar:
        double numero1 = 5.0;
        double numero2 = 3.0;
        String operador = "+";

        //Actuar: ejecutar el metodo que queremos probar
        double resultado = model.calcular(numero1, numero2, operador);

        //Afirmar: Comprobar que el resultado es el esperado
        assertEquals(8.0, resultado, "5 + 3 debería ser 8");
    }

    @Test
    @DisplayName("Prueba de resta 10 - 4 = 6")
    void testResta() {
        assertEquals(6.0, model.calcular(10.0, 4.0, "-"), "10 - 4 debería ser 6");
    }
    @Test
    @DisplayName("Prueba de multiplicación 7 * 6 = 42")
    void testMultiplicacion() {
        assertEquals(42.0, model.calcular(7.0, 6.0, "*"), "7 * 6 debería ser 42");
    }
    @Test
    @DisplayName("Prueba de división 20 / 4 = 5")
    void testDivision() {
        assertEquals(5.0, model.calcular(20.0, 4.0, "/"), "20 / 4 debería ser 5");
    }
    @Test
    @DisplayName("Prueba de división por cero")
    void testDivisionPorCero() {
        //Arranque:
        double numero1 = 10.0;
        double numero2 = 0.0;

        //Vamos a verificar que se lance la ecxepcion correcta cuando queremos dividir por 0
        assertThrows(IllegalArgumentException.class, () -> {
            model.calcular(numero1, numero2, "/");
        }, "Debería lanzar IllegalArgumentException al dividir por cero");
    }

}
