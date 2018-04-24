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
    
    /**
     * Metodo para ingresar por teclado la cantidad de llamadas que ingresaran
     * 
     * @return Int  Numero de lllamadas
     */
    public int cantidadLlamadas()
    {
        Scanner sc = new Scanner(System.in); //Se crea el lector
        System.out.println("Por favor ingrese la cantidad de llamadas: ");//Se pide un dato al usuario
        return sc.nextInt();
    }
    
    /**
     * Metodo para ingresar por teclado la cantidad de operadores 
     * 
     * @return Int  Numero de operadores
     */
    public int cantidadOperadores()
    {
        Scanner sc = new Scanner(System.in); //Se crea el lector
        System.out.println("Por favor ingrese la cantidad de operadores: ");//Se pide un dato al usuario
        return sc.nextInt();
    }
    
    /**
     * Metodo para ingresar por teclado la cantidad de supervisores 
     * 
     * @return Int  Numero de supervisores
     */
    public int cantidadSupervisores()
    {
        Scanner sc = new Scanner(System.in); //Se crea el lector
        System.out.println("Por favor ingrese la cantidad de supervisores: ");//Se pide un dato al usuario
        return sc.nextInt();
    }
    
    /**
     * Metodo para ingresar por teclado la cantidad de directores 
     * 
     * @return Int  Numero de directores
     */
    public int cantidadDirectores()
    {
        Scanner sc = new Scanner(System.in); //Se crea el lector
        System.out.println("Por favor ingrese la cantidad de directores: ");//Se pide un dato al usuario
        return sc.nextInt();
    }  
    
}
