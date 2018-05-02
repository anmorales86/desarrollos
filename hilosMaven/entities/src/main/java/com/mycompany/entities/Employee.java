/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import static java.lang.Thread.sleep;

/**
 * Clase principal de Empleados
 * 
 * @author ANDERSON
 */
public class Employee 
{
    
    private String nombre;
    private String cargo;
    private boolean ocupado;
    
    
    public Employee(String nombre, String cargo, boolean ocupado){
        this.nombre = nombre;
        this.cargo = cargo;
        this.ocupado = ocupado;
    }
    
    /**
     * Metodo que permite asignar la llamada al director
     * 
     * @param id                        Id de la llamada   
     * @param tiempoLlamada             Tiempo de la llamada que va a durar
     * @throws InterruptedException 
     */
    public synchronized void estaOcupado (int id, int tiempoLlamada)  throws InterruptedException  
    {        
        System.out.println (" La llamada -> "+id+" fue tomada por -> "+this.nombre); 
        this.ocupado = true;
        sleep(tiempoLlamada);         
    } 
    
    /**
     * Metodo que permite liberar el recurso, cuando su llamada es terminada
     * 
     * @param id    Id de la llamada
     */
    public synchronized void estaLibre (int id) { 
        ocupado = false ; 
        System.out.println (" La llamada -> "+id+" se termino"); 
        notifyAll (); 
    } 
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    
    
    
    
    
}
