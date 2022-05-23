/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cuenta;

import java.util.StringTokenizer;

/**
 *
 * @author Susana Rosa <susana.rosa@murciaeduca.es>
 */
public class MisString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        
        StringBuffer stb =  new StringBuffer("Hola Caracola");
        System.out.println(stb.capacity());
        System.out.println(stb.length());
        StringBuffer stb2 =  new StringBuffer();
        System.out.println(stb2.capacity());
        System.out.println(stb2.length());
        //stb.delete(1, 3);
        stb.replace(1, 4, "ay");
        stb.append("s");
        System.out.println(stb.toString());
    }

}
