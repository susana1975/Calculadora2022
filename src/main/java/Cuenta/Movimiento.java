package Cuenta;

public class Movimiento {
    // Atributos
    private double cantidad;
    private String concepto;
    
    // Constructores
    public Movimiento(double pCantidad, String pConcepto) {
        this.cantidad = pCantidad;
        this.concepto = pConcepto;
    }
    
    // Getters y setters
    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    @Override
    public String toString() {
        return "Movimiento{" + "cantidad=" + cantidad + ", concepto=" + concepto + '}';
    }
    
}
