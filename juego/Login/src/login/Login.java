/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package login;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;

/**
 *
 * @author Jose Luis Rios Leon
 */

public class Login extends Application {
        // metodo para hacer que la ventana siempre tenga el mismo tamaño y no se pueda usar
        private double xMov = 0;
        private double yMov = 0;
    @Override
    public void start(Stage primaryStage) {
   Parent root = null;
   
   
        try {
            root = FXMLLoader.load(getClass().getResource("Login1.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        Scene escena = new Scene(root);
        primaryStage.setScene(escena);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
        primaryStage.setTitle("Bienvenido a SafarySound");
       
               
        
        // aqui se aplican las variables para que no pueda agrandar la pantalla
        root.setOnMousePressed((MouseEvent event) -> {
            xMov = event.getSceneX();
            yMov = event.getSceneY();
        });
        // Hacer que se pueda mover la ventana con el mouse
      root.setOnMouseDragged((MouseEvent event) -> {
          primaryStage.setX(event.getSceneX() - xMov);
          primaryStage.setY(event.getSceneY() - yMov);
      });
        
    }
    
    

   
    public static void main(String[] args) {
        launch(args);
    }

}
