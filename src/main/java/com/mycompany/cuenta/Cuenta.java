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
public class Cuenta {
    private double saldo;
    private String titular;
    private static String tipo;
    

    public Cuenta(double saldo, String titular) {
        this.saldo = saldo;
        this.titular = titular;
    }

    public Cuenta() {

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
        Cuenta.tipo = tipo;
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
