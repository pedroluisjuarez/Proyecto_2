
package controlador;

import java.net.URL;
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
import modelo.DataSistema;
import modelo.Producto;

/**
 * FXML Controller class
 *
 * @author famil
 */
public class BajasIndividualesController implements Initializable {

    @FXML
    private TextField txtProducto;
    @FXML
    private TextField txtPrecio;
    @FXML
    private TextField txtCantidad;
    @FXML
    private Button btnAgregarProducto;
    @FXML
    private Button btnModificarProducto;
    @FXML
    private Button btnEliminarProducto;
    @FXML
    private TableView <Producto> tableProducto;
    
    private ObservableList<Producto> productos;
    @FXML
    private TableColumn<?, ?> colId;
    @FXML
    private TableColumn<?, ?> colProducto;
    @FXML
    private TableColumn<?, ?> colPrecio;
    @FXML
    private TableColumn<?, ?> colCantidad;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        productos = FXCollections.observableArrayList();
        
        
        this.colProducto.setCellValueFactory(new PropertyValueFactory("producto"));
        this.colPrecio.setCellValueFactory(new PropertyValueFactory("precio"));
        this.colCantidad.setCellValueFactory(new PropertyValueFactory("cantidad"));
        this.colId.setCellValueFactory(new PropertyValueFactory("id"));

        
                Producto p1 = new Producto("Rin",2000,3);
                this.productos.add(p1);
                this.tableProducto.setItems(productos);
                
                Producto p2 = new Producto("Filtro",200,30);
                this.productos.add(p2);
                this.tableProducto.setItems(productos);
                
                Producto p3 = new Producto("Rin",202300,3);
                this.productos.add(p3);
                this.tableProducto.setItems(productos);

                Producto p4 = new Producto("Rin",223000,3);
                this.productos.add(p4);
                this.tableProducto.setItems(productos);
    
                Producto p5 = new Producto("Rin",234000,3);
                this.productos.add(p5);
                this.tableProducto.setItems(productos);
    
                Producto p6 = new Producto("Rin",200650,3);
                this.productos.add(p6);
                this.tableProducto.setItems(productos);
    
                Producto p7 = new Producto("Rin",20900,3);
                this.productos.add(p7);
                this.tableProducto.setItems(productos);
                
                Producto p8 = new Producto("Rin",200680,3);
                this.productos.add(p8);
                this.tableProducto.setItems(productos);
                
                DataSistema s = new DataSistema();
                s.productos.add(p1);
                s.productos.add(p2);
                s.productos.add(p3);
                s.productos.add(p4);
                s.productos.add(p5);
                s.productos.add(p6);
                s.productos.add(p7);
                s.productos.add(p8);
    }    

    @FXML
    private void AgregarProducto(ActionEvent event) {
        try{
            
        String producto = this.txtProducto.getText();
        int precio = Integer.parseInt(this.txtPrecio.getText());
        int cantidad = Integer.parseInt(this.txtCantidad.getText());
        
        Producto p = new Producto(producto, precio, cantidad);
        
        if(!this.productos.contains(p)){
            this.productos.add(p);
            this.tableProducto.setItems(productos);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText("Producto añadido: "+p.toString());
            alert.showAndWait();
            
            DataSistema d = new DataSistema();
            d.productos.add(p);
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("El producto ya existe");
            alert.showAndWait();
        }
             
    }catch(NumberFormatException e){
        Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Incorrecto");
            alert.showAndWait();
    }
    }

    @FXML
    private void ModificarProducto(ActionEvent event) {
        Producto i = this.tableProducto.getSelectionModel().getSelectedItem();
        
        if(i == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debe seleccionar un producto");
            alert.showAndWait();
        }else{
            try{
            
        String producto = this.txtProducto.getText();
        int precio = Integer.parseInt(this.txtPrecio.getText());
        int cantidad = Integer.parseInt(this.txtCantidad.getText());
        
        Producto aux = new Producto(producto, precio, cantidad);
        
        if(!this.productos.contains(aux)){
            
            i.setProducto(aux.getProducto());
            i.setPrecio(aux.getPrecio());
            i.setCantidad(aux.getCantidad());
            
            this.tableProducto.refresh();
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText("Producto Modificado");
            alert.showAndWait();
            
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("El producto ya existe");
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
    private void EliminarProducto(ActionEvent event) {
        Producto i = this.tableProducto.getSelectionModel().getSelectedItem();
        
        if(i == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debe seleccionar una persona");
            alert.showAndWait();
        }else{
            
            this.productos.remove(i);
            this.tableProducto.refresh();
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText("Cliente Eliminado");
            alert.showAndWait();
        }
        
    }

    @FXML
    private void seleccionar(MouseEvent event) {
        Producto i = this.tableProducto.getSelectionModel().getSelectedItem();
        
        if(i!= null){
            this.txtProducto.setText(i.getProducto());
            this.txtPrecio.setText(i.getPrecio()+"");
            this.txtCantidad.setText(i.getCantidad()+ "");
        }
    }

}
