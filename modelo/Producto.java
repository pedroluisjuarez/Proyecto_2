
package modelo;

public class Producto {
    private int id;
    private String producto;
    private int precio;
    private int cantidad;
    static int sigIdProducto=2000;

    public Producto() {
        this.producto= "";
        this.precio = 0;
        this.cantidad = 0;
        this.id = this.getIdProducto();
    }

    public Producto(String producto, int precio, int cantidad) {
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.id = this.getIdProducto();
    }
    
    public int getIdProducto(){
        return sigIdProducto++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombreClase(){
        return this.getClass().getName();
    }
    
    @Override
    public String toString() {
        return "[" + this.getNombreClase() + "]" + "id=" + id + ", producto=" 
                + producto + ", precio=" + precio + ", cantidad" + cantidad + '}';
    }
    
    
    
}
