package com.mycompany.cuenta;

/**
 *
 * @author Susana Rosa <susana.rosa@murciaeduca.es>
 */
enum EstadoCuenta {
    OPERATIVA, CERRADA, INMOVILIZADA, NUMEROS_ROJOS;
}

public class Cuenta3 {

    private double saldo;
    private String titular;
    private static String tipo;
    private int codigo;  //No proporcionamos metodos set
    private EstadoCuenta estado;

    private static int ultimoCodigo = 0;

    public Cuenta3(double saldo, String titular) {
        this();
        this.saldo = saldo;
        this.titular = titular;

    }

    public Cuenta3() {
        //this.codigo = ++ultimoCodigo;
        this.codigo = getCodigoCuenta();
        Cuenta3.tipo = "Ahorro";//Por defecto
        this.estado = EstadoCuenta.OPERATIVA;
    }

    public Cuenta3(double saldo, String titular, String tipo) {
        this(saldo, titular);
        Cuenta3.tipo = tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public static String getTipo() {
        return tipo;
    }

    public static void setTipo(String tipo) {
        Cuenta3.tipo = tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getCodigoCuenta() {
        return ++ultimoCodigo;
    }

    public EstadoCuenta getEstado() {
        return estado;
    }

    public void setEstado(EstadoCuenta estado) {
        this.estado = estado;
    }

    public void ingreso(double cantidad) {
        this.saldo += cantidad;
    }

    public void ingreso(double... cantidad) {
        for (int i = 0; i < cantidad.length; i++) {
            this.saldo += cantidad[i];
        }
    }

    public void reintegro(double cantidad) {
        if (this.saldo >= cantidad) {
            this.saldo -= cantidad;
        } else {
            this.saldo = 0;
            estado = EstadoCuenta.NUMEROS_ROJOS;
        }
    }

    public void reintegro(double... cantidad) {
        for (int i = 0; i < cantidad.length; i++) {
            if (this.saldo >= cantidad[i]) {
                this.saldo -= cantidad[i];
            } else {
                this.saldo = 0;
                estado = EstadoCuenta.NUMEROS_ROJOS;
            }
        }
    }
}
