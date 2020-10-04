/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Cliente;
import modelo.DataSistema;
import modelo.Individual;
import modelo.Producto;

/**
 * FXML Controller class
 *
 * @author famil
 */
public class CambiosIndividualesController implements Initializable {


    @FXML
    private TextField txtCantidad;
    @FXML
    private TextField txtIdCliente;
    @FXML
    private TextField txtIdProducto;
    @FXML
    private Button btnCrear;
    @FXML
    private TableView tableOrdenes;
    @FXML
    private TableColumn<?, ?> colCliente;
    @FXML
    private TableColumn<?, ?> colProducto;
    @FXML
    private TableColumn<?, ?> colCantidad;
    
    private ObservableList<Individual> individuales;
    
    private ObservableList<Producto> prod;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        individuales = FXCollections.observableArrayList();
        prod = FXCollections.observableArrayList();
        
                this.colCliente.setCellValueFactory(new PropertyValueFactory("nombre"));
                this.colProducto.setCellValueFactory(new PropertyValueFactory("producto"));
                this.colCantidad.setCellValueFactory(new PropertyValueFactory("cantidad"));
    }

    @FXML
    private void crearorden(ActionEvent event) {
        DataSistema orden = new DataSistema();
        
        int cliente = Integer.parseInt(this.txtIdCliente.getText());
        int cantidad = Integer.parseInt(this.txtCantidad.getText());
        int producto = Integer.parseInt(this.txtIdProducto.getText());
        
        if(orden.todos.contains(cliente)&&orden.productos.contains(producto)){
            for(int i = 0;i<orden.todos.size();i++){
            orden.todos.get(i);
            this.tableOrdenes.setItems(individuales);
                for(int s = 0;s<orden.productos.size();s++){
                    orden.productos.get(producto);
                    this.tableOrdenes.setItems(prod);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText("Producto añadido ");
            alert.showAndWait();
                }
            }
            }
        else{
                        
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("El producto ya existe");
            alert.showAndWait();
                        }
            }
}