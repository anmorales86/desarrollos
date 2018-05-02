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
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase Dispatcher
 * 
 * @author ANDERSON
 */
public class Dispatcher  extends Thread  implements Serializable
{ 
    
    private final int id; 
    private final int tiempoLlamada; 
    private final ArrayList<Employee> listaEmploye ;
    
    /**
     * Metodo contrsuctor
     * 
     * @param listaEmployee     Listado de los empleados
     * @param id                Id es la referencia de la llamada
     * @param tiempoLlamada     Tiempo de la llamada
     */
    public Dispatcher(ArrayList<Employee> listaEmployee, int id, int tiempoLlamada){
        this.listaEmploye = listaEmployee;
        this.id = id;
        this.tiempoLlamada = tiempoLlamada;
    }
    
    @Override
    public void run () { 
        boolean para = false ; 
        while (!para) { 
            try { 
                dispatchCall(); 
            }catch ( InterruptedException e) { 
                para = true ; 
            } 
        } 
    } 
    
    /**
     * Metodo que comienza a recorrer por todos los empleados empzando
     * por operadores, siguiendo por supervidores y por ultimo directores
     * para recibir la llamada
     * 
     * Cuando no hay un ningun empleado libre, se imprime un mensaje
     * que no hay recursos disponibles
     * 
     * @throws InterruptedException 
     */
    private void dispatchCall () throws InterruptedException 
    { 
        boolean fueRecibida = false;
        
        //ciclo para verficar si un operador esta libre
        for (Employee employee : this.listaEmploye)
        {
            if (employee.getCargo().equals("OPERADOR") && !employee.isOcupado())
            {
                try {
                    employee.estaOcupado(this.id, tiempoLlamada);
                    fueRecibida = true;
                }catch(InterruptedException e){
                    employee.estaLibre(this.id);
                    throw e; 
                }
                employee.estaLibre(this.id);
            }
        }       
        
        
        if (!fueRecibida)
        {
            //ciclo para verficar si un supervisor esta libre
            for (Employee employee : this.listaEmploye)
            {
                if (employee.getCargo().equals("SUPERVISOR") && !employee.isOcupado())
                {
                    try {
                        employee.estaOcupado(this.id, tiempoLlamada);
                        fueRecibida = true;
                    }catch(InterruptedException e){
                        employee.estaLibre(this.id);
                        throw e; 
                    }
                    employee.estaLibre(this.id);
                }
            }
        
        }
        
        if (!fueRecibida)
        {
            //ciclo para verficar si un director esta libre            
            for (Employee employee : this.listaEmploye)
            {
                if (employee.getCargo().equals("DIRECTOR") && !employee.isOcupado())
                {                
                    try {
                        employee.estaOcupado(this.id, tiempoLlamada);
                        fueRecibida = true;
                    }catch(InterruptedException e){
                        employee.estaLibre(this.id);
                        throw e; 
                    }
                    employee.estaLibre(this.id);
                }
            }
        }
        
        if (!fueRecibida)
        {
            System.out.println("TODOS NUESTROS RECURSOS NO SE ENCUENTRAN DISPONIBLES EN "
                             + "ESTE MOMENTO, ESPERE EN LA LLAMADA POR FAVOR");
        }
        
    } 
    
}
