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
    

    public CalculadoraView() {
        view = new VBox(15);
        view.setPadding(new Insets(15));
        view.setAlignment(Pos.CENTER);
        view.setStyle("-fx-background-color: #32DC62;");

        pantalla = new Label("0");
        pantalla.setFont(Font.font("Consolas", FontWeight.BOLD, 40));
        pantalla.setAlignment(Pos.CENTER_RIGHT);
        pantalla.setPrefSize(235, 50);

        cuadroBotones = new GridPane();
        cuadroBotones.setHgap(12);
        cuadroBotones.setVgap(12);
        cuadroBotones.setAlignment(Pos.CENTER);

        // --- Configuración de Botones usando nuevoBoton ---
        
        // Fila 1
        Button btnSiete = nuevoBoton("7");
        Button btnOcho = nuevoBoton("8");
        Button btnNueve = nuevoBoton("9");
        Button btnMultiplicar = nuevoBoton("X");

        // Fila 2
        Button btnCuatro = nuevoBoton("4");
        Button btnCinco = nuevoBoton("5");
        Button btnSeis = nuevoBoton("6");
        Button btnMenos = nuevoBoton("-");

        // Fila 3
        Button btnUno = nuevoBoton("1");
        btnUno.setOnAction(e -> controlador.procesoDeEntrada(btnUno.getText(), pantalla));
        Button btnDos = nuevoBoton("2");
        Button btnTres = nuevoBoton("3");
        Button btnMas = nuevoBoton("+");

        // Agregar al grid
        cuadroBotones.add(btnSiete, 0, 1);
        cuadroBotones.add(btnOcho, 1, 1);
        cuadroBotones.add(btnNueve, 2, 1);
        cuadroBotones.add(btnMultiplicar, 3, 1);

        cuadroBotones.add(btnCuatro, 0, 2);
        cuadroBotones.add(btnCinco, 1, 2);
        cuadroBotones.add(btnSeis, 2, 2);
        cuadroBotones.add(btnMenos, 3, 2);

        cuadroBotones.add(btnUno, 0, 3);
        cuadroBotones.add(btnDos, 1, 3);
        cuadroBotones.add(btnTres, 2, 3);
        cuadroBotones.add(btnMas, 3, 3);

        view.getChildren().addAll(pantalla, cuadroBotones);
    }

    public VBox getView() {
        return view;
    }

    private Button nuevoBoton(String texto) {
        Button btn = new Button(texto);
        btn.setPrefSize(50, 50);
        btn.setFont(Font.font("Consolas", FontWeight.NORMAL, 20)); // Asegura que tengan la fuente correcta
        btn.setStyle("-fx-background-color: #6B8E23; -fx-text-fill:white; -fx-background-radius:5px; -fx-cursor: hand;");

        btn.setOnMousePressed(e -> {
            btn.setStyle("-fx-background-color: #388E3C; -fx-text-fill:white; -fx-background-radius:5px;");
            btn.setTranslateY(2);
        });
        btn.setOnMouseReleased(e -> {
            btn.setStyle("-fx-background-color: #6B8E23; -fx-text-fill:white; -fx-background-radius:5px;");
            btn.setTranslateY(0);
        });
        btn.setOnAction(e -> controlador.procesoDeEntrada(texto, pantalla));
        return btn;
    }
}
