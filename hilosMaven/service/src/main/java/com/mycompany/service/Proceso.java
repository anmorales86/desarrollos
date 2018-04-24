/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.business.Ejecucion;


/**
 * Clase principal donde inicia la ejecucion del proceso de hilos
 * 
 * @author ANDERSON
 */
public class Proceso 
{
    
    /**
     * Metodo que se inicia la ejecucion del proceso
     * 
     * @param numeroLlamadas            Cantidad de llamadas
     * @param cantOperador              Cantidad de operadores
     * @param cantSupervisor            Cantidad de supervisores
     * @param cantDirector              Cantidad de directores
     * @throws InterruptedException 
     */
    public void llamarProceso(int numeroLlamadas,
                              int cantOperador,
                              int cantSupervisor,
                              int cantDirector) throws InterruptedException 
    {                     
        
        Ejecucion ejecucion = new Ejecucion();
        
        ejecucion.ejecucionProcesos(numeroLlamadas,
                                    cantOperador,
                                    cantSupervisor,
                                    cantDirector);
        
    }
    
}
