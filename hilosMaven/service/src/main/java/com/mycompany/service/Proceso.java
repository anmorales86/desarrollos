/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.business.Ejecucion;
import java.util.Scanner;

/**
 *
 * @author ANDERSON
 */
public class Proceso 
{
    
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
