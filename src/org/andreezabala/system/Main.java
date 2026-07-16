package org.andreezabala.system;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.andreezabala.view.CalculadoraView;

public class Main extends Application {

    public static void main(String[] args) {
        System.out.println("Hola Mundo");
        launch(args);
    }

    @Override
    public void start(Stage escenarioPrincipal) throws Exception {

        
        
        //vista
        CalculadoraView calculadora = new CalculadoraView();
        Pane raiz = new Pane(calculadora.getView());
        

        Scene escena = new Scene(raiz, 266, 390);

        escenarioPrincipal.setTitle("Calculadora de Andree");
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.show();
    }

}
