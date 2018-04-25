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

/**
 * Clase Dispatcher
 * 
 * @author ANDERSON
 */
public class Dispatcher  extends Thread  implements Serializable
{ 
    
    private final int id; 
    private final int tiempoLlamada; 
    private final Employee employee;    
    
    /**
     * Metodo constructor de la clase
     * 
     * @param employee          Objeto donde esta la info del operador, supervisor y director
     * @param id                Id que hace referencia a la llamada
     * @param tiempoLlamada     Tiempo aleatoria para la llamada
     */
    public Dispatcher(Employee employee, int id, int tiempoLlamada){
        this.employee = employee;
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
        for (Operador operador : this.employee.getOperador()){
            if (!operador.isOcupado()){
                try {
                    operador.estaOcupado(this.id, tiempoLlamada);
                    fueRecibida = true;
                }catch(InterruptedException e){
                    operador.estaLibre(this.id);
                    throw e; 
                }
                operador.estaLibre(this.id);
            }
        }
        
        if (!fueRecibida)
        {
            //ciclo para verficar si un supervisor esta libre
            for (Supervisor supervisor : this.employee.getSupervisor())
            {
                if (!supervisor.isOcupado()){
                    try {
                        supervisor.estaOcupado(this.id, tiempoLlamada);
                        fueRecibida = true;
                    }catch(InterruptedException e){
                        supervisor.estaLibre(this.id);
                        throw e; 
                    }
                    supervisor.estaLibre(this.id);
                }
            }
        }
        
        if (!fueRecibida)
        {
            //ciclo para verficar si un director esta libre
            for (Director director : this.employee.getDirector()){
                if (!director.isOcupado())
                {
                    try {
                        director.estaOcupado(this.id, tiempoLlamada);
                        fueRecibida = true;
                    }catch(InterruptedException e){
                        director.estaLibre(this.id);
                        throw e; 
                    }
                    director.estaLibre(this.id);
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
