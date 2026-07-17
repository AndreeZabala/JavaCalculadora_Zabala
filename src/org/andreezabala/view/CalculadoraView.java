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
        view.setStyle("-fx-background-color: #32DC62;");

        // Pantalla
        pantalla = new Label("0");
        pantalla.setFont(Font.font("Consolas", FontWeight.BOLD, 40));
        pantalla.setMaxWidth(Double.MAX_VALUE);
        pantalla.setAlignment(Pos.CENTER_RIGHT);
        pantalla.setStyle(
                "-fx-background-color:white;"
                + "-fx-padding:10;"
                + "-fx-background-radius:8;"
        );


        cuadroBotones = new GridPane();
        cuadroBotones.setAlignment(Pos.CENTER);
        cuadroBotones.setHgap(12);
        cuadroBotones.setVgap(12);



        Button btnClear = nuevoBoton("C");
        Button btnClearAll = nuevoBoton("CA");
        Button btnPunto = nuevoBoton(".");
        Button btnDividir = nuevoBoton("/");

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

        Button btnCero = nuevoBoton("0");
        Button btnIgual = nuevoBoton("=");

        // Fila 0
        cuadroBotones.add(btnClear, 0, 0);
        cuadroBotones.add(btnClearAll, 1, 0);
        cuadroBotones.add(btnPunto, 2, 0);
        cuadroBotones.add(btnDividir, 3, 0);

        // Fila 1
        cuadroBotones.add(btnSiete, 0, 1);
        cuadroBotones.add(btnOcho, 1, 1);
        cuadroBotones.add(btnNueve, 2, 1);
        cuadroBotones.add(btnMultiplicar, 3, 1);

        // Fila 2
        cuadroBotones.add(btnCuatro, 0, 2);
        cuadroBotones.add(btnCinco, 1, 2);
        cuadroBotones.add(btnSeis, 2, 2);
        cuadroBotones.add(btnMenos, 3, 2);

        // Fila 3
        cuadroBotones.add(btnUno, 0, 3);
        cuadroBotones.add(btnDos, 1, 3);
        cuadroBotones.add(btnTres, 2, 3);
        cuadroBotones.add(btnMas, 3, 3);

        // Fila 4
        cuadroBotones.add(btnCero, 1, 4);
        cuadroBotones.add(btnIgual, 3, 4);

        view.getChildren().addAll(pantalla, cuadroBotones);
    }

    public VBox getView() {
        return view;
    }

    private Button nuevoBoton(String texto) {

        Button btn = new Button(texto);

        btn.setPrefSize(47.5, 47.5);

        btn.setFont(Font.font("Consolas", FontWeight.BOLD, 20));

        btn.setStyle(
                "-fx-background-color:#6B8E23;"
                + "-fx-text-fill:white;"
                + "-fx-background-radius:8;"
                + "-fx-cursor:hand;"
        );

        btn.setOnMousePressed(e -> {
            btn.setTranslateY(2);
            btn.setStyle(
                    "-fx-background-color:#388E3C;"
                    + "-fx-text-fill:white;"
                    + "-fx-background-radius:8;"
            );
        });

        btn.setOnMouseReleased(e -> {
            btn.setTranslateY(0);
            btn.setStyle(
                    "-fx-background-color:#6B8E23;"
                    + "-fx-text-fill:white;"
                    + "-fx-background-radius:8;"
            );
        });

        btn.setOnAction(e -> controlador.procesoDeEntrada(texto, pantalla));

        return btn;
    }
}
