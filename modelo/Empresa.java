
package modelo;

/**
 *
 * @author famil
 */
public class Empresa extends Cliente{
    private String contacto;
    private int descuento;

    public Empresa(String contacto, int descuento, String nombre, String apellido, int telefono) {
        super(nombre, apellido, telefono);
        this.contacto = contacto;
        this.descuento = descuento;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }
     
}
