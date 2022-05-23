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
public class A {
    static int a;
    int b;
    public A(){
      
        System.out.println("A "+a+" b "+b);
    }
    {
        b= a*2;
    }
   static {
       a=15;
   }
    public static void main(String[] args) {
        A a = new A();
        
    }
}
