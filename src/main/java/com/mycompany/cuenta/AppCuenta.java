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
public class AppCuenta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cuenta3 c = new Cuenta3(2000, "Susana Rosa");
        c.reintegro(2001);
        System.out.println("Estado de la cuenta " + c.getEstado());

        EstadoCuenta[] estados = EstadoCuenta.values();
        for (EstadoCuenta e : estados) {//bucle forEach
            System.out.println(e);
            System.out.println(e.ordinal());
        }
        
        
        EstadoCuenta unEstado = EstadoCuenta.valueOf("OPERATIVA");
        System.out.println(unEstado);
    }

}
