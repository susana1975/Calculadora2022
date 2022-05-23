/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcruz;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;

/**
 *
 * @author Susana Rosa <susana.rosa@murciaeduca.es>
 */
public class CCuentaTest {

    public CCuentaTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of ingresar method, of class CCuenta.
     */
    @Test
    public void testIngresar() throws Exception {
        System.out.println("ingresar");
        double cantidad = 5.5;
        double resultado = 105.5;
        CCuenta instance = new CCuenta("", "", 100, 5);
        instance.ingresar(cantidad);
        assertEquals(resultado, instance.getSaldo());
    }

    @Test
    public void testIngresarNegativo() throws Exception {
        System.out.println("ingresar");
        double cantidad = -1.0;
        CCuenta instance = new CCuenta("", "", 100, 5);
        assertThrows(Exception.class, () -> {
            instance.ingresar(cantidad);
        });
    }

    /**
     * Test of retirar method, of class CCuenta.
     */
    @Test
    public void testRetirar() throws Exception {
        System.out.println("retirar");
        double cantidad = 5.0;
        double resultado = 95.0;
        CCuenta instance = new CCuenta("", "", 100, 5);
        instance.retirar(cantidad);
        assertEquals(resultado, instance.getSaldo());
    }

    /**
     * Test of retirar method, of class CCuenta.
     */
    @Test
    public void testRetirarNegativo() throws Exception {
        System.out.println("retirar");
        double cantidad = -5.0;
        CCuenta instance = new CCuenta("", "", 100, 5);
        assertThrows(Exception.class, () -> {
            instance.retirar(cantidad);
        });
    }

    /**
     * Test of retirar method, of class CCuenta.
     */
    @Test
    public void testRetirarNFallo() throws Exception {
        System.out.println("retirar");
        double cantidad = 105.0;
        CCuenta instance = new CCuenta("", "", 100, 5);
        assertThrows(Exception.class, () -> {
            instance.retirar(cantidad);
        });
    }

    /**
     * Test of getSaldo method, of class CCuenta.
     */
    @Test
    public void testGetSaldo() {
        System.out.println("getSaldo");
        CCuenta instance = new CCuenta("", "", 100, 5);
        double expResult = 100.0;
        double result = instance.getSaldo();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of setSaldo method, of class CCuenta.
     */
    @Test
    public void testSetSaldo() {
        System.out.println("setSaldo");
        CCuenta instance = new CCuenta("", "", 100, 5);
        double cantidad = 10.0;
        double expResult = 110.0;
        instance.setSaldo(cantidad);
        assertEquals(expResult, instance.getSaldo());
    }

}
