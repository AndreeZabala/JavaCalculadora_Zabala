package org.andreezabala.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.andreezabala.controller.CalculadoraController;

public class CalculadoraView {

    private VBox view;
    private Label pantalla;
    private GridPane cuadroBotones;
    private CalculadoraController controlador;

    public CalculadoraView(CalculadoraController controlador) {
        this.controlador = controlador;

        view = new VBox(15);
        view.setPadding(new Insets(20));
        view.setAlignment(Pos.CENTER);
        // Fondo gris oscuro tipo metal
        view.setStyle("-fx-background-color: #2F3640;");

        pantalla = new Label("0");
        pantalla.setFont(Font.font("Consolas", FontWeight.BOLD, 40));
        pantalla.setMaxWidth(Double.MAX_VALUE);
        pantalla.setAlignment(Pos.CENTER_RIGHT);
        // Pantalla con borde cuadrado
        pantalla.setStyle("-fx-background-color: #DCDDE1; -fx-padding: 10;");

        cuadroBotones = new GridPane();
        cuadroBotones.setHgap(5);
        cuadroBotones.setVgap(5);
        cuadroBotones.setAlignment(Pos.CENTER);

        // --- Botones (Cuadrados) ---
        Button btnClearNum = nuevoBoton("C");
        Button btnPunto = nuevoBoton(".");
        Button btnCero = nuevoBoton("0");
        Button btnDivisor = nuevoBoton("/");
        Button btnSiete = nuevoBoton("7");
        Button btnOcho = nuevoBoton("8");
        Button btnNueve = nuevoBoton("9");
        Button btnMultiplicar = nuevoBoton("*");
        Button btnCuatro = nuevoBoton("4");
        Button btnCinco = nuevoBoton("5");
        Button btnSeis = nuevoBoton("6");
        Button btnMenos = nuevoBoton("-");
        Button btnUno = nuevoBoton("1");
        Button btnDos = nuevoBoton("2");
        Button btnTres = nuevoBoton("3");
        Button btnMas = nuevoBoton("+");
        Button btnPorcentaje = nuevoBoton("%");
        Button btnRaiz = nuevoBoton("√");
        Button btnPotencia = nuevoBoton("^");
        Button btnIgual = nuevoBoton("=");

        // --- Orden reestructurado ---
        cuadroBotones.add(btnRaiz, 0, 0);
        cuadroBotones.add(btnPotencia, 1, 0);
        cuadroBotones.add(btnPorcentaje, 2, 0);
        cuadroBotones.add(btnClearNum, 3, 0);
        cuadroBotones.add(btnSiete, 0, 1);
        cuadroBotones.add(btnOcho, 1, 1);
        cuadroBotones.add(btnNueve, 2, 1);
        cuadroBotones.add(btnDivisor, 3, 1);
        cuadroBotones.add(btnCuatro, 0, 2);
        cuadroBotones.add(btnCinco, 1, 2);
        cuadroBotones.add(btnSeis, 2, 2);
        cuadroBotones.add(btnMultiplicar, 3, 2);
        cuadroBotones.add(btnUno, 0, 3);
        cuadroBotones.add(btnDos, 1, 3);
        cuadroBotones.add(btnTres, 2, 3);
        cuadroBotones.add(btnMenos, 3, 3);
        cuadroBotones.add(btnPunto, 0, 4);
        cuadroBotones.add(btnCero, 1, 4);
        cuadroBotones.add(btnMas, 2, 4);
        cuadroBotones.add(btnIgual, 3, 4);

        view.getChildren().addAll(pantalla, cuadroBotones);
    }

    public VBox getView() {
        return view;
    }

    private Button nuevoBoton(String texto) {
        Button btn = new Button(texto);
        btn.setPrefSize(50, 50);
        btn.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        // Estilo cuadrado: Se eliminó background-radius
        btn.setStyle("-fx-background-color: #7F8C8D; -fx-text-fill: white; -fx-background-radius: 0; -fx-cursor: hand;");

        btn.setOnMousePressed(e -> {
            btn.setStyle("-fx-background-color: #C0392B; -fx-text-fill: white; -fx-background-radius: 0;");
            btn.setTranslateY(2);
        });

        btn.setOnMouseReleased(e -> {
            btn.setStyle("-fx-background-color: #7F8C8D; -fx-text-fill: white; -fx-background-radius: 0;");
            btn.setTranslateY(0);
        });

        btn.setOnAction(e -> controlador.procesoDeEntrada(texto, pantalla));
        return btn;
    }
}
