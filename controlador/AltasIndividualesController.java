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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import modelo.Cliente;
import modelo.DataSistema;
import modelo.Empresa;
import modelo.Individual;

public class AltasIndividualesController implements Initializable {

    @FXML
    private TextField txtNombres;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtDPI;
    @FXML
    private Button btnAgregarPersona;
    
    @FXML
    private TableView<Individual> tableInformacion;
    @FXML
    private TableColumn colNombres;
    @FXML
    private TableColumn colApellidos;
    @FXML
    private TableColumn colTelefono;
    @FXML
    private TableColumn colDPI;
    
    private ObservableList<Individual> individuales;
    @FXML
    private Button btnCambiosCliente;
    @FXML
    private Button btnEliminarCliente;
    @FXML
    private TextField txtTipo;
    @FXML
    private TextField txtContacto;
    @FXML
    private TextField txtDescuento;
    @FXML
    private TableColumn<?, ?> colID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        individuales = FXCollections.observableArrayList();
        
        
        this.colNombres.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colApellidos.setCellValueFactory(new PropertyValueFactory("apellido"));
        this.colTelefono.setCellValueFactory(new PropertyValueFactory("telefono"));
        this.colDPI.setCellValueFactory(new PropertyValueFactory("dpi"));
        this.colID.setCellValueFactory(new PropertyValueFactory("id"));

        
                Individual c1 = new Individual("Josue", "Albizures", 21212, "1213123");
                this.individuales.add(c1);
                this.tableInformacion.setItems(individuales);
                
                Individual c2 = new Individual("Pedro", "Ramirez", 11124322, "1222345");
                this.individuales.add(c2);
                this.tableInformacion.setItems(individuales);
                
                Individual c3 = new Individual("Jose", "Perez", 3121434, "2332454233");
                this.individuales.add(c3);
                this.tableInformacion.setItems(individuales);
                
                Individual c4 = new Individual("Jose", "Perez", 5245345, "2332454233");
                this.individuales.add(c4);
                this.tableInformacion.setItems(individuales);
                                
            DataSistema s = new DataSistema();
            s.todos.add(c1);
            s.todos.add(c2);
            s.todos.add(c3);
            s.todos.add(c4);
            
    }    

    @FXML
    private void AgregarPersona(ActionEvent event) {
        try{
            
        String nombres = this.txtNombres.getText();
        String apellidos = this.txtApellidos.getText();
        int telefono = Integer.parseInt(this.txtTelefono.getText());
        String dpi = this.txtDPI.getText();
        
        Individual i = new Individual(nombres, apellidos, telefono, dpi);
        
        if(!this.individuales.contains(i)){
            
            this.individuales.add(i);
            this.tableInformacion.setItems(individuales);
            
            DataSistema s = new DataSistema();
            s.todos.add(i);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText(i.toString());
            alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("La persona ya existe");
            alert.showAndWait();
        }
             
    }catch(NumberFormatException e){
        Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato incorrecto");
            alert.showAndWait();
    }
    
    }

    @FXML
    private void eliminarCliente(ActionEvent event) {
        Individual i = this.tableInformacion.getSelectionModel().getSelectedItem();
        
        if(i == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debe seleccionar una persona");
            alert.showAndWait();
        }else{
            
            this.individuales.remove(i);
            this.tableInformacion.refresh();
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText("Cliente Eliminado");
            alert.showAndWait();
            
            DataSistema s = new DataSistema();
            s.todos.remove(s);
        }
        
    }

    @FXML
    private void modificarCliente(ActionEvent event) {
        Individual i = this.tableInformacion.getSelectionModel().getSelectedItem();
        
        if(i == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debe seleccionar una persona");
            alert.showAndWait();
        }else{
            try{
            
        String nombres = this.txtNombres.getText();
        String apellidos = this.txtApellidos.getText();
        int telefono = Integer.parseInt(this.txtTelefono.getText());
        String dpi = this.txtDPI.getText();
        
        Individual aux = new Individual(nombres, apellidos, telefono, dpi);
        
        if(!this.individuales.contains(aux)){
            
            i.setNombre(aux.getNombre());
            i.setApellido(aux.getApellido());
            i.setTelefono(aux.getTelefono());
            i.setDpi(aux.getDpi());
            
            this.tableInformacion.refresh();
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText("Cliente Modificado");
            alert.showAndWait();
                       
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("La persona ya existe");
            alert.showAndWait();
        }
             
    }catch(NumberFormatException e){
        Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato incorrecto");
            alert.showAndWait();
    }
        }
    }

    @FXML
    private void seleccionar(MouseEvent event) {
        Individual i = this.tableInformacion.getSelectionModel().getSelectedItem();
        
        if(i!= null){
            this.txtNombres.setText(i.getNombre());
            this.txtApellidos.setText(i.getApellido());
            this.txtTelefono.setText(i.getTelefono()+ "");
            this.txtDPI.setText(i.getDpi());
        }
        
    }
}
