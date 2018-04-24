/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

/**
 * Clase principal de Empleados
 * 
 * @author ANDERSON
 */
public class Employee 
{
    
    private Operador [] operador;
    private Supervisor [] supervisor;
    private Director [] director;
    
    /**
     * Contructor principal para incializar los arreglos de las clases
     * operador, supervisor, director con su respectiva informacion
     * 
     * @param cantOperador      Cantidad de operadores
     * @param cantSupervisor    Cantidad de supervisores
     * @param cantDirector      Cantidad de directores
     */
    public Employee(int cantOperador, int cantSupervisor, int cantDirector){
        this.operador = new Operador[cantOperador];
        this.supervisor = new Supervisor[cantSupervisor];
        this.director = new Director[cantDirector];
        
        // se le asigna un nombre al operador terminado con la secuencia del ciclo
        for (int i = 0;i<this.operador.length;i++){
            this.operador[i] = new Operador("Luis - "+i);
        }
        // se le asigna un nombre al supervisor terminado con la secuencia del ciclo
        for (int i = 0;i<this.supervisor.length;i++){
            this.supervisor[i] = new Supervisor("Rocio - "+i);
        }
        // se le asigna un nombre al director terminado con la secuencia del ciclo
        for (int i = 0;i<this.director.length;i++){
            this.director[i] = new Director("Angel - "+i);
        }
    }

    public Operador[] getOperador() {
        return operador;
    }

    public void setOperador(Operador[] operador) {
        this.operador = operador;
    }

    public Supervisor[] getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor[] supervisor) {
        this.supervisor = supervisor;
    }

    public Director[] getDirector() {
        return director;
    }

    public void setDirector(Director[] director) {
        this.director = director;
    }
    
    
    
}
