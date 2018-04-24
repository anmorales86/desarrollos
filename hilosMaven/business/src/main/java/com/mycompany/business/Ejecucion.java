/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.business;

import com.mycompany.entities.Dispatcher;
import com.mycompany.entities.Employee;
import static java.lang.Thread.sleep;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Clase Ejecucion
 * 
 * @author ANDERSON
 */
public class Ejecucion {
    
    public Ejecucion(){
        
    }
    
    /**
     * Metodo donde se ejecuta todo el proceso de la llamadas en hilos
     * 
     * @param numeroLlamadas            Cantidad de llamadas
     * @param cantOperador              Cantidad de operadores
     * @param cantSupervisor            Cantidad de supervisores
     * @param cantDirector              Cantidad de directores
     * @throws InterruptedException 
     */
    public void ejecucionProcesos(int numeroLlamadas,
                                  int cantOperador,
                                  int cantSupervisor,
                                  int cantDirector) throws InterruptedException
    {
    
        Dispatcher [] dispatcher = new Dispatcher[numeroLlamadas];
        Employee employee = new Employee(cantOperador, cantSupervisor, cantDirector);
        
        for (int i = 0; i<numeroLlamadas; i++)
        {
            int tiempoLlamada = ThreadLocalRandom.current().nextInt(5000, 10000);
            dispatcher[i] = new Dispatcher(employee, i, tiempoLlamada);
            dispatcher[i].start();
        }        
        for ( int i = 0; i < numeroLlamadas ; i++) 
        { 
            sleep(500); 
            dispatcher[i].interrupt(); 
        }         
        for ( int i = 0; i < numeroLlamadas ; i++) 
        { 
            dispatcher[i].join(); 
        }    
        
    }  
    
}
