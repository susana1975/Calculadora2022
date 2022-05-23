/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cuenta;

import java.util.Arrays;

/**
 *
 * @author Susana Rosa <susana.rosa@murciaeduca.es>
 */
public class MisArrays {
    public static void main(String[] args) {
        int [] v = {5,2,1,4,3};
        int [] v2 = {5,2,1,4,3};
        if(Arrays.equals(v,v2))
            System.out.println("Iguales");
        if(v==v2)
            System.out.println("que pasa aqui");
        v=v2;
        if(v==v2)
            System.out.println("que pasa aqui ahora");
        Arrays.sort(v);
        System.out.println(Arrays.toString(v));
       
    }
}
