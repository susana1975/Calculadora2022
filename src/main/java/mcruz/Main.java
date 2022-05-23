/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mcruz;

/**
 *
 * @author Francico Javier Cabrerizo Membrilla
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CCuenta cuenta1;
        double saldoActual;
        
        cuenta1 = new CCuenta("Juan López","1000-2365-85-123456789",2500,0);
        operativa_cuenta(cuenta1, 0); 
        saldoActual = cuenta1.estado();
        System.out.println("El saldo actual es"+ saldoActual );
    }

    private static void operativa_cuenta(CCuenta cuenta1, float cantidad) {
        try
        {
            cuenta1.retirar(2300);
        } catch (Exception e)
        {
            System.out.print("Fallo al retirar");
        }
        
        try
        {
            System.out.println("Ingreso en cuenta");
            cuenta1.ingresar(695);
        } catch (Exception e)
        {
            System.out.print("Fallo al ingresar");
        }
    }

}
