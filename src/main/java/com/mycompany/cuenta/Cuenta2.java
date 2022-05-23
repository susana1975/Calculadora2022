/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cuenta;

/**
 *
 * @author Susana Rosa <susana.rosa@murciaeduca.es>
 */
public class Cuenta2 {

    private double saldo;
    private String titular;
    private static String tipo;
    private int codigo;  //No proporcionamos metodos set
    private static int ultimoCodigo = 0;
    

    public Cuenta2(double saldo, String titular) {
        this();
        this.saldo = saldo;
        this.titular = titular;
        
    }
    public Cuenta2() {
        //this.codigo = ++ultimoCodigo;
        this.codigo = getCodigoCuenta();
        this.tipo = "Ahorro";//Por defecto
    }
    public Cuenta2(double saldo, String titular,String tipo){
        this(saldo,titular);
        this.tipo = tipo;
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
        Cuenta2.tipo = tipo;
    }

    public int getCodigo() {
        return codigo;
    }
    public int getCodigoCuenta(){
        return ++ultimoCodigo;
    }
    public void ingreso(double cantidad) {
        this.saldo += cantidad;
    }

    public void reintegro(double cantidad) {
        if (this.saldo >= cantidad) {
            this.saldo -= cantidad;
        }

    }
}
