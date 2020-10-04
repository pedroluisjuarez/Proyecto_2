
package modelo;

import java.util.Date;

public class Orden {
    private int id;
    private Cliente cliente;
    private ItemOrden item1;
    private ItemOrden item2;
    private Date fechaOrden;
    private double precioEnvio;
    private double total;
    private String tipoEnvio;
    private String estado;
    static int sigIdOrden;
    private int diasOrden;

    public Orden() {
        this.id = this.getIdOrden();
        this.fechaOrden = new Date();
        this.total = 0.00;
    }

    public Orden(Cliente cliente, ItemOrden item1, Date fechaOrden, double precioEnvio, double total, String tipoEnvio, String estado, int diasOrden) {
        this.cliente = cliente;
        this.item1 = item1;
        this.fechaOrden = fechaOrden;
        this.precioEnvio = precioEnvio;
        this.total = total;
        this.tipoEnvio = tipoEnvio;
        this.estado = estado;
        this.diasOrden = diasOrden;
        this.id = this.getIdOrden();
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ItemOrden getItem1() {
        return item1;
    }

    public void setItem1(ItemOrden item1) {
        this.item1 = item1;
    }

    public ItemOrden getItem2() {
        return item2;
    }

    public void setItem2(ItemOrden item2) {
        this.item2 = item2;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public double getPrecioEnvio() {
        return precioEnvio;
    }

    public void setPrecioEnvio(double precioEnvio) {
        this.precioEnvio = precioEnvio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getTipoEnvio() {
        return tipoEnvio;
    }

    public void setTipoEnvio(String tipoEnvio) {
        this.tipoEnvio = tipoEnvio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getDiasOrden() {
        return diasOrden;
    }

    public void setDiasOrden(int diasOrden) {
        this.diasOrden = diasOrden;
    }
        
    public double getTotalOrden(){
        return total+precioEnvio;
    }
    
     public int getIdOrden(){
        return sigIdOrden++;
    }
}
