/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcruz;

import java.util.Arrays;
import java.util.Collection;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author Susana Rosa <susana.rosa@murciaeduca.es>
 */
public class CCuentaTestIngreso {
 private CCuenta instance = null;
    
    private static Collection<Object[]> valores() {
        return Arrays.asList(new Object[][]{{100.0, 10.0, 110.0}, {30, 2, 32}, 
            {100.0, 1000.0, 1100.0}});
    }
    
    @ParameterizedTest
    @MethodSource("valores")
    public void testIngreso(double v1,double v2,double r) {
        instance = new CCuenta("","",v1,0);
        try{
            instance.ingresar(v2);
        }catch(Exception e){
               System.out.println("");
        }
        assertEquals(r, instance.getSaldo());
    }

}
