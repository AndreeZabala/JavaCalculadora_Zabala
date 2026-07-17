package org.andreezabala.controller;

import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class CalculadoraController {

    private String opcion1 = "";
    private String operador = "";
    private String opcion2 = "";
    private boolean calculoTerminado = false;

    public CalculadoraController() {
    }

public void procesoDeEntrada(String entrada, Label pantalla) {
    if (entrada.equals("C")) {
        opcion1 = ""; operador = ""; opcion2 = "";
        calculoTerminado = false;
        pantalla.setText("0");
        return;
    }

    if (entrada.matches("[0-9]")) {
        // CORRECCIÓN: Si el cálculo terminó, el usuario quiere seguir sumando.
        // Mantenemos opcion1 (que es el resultado anterior) y permitimos que 
        // el número presionado se guarde en opcion2.
        if (calculoTerminado) {
            calculoTerminado = false;
            // No reseteamos opcion1, la mantenemos para seguir operando
            opcion2 = entrada; // El primer número de la nueva parte
            operador = ""; // Limpiamos el operador antiguo
        } else {
            if (operador.isEmpty()) {
                opcion1 += entrada;
            } else {
                opcion2 += entrada;
            }
        }
        actualizarPantalla(pantalla);
        
    } else if (entrada.equals("+")) {
        // Si ya hay un resultado y presionan "+", el resultado actual (opcion1)
        // se convierte en la base para la siguiente suma.
        operador = entrada;
        calculoTerminado = false; // Ya no está "terminado", está en proceso
        actualizarPantalla(pantalla);
        
    } else if (entrada.equals("=")) {
        if (!opcion1.isEmpty() && !opcion2.isEmpty() && operador.equals("+")) {
            opcion1 = resultadoSuma(opcion1, opcion2);
            operador = "";
            opcion2 = "";
            calculoTerminado = true;
        }
        actualizarPantalla(pantalla);
    }
}

    private void actualizarPantalla(Label pantalla) {
        // Aseguramos que el Label mantenga su configuración de ancho máximo
        pantalla.setMaxWidth(Double.MAX_VALUE);
        pantalla.setAlignment(Pos.CENTER_RIGHT);

        if (operador.isEmpty()) {
            pantalla.setText(opcion1);
        } else if (opcion2.isEmpty()) {
            pantalla.setText(opcion1 + " " + operador);
        } else {
            pantalla.setText(opcion1 + " " + operador + " " + opcion2);
        }
    }

    private String resultadoSuma(String numeroUno, String numeroDos) {
        String resultado;
        // Usamos .trim() para quitar los espacios antes de convertir
        int datoUno = Integer.parseInt(numeroUno.trim());
        int datoDos = Integer.parseInt(numeroDos.trim());
        int suma = datoUno + datoDos;

        return resultado = String.valueOf(suma);
    }

}
