
package modelo;

public class Cliente {
    
    protected int id;
    protected String nombre;
    protected String apellido;
    protected int telefono;
    static int sigIdCliente = 1;
  
    public Cliente(){
        this.nombre = "";
        this.apellido = "";
        this.id = this.getIdCliente();
    }
    public Cliente(String nombre, String apellido, int telefono) {
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = this.getIdCliente();
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getIdCliente(){
        return sigIdCliente++;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreClase(){
        return this.getClass().getName();
    }

    @Override
    public String toString() {
        return "["+ this.getNombreClase()+ "]" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + '}';
    }
    
}
