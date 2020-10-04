package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class VistaInicialController implements Initializable {
    @FXML private TextField txtUser;
    @FXML private TextField txtPassword;
    @FXML private Button btnValidar;

  /*se inicializan el control de las clases*/
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    private void btmInicio(ActionEvent event) {
        //se da el inicio a una Validacion del unico usuario registrado staticamente
        if(txtUser.getText().equals("admin") && txtPassword.getText().equals("admin")){
            
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/PantallaPrincipal.fxml"));
                //se cargara el formulario FXML
                Parent root = loader.load();
                
                PantallaPrincipalController controlador = loader.getController();
                //inicio del Stage para logearse
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();

            } catch (IOException ex) {
                Logger.getLogger(VistaInicialController.class.getName()).log(Level.SEVERE, null, ex);
            }
        // si no es correcto el usuario no Invalidara al usuario
        }else{
            JOptionPane.showMessageDialog(null, "Advertencia!", "Programacion II", JOptionPane.ERROR_MESSAGE);
        }
    }
 // Accion para cerrar ventana de Login
    public void btmCerrar(ActionEvent actionEvent) {
        System.exit(0);
    }
}