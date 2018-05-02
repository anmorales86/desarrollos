/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.business;

import com.mycompany.entities.Director;
import com.mycompany.entities.Employee;
import com.mycompany.entities.Operador;
import com.mycompany.entities.Supervisor;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
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
        
        ArrayList<Employee> listaEmployee = new ArrayList<>();
        listaEmployee = cargarOperador(listaEmployee, cantOperador);
        listaEmployee = cargarSupervisor(listaEmployee, cantSupervisor);
        listaEmployee = cargarDirector(listaEmployee, cantDirector);
        
        
        for (int i = 0; i<numeroLlamadas; i++)
        {
            int tiempoLlamada = ThreadLocalRandom.current().nextInt(5000, 10000);
            dispatcher[i] = new Dispatcher(listaEmployee, i, tiempoLlamada);
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
    
    /**
     * Metodo para cargar los datos del operador
     * @param listaEmployee             Lista donde se almacenara la informacion
     * @param cantOperador              Cantidad de operadores
     * @return ArrayList<Employee>      Lista con la informacion cargada
     */
    public static ArrayList<Employee> cargarOperador(ArrayList<Employee> listaEmployee, int cantOperador)
    {
        Employee employee = null;
        for (int i = 0;i<cantOperador;i++){
            employee = new Operador("Luis - "+i, "OPERADOR", false);
            listaEmployee.add(employee);
        }
        return listaEmployee;
    }
    
    /**
     * Metodo para cargar los datos del operador
     * @param listaEmployee             Lista donde se almacenara la informacion
     * @param cantSupervisor            Cantidad de supervisores
     * @return ArrayList<Employee>      Lista con la informacion cargada
     */
    public static ArrayList<Employee> cargarSupervisor(ArrayList<Employee> listaEmployee, int cantSupervisor)
    {
        Employee employee = null;
        for (int i = 0;i<cantSupervisor;i++){
            employee = new Supervisor("Rocio - "+i, "SUPERVISOR", false);
            listaEmployee.add(employee);
        }
        return listaEmployee;
    }
    
    /**
     * Metodo para cargar los datos del operador
     * @param listaEmployee             Lista donde se almacenara la informacion    
     * @param cantDirector              Cantidad de directores
     * @return ArrayList<Employee>      Lista con la informacion cargada
     */
    public static ArrayList<Employee> cargarDirector(ArrayList<Employee> listaEmployee, int cantDirector)
    {
        Employee employee = null;
        for (int i = 0;i<cantDirector;i++){
            employee = new Director("Pedro - "+i, "DIRECTOR", false);
            listaEmployee.add(employee);
        }
        return listaEmployee;
    }
    
}
