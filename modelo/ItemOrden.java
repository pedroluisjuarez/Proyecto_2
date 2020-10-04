
package modelo;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

class ItemOrden {
    private int noLinea;
    private int cantidad;
    private Producto producto;

    public ItemOrden(int noLinea, int cantidad, Producto producto) {
        this.noLinea = noLinea;
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public String getNombreClase(){
        return this.getClass().getName();
    }

    @Override
    public String toString() {
        return "[" + this.getNombreClase()+ "]" + "noLinea=" + noLinea + ", cantidad=" + cantidad + ", producto=" + producto + '}';
    }
    
    
}
