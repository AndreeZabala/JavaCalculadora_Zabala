/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.andreezabala.system;

/**
 *
 * @author informatica
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage escenarioPrincipal) {

        VBox raiz = new VBox();

        Scene escena = new Scene(raiz, 400, 300);

        escenarioPrincipal.setTitle("JavaCalculadorafx_Zabala");
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.show();
    }
}
