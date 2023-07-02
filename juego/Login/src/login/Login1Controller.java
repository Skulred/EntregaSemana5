/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package login;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Jose Luis Rios Leon
 */
public class Login1Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void labCerrar (MouseEvent event) {
    System.exit(0);
    }
    @FXML
    private void labSalir (ActionEvent event) {
    System.exit(0);
    }
    @FXML
     private TextField txtuser;
    @FXML
     private Button btnlogin;
 
    @FXML // metodo para que no se puedan ingresar espacios en blanco en el nombre
    private void eventKey(KeyEvent event){
        Object evt = event.getSource();
        
        if (event.equals(txtuser)){
            if(event.getCharacter().equals(""))
                event.consume();
        }
    }
    @FXML
    private void eventAction(ActionEvent event){
        Object evt = event.getSource();
        if(evt.equals(btnlogin)){
        if (txtuser.getText().isEmpty()){
            String user = txtuser.getText();
        }else {
            JOptionPane.showMessageDialog(null, "Escribe el nombre");
        }
       }
        
    }
}
