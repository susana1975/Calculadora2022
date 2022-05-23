/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cuenta;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Susana Rosa <susana.rosa@murciaeduca.es>
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cuenta c1 = new Cuenta (new Persona("Carolina Pérez",(byte) 45, 'M'),200);
        ArrayList cotitulares = new ArrayList<Persona>();
        cotitulares.add(new Persona("Jaime Ruiz",(byte)25,'H'));
        cotitulares.add(new Persona("Martin Ruiz",(byte)15,'H'));
        c1.setCotitulares(cotitulares);
        c1.setTipo(TipoCuenta.AHORRO);
        c1.ingreso(250,300);
        c1.ingreso(250,"Para la universidad");
        System.out.println("DATOS DE LA CUENTA: ");
        System.out.println(c1.toString());
        System.out.println("COTITULARES: ");
        System.out.println(c1.getCotitulares());
        c1.reintegro(910);
        System.out.println("OPERACIONES REALIZADAS: ");
        //Aliasing -> modificamos los movimientos
        //Hemos protegido la clase del aliasing
        Movimiento[] movimientos = c1.getUltOp();
        for(Movimiento m: movimientos){ //Recorro las operaciones y las modifico
            System.out.println(m);
            m.setCantidad(0);
        }
        //Como estoy modificando la copia no modifico los objetos originales
        System.out.println(Arrays.toString(c1.getUltOp()));      
        //Ver qué ocurre si no replicamos los objetos
        
        ArrayList copiaCotitulares = c1.getCotitulares();
        Persona p  = (Persona)copiaCotitulares.get(0);//obtiene el primer cotitular de la lista
        p.setNombre("Jaimito Ruiz"); //lo modificamos
        System.out.println(c1.getCotitulares());
    }
    
}
