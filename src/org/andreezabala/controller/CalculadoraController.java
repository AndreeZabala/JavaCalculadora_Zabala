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
            opcion1 = "";
            operador = "";
            opcion2 = "";
            calculoTerminado = false;
            pantalla.setText("0");
            return;
        }

        // Números
        if (entrada.matches("[0-9]")) {

            if (calculoTerminado) {
                calculoTerminado = false;
                opcion1 = entrada;
                opcion2 = "";
            } else {

                if (operador.isEmpty()) {
                    opcion1 += entrada;
                } else {
                    opcion2 += entrada;
                }
            }

            actualizarPantalla(pantalla);

            // Operadores
        } else if (entrada.equals("+")
                || entrada.equals("-")
                || entrada.equals("*")
                || entrada.equals("/")
                || entrada.equals("^")) {
            operador = entrada;
            calculoTerminado = false;

            actualizarPantalla(pantalla);

            // Raíz cuadrada
        } else if (entrada.equals("√")) {

            if (!opcion1.isEmpty()) {

                opcion1 = resultadoRaiz(opcion1);
                operador = "";
                opcion2 = "";
                calculoTerminado = true;
            }

            actualizarPantalla(pantalla);

            // Igual
        } else if (entrada.equals("=")) {

            if (!opcion1.isEmpty() && !opcion2.isEmpty()) {

                if (operador.equals("+")) {
                    opcion1 = resultadoSuma(opcion1, opcion2);

                } else if (operador.equals("-")) {
                    opcion1 = resultadoResta(opcion1, opcion2);

                } else if (operador.equals("*")) {
                    opcion1 = resultadoMultiplicacion(opcion1, opcion2);

                } else if (operador.equals("/")) {
                    opcion1 = resultadoDivision(opcion1, opcion2);

                } else if (operador.equals("^")) {
                    opcion1 = resultadoPotencia(opcion1, opcion2);
                }

                operador = "";
                opcion2 = "";
                calculoTerminado = true;
            }

            actualizarPantalla(pantalla);
        }
    }

    private void actualizarPantalla(Label pantalla) {

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

        int datoUno = Integer.parseInt(numeroUno.trim());
        int datoDos = Integer.parseInt(numeroDos.trim());

        return String.valueOf(datoUno + datoDos);
    }

    private String resultadoResta(String numeroUno, String numeroDos) {

        int datoUno = Integer.parseInt(numeroUno.trim());
        int datoDos = Integer.parseInt(numeroDos.trim());

        return String.valueOf(datoUno - datoDos);
    }

    private String resultadoMultiplicacion(String numeroUno, String numeroDos) {

        int datoUno = Integer.parseInt(numeroUno.trim());
        int datoDos = Integer.parseInt(numeroDos.trim());

        return String.valueOf(datoUno * datoDos);
    }

    private String resultadoDivision(String numeroUno, String numeroDos) {

        int datoUno = Integer.parseInt(numeroUno.trim());
        int datoDos = Integer.parseInt(numeroDos.trim());

        if (datoDos == 0) {
            return "Error";
        }

        return String.valueOf(datoUno / datoDos);
    }

    // Método para raíz cuadrada
    private String resultadoRaiz(String numero) {

        double valor = Double.parseDouble(numero.trim());

        if (valor < 0) {
            return "Error";
        }

        double raiz = Math.sqrt(valor);

        return String.valueOf(raiz);
    }

    // Método para potencia
    private String resultadoPotencia(String base, String exponente) {

        double datoBase = Double.parseDouble(base.trim());
        double datoExponente = Double.parseDouble(exponente.trim());

        double resultado = Math.pow(datoBase, datoExponente);

        return String.valueOf(resultado);
    }
}
