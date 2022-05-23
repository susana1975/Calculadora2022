/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcruz;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.function.Executable;

/**
 *
 * @author Susana Rosa <susana.rosa@murciaeduca.es>
 */
public class CCuentaTest3 {

    private static CCuenta instance = null;

    public CCuentaTest3() {
    }

    @BeforeAll
    public static void setUpClass() {
        instance = new CCuenta("", "", 100, 5);
    }

    @AfterAll
    public static void tearDownClass() {
        instance = null;
    }

    /**
     * Test of ingresar method, of class CCuenta.
     */
    @Test
    public void testIngresar() throws Exception {
        System.out.println("ingresar");
        double cantidad = 5.5;
        double resultado = 105.5;
        instance.ingresar(cantidad);
        assertEquals(resultado, instance.getSaldo());
    }


    @Test
    public void testIngresarNegativo() throws Exception {
        System.out.println("ingresar");
        double cantidad = -1.0;
        assertThrows(Exception.class, () -> {
            instance.ingresar(cantidad);
        });
    }

}
