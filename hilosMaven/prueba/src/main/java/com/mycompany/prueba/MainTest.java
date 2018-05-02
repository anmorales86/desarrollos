/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prueba;

import com.mycompany.service.Proceso;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANDERSON
 */
public class MainTest {
    
    private static Proceso proceso;
    
    public static void main(String []args) {
        try {
            proceso = new Proceso();
            Scanner entradaEscaner = new Scanner (System.in); 
            
            System.out.print("********** BIENVENIDO !!! ************");
            
            System.out.print("\n\nIngrese el numero de llamadas:");
            int numeroLlamadas = entradaEscaner.nextInt();        //Cantidad de llamadas
            System.out.print("\nIngrese la cantidad de empleados operadores:");
            int cantOperador = entradaEscaner.nextInt();           //Cantidad de operador
            System.out.print("\nIngrese la cantidad de empleados supervisores:");
            int cantSupervisor = entradaEscaner.nextInt();          //Cantidad de supervisor
            System.out.print("\nIngrese la cantidad de empleados directores:");
            int cantDirector = entradaEscaner.nextInt();            //Cantidad de director
            proceso.llamarProceso(numeroLlamadas,
                    cantOperador,
                    cantSupervisor,
                    cantDirector);
        } catch (InterruptedException ex) {
            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
